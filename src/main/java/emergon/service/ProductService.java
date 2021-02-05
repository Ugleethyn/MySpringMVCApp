/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.service;

import emergon.entity.Product;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ugleethyn
 */
@Service
public class ProductService {

    private List<Product> products;

    public List<Product> createCustomerList() {
        if (products == null) {
//            products = new ArrayList();
//            products.add(new Product(1, "Tv Monitor", 350));
//            products.add(new Product(2, "Laptop Asus", 1500));
//            products.add(new Product(3, "Keyboard", 120));
        }
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}
