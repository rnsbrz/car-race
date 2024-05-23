package com.spring.porscheRace.controller;

import com.spring.porscheRace.model.User;
import com.spring.porscheRace.service.UserService;
import com.spring.porscheRace.utils.BCryptPassword;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import static com.spring.porscheRace.utils.Validator.pwValidCheck;

@Controller
@EnableAutoConfiguration
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    public UserController(@Qualifier("UserService") UserService userService){
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @GetMapping("/register")
    public String registrationPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerNewUser(@Valid @ModelAttribute("user") User u, BindingResult br){
        if (br.hasErrors()){
            return "register";
        }

        if(!pwValidCheck(u.getPassword())) {
            br.rejectValue("password", "error.u", "Password must be 8-12 characters, with at least one letter, one" +
                    " number, and one symbol");
            return "register";
        }
        if(!u.getPassword().equals(u.getPasswordConfirm())){
            br.rejectValue("passwordConfirm", "error.u", "Passwords must match");
            return "register";
        }
        if(userService.getUserByUsername(u.getUsername()) != null) {
            br.rejectValue("username", "error.u", "Username already exists");
            return "register";
        }
        if(userService.getUserByEmail(u.getEmail()) != null) {
            br.rejectValue("email", "error.u", "Email already exists");
            return "register";
        }

        userService.createUser(u);
        return "redirect:/login";
    }

    @GetMapping(value = "/login")
    public String loginPage(Model model){
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/loginUser")
    public String loginUser(@ModelAttribute("user") User loginUser, HttpSession session, Model model) {
        User user = userService.getUserByUsername(loginUser.getUsername());

        if (user == null || !BCryptPassword.checkPassword(loginUser.getPassword(), user.getPassword())){
            model.addAttribute("errorMessage", "Username or password incorrect");
            return "login";
        }

        logger.info("Entered Username: {}", loginUser.getUsername());
        logger.info("Entered Password (hashed): {}", BCryptPassword.hashPassword(loginUser.getPassword()));

        if(BCryptPassword.checkPassword(loginUser.getPassword(), user.getPassword())){
            session.setAttribute("username", user.getUsername());
            return "redirect:/raceSelector";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/login";
    }
}
