package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import services.OwnerService;
import services.PetService;
import services.VisitService;
import sfpetclinic.Model.Pet;
import sfpetclinic.Model.Visit;

@Controller
@RequestMapping("")
public class VisitController {
    private  final VisitService visitService;
    private  final OwnerService ownerService;
    private  final PetService petService;

    public VisitController(VisitService visitService, OwnerService ownerService, PetService petService) {
        this.visitService = visitService;
        this.ownerService = ownerService;
        this.petService = petService;
    }

    @ModelAttribute("visit")
    public Visit loadPetWithVisit(@PathVariable("petId") Long petId, Model model)
    {
        Pet pet= petService.findById(petId);
        model.addAttribute("pet",pet);
        Visit visit= new Visit();
        pet.getVisits().add(visit);
        visit.setPet(pet);
        return visit;
    }

    @RequestMapping("/owners/*/pets/{petId}/visits/new")
    public String initNewVisitForm(@PathVariable("petId") Long petId, Model model)
    {
        return "pets/createOrUpdateVisitForm";
    }


    @PostMapping("/owners/{ownerId}/pets/{petId}/visits/new")
    public String ProcessNewVisitForm( @PathVariable("petId") Long petId, Visit visit, BindingResult bindingResult)
    {
            if(bindingResult.hasErrors())
            {
                return "pets/createOrUpdateVisitForm";
            }
            else
            {
                visitService.save(visit);
                return "redirect:/owners/{ownerId}";
            }
    }
}
