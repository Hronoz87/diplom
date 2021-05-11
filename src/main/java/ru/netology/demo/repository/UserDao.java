package ru.netology.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.netology.demo.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
   User findByUsername(String username);
}
