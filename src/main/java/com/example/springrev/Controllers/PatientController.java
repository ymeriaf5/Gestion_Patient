package com.example.springrev.Controllers;

import com.example.springrev.Services.PatientService;
import com.example.springrev.entities.Patient;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping("/index")
    public String patient(Model model,
                          @RequestParam(name = "page", defaultValue = "0") int page,
                          @RequestParam(name = "size", defaultValue = "5") int size,
                          @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        Page<Patient> patientsPage = patientService.getAllPatientsbyNom(PageRequest.of(page, size), keyword);
        model.addAttribute("listpatients", patientsPage.getContent());
        model.addAttribute("pages", new int[patientsPage.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "patients";
    }

    @GetMapping("/formPatients")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String formPatients(Model model) {
        model.addAttribute("patient", new Patient());
        return "formPatients";
    }

    @PostMapping("/save")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String save(Model model, @Valid Patient patient, BindingResult bindingResult,
                       @RequestParam(name = "keyword", defaultValue = "") String keyword,
                       @RequestParam(name = "page", defaultValue = "0") int page) {
        if (bindingResult.hasErrors()) {
            return "formPatients";
        } else {
            patientService.save(patient);
            return "redirect:/index?page=" + page + "&keyword=" + keyword;
        }
    }

    @GetMapping("/editForm")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String editForm(Model model, Long id, String keyword, int page) {
        Patient p = patientService.getPatientbyId(id);
        model.addAttribute("patient", p);
        model.addAttribute("page", page);
        model.addAttribute("keyword", keyword);
        return "editForm";
    }

    @GetMapping("/delete")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String delete(long id, String keyword, int page) {
        patientService.delete(id);
        return "redirect:/user/index?page=" + page + "&keyword=" + keyword;
    }
    @GetMapping("/")
    public String home(){
        return "redirect:/index";
    }
}
