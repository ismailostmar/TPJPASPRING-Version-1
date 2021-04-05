package ma.emsi.TpJPA;

import ma.emsi.TpJPA.entities.Patient;
import ma.emsi.TpJPA.repositoriesDAO.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class TpJpaApplication implements CommandLineRunner {

	@Autowired // Injetction de Dependences
	private PatientRepository patientRepository;

	public static void main(String[] args) {
		SpringApplication.run(TpJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		// On Ajoute quelque Patients à l'aide de la Fonction Save();

		patientRepository.save(new Patient(null,"ISMAIL",new Date(),2300,false));
		patientRepository.save(new Patient(null,"ILYASS",new Date(),2400,false));
		patientRepository.save(new Patient(null,"AYOUB",new Date(),2500,false));
		patientRepository.save(new Patient(null,"KARIM",new Date(),2600,true));

		System.out.println("**************************");

		// On Cherche tous les Patients
		patientRepository.findAll().forEach(p->{
			System.out.println(p.toString());
		});

		System.out.println("*****************************");

		// On Cherche un Patient dont son ID est : 4
		Patient patient = patientRepository.findById(4L).get();
		System.out.println(patient.getNom());

        System.out.println("*****************************");
		List<Patient> patients = patientRepository.findByNomContains("K");
		patients.forEach(p->{
			System.out.println(p.toString());
		});

		// on cherche les patients avec la maladie
		System.out.println("*****************************");
		List<Patient> patients1 = patientRepository.findByMalade(false);
		patients1.forEach(p->{
			System.out.println(p.toString());
		});

		// On cherche les Patients avec leurs nom et la maladie
		System.out.println("*****************************");
		List<Patient> patients2 = patientRepository.findByNomContainsAndMalade("K",true);
		patients2.forEach(p->{
			System.out.println(p.toString());
		});

		// On Supprime le Patients à partir de son ID
		//patientRepository.deleteById(3L);

		System.out.println("*****************************");
		List<Patient> patients4 = patientRepository.findAll();
		patients4.forEach(p->{
			System.out.println(p.toString());
		});




	}
}
