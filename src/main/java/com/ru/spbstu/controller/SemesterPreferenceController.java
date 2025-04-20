package com.ru.spbstu.controller;

import com.ru.spbstu.entities.SemesterPreference;
import com.ru.spbstu.entities.User;
import com.ru.spbstu.service.PreferenceService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/semester")
public class SemesterPreferenceController {

    @Autowired
    private PreferenceService preferenceService;

    @GetMapping
    public String showForm(Model model, HttpSession session) {
        User user = (User) session.getAttribute("currentUser");
        if (user == null) return "redirect:/auth/login";

        model.addAttribute("pref", new SemesterPreference());
        return "semester_form"; // HTML form
    }

    @PostMapping
    public String submitForm(@ModelAttribute("pref") SemesterPreference pref,
                             HttpSession session) {
        User user = (User) session.getAttribute("currentUser");
        if (user == null) return "redirect:/auth/login";

        pref.setUser(user);
        preferenceService.saveSemesterPreference(pref);
        return "redirect:/user/main";
    }
}
