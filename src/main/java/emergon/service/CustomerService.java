/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.service;

import emergon.entity.Customer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ugleethyn
 */
@Service
public class CustomerService {

    private List<Customer> customers;

    public List<Customer> createCustomerList() {
        if (customers == null) {
            customers = new ArrayList();
            customers.add(new Customer(1, "Jack"));
            customers.add(new Customer(2, "Jonathan"));
            customers.add(new Customer(3, "Jenny"));
        }
        return customers;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void delete(int id) {
        Iterator<Customer> it = customers.iterator();
        while (it.hasNext()) {
            Customer c = it.next();
            if (c.getCcode() == id) {
                it.remove();
            }
        }
    }

    public Customer getCustomerById(int ccode) {
        for (Customer c : customers) {
            if (c.getCcode() == ccode) {
                return c;
            }
        }
        return null;
    }

    public void updateCustomer(Customer customer) {
        Customer customerToUpdate = getCustomerById(customer.getCcode());
        customerToUpdate.setCname(customer.getCname());
    }

}
