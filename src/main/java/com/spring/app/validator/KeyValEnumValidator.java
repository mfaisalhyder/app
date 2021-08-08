package com.spring.app.validator;

import com.spring.app.constant.BookStatus;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KeyValEnumValidator implements ConstraintValidator<ValidateKeyValEnum, Integer> {
    private Set<Integer> allowedValues;

    @Override
    public void initialize(ValidateKeyValEnum targetEnum) {
        allowedValues = Stream
                .of(targetEnum.targetClassType().getEnumConstants())
                .map(this::mapEnumConstant)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet())
        ;
    }

    @Override
    public boolean isValid(Integer key, ConstraintValidatorContext context) {
        return key != null && allowedValues.contains(key);
    }

    private Integer mapEnumConstant(final Object enumConstant) {
        Integer key = null;
        if (enumConstant instanceof BookStatus) {
            key = ((BookStatus) enumConstant).getKey();
        }

        return key;
    }
}