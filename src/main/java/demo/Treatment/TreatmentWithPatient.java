package demo.Treatment;

import demo.Patient.Patient;
import demo.Treatment.Treatment;

public class TreatmentWithPatient {

    private Treatment treatment;
    private Patient patient;

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
