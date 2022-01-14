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
        repositoryTreatment.save(new Treatment(1L,"T1", new Date(122,0,10,15,0,0)));
        repositoryTreatment.save(new Treatment(1L,"T2", new Date(122,0,11,15,0,0)));
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
            return "loginFailed";
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

    @RequestMapping("/patientInfo")
    public String patientInfo(
            @RequestParam(name="id", required=true) Long id,
            Model model) {
        Optional<Patient> result = repositoryPatient.findById(id);
        if (result.isPresent()){
            Patient patient = result.get();
            model.addAttribute("patient", patient);

            List<Prescription> prescriptions = new LinkedList<>();
            for(Prescription p: repositoryPrescription.findByIdPatient(id)){
                prescriptions.add(p);
            }
            model.addAttribute("prescriptions", prescriptions);

            return "patientInfo";
        }
        else
            return "notfound";
    }

    public static Date removeTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
    @RequestMapping("/treatmentsList")
    public String treatmentsList(Model model){
        List<Treatment> treatments = new LinkedList<>();
        List<Optional <Patient>> patientsList = new ArrayList<>();
        List<TreatmentWithPatient> completeTreatments = new LinkedList<>();

        for(Treatment treatment: repositoryTreatment.findAll()){
            treatment.setDate(removeTime(treatment.getDate()));
            completeTreatments.add(new TreatmentWithPatient(treatment, repositoryPatient.findById(treatment.getidPatient()).get()));
        }

        model.addAttribute("completeTreatments", completeTreatments);
        return "showTreatments";
    }

    @RequestMapping("/dailyTreatments")
    public String dailyTreatments(Model model){

        List<TreatmentWithPatient> completeTreatments = new LinkedList<>();
        for(Treatment treatment: repositoryTreatment.findAll()){
            if(treatment.getDate().getDate() == LocalDate.now().getDayOfMonth() &&
                    (treatment.getDate().getMonth() + 1) == LocalDate.now().getMonthValue() &&
                    (treatment.getDate().getYear() + 1900) == LocalDate.now().getYear()){

                completeTreatments.add(new TreatmentWithPatient(treatment, repositoryPatient.findById(treatment.getidPatient()).get()));
            }
        }
        model.addAttribute("completeTreatments", completeTreatments);
        return "showDailyTreatments";
    }

    @RequestMapping("/showPrescriptions")
    public String showPrescriptions(Model model){
        List<Prescription> prescriptionsList = new LinkedList<>();
        List<PrescriptionWithPatientAndTreatment> completePrescriptionsList = new ArrayList<>();
        for(Prescription prescription: repositoryPrescription.findAll()){
            completePrescriptionsList.add(
                    new PrescriptionWithPatientAndTreatment(prescription,
                            repositoryPatient.findById(prescription.getIdPatient()).get(),
                            repositoryTreatment.findById(prescription.getIdTreatment()).get() ) );
        }
        model.addAttribute("completePrescriptions", completePrescriptionsList);

        return "showPrescriptions";
    }

    @RequestMapping("/createPage")
    public String createPage(@RequestParam(name="idTreatment", required = true) Long idTreatment, Model model){
        model.addAttribute("idTreatment", idTreatment);
        Optional<Treatment> treatment = repositoryTreatment.findById(idTreatment);
        model.addAttribute("idPatient", treatment.get().getidPatient());

        return "inputPrescription";
    }

    @RequestMapping("/createPrescription")
    public String create(
            @RequestParam(name="idPatient", required=true) Long idPatient,
            @RequestParam(name="idTreatment", required=true) Long idTreatment,
            @RequestParam(name="type", required=true) String type,
            @RequestParam(name="comment", required=true) String comment) {
        repositoryPrescription.save(new Prescription(idPatient,idTreatment,type,comment));
        return "redirect:/showPrescriptions";
    }

    @RequestMapping("/editPrescription")
    public String editPrescription(
            @RequestParam(name="id", required=true) Long id,
            Model model) {
        Optional<Prescription> result = repositoryPrescription.findById(id);
        if (result.isPresent()) {
            Prescription prescription = result.get();
            model.addAttribute("prescription", prescription);
            return "editPrescription";
        }
        else
            return "notfound";
    }

    @RequestMapping("/updatePrescription")
    public String updatePrescription(
            @RequestParam(name="id", required=true) Long id,
            @RequestParam(name="idPatient", required=true) Long idPatient,
            @RequestParam(name="idTreatment", required=true) Long idTreatment,
            @RequestParam(name="type", required=true) String type,
            @RequestParam(name="comment", required=true) String comment) {
        Optional<Prescription> result = repositoryPrescription.findById(id);
        if (result.isPresent()) {
            repositoryPrescription.delete(result.get());
            repositoryPrescription.save(new Prescription(idPatient,idTreatment,type,comment));
            return "redirect:/showPrescriptions";
        }
        else
            return "notfound";
    }

    @RequestMapping("/deletePrescription")
    public String deletePrescription(
            @RequestParam(name="id", required=true) Long id) {
        Optional<Prescription> result = repositoryPrescription.findById(id);
        if (result.isPresent()){
            repositoryPrescription.delete(result.get());
            return "redirect:/showPrescriptions";
        }
        else
            return "notfound";
    }
}