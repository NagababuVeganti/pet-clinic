package sfpetclinic.Model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="pets")
public class Pet extends  BaseEntity
{
    @ManyToOne
    @JoinColumn(name="type_id")
    private PetType petype;
    @Column(name="name")
    private String name;
    @ManyToOne
    @JoinColumn(name="owner_id")
    private Owner owner;
    @Column(name="birth_date")
    private LocalDate birthdate;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "pet")
    private Set<Visit> visits= new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public PetType getPetype() {
        return petype;
    }

    public void setPetype(PetType petype) {
        this.petype = petype;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}
