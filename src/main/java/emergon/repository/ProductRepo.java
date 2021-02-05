/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.repository;


import emergon.entity.Product;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ugleethyn
 */
@Repository
public class ProductRepo  extends HibernateUtil<Product> {
    
        public List<Product> findAll(){
        return super.findAll("Product.findAll");
    }
    
    public Product save(Product product){
        return super.save(product);
    }
    
    public Product find(int pcode){
        return super.find(Product.class, pcode);
    }
    
}
