package demo.unitTests.Treatment;

import demo.Patient.Patient;
import demo.Treatment.Treatment;
import demo.Treatment.TreatmentWithPatient;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.Assert.*;

public class TestTreatmentWithPatient {

    @Test
    public void testGetPatient(){
        Patient patient = new Patient(1L,"Prova","Prova1", LocalDate.of(1999,12,31),"Prova2");
        Treatment treatment = new Treatment(1L, 1L,"Provatipo", new Date(122,0,10,15,0,0));
        TreatmentWithPatient treaPatient = new TreatmentWithPatient(treatment, patient);
        assertEquals(patient, treaPatient.getPatient());
    }

    @Test
    public void testGetTreatment(){
        Patient patient = new Patient(1L,"Prova","Prova1", LocalDate.of(1999,12,31),"Prova2");
        Treatment treatment = new Treatment(1L, 1L,"Provatipo", new Date(122,0,10,15,0,0));
        TreatmentWithPatient treaPatient = new TreatmentWithPatient(treatment, patient);
        assertEquals(treatment, treaPatient.getTreatment());
    }
}
