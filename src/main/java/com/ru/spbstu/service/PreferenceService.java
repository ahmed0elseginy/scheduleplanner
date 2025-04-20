package com.ru.spbstu.service;

import com.ru.spbstu.entities.SemesterPreference;
import com.ru.spbstu.entities.SessionPreference;
import com.ru.spbstu.entities.User;
import com.ru.spbstu.repository.SemesterPreferenceRepository;
import com.ru.spbstu.repository.SessionPreferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreferenceService {

    @Autowired
    private SemesterPreferenceRepository semesterRepo;

    @Autowired
    private SessionPreferenceRepository sessionRepo;

    // ✅ حفظ تفضيلات الفصل
    public void saveSemesterPreference(SemesterPreference pref) {
        semesterRepo.save(pref);
    }

    // ✅ حفظ تفضيلات السессии
    public void saveSessionPreference(SessionPreference pref) {
        sessionRepo.save(pref);
    }

    // ✅ جلب تفضيلات مدرس معيّن
    public List<SemesterPreference> getSemesterPreferencesForUser(User user) {
        return semesterRepo.findByUser(user);
    }

    public List<SessionPreference> getSessionPreferencesForUser(User user) {
        return sessionRepo.findByUser(user);
    }

    // ✅ للمشرف: جلب كل التفضيلات
    public List<SemesterPreference> getAllSemesterPreferences() {
        return semesterRepo.findAll();
    }

    public List<SessionPreference> getAllSessionPreferences() {
        return sessionRepo.findAll();
    }
}
