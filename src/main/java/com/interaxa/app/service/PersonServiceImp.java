package com.interaxa.app.service;

import java.text.MessageFormat;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.interaxa.app.model.dto.PersonRequest;
import com.interaxa.app.model.dto.PersonResponse;
import com.interaxa.app.model.entity.Person;
import com.interaxa.app.repository.IPersonRepository;
import com.interaxa.app.service.abstraction.IPersonService;
import com.interaxa.app.util.ConvertUtil;

@Service
@Transactional
public class PersonServiceImp implements IPersonService{

	private static final String PERSON_ID_NOT_FOUND = "Person ID: {0} not found.";
	
	@Autowired
	private IPersonRepository personRepository;
	
	@Override
	public void create(PersonRequest personRequest) {
		Person person = ConvertUtil.convertToEntity(personRequest);
		personRepository.save(person);
	}

	@Override
	public void delete(Long id) {
		Person person = personRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException(MessageFormat.format(PERSON_ID_NOT_FOUND, id)));
		personRepository.delete(person);
	}

	@Override
	public PersonResponse update(PersonRequest personRequest, Long id) {
		Person person = personRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException(MessageFormat.format(PERSON_ID_NOT_FOUND, id)));
		
		Person personUpdated = ConvertUtil.convertToEntity(personRequest);
		personUpdated.setId(id);
		personUpdated.setDni(person.getDni());
		personRepository.save(personUpdated);
		
		return ConvertUtil.convertToDto(personUpdated);
	}

}
