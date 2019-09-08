package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.CrudService;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Service;


@Service
public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements OwnerService  {
    @Override
    public Owner save(Owner obj) {
        return super.save(obj.getId(),obj);
    }
}
