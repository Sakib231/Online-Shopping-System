package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


class CartTest {

    static Cart cart;
    static Cart cart2;
    static Products product1;
    static Products product2;
    static Products product3;

    @BeforeAll
    static void init(){
        cart = new Cart();
        product1 = new Products("Canon D1", "Camera", 70000);
        product2 = new Products("Asus XR", "Laptop", 5000);
        product3 = new Products("Nokia n70", "Phone", 5000);

        cart.AddToCart(product1);
        cart.AddToCart(product2);
        cart.AddToCart(product3);
    }

    @Test
    void addToCart() {

        assertEquals(3, cart.cartItems.size());
        assertEquals("Canon D1", cart.cartItems.get(0).Name);
        assertEquals("Camera", cart.cartItems.get(0).Group);
        assertEquals(70000, cart.cartItems.get(0).Price);
    }

    @Test
    void deleteFromCard() {

        assertEquals(3, cart.cartItems.size());

        cart.DeleteFromCart(1);
        assertEquals(2, cart.cartItems.size());
        assertEquals("Asus XR", cart.cartItems.get(0).Name);
        assertEquals("Laptop", cart.cartItems.get(0).Group);
        assertEquals(5000, cart.cartItems.get(0).Price);
    }

    @Test
    void viewCart() {
        cart2 = new Cart();
        cart2.AddToCart(product1);
        cart2.AddToCart(product2);
        cart2.AddToCart(product3);


        assertEquals(3, cart2.cartItems.size());


        assertEquals("Canon D1", cart2.cartItems.get(0).Name);
        assertEquals("Camera", cart2.cartItems.get(0).Group);
        assertEquals(70000, cart2.cartItems.get(0).Price);

        assertEquals("Nokia n70", cart2.cartItems.get(2).Name);
        assertEquals("Phone", cart2.cartItems.get(2).Group);
        assertEquals(5000, cart2.cartItems.get(2).Price);

        assertSame(cart2.cartItems, cart2.ViewCart());
    }

    @Test
    void sumTotalPrice() {

        assertEquals(80000, cart.SumTotalPrice());
    }

    @Test
    void makePayment() {
        cart2 = new Cart();
        cart2.AddToCart(product1);
        cart2.AddToCart(product2);
        assertEquals(75000, cart2.SumTotalPrice());
    }
}