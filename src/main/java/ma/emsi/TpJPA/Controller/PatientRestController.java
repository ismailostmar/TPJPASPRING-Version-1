package ma.emsi.TpJPA.Controller;

import ma.emsi.TpJPA.entities.Patient;
import ma.emsi.TpJPA.repositoriesDAO.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {

    @Autowired
    private PatientRepository patientRepository;

    // API REST FULL
    //@ResponseBody on a plus besoin parce que on a utilisé l'annotation RestController
    @GetMapping(path = "/listPatient")
    public List<Patient> list() {
        return patientRepository.findAll();
    }

    @GetMapping("/patient/{id}")
    public Patient getOne(@PathVariable Long id) {
        return patientRepository.findById(id).get();
    }
}
