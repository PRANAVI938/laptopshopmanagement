package com.laptopssale.Controllers;

import com.laptopssale.Entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("userBySession")
public class MainController {
    @GetMapping("/main")
    public String getMainPage() {
        return "main";
    }

    @PostMapping("/main")
    public String setSessionUser(HttpServletRequest request, User user ) {

        HttpSession httpSession = request.getSession();
        httpSession.setAttribute(
                "userBySession",
               new User(user.getUsername(), user.getPassword()));
        return "main";
    }

    @GetMapping("/check")
    public String getSessionAttributes(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("userBySession");
        model.addAttribute("imya", user.getUsername());
        model.addAttribute("pass", user.getPassword());
        return "second";
    }
}
