package ro.itschool.project.services;

import org.springframework.stereotype.Service;
import ro.itschool.project.models.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService{

    List<User> userList = new ArrayList<>();

    @Override
    public User createUser(String firstName, String lastName, String email) {
        if (!validName(firstName) || !validName(lastName) || !validEmail(email)){
            throw new IllegalArgumentException("one of the fields are invalid");
        }
        User user = new User();
        long userId = userList.isEmpty() ? 0 : userList.get(userList.size()-1).getId()+1;
        // note using just: userId = userList.size()+1 breaks easily when removing any element apart from the last one
        user.setId(userId);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setCreationTime(LocalDateTime.now());
        userList.add(user);

        // TODO send an email to the user

        return user;
    }

    boolean validName(String name){
        return name.length()>2; // screw you people named "Al"
    }
    boolean validEmail(String email){
        return email.toLowerCase().matches("[a-z0-9._%-]+@[a-z0-9.-]+\\.[a-z]{2,4}");
    }

    // could use a map/tree instead will be faster
    @Override
    public User getUser(long id) {
        return userList.stream().
                filter( e -> e.getId() == id)
                .findFirst().orElse(null);
    }
}
