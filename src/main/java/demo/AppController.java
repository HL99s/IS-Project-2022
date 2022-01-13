package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.*;

@Controller
public class AppController {

    @Autowired
    private PatientRepository repositoryPatient;
    @Autowired
    private TreatmentRepository repositoryTreatment;
    @Autowired
    private PrescriptionRepository repositoryPrescription;

    private void initRepo(){
        repositoryPatient.save(new Patient("marcello", "de vincenzi", LocalDate.of(1999,12,7), "gazzo vigarello"));
        repositoryPatient.save(new Patient("giacomo", "gatto", LocalDate.of(1999,9,14), "cerea"));
        repositoryPatient.save(new Patient("mario", "rossi", LocalDate.of(1989,5,10), "verona"));
        repositoryPatient.save(new Patient("fabio", "bianchi", LocalDate.of(1974,6,30), "mantova"));
        repositoryPatient.save(new Patient("alessio", "verdi", LocalDate.of(1996,11,15), "brescia"));
        repositoryPatient.save(new Patient("maria", "sanna", LocalDate.of(1998,4,2), "torino"));
        repositoryPatient.save(new Patient("giorgio", "caiola", LocalDate.of(2000,1,2), "milano"));
        repositoryPatient.save(new Patient("rosa", "fiore", LocalDate.of(1985,2,5), "verona"));
        repositoryPatient.save(new Patient("luca", "salvo", LocalDate.of(1997,8,8), "brescia"));
        repositoryPatient.save(new Patient("mario", "pasqua", LocalDate.of(1996,7,13), "verona"));
        repositoryTreatment.save(new Treatment(1L,"T1", new Date(1,1,1,1,1,1)));
        repositoryTreatment.save(new Treatment(1L,"T2", new Date()));
        repositoryTreatment.save(new Treatment(2L,"T2", new Date()));
        repositoryTreatment.save(new Treatment(2L,"T4", new Date()));
        repositoryTreatment.save(new Treatment(3L,"T3", new Date()));
        repositoryTreatment.save(new Treatment(5L,"T5", new Date()));
        repositoryTreatment.save(new Treatment(4L,"T1", new Date()));
        repositoryTreatment.save(new Treatment(2L,"T1", new Date()));
        repositoryTreatment.save(new Treatment(1L,"T5", new Date()));
        repositoryTreatment.save(new Treatment(7L,"T3", new Date()));
        repositoryTreatment.save(new Treatment(6L,"T4", new Date()));
        repositoryTreatment.save(new Treatment(8L,"T3", new Date()));

        repositoryPrescription.save(new Prescription(1L, 1L,"prova","ciao"));
        repositoryPrescription.save(new Prescription(1L, 2L,"prova1","ciao1"));
    }

    @RequestMapping("/")
    public String index(){
        initRepo();
        return "login";
    }

    @RequestMapping("/login")
    public String login(@RequestParam(name = "username", required = true) String name,
                        @RequestParam(name = "password", required = true) String pass){
        String username = "admin";
        String password = "admin";
        if(name.equals(username) && pass.equals(password))
            return "home";
        else
            return "login";
    }

    @RequestMapping("/home")
    public String home(){
        return "home";
    }

    @RequestMapping("/patientsList")
    public String patientsList(Model model){
        List<Patient> patients = new LinkedList<>();
        for(Patient patient: repositoryPatient.findAll()){
            patients.add(patient);
        }
        model.addAttribute("patients", patients);

        return "showPatients";
    }

    @RequestMapping("/treatmentsList")
    public String treatmentsList(Model model){
        List<Treatment> treatments = new LinkedList<>();

        for(Treatment treatment: repositoryTreatment.findAll()){
            treatments.add(treatment);
        }
        model.addAttribute("treatments", treatments);
        return "showTreatments";
    }


    @RequestMapping("/read")
    public String read(
            @RequestParam(name="id", required=true) Long id,
            Model model) {
        Optional<Patient> result = repositoryPatient.findById(id);
        if (result.isPresent()){
            Patient Patient = result.get();
            model.addAttribute("Patient", Patient);
            return "read";
        }
        else
            return "notfound";
    }

    @RequestMapping("/createPage")
    public String inputPage(){
        return "inputPrescription";
    }

    @RequestMapping("/createPrescription")
    public String create(
            @RequestParam(name="idPatient", required=true) Long idPatient,
            @RequestParam(name="idTreatment", required=true) Long idTreatment,
            @RequestParam(name="type", required=true) String type,
            @RequestParam(name="comment", required=true) String comment) {
        repositoryPrescription.save(new Prescription(idPatient,idTreatment,type,comment));
        return "redirect:/home";
    }

    @RequestMapping("/edit")
    public String edit(
            @RequestParam(name="id", required=true) Long id,
            Model model) {
        Optional<Patient> result = repositoryPatient.findById(id);
        if (result.isPresent()) {
            Patient Patient = result.get();
            model.addAttribute("Patient", Patient);
            return "edit";
        }
        else
            return "notfound";
    }

    @RequestMapping("/update")
    public String update(
            @RequestParam(name="id", required=true) Long id,
            @RequestParam(name="firstname", required=true) String firstname,
            @RequestParam(name="lastname", required=true) String lastname,
            Model model) {
        Optional<Patient> result = repositoryPatient.findById(id);
        if (result.isPresent()) {
            repositoryPatient.delete(result.get());
            //Patient Patient = new Patient(firstname,lastname);
            //repositoryPatient.save(Patient);
            return "redirect:/list";
        }
        else
            return "notfound";
    }

   @RequestMapping("/delete")
    public String delete(
            @RequestParam(name="id", required=true) Long id) {
        Optional<Patient> result = repositoryPatient.findById(id);
        if (result.isPresent()){
            repositoryPatient.delete(result.get());
            return "redirect:/list";
        }
        else
            return "notfound";
    }


    /*@RequestMapping("/show1")
    public String show1(
            @RequestParam(name="id", required=true) Long id,
            Model model) {
        Optional<Patient> result = repositoryPatient.findById(id);
        if (result.isPresent()){
            Patient Patient = result.get();
            model.addAttribute("Patient", Patient);
            return "show1";
        }
        else
            return "notfound";
    }*/

}