package com.abc.validatordemo.validator;

import com.abc.validatordemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import java.util.Set;

@Component
public class ValidationManager {
    @Autowired
    @Qualifier("localValidatorFactoryBean")
    Validator validator;

    public void validate(Employee employee) {
        Set<ConstraintViolation<Employee>> validatorResponse = validator.validate(employee);

        if(!validatorResponse.isEmpty()) {
            throw new ValidationException(getConcatenatedMessages(validatorResponse));
        }
    }

    private String getConcatenatedMessages(Set<ConstraintViolation<Employee>> validatorResponse) {
        return validatorResponse.stream()
                .map(v -> v.getMessage()).reduce((s1, s2) -> s1 + "; " + s2).get();
    }
}
