package sfpetclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"controllers","bootstrap"})
public class SfPetClinicApplication {

    public static void main(String[] args) {
        SpringApplication.run(SfPetClinicApplication.class, args);
    }

}
