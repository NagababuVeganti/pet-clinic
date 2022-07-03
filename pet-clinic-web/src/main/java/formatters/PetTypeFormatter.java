package formatters;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import services.PetTypeService;
import sfpetclinic.Model.PetType;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

@Component
public class PetTypeFormatter implements Formatter<PetType> {
    private final PetTypeService petTypeService;

    public PetTypeFormatter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public String print(PetType petType, Locale locale)
    {
        System.out.println("loaded");
        return petType.getName();
    }

    @Override
    public  PetType parse(String text,Locale locale) throws ParseException
    {
        Collection<PetType> findPetTypes= petTypeService.findAll();
        for(PetType type: findPetTypes)
        {
            if(type.getName().equals(text)) {
                System.out.println("found");
                return type;
            }
        }
        System.out.println("returning NUll");
        throw  new ParseException("text",0);
    }

}
