package controllers;

import org.flywaydb.core.internal.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import services.OwnerService;
import services.PetTypeService;
import services.sfdservices.PetService;
import sfpetclinic.Model.Owner;
import sfpetclinic.Model.Pet;
import sfpetclinic.Model.PetType;

import java.util.Collection;

@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {
    private final PetService petService;
    private  final OwnerService ownerService;

    private final PetTypeService petTypeService;

    public PetController(PetService petService, OwnerService ownerService, PetTypeService petTypeService) {
        this.petService = petService;
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
    }

    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes()
    {
        return petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable String ownerId)
    {
            return ownerService.findById(Long.valueOf(ownerId));
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder)
    {
        dataBinder.setDisallowedFields("Id");
    }

    @RequestMapping("/pets/new")
    public String initCreationForm(Owner owner, Model model)
    {
        Pet pet = new Pet();
        owner.getPets().add(pet);
        pet.setOwner(owner);
        model.addAttribute("pet",pet);
        return "pets/createOrUpdatePetForm";
    }

    @PostMapping("/pets/new")
    public String processCreationForm(Owner owner, Pet pet, BindingResult result, Model model) {
        if (StringUtils.hasLength(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true) != null) {
            result.rejectValue("name", "duplicate", "already exists");
        }
        owner.getPets().add(pet);
        if (result.hasErrors()) {
            model.addAttribute("pet", pet);
            return "pets/createOrUpdatePetForm";
        } else {
            pet.setOwner(owner);
            petService.save(pet);
            return "redirect:/owners/" + owner.getId();
        }
    }

        @GetMapping("/pets/{petId}/edit")
        public String initUpdateForm(@PathVariable Long petId, Model model) {
            model.addAttribute("pet", petService.findById(petId));
            return "pets/createOrUpdatePetForm";
        }

        @PostMapping("/pets/{petId}/edit")
        public String processUpdateForm( Pet pet, BindingResult result, Owner owner, Model model) {
            if (result.hasErrors()) {
                pet.setOwner(owner);
                model.addAttribute("pet", pet);
                return "pets/createOrUpdatePetForm";
            } else {
                pet.setOwner(owner);
                owner.getPets().add(pet);
                petService.save(pet);
                return "redirect:/owners/" + owner.getId();
            }
        }

}
