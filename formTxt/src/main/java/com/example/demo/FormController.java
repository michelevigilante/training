package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.io.*;

@Controller
public class FormController {

    @GetMapping("/form")
    public String getForm(Model model) {
        model.addAttribute("form", new Form());
        return "form";
    }

    @GetMapping("/listFileData")
    public String getData(@ModelAttribute Form dataForm, Model model) {
        model.addAttribute("dataForm", dataForm);
        return "listFileData";
    }

    @PostMapping(value = "/form" ,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getSumForm(@RequestBody Form dataForm) throws Exception {
        dataForm.saveDataTxt();
        return "{\"result\":" + dataForm.getSum() + "}";
    }

    @GetMapping("/avg")
    @ResponseBody
    public String getAvgFile (@ModelAttribute Form dataForm) throws Exception {
        return "{\"avg\":" + dataForm.getAverageFromTxt() + "}";
    }
}