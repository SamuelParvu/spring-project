package ro.itschool.project.services;

import ro.itschool.project.models.User;

public interface UserService {

    User createUser(String firstName, String lastName, String email);
    User getUser(long id);
}
