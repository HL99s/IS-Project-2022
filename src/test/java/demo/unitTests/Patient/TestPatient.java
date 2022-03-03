package demo.unitTests.Patient;

import demo.Patient.Patient;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class TestPatient {

    @Test
    public void testGetId(){
        Patient patient = new Patient(1L,"Prova","Prova1", LocalDate.of(1999,12,31),"Prova2");
        assertEquals("1", patient.getId().toString());
    }

    @Test
    public void testGetFirstName(){
        Patient patient = new Patient("Prova","Prova1", LocalDate.of(1999,12,31),"Prova2");
        assertEquals("Prova", patient.getFirstName());
    }

    @Test
    public void testGetLastName(){
        Patient patient = new Patient("Prova","Prova1", LocalDate.of(1999,12,31),"Prova2");
        assertEquals("Prova1", patient.getLastName());
    }

    @Test
    public void testGetBirthDate(){
        Patient patient = new Patient("Prova","Prova1", LocalDate.of(1999,12,31),"Prova2");
        LocalDate date = LocalDate.of(1999, 12, 31);
        assertEquals(date, patient.getBirthDate());
    }

    @Test
    public void testGetResidence(){
        Patient patient = new Patient("Prova","Prova1", LocalDate.of(1999,12,31),"Prova2");
        assertEquals("Prova2", patient.getResidence());
    }

    @Test
    public void testSetFirstName(){
        Patient patient = new Patient();
        patient.setFirstName("Prova2");
        assertEquals("Prova2", patient.getFirstName());
    }
}
