package rw.bk.codingchallenge.sneakercity.service;

import rw.bk.codingchallenge.sneakercity.domain.Cart;
import rw.bk.codingchallenge.sneakercity.dto.CartDto;
import rw.bk.codingchallenge.sneakercity.enums.EPaymentStatus;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface CartService {

    CartDto createOne(CartDto cartDto) throws InvocationTargetException, IllegalAccessException;
    List<Cart> viewCart(EPaymentStatus status);
    Boolean checkout();
}
