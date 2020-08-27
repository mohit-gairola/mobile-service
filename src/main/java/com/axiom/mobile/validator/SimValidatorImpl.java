package com.axiom.mobile.validator;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.axiom.mobile.exception.BadRequestException;
import com.axiom.mobile.model.SimType;

@Service
public class SimValidatorImpl implements SimValidator {

	@Override
	public void validate(String sim) {
		if (!StringUtils.isEmpty(sim)) {
			boolean isValid = false;
			for (SimType simType : SimType.values()) {
				if (simType.getName().equalsIgnoreCase(sim)) {
					isValid = true;
				}
			}

			if (!isValid) {
				throw new BadRequestException(sim);
			}
		}
	}

}
