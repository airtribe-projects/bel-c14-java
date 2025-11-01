package org.airtribe.AsyncApiApplication.dto;

import java.util.List;


public class ApiResult {

  public List<ApiMeasurements> products;

  public ApiResult(List<ApiMeasurements> products) {
    this.products = products;
  }

  public List<ApiMeasurements> getProducts() {
    return products;
  }

  public void setProducts(List<ApiMeasurements> products) {
    this.products = products;
  }
}
