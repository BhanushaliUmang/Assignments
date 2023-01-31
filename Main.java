package bmt;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException{

        String url = "https://api.weatherbit.io/v2.0/current?lat=35.7796&lon=-78.6382&key=a81a47cc969140bd9cd23e0b0bc0b227&include=minutely";

        // request
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();

        // http client object
        HttpClient httpClient = HttpClient.newBuilder().build();

        HttpResponse<String> httpResponse = httpClient.send(request,HttpResponse.BodyHandlers.ofString());

        // status code and body
        System.out.println(httpResponse.body());

    }
}

