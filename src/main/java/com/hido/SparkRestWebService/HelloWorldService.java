package com.hido.SparkRestWebService;
import static spark.Spark.*;
public class HelloWorldService {
    public static void main(String[] args) {
       get("/hello",(request, response) -> "Hello, Hido9x");
       get("/hello/:name",(request, response) -> {
           return "Hello:" + request.params(":name");
       });
    }
}
