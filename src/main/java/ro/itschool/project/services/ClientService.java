package ro.itschool.project.services;

import ro.itschool.project.models.entities.Client;

public interface ClientService {

    Client createUser(String firstName, String lastName, String email);
    Client getUser(long id);
}
