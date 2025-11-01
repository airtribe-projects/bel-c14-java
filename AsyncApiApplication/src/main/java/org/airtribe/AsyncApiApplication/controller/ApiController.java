package org.airtribe.AsyncApiApplication.controller;

import org.airtribe.AsyncApiApplication.dto.ApiResult;
import org.airtribe.AsyncApiApplication.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
public class ApiController {

  @Autowired
  private ApiService _apiService;

  @GetMapping("/hello")
  public String hello() {
    System.out.println("Request is being handled by Thread: " + Thread.currentThread().getName());
    return "Hello world";
  }

  @GetMapping("/hello2")
  public String hello2() {
    return _apiService.invokeHelloEndpoint();

  }

  @GetMapping("/products/sync")
  public ApiResult getProductsSync() {
    return _apiService.getProductsSync();
  }

  @GetMapping("/products/async")
  public Mono<ApiResult> getProductsAsync() {
    return _apiService.getProductsAsync();
  }

}
