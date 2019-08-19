package ru.werdna.repositories;

import ru.werdna.models.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsersRepositoryInMemoryImpl implements UsersRepository {
    private List<User> users;

    public UsersRepositoryInMemoryImpl() {
        this.users = new ArrayList<>();
        User user = new User("Andrew", "qwety", LocalDate.parse("1993-01-22"));
        User user2 = new User("Andrew", "qwety", LocalDate.parse("1993-01-22"));
        User user3 = new User("Andrew", "qwety", LocalDate.parse("1993-01-22"));
        users.add(user);
        users.add(user2);
        users.add(user3);
    }

    @Override
    public void save(User user) {
        users.add(user);
    }

    public List<User> findAll() {
        return this.users;
    }

}
