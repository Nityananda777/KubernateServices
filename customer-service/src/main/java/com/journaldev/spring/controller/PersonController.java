package com.journaldev.spring.controller;

import com.journaldev.spring.model.PersonDto;
import com.journaldev.spring.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {

	@Autowired
	private PersonService personService;

	@RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
	public @ResponseBody PersonDto getAllUsers(@PathVariable Long id) {
		return personService.getById(id);
	}

	@RequestMapping(value = "/personByName/{name}", method = RequestMethod.GET)
	public List<PersonDto> getPersoneByName(@PathVariable String name) {
		return personService.findByName(name);
	}

	@RequestMapping(value = "/fetch", method = RequestMethod.GET)
	public ResponseEntity<List<PersonDto>> getAllPersons(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "id") String sortBy) {
		List<PersonDto> list = personService.getAllPerson(pageNo, pageSize, sortBy);

		return new ResponseEntity<List<PersonDto>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping(value = "/person/{id}", method = RequestMethod.DELETE)
	public HttpStatus deletePerson(@PathVariable Long id) {
		personService.deletePerson(id);
		return HttpStatus.NO_CONTENT;
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public HttpStatus insertPersone(@RequestBody PersonDto person) {
		return personService.addPerson(person) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public HttpStatus updatePerson(@RequestBody PersonDto person) {
		return personService.updatePerson(person) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
	}
}
