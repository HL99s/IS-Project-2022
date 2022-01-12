package demo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PatientRepository extends CrudRepository<Patient, Long> {

        Patient findById(long id);
    }
