/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.controller;

import emergon.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Ugleethyn
 */
@Controller
@RequestMapping("/") //This will ve inherited from all the moethds of the controller
public class HomeController {

    @Autowired
    private HomeService homeService;

    //    "/application/
    @RequestMapping
    public String showHome(Model model) {
        String message = homeService.getWelcome();
        model.addAttribute("myMessage", message);
        return "home";
    }

    // localhost:8080/MySpringMVCApp/and the return type of the method
    // "/application/appName"
    @RequestMapping("/appName")
    public String showNameOfApplication(Model model) {
       String appName = homeService.getApplicationName();
       model.addAttribute("myAppName", appName);
        return "home";
    }

}
