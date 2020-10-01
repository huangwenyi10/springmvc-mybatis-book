package com.ay.validator;

import com.ay.model.AyUser;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * 描述：用户数据校验类
 *
 * @author Ay
 * @create 2018/05/25
 **/

@Component
public class AyUserValidator implements Validator {

    /**
     * This Validator validates *just* AyUser instances
     */
    public boolean supports(Class clazz) {
        return AyUser.class.equals(clazz);
    }

    public void validate(Object obj, Errors e) {
        ValidationUtils.rejectIfEmpty(e, "name", "name.empty");
        AyUser p = (AyUser) obj;
        if (p.getAge() < 0) {
            e.rejectValue("age", "年龄不能小于0岁");
        } else if (p.getAge() > 150) {
            e.rejectValue("age", "年龄不能超过150岁");
        }
    }
}
