package demo.unitTests.Treatment;

import demo.Treatment.Treatment;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class TestTreatment {

    @Test
    public void testGetId(){
        Treatment t = new Treatment(1L, 1L,"Provatipo", new Date(122,0,10,15,0,0));
        assertEquals("1", t.getId().toString());
    }

    @Test
    public void testGetIdPatient(){
        Treatment t = new Treatment(2L,"Provatipo", new Date(122,0,10,15,0,0));
        assertEquals("2", t.getIdPatient().toString());
    }

    @Test
    public void testGetType(){
        Treatment t = new Treatment(2L,"Provatipo", new Date(122,0,10,15,0,0));
        assertEquals("Provatipo", t.getType());
    }

    @Test
    public void testGetDate(){
        Treatment t = new Treatment(2L,"Provatipo", new Date(122,0,10,15,0,0));
        Date date = new Date(122,0,10,15,0,0);
        assertEquals(date, t.getDate());
    }

    @Test
    public void testSetDate(){
        Treatment t = new Treatment();
        Date date = new Date();
        t.setDate(date);
        assertEquals(date, t.getDate());
    }
}
