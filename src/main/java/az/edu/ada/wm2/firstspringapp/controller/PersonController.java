package az.edu.ada.wm2.firstspringapp.controller;

import az.edu.ada.wm2.firstspringapp.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private Person defaultPerson;

    @GetMapping
    public String listPersons(Model model){

        System.out.println(defaultPerson);
        var list = List.of(
                new Person("Musa", "Afandiyev"),
                new Person("Zumrud", "Isgandarli"),
                new Person("Fidan", "Yusifova")
        );

        model.addAttribute("persons", list);
        return "person_list";
    }
}
