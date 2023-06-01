FROM openjdk:17

COPY target/devOps-lab1-1.0-SNAPSHOT.jar app.jar
COPY libs/javafx-sdk-17.0.2 javafx-sdk-17

ENTRYPOINT java --module-path /javafx-sdk-17/lib --add-modules=javafx.controls,javafx.fxml -jar app.jar -Dprism.verbose=true