package ru.netology.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.netology.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
     User findByUsername(String username);
}
