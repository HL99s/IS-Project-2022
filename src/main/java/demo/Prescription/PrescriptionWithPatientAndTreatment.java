package demo.Prescription;

import demo.Patient.Patient;
import demo.Prescription.Prescription;
import demo.Treatment.Treatment;


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
