package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.SpecialityService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetService {
    private final SpecialityService specialityService;
    @Autowired
    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }


    @Override
    public Vet save(Vet vet){
        if(vet != null) {
            if (vet.getSpecialities().size() > 0) {
                vet.getSpecialities().forEach(speciality -> {
                    if (speciality.getId() == null) {
                        Speciality savedSpeciality = specialityService.save(speciality);
                        speciality.setId(savedSpeciality.getId());
                    }
                });
            }
        }
        return super.save(vet);

    }

}
