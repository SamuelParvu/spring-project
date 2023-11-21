package ro.itschool.project.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {

    long id;
    String firstName;
    String lastName;
    String email;
    LocalDateTime creationTime;
}
