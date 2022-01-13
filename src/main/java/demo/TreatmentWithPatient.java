package demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


public class TreatmentWithPatient {

    private Treatment treatment;
    private Patient patient;

    protected TreatmentWithPatient() {}

    public TreatmentWithPatient(Treatment treatment, Patient patient) {
        this.treatment = treatment;
        this.patient = patient;
    }

    public Patient getPatient() {
        return patient;
    }

    public Treatment getTreatment(){
        return treatment;
    }
}
