/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.repository;

import emergon.entity.Customer;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepo extends HibernateUtil<Customer>{
    
    public List<Customer> findAll(){
        return super.findAll("Customer.findAll");
    }
    
    @Override
    public Customer save(Customer customer){
        return super.save(customer);
    }
    
    public Customer find(int id){
        return super.find(Customer.class, id);
    }
    
}
