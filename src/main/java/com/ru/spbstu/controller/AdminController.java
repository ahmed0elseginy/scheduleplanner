package com.ru.spbstu.controller;

import com.ru.spbstu.entities.SessionPreference;
import com.ru.spbstu.entities.User;
import com.ru.spbstu.service.PreferenceService;
import com.ru.spbstu.util.ExcelExporter;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.InputStream;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private PreferenceService preferenceService;

    @GetMapping("/export-session")
    public ResponseEntity<byte[]> exportSessionExcel(HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser == null || !"ADMIN".equals(currentUser.getRole())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        List<SessionPreference> sessionPrefs = preferenceService.getAllSessionPreferences();
        InputStream is = ExcelExporter.exportSessionPreferences(sessionPrefs);

        byte[] bytes;
        try {
            bytes = is.readAllBytes();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=session_prefs.xlsx");

        return ResponseEntity.ok()
                .headers(headers)
                .body(bytes);
    }
}
