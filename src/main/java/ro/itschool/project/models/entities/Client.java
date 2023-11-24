package ro.itschool.project.models.entities;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Client {

    long id;
    String firstName;
    String lastName;
    String email;
    LocalDateTime creationTime;
}
