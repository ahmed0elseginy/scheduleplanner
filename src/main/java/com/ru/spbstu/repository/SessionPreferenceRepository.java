package com.ru.spbstu.repository;

import com.ru.spbstu.entities.SessionPreference;
import com.ru.spbstu.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionPreferenceRepository extends JpaRepository<SessionPreference, Long> {
    List<SessionPreference> findByUser(User user);
}
