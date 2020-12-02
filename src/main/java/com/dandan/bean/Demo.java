package com.dandan.bean;

import com.dandan.validation.CaseMode;
import com.dandan.validation.CheckCase;

/**
 * @date：2020/11/29
 * @author：suchao
 */
public class Demo{
    @CheckCase(value = CaseMode.LOWER,message = "userName必须是小写")
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
