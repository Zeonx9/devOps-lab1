package com.example.devopslab1.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.converter.LocalDateStringConverter;
import com.example.devopslab1.model.Person;
import com.example.devopslab1.model.PersonManager;
import com.example.devopslab1.utils.AllFieldsChecker;

import java.time.format.DateTimeFormatter;

public class ViewController {
    @FXML private TextField surnameTF;
    @FXML private TextField nameTF;
    @FXML private TextField patronymicTF;
    @FXML private DatePicker datePicker;
    @FXML private Button enterButton;
    @FXML private Label answerText;
    @FXML private Label warningText;
    private final AllFieldsChecker checker = new AllFieldsChecker((msg, res) -> {
        warningText.setText(msg);
        enterButton.setDisable(!res);
    });

    public void init() {
        // link listeners
        surnameTF.textProperty().addListener(checker.newListener(PersonManager::checkStrInput));
        nameTF.textProperty().addListener(checker.newListener(PersonManager::checkStrInput));
        patronymicTF.textProperty().addListener(checker.newListener(PersonManager::checkStrInput));
        datePicker.valueProperty().addListener(checker.newListener(PersonManager::checkDateOfBirth));

        // set initial values
        datePicker.setConverter(new LocalDateStringConverter(DateTimeFormatter.ofPattern("dd.MM.yyyy"), null));
        enterButton.setDisable(true);
    }

    @FXML
    protected void onEnterButtonClicked() {
        PersonManager pm = new PersonManager(
                Person.builder()
                        .name(nameTF.getText().toLowerCase())
                        .surname(surnameTF.getText().toLowerCase())
                        .patronymic(patronymicTF.getText().toLowerCase())
                        .dateOfBirth(datePicker.getValue())
                        .build()
        );
        answerText.setText(
                "Ваши фамилия и инициалы: " + pm.getPrettyName() + "\n" +
                "Ваш возраст: " + pm.getPrettyAge() + "\n" +
                "Ваш пол: " + pm.getGender()
        );
    }
}