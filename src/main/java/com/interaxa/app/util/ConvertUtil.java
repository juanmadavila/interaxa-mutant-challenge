package com.interaxa.app.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.interaxa.app.model.dto.PersonRequest;
import com.interaxa.app.model.dto.PersonResponse;
import com.interaxa.app.model.entity.Person;

@Component
public class ConvertUtil {

	private static ModelMapper modelMapper;

	@Autowired
	public void setModelMapper(ModelMapper modelMapper) {
		ConvertUtil.modelMapper = modelMapper;
	}

	private static <D> D map(Object source, Class<D> destinationType) {
		if (source == null) {
			return null;
		}

		return modelMapper.map(source, destinationType);
	}

	public static Person convertToEntity(PersonRequest request) {
		return map(request, Person.class);
	}
	
	public static PersonResponse convertToDto(Person person) {
		return map(person, PersonResponse.class);
		
	}
}
