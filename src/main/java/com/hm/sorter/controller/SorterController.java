package com.hm.sorter.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hm.sorter.dto.SortedNumbers;
import com.hm.sorter.service.SorterService;

@RestController
@RequestMapping("/numbers")
public class SorterController {
	private static Logger logger = LoggerFactory.getLogger(SorterController.class);
	
	@Autowired
	private SorterService numberSorterService;

	@RequestMapping(value = "/status", method = RequestMethod.GET)
	public Response status() {
		return Response.ok().build();
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<SortedNumbers> findItems() {
		logger.debug("Received request to get all entries");
		return numberSorterService.getAllEntries();
	}

	@RequestMapping(method = RequestMethod.POST)
	public void sortNumbers(@RequestBody List<Integer> numbers) {
		if(numbers == null) {
			throw new BadRequestException("Not a valid entry");
		}
		if (numbers.stream().anyMatch(number -> number == null)) {
			throw new BadRequestException("Not a valid entry");
		};
		logger.debug("Received a new sorting request");
		numberSorterService.sortNumbers(numbers);
	}
}
