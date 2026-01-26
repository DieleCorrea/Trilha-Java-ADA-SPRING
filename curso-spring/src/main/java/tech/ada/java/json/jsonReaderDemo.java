package tech.ada.java.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import java.net.URL;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest;
import java.util.Scanner;

public class jsonReaderDemo {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {
        //lerComScanner();
        lerComHttpClient();

    }

    private static void lerComScanner() {
        try (Scanner scanner = new Scanner(new URL("https://dummyjson.com/posts/1").openStream())) {
            String json = scanner.nextLine();
            Post post = convertJsonoPost(json);
            System.out.println(json);
            System.out.println(post);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void lerComHttpClient() {
        try (HttpClient client = HttpClient.newBuilder().build()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://dummyjson.com/posts/1"))
                    .build();
            client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(stringHttpResponse -> convertJsonoPost(stringHttpResponse.body()))
                    .thenAccept(System.out::println)
                    .join();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @SneakyThrows
    private static Post convertJsonoPost(String json){
        return mapper.readValue(json, Post.class);
    }
}
    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    class Post {
        private Long id;
        private String title;
        private String body;
        private Long userId;
        private Long views;
        private String[] tags;
        private Reaction reactions;;
    }
    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    class Reaction{
        private Long likes;
        private Long dislikes;
    }

