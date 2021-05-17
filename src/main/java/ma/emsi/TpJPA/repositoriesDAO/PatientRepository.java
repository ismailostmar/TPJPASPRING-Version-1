package ma.emsi.TpJPA.repositoriesDAO;
import ma.emsi.TpJPA.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
/* Mapping relationnel*/
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Page<Patient> findByNomContains(String mc, Pageable pageable);
    List<Patient> findByMalade(boolean b);
    List<Patient> findByNomContainsAndMalade(String name, boolean b);
}
