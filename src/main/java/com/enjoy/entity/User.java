package com.enjoy.entity;

import com.enjoy.enums.Status;
import lombok.Data;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class User {

    @Min(value = 0, message = "ID不能小于0")
    private long userId;

    @NotNull(message = "用户名不能为空")
    private String userName;

    @DecimalMax(value = "9999999.99", message = "产品单价不能大于9999999.99元")
    private BigDecimal unitPrice;

    @Status(groups = {UserCreate.class})
    private Integer statue;
    public interface UserCreate {}
    public interface UserUpdate {}
}
