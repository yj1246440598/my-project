package com.enjoy.enums;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class StatusValidated implements ConstraintValidator<Status,Integer> {
    @Override
    public boolean isValid(Integer status, ConstraintValidatorContext context) {
        if (Objects.isNull(status)) {
            return false;
        }
        // 检查当前字段的值是否在枚举里有定义
        for (StatusEnum statusEnum : StatusEnum.values()) {
            if (Objects.equals(statusEnum.getCode(), status)) {
                return true;
            }
        }
        return false;
    }
}
