package demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Treatment {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Long idPatient;
    private String type;
    private Date date;

    protected Treatment() {}

    public Treatment(Long idPatient, String type, Date date) {
        this.idPatient = idPatient;
        this.type = type;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public Long getidPatient() {
        return idPatient;
    }

    public String getType() {
        return type;
    }

    public Date getDate(){return date;}

    public void setDate(Date date){this.date = date;}

}
