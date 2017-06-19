package com.hm.sorter.utils;

import java.util.Arrays;

import javax.ws.rs.BadRequestException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class RequestValidatorTest {

	@Test
	public void validateRequestSuccess() {
		RequestValidator.validateRequest(Arrays.asList(-1,-2,100));
	}
	
	@Test(expected=BadRequestException.class)
	public void validateRequestNullListFailure() {
		RequestValidator.validateRequest(null);
	}
	
	@Test(expected=BadRequestException.class)
	public void validateRequestListWithNullValueFailure() {
		RequestValidator.validateRequest(Arrays.asList(-1,null,100));
	}
}
