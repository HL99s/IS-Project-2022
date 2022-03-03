package demo.Prescription;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Prescription {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Long idPatient;
    private Long idTreatment;
    private String type;
    private String comment;

    public Prescription(Long idPatient, Long idTreatment, String type, String comment) {
        this.idPatient = idPatient;
        this.idTreatment = idTreatment;
        this.type = type;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public Long getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Long idPatient) {
        this.idPatient = idPatient;
    }

    public Long getIdTreatment(){return idTreatment;}

    public String getType() {
        return type;
    }

    public String getComment(){return comment;}


}
