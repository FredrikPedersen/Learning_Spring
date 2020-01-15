package petclinic.model.pets;

import petclinic.model.people.Owner;

import java.time.LocalDate;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 15/01/2020 at 17:42
 */
public class Pet {

    private PetType petType;
    private Owner owner;
    private LocalDate birthDate;

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
