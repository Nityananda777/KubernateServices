package com.journaldev.spring.services;

import com.journaldev.spring.entity.PersonEntity;
import com.journaldev.spring.model.PersonDto;
import com.journaldev.spring.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Transactional
	public List<PersonDto> getAll() {

		return ((List<PersonEntity>) personRepository.findAll()).stream().map(this::getDTO)
				.collect(Collectors.toList());
	}

	@Transactional
	public List<PersonDto> getAllPerson(int pageNo,int pageSize,String sortBy) {
		
		Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending());

		Page<PersonEntity> pagedResult = personRepository.findAll(pageable);
		if (pagedResult.hasContent()) {
			return pagedResult.getContent().stream().map(this::getDTO).collect(Collectors.toList());
			
		} else {
			return new ArrayList<PersonDto>();
		}
	}

	private PersonDto getDTO(PersonEntity personEntity) {
		PersonDto personDto = new PersonDto();
		personDto.setId(personEntity.getId());
		personDto.setFirstName(personEntity.getFirstName());
		personDto.setLastName(personEntity.getLastName());
		personDto.setAge(personEntity.getAge());
		return personDto;
	}

	private PersonEntity getEntity(PersonDto personDto) {
		PersonEntity personEntity = new PersonEntity();
		personEntity.setId(personDto.getId());
		personEntity.setFirstName(personDto.getFirstName());
		personEntity.setLastName(personDto.getLastName());
		personEntity.setAge(personDto.getAge());
		return personEntity;
	}

	@Transactional
	public List<PersonDto> findByName(String name) {
		return personRepository.findByFirstName(name).stream().map(this::getDTO).collect(Collectors.toList());
	}

	@Transactional
	public PersonDto getById(Long id) {
		Optional<PersonEntity> op = personRepository.findById(id);
		if (op.isPresent()) {
			return getDTO(op.get());
		}
		return new PersonDto();

	}

	@Transactional
	public void deletePerson(Long personId) {
		personRepository.deleteById(personId);

	}

	@Transactional
	public boolean addPerson(PersonDto person) {

		return personRepository.save(getEntity(person)) != null;
	}

	@Transactional
	public boolean updatePerson(PersonDto person) {
		return personRepository.save(getEntity(person)) != null;
	}
}
