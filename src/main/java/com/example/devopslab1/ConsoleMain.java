package com.example.devopslab1;

import com.example.devopslab1.model.Person;
import com.example.devopslab1.model.PersonManager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ConsoleMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String sur = "", name = "", pat = "";
        while (sur.isBlank()) {
            try {
                System.out.println("Введите свое ФИО на русском языке");
                StringTokenizer st = new StringTokenizer(sc.nextLine());
                sur = st.nextToken();
                name = st.nextToken();
                pat = st.nextToken();
            } catch (NoSuchElementException e) {
                System.out.println("Строка должна содержать 3 русских слова.");
            }
        }

        LocalDate date = null;
        while (date == null) {
            try {
                System.out.println("Введите вашу дату рождения");
                date = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            } catch (DateTimeParseException e) {
                System.out.println("формат даты: дд.ММ.гггг");
            }
        }
        Person p = Person.builder()
                .surname(sur)
                .name(name)
                .patronymic(pat)
                .dateOfBirth(date)
                .build();
        PersonManager pm = new PersonManager(p);

        System.out.println("Ваше форматированное имя: " + pm.getPrettyName());
        System.out.println("Ваш пол: " + pm.getGender());
        System.out.println("Ваш возраст: " + pm.getPrettyAge());
    }
}
