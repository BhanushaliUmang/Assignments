package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        String url = "https://api.chucknorris.io/jokes/random";

        // request
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();

        // http client object
        HttpClient httpClient = HttpClient.newBuilder().build();

        HttpResponse<String> httpResponse = httpClient.send(request,HttpResponse.BodyHandlers.ofString());

        // status code and body
        System.out.println(httpResponse.body());

    }
}