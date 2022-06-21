package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import services.OwnerService;

@RequestMapping("/owners")
@Controller
public class ownersController {

    private final OwnerService ownerService;

    public ownersController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"/","index","index.html"})
    public String getOwners(Model model)
    {
        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }

    @RequestMapping({"/find"})
    public String findOwners()
    {
        return "notImplemented";
    }
}
