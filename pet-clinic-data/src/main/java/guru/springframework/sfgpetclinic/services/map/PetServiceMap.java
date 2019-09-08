package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.services.CrudService;
import guru.springframework.sfgpetclinic.services.PetService;

public class PetServiceMap extends AbstractMapService<Pet,Long> implements PetService {


    @Override
    public Pet save(Pet obj) {
        return this.save(obj.getId(),obj);
    }
}
