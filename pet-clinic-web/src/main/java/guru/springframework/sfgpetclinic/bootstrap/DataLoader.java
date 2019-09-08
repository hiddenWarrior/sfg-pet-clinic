package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.OwnerServiceMap;
import guru.springframework.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(){
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("yasser");
        owner1.setLastName("ahmad");
        ownerService.save(owner1);


        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("mohamad");
        owner2.setLastName("taha");
        ownerService.save(owner2);

        System.out.println("Loaded owners.....");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("omar");
        vet1.setLastName("saftawi");
        vetService.save(vet1);


        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("kemal");
        vet2.setLastName("effendi");
        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}