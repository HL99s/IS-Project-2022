package demo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TreatmentRepository extends CrudRepository<Treatment, Long> {

        Treatment findById(long id);

    }
