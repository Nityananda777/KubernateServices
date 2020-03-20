package com.journaldev.spring.repository;

import com.journaldev.spring.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Siva
 * 
 */
public interface ContactRepository extends JpaRepository<Contact, Integer>
{

}
