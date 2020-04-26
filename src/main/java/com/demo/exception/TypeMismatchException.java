
package com.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TypeMismatchException extends Exception {


  public TypeMismatchException(String message) {
    super(message);
  }
  

}