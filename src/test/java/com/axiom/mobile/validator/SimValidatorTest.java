package com.axiom.mobile.validator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.Before;
import org.junit.Test;

import com.axiom.mobile.exception.BadRequestException;

public class SimValidatorTest {

	private SimValidator simValidator;

	@Before
	public void setUp() {
		simValidator = new SimValidatorImpl();
	}

	@Test
	public void testValidateWithValidSim() {

		assertDoesNotThrow(() -> simValidator.validate("eSIM"));

	}

	@Test(expected = BadRequestException.class)
	public void testValidateWithInvalidSim() {

		simValidator.validate("INVALID_SIM");

	}
}
