package demo.Patient;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String residence;


    public Patient(String firstName, String lastName, LocalDate birthDate, String residence) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.residence = residence;
    }

    public Patient(Long id, String firstName, String lastName, LocalDate birthDate, String residence) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.residence = residence;
    }

    public Patient() {
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName){this.firstName = firstName;}

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getResidence() {
        return residence;
    }

}
