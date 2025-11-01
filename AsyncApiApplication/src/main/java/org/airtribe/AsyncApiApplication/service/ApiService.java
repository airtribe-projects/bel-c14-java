package org.airtribe.AsyncApiApplication.service;

import org.airtribe.AsyncApiApplication.dto.ApiMeasurements;
import org.airtribe.AsyncApiApplication.dto.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Service
public class ApiService {

  @Autowired
  private RestTemplate restTemplate;


  @Autowired
  private WebClient webClient;

  public String invokeHelloEndpoint() {
    String result = restTemplate.getForObject("http://localhost:9001/hello", String.class);
    System.out.println("Thread handling the request: " + Thread.currentThread().getName());
    for (int i=0;i<100;i++) {
      // Simulating some work in the foreground
       System.out.println("Doing some work in the foreground");
    }
    return result;

  }

  public ApiResult getProductsSync() {
    ApiResult result = restTemplate.getForObject("https://dummyjson.com/products", ApiResult.class);
    System.out.println("Thread handling the request: " + Thread.currentThread().getName());
    for (int i=0;i<100;i++) {
      // Simulating some work in the foreground
      System.out.println("Doing some work in the foreground");
    }
    return result;
  }

  public Mono<ApiResult> getProductsAsync() {
    Mono<ApiResult> apiResultMono = webClient.get().uri("https://dummyjson.com/products")
        .retrieve().bodyToMono(ApiResult.class).doOnSuccess(apiResult -> {
          System.out.println("Thread handling the request: " + Thread.currentThread().getName());
        });

    System.out.println("Thread handling the request: " + Thread.currentThread().getName());
    for (int i=0;i<10;i++){
      // Simulating some work in the foreground
       System.out.println("Doing some work in the foreground");
    }
    return apiResultMono;
  }
}


// sync

// user -> controller -> tomcat thread -> service -> blocked products -> returns the result -> tomcat thread is freed up

// async -> controller -> tomcat thread -> service -> reactor thread -> returns the mon -> tom cat thread

// reactor thread -> products