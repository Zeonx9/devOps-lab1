package com.example.devopslab1.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Person {
    private final String surname;
    private final String name;
    private final String patronymic;
    private final LocalDate dateOfBirth;
}
