package com.ru.spbstu.repository;

import com.ru.spbstu.entities.SemesterPreference;
import com.ru.spbstu.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SemesterPreferenceRepository extends JpaRepository<SemesterPreference, Long> {
    List<SemesterPreference> findByUser(User user);
}