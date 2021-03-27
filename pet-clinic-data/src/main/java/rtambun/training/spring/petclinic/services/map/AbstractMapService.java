package rtambun.training.spring.petclinic.services.map;

import rtambun.training.spring.petclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }

    T save(T object){
        object.setId(getNextId());
        map.put(object.getId(), object);
        return object;
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId () {
        try {
            return Collections.max(map.keySet()) + 1L;
        } catch (NoSuchElementException noSuchElementException) {
            return 1L;
        }
    }
}
