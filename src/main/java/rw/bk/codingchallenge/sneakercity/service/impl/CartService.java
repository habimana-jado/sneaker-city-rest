package rw.bk.codingchallenge.sneakercity.service.impl;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;
import rw.bk.codingchallenge.sneakercity.domain.Cart;
import rw.bk.codingchallenge.sneakercity.domain.ProductSize;
import rw.bk.codingchallenge.sneakercity.dto.CartDto;
import rw.bk.codingchallenge.sneakercity.enums.EPaymentStatus;
import rw.bk.codingchallenge.sneakercity.repository.CartRepository;
import rw.bk.codingchallenge.sneakercity.repository.ProductSizeRepository;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CartService implements rw.bk.codingchallenge.sneakercity.service.CartService {

    private final CartRepository cartRepository;
    private final ProductSizeRepository productSizeRepository;

    //OrderNo to be assigned to each order, changes when application is restarted
    private final String ORDER_NO = UUID.randomUUID().toString().substring(0, 7);

    public CartService(CartRepository cartRepository, ProductSizeRepository productSizeRepository) {
        this.cartRepository = cartRepository;
        this.productSizeRepository = productSizeRepository;
    }

    @Override
    public CartDto createOne(CartDto cartDto) throws InvocationTargetException, IllegalAccessException {
        ProductSize size = this.productSizeRepository.findById(cartDto.getProductSizeId())
                .orElseThrow(()-> new IllegalArgumentException("Product Size Not Found, Id: "+cartDto.getProductSizeId()));

        Cart cart = new Cart();
        BeanUtils.copyProperties(cart, cartDto);
        cart.setPaymentStatus(EPaymentStatus.PENDING);
        cart.setProductSize(size);
        cart.setOrderNo(ORDER_NO);
        cart.setPurchaseDate(new Date());

        Cart response = this.cartRepository.save(cart);
        BeanUtils.copyProperties(cartDto, response);

        return cartDto;
    }

    @Override
    public List<Cart> viewCart(EPaymentStatus status) {
        return this.cartRepository.findByStatus(status);
    }

    @Override
    public Boolean checkout() {
        ProductSize productSize;

        for(Cart c: cartRepository.findByStatus(EPaymentStatus.PENDING)){
            c.setPaymentStatus(EPaymentStatus.COMPLETED);
            cartRepository.save(c);

            productSize = c.getProductSize();
            productSize.setQuantity(productSize.getQuantity() - c.getQuantity());
            this.productSizeRepository.save(productSize);

        }
        return true;
    }
}
