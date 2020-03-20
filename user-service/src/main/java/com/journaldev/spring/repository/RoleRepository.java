package com.journaldev.spring.repository;

import com.journaldev.spring.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Siva
 * 
 */
public interface RoleRepository extends JpaRepository<Role, Integer>
{

}
