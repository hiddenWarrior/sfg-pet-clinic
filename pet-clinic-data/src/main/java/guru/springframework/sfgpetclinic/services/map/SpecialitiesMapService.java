package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.services.SpecialitiesService;
import org.springframework.stereotype.Service;

@Service
public class SpecialitiesMapService extends AbstractMapService<Speciality,Long> implements SpecialitiesService {
}
