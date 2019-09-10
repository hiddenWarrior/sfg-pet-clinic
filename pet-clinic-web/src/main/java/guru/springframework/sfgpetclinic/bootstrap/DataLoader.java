package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.SpecialityService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if(count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);


        Owner owner1 = new Owner();
        owner1.setFirstName("yasser");
        owner1.setLastName("ahmad");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("141424124");
        Pet yasserPet = new Pet();
        yasserPet.setPetType(savedDogPetType);
        yasserPet.setOwner(owner1);
        yasserPet.setBirthDate(LocalDate.now());
        yasserPet.setName("clous");
        owner1.getPets().add(yasserPet);
        ownerService.save(owner1);


        Owner owner2 = new Owner();
        owner2.setFirstName("mohamad");
        owner2.setLastName("taha");
        owner2.setAddress("123 berkely");
        owner2.setCity("california");
        owner2.setTelephone("111424124");
        Pet tahaPet = new Pet();
        tahaPet.setPetType(savedCatPetType);
        tahaPet.setName("kitty");
        tahaPet.setBirthDate(LocalDate.now());
        owner2.getPets().add(tahaPet);
        ownerService.save(owner2);

        System.out.println("Loaded owners.....");

        Vet vet1 = new Vet();
        vet1.setFirstName("omar");
        vet1.setLastName("saftawi");
        vet1.getSpecialities().add(savedDentistry);
        vetService.save(vet1);


        Vet vet2 = new Vet();
        vet2.setFirstName("kemal");
        vet2.setLastName("effendi");
        vet2.getSpecialities().add(savedRadiology);
        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
