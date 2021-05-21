package ma.emsi.TpJPA.Controller;
import ma.emsi.TpJPA.entities.Patient;
import ma.emsi.TpJPA.repositoriesDAO.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    // Delete Patient
    @GetMapping(path = "/deletePatient")
    public String delete(Long id){
        patientRepository.deleteById(id);
        return "redirect:/pat?";
    }

    @GetMapping(path = "/formPatient")
    public String formPatient(Model model) {
        model.addAttribute("patient", new Patient());
        return "formPatient";
    }

    // Add Patient
    // BindingResult : est une collection qui contient la liste des erreurs generé au moment de la validation
     @PostMapping(path = "/savePatient")
    public String savePatient(@Valid Patient patient, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "formPatient";
        patientRepository.save(patient);
        return "redirect:/pat?";
    }

    // the Main Page
    @GetMapping(path = "/pat")
       /*ces Parametre pour faire la pagination ,
     size pour chaque page on affiche 5 resultats*/
    public String List(Model model,
                @RequestParam(name = "page", defaultValue = "0") int page,
                @RequestParam(name = "size", defaultValue = "6") int size,
                @RequestParam(name = "keyword", defaultValue = "") String mc)
    {
        Page<Patient> pagePatients =
         patientRepository.findByNomContains(mc, PageRequest.of(page, size));
        // Stocker les Patients dans le Model
        model.addAttribute("patients",pagePatients.getContent());
        // Retourne le nombre Total de pages
        model.addAttribute("pages",new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("size",size);
        model.addAttribute("keyword",mc);
        return "patients";
    }
}
