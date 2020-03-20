package com.journaldev.spring.repository;

import com.journaldev.spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Siva
 * 
 */
public interface UserRepository extends JpaRepository<User, Integer>
{

	User findByEmail(String email);

	User findByUserName(String userName);

	User findByUserNameAndPassword(String userName, String password);

}
