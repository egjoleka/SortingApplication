package com.hm.sorter.utils;

import java.util.List;

import javax.ws.rs.BadRequestException;

public class RequestValidator {

	public static void validateRequest(List<Integer> numbers) {
		if(numbers == null) {
			throw new BadRequestException("Not a valid entry");
		}
		if (numbers.stream().anyMatch(number -> number == null)) {
			throw new BadRequestException("Not a valid entry");
		};
	}
}
