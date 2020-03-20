package com.journaldev.spring.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.journaldev.spring.entity.PersonEntity;

public interface PersonRepository extends PagingAndSortingRepository<PersonEntity, Long> {
	List<PersonEntity> findByFirstName(String firstName);
	Page<PersonEntity> findAll(Pageable pageable);



}
