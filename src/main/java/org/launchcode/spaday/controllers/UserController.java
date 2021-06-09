package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("/add")
    public String displayAddUserForm(Model model){
        model.addAttribute(new User());
        return "user/add";

    }
    @PostMapping()
    public String processAddUserForm(Model model, @ModelAttribute @Valid User user,Errors errors, String verify) {
        if(errors.hasErrors()) {
            //model.addAttribute("error", "Please check your input.");
            return "user/add";

        }
          if (!verify.equals(user.getPassword())) {
              model.addAttribute("error", "Your passwords don't match. Try again.");
            return "user/add" ;
            //could be used for email too

       } else {
              model.addAttribute( "reply", "Welcome, " + user.getUsername() + "!");
        return "user/index";

        }
    }

}
