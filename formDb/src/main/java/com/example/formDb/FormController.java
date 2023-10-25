package com.example.formDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FormController {

    @GetMapping("/form")
    public String getForm(Model model) {
        model.addAttribute("form", new Form());

        return "form";
    }

    @Autowired
    private final FormRepository formRepository;
    public FormController(FormRepository formRepository) {
        this.formRepository = formRepository;
    }

    @GetMapping("/listNumDb")
    public String findAllNum(Model model) {
        Iterable<Form> dataList = this.formRepository.findAll();
        model.addAttribute("dataForm", dataList);
        return "listNumDb";
    }

    @PostMapping("/form")
    @ResponseBody
    public String addNum(@RequestBody Form form) {
        form.doSum();
        formRepository.save(form);
        return "{\"result\":" + form.getSum() + "}";
    }

    @GetMapping("/avg")
    @ResponseBody
    public String calcAvg(){
        Form dataForm = new Form();
        Iterable<Form> dataList2 = this.formRepository.findAll();

        return "{\"avg\":" +  dataForm.getAvg(dataList2) + "}";
    }
}
