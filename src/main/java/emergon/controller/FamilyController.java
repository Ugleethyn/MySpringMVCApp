package emergon.controller;

import emergon.entity.Family;
import emergon.entity.Salesman;
import emergon.service.FamilyService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/family")
public class FamilyController {

    @Autowired
    private FamilyService familyService;

    @GetMapping("/{scode}")
    public String showFamily(@PathVariable("scode") int scode, Model model) {
        List<Family>list = familyService.getFamilyBySalesman(scode);
        model.addAttribute("listOfFamily", list);
        return "family/familyList";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showForm(@ModelAttribute("family") Family family) {
        return "family/familyForm";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("family") Family family,
            BindingResult result,
            RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "family/familyForm";
        }
        familyService.saveFamily(family);
        String minima = "Family " + family.getFname() + " successfully created!!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/family";//Redirect instructs client to sent a new GET request to /family
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id, RedirectAttributes attributes) {
        familyService.deleteFamily(id);
        String minima = "Family deleted successfully!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/family";
    }

    //localhost:8080/MySpringMVCApp/family/update/30
    @GetMapping("/update/{scode}")
    public String showFormUpdate(@PathVariable("scode") int scode, Model model) {
        Family family = familyService.getFamilyById(scode);
        model.addAttribute("poliths", family);
        return "family/familyForm";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("poliths") Family family,
            BindingResult result,
            RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "family/familyForm";
        }
        familyService.saveFamily(family);
        String minima = "Family updated successfully!!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/family";
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public String handleDataIntegrityViolationException(RedirectAttributes attributes) {
        String minima = "Could not commit transaction!!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/family";
    }

}
