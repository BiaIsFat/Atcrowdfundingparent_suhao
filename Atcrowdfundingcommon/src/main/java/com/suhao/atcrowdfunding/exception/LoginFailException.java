package com.suhao.atcrowdfunding.exception;

/**
 * @author suhao
 * @create_date 2020-05-18 9:10
 */
public class LoginFailException extends RuntimeException {
    public LoginFailException(String message){
        super(message);
    }
}
