package demo.Treatment;

import demo.Treatment.Treatment;
import org.springframework.data.repository.CrudRepository;

public interface TreatmentRepository extends CrudRepository<Treatment, Long> {

        Treatment findById(long id);
    }
