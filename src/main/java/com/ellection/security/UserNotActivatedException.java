package com.ellection.security;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by faos7 on 02.04.17.
 */
public class UserNotActivatedException extends AuthenticationException {

    public UserNotActivatedException(String msg, Throwable t) {
        super(msg, t);
    }

    public UserNotActivatedException(String msg) {
        super(msg);
    }
}