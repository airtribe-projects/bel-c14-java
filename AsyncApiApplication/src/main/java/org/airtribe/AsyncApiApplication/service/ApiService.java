package org.airtribe.AsyncApiApplication.service;

import java.time.Duration;
import java.util.List;
import org.airtribe.AsyncApiApplication.dto.ApiMeasurements;
import org.airtribe.AsyncApiApplication.dto.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
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

  public Mono<List<ApiResult>> getProductsAsyncParallel() {
    Mono<ApiResult> apiResultMono1 = webClient.get().uri("https://dummyjson.com/products")
        .retrieve().bodyToMono(ApiResult.class);

    Mono<ApiResult> apiResultMono2 = webClient.get().uri("https://dummyjson.com/products")
        .retrieve().bodyToMono(ApiResult.class);

    Mono<ApiResult> apiResultMono3 = webClient.get().uri("https://dummyjson.com/products")
        .retrieve().bodyToMono(ApiResult.class);

    Mono<List<ApiResult>> apiResultsComibend = Mono.zip(apiResultMono1, apiResultMono2, apiResultMono3)
        .map(tuple -> List.of(tuple.getT1(), tuple.getT2(), tuple.getT3()))
        .doOnSuccess(apiResults -> {
          System.out.println("Thread handling the request: " + Thread.currentThread().getName());
        }).doOnError(error -> {
          System.out.println("Error occurred: " + error.getMessage());
        });

    System.out.println("Thread handling the request: " + Thread.currentThread().getName());

    return apiResultsComibend;
  }

  public Mono<ApiResult> getProductsAsyncFastestParallel() {
    Mono<ApiResult> apiResultMono1 = webClient.get().uri("https://dummyjson.com/products")
        .retrieve().bodyToMono(ApiResult.class);

    Mono<ApiResult> apiResultMono2 = webClient.get().uri("https://dummyjson.com/products")
        .retrieve().bodyToMono(ApiResult.class);

    Mono<ApiResult> apiResultMono3 = webClient.get().uri("https://dummyjson.com/products")
        .retrieve().bodyToMono(ApiResult.class);

    Mono<ApiResult> fastestApiResultMono = Mono.first(apiResultMono1, apiResultMono2, apiResultMono3).doOnSuccess(apiResults -> {
      System.out.println("Thread handling the request: " + Thread.currentThread().getName());
    });

    System.out.println("Thread handling the request: " + Thread.currentThread().getName());

    return fastestApiResultMono;
  }

  public List<ApiResult> getProductsSyncChained() {
    System.out.println("Thread handling the request: " + Thread.currentThread().getName());

    ApiResult result1 = restTemplate.getForObject("https://dummyjson.com/products", ApiResult.class);
    System.out.println("Fetched first result by Thread: " + Thread.currentThread().getName());

    ApiResult result2 = webClient.get().uri("https://dummyjson.com/products")
        .retrieve().bodyToMono(ApiResult.class).block();
    System.out.println("Fetched second result by Thread: " + Thread.currentThread().getName());

    ApiResult result3 = restTemplate.getForObject("https://dummyjson.com/products", ApiResult.class);
    System.out.println("Fetched third result by Thread: " + Thread.currentThread().getName());

    return List.of(result1, result2, result3);
  }

  public Mono<ApiResult> invokeFirstApi() {
    return webClient.get().uri("https://dummyjson.com/products")
        .retrieve().bodyToMono(ApiResult.class).doOnSuccess(apiResult -> {
          System.out.println("Thread handling the request: " + Thread.currentThread().getName());
        });
  }

  public Mono<ApiResult> invokeSecondApi() {
    return webClient.get().uri("https://dummyjson.com/products")
        .retrieve().bodyToMono(ApiResult.class).doOnSuccess(apiResult -> {
          System.out.println("Thread handling the request: " + Thread.currentThread().getName());
        });
  }

  public Mono<ApiResult> inokeThirdApi() {
    return webClient.get().uri("https://dummyjson.com/products")
        .retrieve().bodyToMono(ApiResult.class).doOnSuccess(apiResult -> {
          System.out.println("Thread handling the request: " + Thread.currentThread().getName());
        });
  }

  public Mono<List<ApiResult>> getProductsAsyncChained() {
    System.out.println("Thread handling the request: " + Thread.currentThread().getName());
      return invokeFirstApi()
          .flatMap(firstResult -> invokeSecondApi().flatMap(secondResult -> inokeThirdApi().map(thirdResult -> {
                          return List.of(firstResult, secondResult, thirdResult);
                        })
                    ));

  }

  public Flux<ApiResult> getProductsFluxStream() {
    System.out.println("Thread handling the request: " + Thread.currentThread().getName());

    return Flux.interval(Duration.ofSeconds(3))
        .take(20)
        .flatMap(i -> webClient.get().uri("https://dummyjson.com/products")
            .retrieve().bodyToMono(ApiResult.class)
            .doOnSuccess(apiResult -> {
              System.out.println("Fetched product id " + (i + 1) + " by Thread: " + Thread.currentThread().getName());
            })
        ).doOnComplete(() -> {
          System.out.println("Completed fetching products by Thread: " + Thread.currentThread().getName());
        });
  }
}


// sync

// user -> controller -> tomcat thread -> service -> blocked products -> returns the result -> tomcat thread is freed up

// async -> controller -> tomcat thread -> service -> reactor thread -> returns the mon -> tom cat thread

// reactor thread -> products