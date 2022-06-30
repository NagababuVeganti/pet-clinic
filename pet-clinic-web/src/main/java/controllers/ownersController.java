package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import services.OwnerService;
import sfpetclinic.Model.Owner;

import javax.naming.Binding;
import java.util.List;

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
    public String findOwners(Model model)
    {
        model.addAttribute("owner", new Owner());
        return "owners/findOwners";
    }

    @GetMapping
    public String processFindForm(Owner owner, BindingResult bindingResult, Model model)
    {
        if(owner.getLastName()==null)
            owner.setLastName("");
        List<Owner> result=ownerService.findAllByLastNameLike("%"+owner.getLastName()+"%");
        if(result.size()<=0)
        {
            bindingResult.rejectValue("lastName","Notfound","notfound");
            return "owners/findOwners";
        }
        else if(result.size()==1) {
            owner = result.get(0);
            return "redirect:/owners/" + owner.getId();
        }
        else
        {
            model.addAttribute("selections",result);
            return "/owners/ownersList";
        }


    }
    @RequestMapping("/{ownerId}")
    public String ShowOwner(@PathVariable String ownerId,Model model)
    {
        model.addAttribute("owner",ownerService.findById(Long.valueOf(ownerId)));
        return "owners/ownerDetails";
    }
}
