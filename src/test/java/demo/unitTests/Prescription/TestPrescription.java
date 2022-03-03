package demo.unitTests.Prescription;

import demo.Prescription.Prescription;
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

    @Test
    public void testGetIdTreatment(){
        Prescription prescription = new Prescription(4L, 10L, "tipo 6", "commento prova");
        assertEquals("10", prescription.getIdTreatment().toString());
    }

    @Test
    public void testGetType(){
        Prescription prescription = new Prescription(4L, 10L, "tipo 6", "commento prova");
        assertEquals("tipo 6", prescription.getType());
    }

    @Test
    public void testGetComment(){
        Prescription prescription = new Prescription(4L, 10L, "tipo 6", "commento prova");
        assertEquals("commento prova", prescription.getComment());
    }
    @Test
    public void testSetIdPatient(){
        Prescription prescription = new Prescription();
        prescription.setIdPatient(4l);
        assertEquals("4", prescription.getIdPatient().toString());
    }

}
