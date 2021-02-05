/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.controller;

import emergon.entity.Product;
import emergon.service.ProductService;
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
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping
    public ModelAndView showProducts(ModelAndView modelAndView) {
        modelAndView.addObject("listOfProducts", productService.getProducts());
        modelAndView.setViewName("productList");
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showForm() {
        return "productForm";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Product c, RedirectAttributes attributes) {
        productService.addProduct(c);
        String message = c.getPdescr() + " has been successfully added";
        attributes.addFlashAttribute("message", message);
        return "redirect:/product";
    }

    @GetMapping("/update/{pcode}")
    public String showFormUpdate(@PathVariable(name = "pcode") int pcode, Model model) {
        model.addAttribute("productToEdit", productService.getProductById(pcode));
        return "productForm";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int pcode, RedirectAttributes attributes) {
        productService.deleteProduct(pcode);
        String message = "Product has been successfully deleted";
        attributes.addFlashAttribute("message", message);
        return "redirect:/product";
    }

    @PostMapping("update")
    public String update(Product product, RedirectAttributes attributes) {
        productService.updateProduct(product);
        String message = "Product has been successfully edited";
        attributes.addFlashAttribute("message", message);
        return "redirect:/product";
    }

}
