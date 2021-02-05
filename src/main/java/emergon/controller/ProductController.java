/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.controller;

import emergon.entity.Product;
import emergon.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Ugleethyn
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping
    public ModelAndView showCustomers(ModelAndView modelAndView) {
        List<Product> products = productService.createCustomerList();
        modelAndView.addObject("listOfProducts", products);
        modelAndView.setViewName("productList");
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showForm() {
        return "productForm";
    }
    
        @RequestMapping(value = "/create" , method = RequestMethod.POST)
    public String create (Product p , Model model){
        productService.addProduct(p);
        List<Product> products = productService.createCustomerList();
        model.addAttribute("listOfProducts", products);
        return "productList";
    }

}
