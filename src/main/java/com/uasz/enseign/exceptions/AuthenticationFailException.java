package com.uasz.enseign.exceptions;

public class AuthenticationFailException extends IllegalArgumentException{
 public AuthenticationFailException(String msg){
     super(msg);
 }
}
