package com.journaldev.spring.repository;

import com.journaldev.spring.entity.PersonEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PersonRepository extends PagingAndSortingRepository<PersonEntity, Long> {
	List<PersonEntity> findByFirstName(String firstName);
	Page<PersonEntity> findAll(Pageable pageable);



}
