package demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class PrescriptionWithPatientAndTreatment {

    private Prescription prescription;
    private Patient patient;
    private Treatment treatment;

    public PrescriptionWithPatientAndTreatment(Prescription prescription, Patient patient, Treatment treatment) {
        this.prescription = prescription;
        this.patient = patient;
        this.treatment = treatment;
    }

    public Prescription getPrescription(){return prescription;}

    public Patient getPatient(){return patient;}

    public Treatment getTreatment(){return treatment;}


}
