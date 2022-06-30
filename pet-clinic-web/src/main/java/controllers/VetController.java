package controllers;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import services.VetService;

@RequestMapping("/vets")
@Controller
@ComponentScan("services")
public class VetController {
    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/","/vets.html"})
    public String listVets(Model model)
    {
        System.out.println(vetService.findAll().size());
        model.addAttribute("vets",vetService.findAll());
        return "vets/index";
    }
}
