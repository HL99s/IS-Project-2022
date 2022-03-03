package demo.unitTests.Prescription;

import demo.Patient.Patient;
import demo.Prescription.Prescription;
import demo.Prescription.PrescriptionWithPatientAndTreatment;
import demo.Treatment.Treatment;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.Assert.*;

public class TestPrescriptionWithPatientAndTreatment {

    @Test
    public void testGetPrescription() {
        
        Prescription prescription = new Prescription(4L, 10L, "tipo 6", "commento prova");
        Patient patient = new Patient(1L,"Prova","Prova1", LocalDate.of(1999,12,31),"Prova2");
        Treatment treatment = new Treatment(1L, 1L,"Provatipo", new Date(122,0,10,15,0,0));
        PrescriptionWithPatientAndTreatment presPatiTreat = new PrescriptionWithPatientAndTreatment(prescription, patient, treatment);
        assertEquals(prescription, presPatiTreat.getPrescription());
    }

    @Test
    public void testGetPatient() {

        Prescription prescription = new Prescription(4L, 10L, "tipo 6", "commento prova");
        Patient patient = new Patient(1L,"Prova","Prova1", LocalDate.of(1999,12,31),"Prova2");
        Treatment treatment = new Treatment(1L, 1L,"Provatipo", new Date(122,0,10,15,0,0));
        PrescriptionWithPatientAndTreatment presPatiTreat = new PrescriptionWithPatientAndTreatment(prescription, patient, treatment);
        assertEquals(patient, presPatiTreat.getPatient());
    }

    @Test
    public void testGetTreatment() {

        Prescription prescription = new Prescription(4L, 10L, "tipo 6", "commento prova");
        Patient patient = new Patient(1L,"Prova","Prova1", LocalDate.of(1999,12,31),"Prova2");
        Treatment treatment = new Treatment(1L, 1L,"Provatipo", new Date(122,0,10,15,0,0));
        PrescriptionWithPatientAndTreatment presPatiTreat = new PrescriptionWithPatientAndTreatment(prescription, patient, treatment);
        assertEquals(treatment, presPatiTreat.getTreatment());
    }
    
    
}
