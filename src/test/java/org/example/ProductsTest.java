package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductsTest {

    static Products product1;
    static Products product2;

    @BeforeAll
    static void init(){
       product1 = new Products("Canon D1", "Camera", 70000);
        product2 = new Products("Asus XR", "Latop", 5000);
    }


    @Test
    void setId() {
        product1.setId(1);
        assertEquals(1, product1.Id);
    }

    @Test
    void setName() {
        product1.setName("Canon D2");
        assertEquals("Canon D2", product1.Name);
    }

    @Test
    void setGroup() {
        product2.setGroup("Computer");
        assertEquals("Computer", product2.Group);
    }

    @Test
    void setPrice() {
        product1.setPrice(18000);
        assertEquals(18000, product1.Price);
    }
}