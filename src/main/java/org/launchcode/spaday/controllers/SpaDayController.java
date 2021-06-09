package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;


@Controller
public class SpaDayController {

    @GetMapping
    public String displayClientForm (Model model) {
        return "menu";
    }

    @PostMapping
    public String processClientForm(@RequestParam String skinType, @RequestParam String manipedi, Model model) {
        Client newClient = new Client(skinType, manipedi);
        newClient.setAppropriateFacials(skinType);
        model.addAttribute("client" , newClient);

        return "menu";
    }
}