package ma.emsi.TpJPA.Controller;

import ma.emsi.TpJPA.entities.Patient;
import ma.emsi.TpJPA.repositoriesDAO.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping(path = "/index")
    public String index(){

        return "index";
    }

    @GetMapping(path = "/pat")
    public String List(Model model,
    /*ces Parametre pour faire la pagination ,
     size pour chaque page on affiche 5 resultats*/
    @RequestParam(name = "page", defaultValue = "0") int page,
    @RequestParam(name = "size", defaultValue = "5") int size)
    {
        Page<Patient> pagePatients = patientRepository.findAll(PageRequest.of(page,size));
        // Stocker les Patients dans le Model
        model.addAttribute("patients",pagePatients.getContent());
        model.addAttribute("pages",new int[pagePatients.getTotalPages()]); // Retourne le nombre Tital de pages

        return "patients";
    }
}
