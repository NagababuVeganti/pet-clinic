package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class ownersController {

    @RequestMapping({"/","index","index.html"})
    public String getOwners()
    {
         return "owners/index";
    }
}
