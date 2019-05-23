package com.yunding.weimuke.weimukeserver.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
public class UserLoginForm {


    private String username;

    private String password;

}
