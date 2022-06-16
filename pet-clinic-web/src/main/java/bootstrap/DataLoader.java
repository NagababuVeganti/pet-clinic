package bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import services.OwnerService;
import services.VetService;
import sfpetclinic.Model.Owner;
import sfpetclinic.Model.Vet;

@Component
@ComponentScan({"services"})
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    public DataLoader(OwnerService ownerService, VetService vetService)
    {

        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception
    {

        Owner owner1= new Owner();
        owner1.setFirstname("Nagababu");
        owner1.setLastname("Veganti");

        ownerService.save(owner1);

        Owner owner2= new Owner();
        owner2.setFirstname("Michel");
        owner2.setLastname("Warner");
        ownerService.save(owner2);

        Owner owner3= new Owner();
        owner3.setFirstname("Fiona");
        owner3.setLastname("Veg");
        ownerService.save(owner3);

        Owner owner4= new Owner();
        owner4.setFirstname("Sara");
        owner4.setLastname("widler");
        ownerService.save(owner4);

        System.out.println("Loaded Owner data");

        Vet vet1 = new Vet();
        vet1.setFirstname("Sam");
        vet1.setLastname("Axe");

        Vet vet2 = new Vet();
        vet2.setFirstname("Lilly");
        vet2.setLastname("Anne");

        Vet vet3 = new Vet();
        vet1.setFirstname("Joe");
        vet1.setLastname("A");

        Vet vet4 = new Vet();
        vet1.setFirstname("Adam");
        vet1.setLastname("Pudder");

        vetService.save(vet1);
        vetService.save(vet2);
        vetService.save(vet3);
        vetService.save(vet4);

        System.out.println("Loaded Vet data");




    }
}
