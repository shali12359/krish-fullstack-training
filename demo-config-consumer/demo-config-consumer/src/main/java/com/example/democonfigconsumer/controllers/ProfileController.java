package com.example.democonfigconsumer.controllers;

import com.example.democonfigconsumer.models.MemberProfileConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ProfileController {
    @Autowired
    MemberProfileConfiguration memberProfileConfiguration;

    @RequestMapping(value = "/profile")
    public String getConfig(Model model) {
        model.addAttribute("model", memberProfileConfiguration.getDefaultModel());
        model.addAttribute("min", memberProfileConfiguration.getMinRentPeriod());
        return "mprofile";
    }
}
