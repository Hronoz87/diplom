package ru.netology.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.netology.demo.dao.DAOUser;

@Repository
public interface UserDao extends CrudRepository<DAOUser, Long> {
   UserDao findByUsername(String username);
}
