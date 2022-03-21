package rw.bk.codingchallenge.sneakercity.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import rw.bk.codingchallenge.sneakercity.dto.CartDto;
import rw.bk.codingchallenge.sneakercity.enums.EPaymentStatus;
import rw.bk.codingchallenge.sneakercity.service.CartService;

import java.lang.reflect.InvocationTargetException;

@RestController
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add-cart")
    public ResponseEntity<?> createOne(@RequestBody CartDto cartDto) throws InvocationTargetException, IllegalAccessException {
        return new ResponseEntity<>(this.cartService.createOne(cartDto), HttpStatus.CREATED);
    }

    @PostMapping("/checkout-cart")
    public ResponseEntity<?> checkout() {
        return new ResponseEntity<>(this.cartService.checkout(), HttpStatus.OK);
    }

    @GetMapping("/view-cart")
    public ResponseEntity<?> findPendingCart(){
        return new ResponseEntity<>(this.cartService.viewCart(EPaymentStatus.PENDING), HttpStatus.OK);
    }
}
