/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.controller;

import emergon.entity.Customer;
import emergon.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Ugleethyn
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @RequestMapping
    public ModelAndView showCustomers(ModelAndView modelAndView) {
        modelAndView.addObject("listOfCustomers", customerService.getCustomers());
        modelAndView.setViewName("customerList");
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showForm() {
        return "customerForm";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Customer c, RedirectAttributes attributes) {
        customerService.addCustomer(c);
        String message = c.getCname() + " has been successfully added";
        attributes.addFlashAttribute("message", message);
        List<Customer> customers = customerService.getCustomers();
        return "redirect:/customer";
    }

    @GetMapping("/update/{ccode}")
    public String showFormUpdate(@PathVariable(name = "ccode") int ccode, Model model) {
        Customer customer = customerService.getCustomerById(ccode);
        model.addAttribute("customerToEdit", customer);
        return "customerForm";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int ccode, RedirectAttributes attributes) {
        customerService.deleteCustomer(ccode);
        String message = "Customer has been successfully deleted";
        attributes.addFlashAttribute("message", message);
        return "redirect:/customer";
    }

    @PostMapping("update")
    public String update(Customer customer, RedirectAttributes attributes) {
        customerService.updateCustomer(customer);
        String message = "Customer has been successfully edited";
        attributes.addFlashAttribute("message", message);
        return "redirect:/customer";
    }

}
