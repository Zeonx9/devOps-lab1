package com.example.devopslab1.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;
class PersonManagerTest {
    private PersonManager undertest;

    @BeforeEach
    void setUp() {
        undertest = new PersonManager(new Person("Иванов", "Артём", "Вадимович", LocalDate.of(2003, Month.JANUARY, 9)));
    }

    @Test
    void checkStrInput() {
        assert PersonManager.checkStrInput("Русский").equals("");
        assert PersonManager.checkStrInput("   ").equals("Это поле не должно быть пустым");
        assert PersonManager.checkStrInput("English").equals("Можно вводить только русские буквы");
    }

    @Test
    void checkDateOfBirth() {
        assert PersonManager.checkDateOfBirth(null).equals("Дата рождения не указана");
        assert PersonManager.checkDateOfBirth(undertest.getPerson().getDateOfBirth()).equals("");
    }

    @Test
    void getPrettyName() {
        assertEquals(undertest.getPrettyName(), "Иванов А.В.");
    }

    @Test
    void getPrettyAge() {
        assertEquals(undertest.getPrettyAge(), "20 лет");
    }

    @Test
    void getGender() {
        assertEquals(undertest.getGender(), "Мужской");
    }
}