//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package cn.metaq.sample.camunda.web;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;

public class Result<T> implements Serializable {
  private Integer code;
  private String message;
  @JsonInclude(Include.NON_NULL)
  private T data;

  public Result() {
  }

  public static <T> Result<T> ok(T data) {
    return (new Result()).data(data).code(200).message("OK");
  }

  public static <T> Result<T> ok() {
    return (new Result()).code(200).message("OK");
  }

  public static <T> Result<T> error() {
    return error(500, "Internal Server Error");
  }

  public static <T> Result<T> error(String msg) {
    return error(500, msg);
  }

  public static <T> Result<T> error(Integer code, String message) {
    return (new Result()).code(code).message(message);
  }

  public static <T> Result<T> ok(T data, String message) {
    return (new Result()).data(data).code(200).message(message);
  }

  private Result<T> data(T data) {
    this.data = data;
    return this;
  }

  private Result<T> code(Integer code) {
    this.code = code;
    return this;
  }

  private Result<T> message(String message) {
    this.message = message;
    return this;
  }

  public Integer getCode() {
    return this.code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMessage() {
    return this.message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return this.data;
  }

  public void setData(T data) {
    this.data = data;
  }
}
