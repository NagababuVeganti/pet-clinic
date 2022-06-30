package sfpetclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com","controllers","bootstrap","services", "repositories","services.SpringDataJPA"})
public class SfPetClinicApplication {

    public static void main(String[] args) {
        SpringApplication.run(SfPetClinicApplication.class, args);


    }

}
