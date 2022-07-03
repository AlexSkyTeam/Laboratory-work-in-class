package org.example.app.manager;

import org.example.app.dto.UserDTO;
import org.example.app.exception.UserLoginAlreadyRegisteredException;
import org.example.app.exception.UserNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class UserManager {

    private long nextId = 1;
    private final List<UserDTO> users = new ArrayList<>();

    public List<UserDTO> getAll() {
        return users;
    }

    public UserDTO getById(final long id) {
        for (UserDTO user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        throw new UserNotFoundException();
    }

    public UserDTO create(final String login) {
        Objects.requireNonNull(login);

        for (UserDTO user : users) {
            if (user.getLogin().equals(login)) {
                throw new UserLoginAlreadyRegisteredException(login);
            }
        }

        final UserDTO user = new UserDTO(nextId++, login);
        users.add(user);
        return user;
    }
}
