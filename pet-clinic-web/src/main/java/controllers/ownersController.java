package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.OncePerRequestFilter;
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
            return "owners/ownersList";
        }


    }
    @RequestMapping("/{ownerId}")
    public String ShowOwner(@PathVariable String ownerId,Model model)
    {
        model.addAttribute("owner",ownerService.findById(Long.valueOf(ownerId)));
        return "owners/ownerDetails";
    }
    @RequestMapping("/new")
    public String createNewOwner(Model model)
    {
        Owner owner = new Owner();
        model.addAttribute("owner",owner);
        return "owners/createOrUpdateOwnerForm";
    }

    @PostMapping
    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public String saveOwner(@ModelAttribute Owner owner,BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return "owners/createOrUpdateOwnerForm";
        else {
            Owner savedowner = ownerService.save(owner);
            return "redirect:/owners/"+savedowner.getId();
        }
    }

    @GetMapping
    @RequestMapping("{ownerId}/edit")
    public String editOwner(Model model,@PathVariable String ownerId)
    {
        Owner owner= ownerService.findById(Long.valueOf(ownerId));
        model.addAttribute("owner",owner);
        return "owners/createOrUpdateOwnerForm";
    }

    @PostMapping
    @RequestMapping(value = "{ownerId}/edit",method = RequestMethod.POST)
    public String processUpdate(@ModelAttribute Owner owner,
                                BindingResult bindingResult,@PathVariable String ownerId)
    {
        if(bindingResult.hasErrors())
            return "owners/createOrUpdateOwnerForm";
        else {
            Owner dbowner= ownerService.findById(Long.valueOf(ownerId));
            dbowner.setFirstName(owner.getFirstName());
            dbowner.setLastName(owner.getLastName());
            dbowner.setPhone(owner.getPhone());
            dbowner.setCity(owner.getCity());
            dbowner.setAddress(owner.getAddress());
            dbowner.setPets(owner.getPets());
            Owner savedowner=ownerService.save(dbowner);
            return "redirect:/owners/"+ savedowner.getId();
        }
    }
}
