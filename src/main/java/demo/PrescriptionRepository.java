package demo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PrescriptionRepository extends CrudRepository<Prescription, Long> {


        Prescription findById(long id);

        List<Prescription> findByIdPatient(long idPatient);
    }
