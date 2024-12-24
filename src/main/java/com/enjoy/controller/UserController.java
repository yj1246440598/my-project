package com.enjoy.controller;

import com.enjoy.entity.Result;
import com.enjoy.entity.Users;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @RequestMapping("/user")
    @PutMapping
    @ResponseBody
    public Result<Void> edit(@Valid @RequestBody Users userDTO, BindingResult bindingResult) {
        // 判断参数校验是否通过
        if (bindingResult.hasErrors()) {
            List<String> errors = new ArrayList<>();
            bindingResult.getFieldErrors().forEach(error -> {
                errors.add(error.getDefaultMessage());
            });
            // 未通过则手动处理并返回错误信息
            return Result.error(String.join(",", errors));
        }

        // 如果校验通过，就执行对应的业务逻辑
        System.out.println("V2-模拟修改操作：" + userDTO);
        return Result.success("用户信息编辑成功！");
    }

    @RequestMapping("/user2")
    @PutMapping
    @ResponseBody
    public Result<Void> edit2(@Valid @RequestBody Users userDTO) {
        // 如果校验通过，就执行对应的业务逻辑
        System.out.println("V2-模拟修改操作：" + userDTO);
        return Result.success("用户信息编辑成功！");
    }

}
