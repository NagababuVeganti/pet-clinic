package controllers;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import services.VetService;
import sfpetclinic.Model.Vet;

import java.util.Set;

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

    @GetMapping("/api/vets")
    public @ResponseBody Set<Vet> getVetsJson()
    {
        return vetService.findAll();
    }
}
