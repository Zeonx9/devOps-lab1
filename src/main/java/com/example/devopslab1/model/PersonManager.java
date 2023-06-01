package com.example.devopslab1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import com.example.devopslab1.utils.CheckUtils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static com.example.devopslab1.utils.CheckUtils.*;

@Getter
@AllArgsConstructor
public class PersonManager {
    private Person person;
    public static String checkStrInput(String s) {
        if (s.isBlank()) {
            return "Это поле не должно быть пустым";
        }
        if (anyInStrNot(s, CheckUtils::charIsRussian)) {
            return "Можно вводить только русские буквы";
        }
        return "";
    }

    public static String checkDateOfBirth(LocalDate date) {
        if (date == null) {
            return "Дата рождения не указана";
        }
        if (date.isAfter(LocalDate.now())) {
            return "Эта дата ещё не наступила";
        }
        return "";
    }

    public String getPrettyName() {
        return capitalize(person.getSurname()) + " " +
                getInitial(person.getName()) + "." +
                getInitial(person.getPatronymic()) + ".";
    }

    public String getPrettyAge() {
        int age = calculateAge();
        return age + " " + formOfWordYearFor(age);
    }

    public String getGender() {
        if (checkPatronymicEndsWith("ич") || checkPatronymicEndsWith("лы")) {
            return "Мужской";
        }
        if (checkPatronymicEndsWith("на") || checkPatronymicEndsWith("зы")) {
            return "Женский";
        }
        return "не знаю(";
    }

    private int calculateAge() {
        return (int) ChronoUnit.YEARS.between(person.getDateOfBirth(), LocalDate.now());
    }

    private static String formOfWordYearFor(int age) {
        if (11 <= age % 100 && age % 100 <= 14) {
            return "лет";
        }
        if (age % 10 == 1) {
            return "год";
        }
        if (2 <= age % 10 && age % 10 <= 4) {
            return "года";
        }
        return "лет";
    }

    private boolean checkPatronymicEndsWith(String s) {
        return person.getPatronymic().endsWith(s);
    }
}
