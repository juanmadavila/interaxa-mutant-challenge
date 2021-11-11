package com.interaxa.app.service.abstraction;

import com.interaxa.app.model.dto.PersonRequest;
import com.interaxa.app.model.dto.PersonResponse;

public interface IPersonService {

	void create(PersonRequest personRequest);
	
	void delete(Long id);
	
	PersonResponse update(PersonRequest personRequest, Long id);
	
}
