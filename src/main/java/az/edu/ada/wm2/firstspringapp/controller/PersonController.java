package az.edu.ada.wm2.firstspringapp.controller;

import az.edu.ada.wm2.firstspringapp.model.Person;
import az.edu.ada.wm2.firstspringapp.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.model.IModel;

import java.util.ArrayList;
import java.util.List;

import java.util.List;
import java.util.ArrayList;

@Controller
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping({"", "/"})
    public String listPersons(Model model){
        var list = personService.listPersons();
        model.addAttribute("persons", list);
        return "person_list";
    }

    @GetMapping("/new")
    public String newForm(Model model){
        model.addAttribute("person", new Person("",""));
        return "new_person_form";
    }

    @PostMapping("/save")
    public String savePerson(Model model, @ModelAttribute("person") Person newPerson){
        personService.addPerson(newPerson);
        return "redirect:/persons";
    }

    @GetMapping("/delete/{idx}")
    public String deletePerson(@PathVariable Integer idx ){
        personService.deletePerson(idx);
        return "redirect:/persons";
    }

    @GetMapping("/update/{idx}")
    public String updateForm(@PathVariable Integer idx, Model model) {
        if (idx < 0 || idx >= personService.listPersons().size()) {
            return "redirect:/persons";
        }
        Person existingPerson = personService.listPersons().get(idx);
        model.addAttribute("person", existingPerson);
        model.addAttribute("personIndex", idx);
        return "update_person";
    }

    @PostMapping("/update/{idx}")
    public String updatePerson(@PathVariable Integer idx, @ModelAttribute("person") Person updatedPerson) {
        personService.updatePerson(idx, updatedPerson);
        return "redirect:/persons";
    }
}