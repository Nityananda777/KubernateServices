package com.journaldev.spring.services;

import com.journaldev.spring.entity.Contact;
import com.journaldev.spring.entity.Role;
import com.journaldev.spring.entity.User;
import com.journaldev.spring.repository.RoleRepository;
import com.journaldev.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



/**
 * @author Siva
 *
 */
@Service
@Transactional
public class UserService
{
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	public void createUser(User user)
	{
		if(checkUserNameExists(user.getUserName())){
			throw new RuntimeException("UserName ["+user.getUserName()+"] already exist");
		}
		if(checkEmailExists(user.getEmail())){
			throw new RuntimeException("Email ["+user.getEmail()+"] already exist");
		}
		userRepository.save(user);
	}

	public User findUserById(Integer userId)
	{
		return userRepository.findById(userId).get();
	}

	public List<User> findAllUsers()
	{
		return userRepository.findAll();
	}

	public boolean checkEmailExists(String email)
	{
		return userRepository.findByEmail(email) != null;
	}

	public boolean checkUserNameExists(String userName)
	{
		return userRepository.findByUserName(userName) != null;
	}

	public User login(String userName, String password)
	{
		return userRepository.findByUserNameAndPassword(userName, password);
	}

	public void addRole(Role role) {
		//roleRepository.save(role);
	}

	public List<Contact> findUserContacts(int userId) {
		return findUserById(userId).getContacts();
	}

	public Contact findUserContact(int userId, int contactId) {
		List<Contact> userContacts = findUserContacts(userId);
		for (Contact contact : userContacts) {
			if(contact.getId() == contactId){
				return contact;
			}
		}
		return null;
	}
}
