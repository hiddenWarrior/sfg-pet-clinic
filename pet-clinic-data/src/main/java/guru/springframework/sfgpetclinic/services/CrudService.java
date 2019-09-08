package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.BaseEntity;

import java.util.Set;

public interface CrudService<T extends BaseEntity,ID extends Long> {
    public T findById(ID id);
    public T save(T obj);
    public Set<T> findAll();
    public void delete(T obj);
    public void deleteById(ID id);

}
