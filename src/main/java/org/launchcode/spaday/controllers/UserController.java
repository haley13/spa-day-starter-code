package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("add")
    public String displayAddUserForm(){
        return "user/add";

    }
    @PostMapping("add")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {

          if (!verify.equals(user.getPassword())) {
              model.addAttribute("error", "Your passwords don't match. Try again");
            return "user/add" ;
            //could be used for email too

       } else {
              model.addAttribute( "reply", "Welcome, " + user.getUsername() + "!");
        return "user/index";

        }
    }

}
