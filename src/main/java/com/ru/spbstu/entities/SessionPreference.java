package com.ru.spbstu.entities;

import com.ru.spbstu.util.StringListConverter;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "session_preferences")
@Data
public class SessionPreference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private String subjectName;

    @Convert(converter = StringListConverter.class)
    private List<String> preferredDates;

    @Convert(converter = StringListConverter.class)
    private List<String> unwantedDates;

    private Boolean aroundNewYear;

    @Convert(converter = StringListConverter.class)
    private List<String> preferredDays;

    @Convert(converter = StringListConverter.class)
    private List<String> preferredTimes;

    private String loadType;
    private String building;
    private String room;
    private String boardType;
    private Boolean computers;
    private String osType;
    private String format;
    private Integer importance;

    @Column(columnDefinition = "text")
    private String comments;

    // Getters and Setters
}