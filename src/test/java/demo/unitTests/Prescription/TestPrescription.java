package demo.unitTests.Prescription;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestPrescription {

    @Test
    public void testGetId(){
        Prescription prescription = new Prescription(1L,4L, 10L, "tipo 6", "commento prova");
        assertEquals("1",prescription.getId().toString());
    }

    @Test
    public void testGetIdPatient(){
        Prescription prescription = new Prescription(4L, 10L, "tipo 6", "commento prova");
        assertEquals("4",prescription.getIdPatient().toString());
    }
}
