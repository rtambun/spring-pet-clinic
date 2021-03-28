package rtambun.training.spring.petclinic.model;

import java.util.HashSet;
import java.util.Set;

public class Vet extends Person{

    private Set<Speciality> specialties = new HashSet<>();

    public Set<Speciality> getSpecialities() {
        return specialties;
    }

    public void setSpecialities(Set<Speciality> specialties) {
        this.specialties = specialties;
    }
}
