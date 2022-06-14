package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ownersController {

    @RequestMapping({"/owners","/owners/index","/owners/index.html"})
    public String getOwners()
    {
         return "owners/index";
    }
}
