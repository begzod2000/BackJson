package com.example.backjson.Controller;

import com.example.backjson.Payload.JsonPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

public class jsonController {
    @RestController
    @RequestMapping("api/json")
    public class JsonController {
        @Autowired
        private RestTemplate restTemplate;

        @GetMapping("/posts")
        public JsonPayload[] getProductLists() {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
            return restTemplate.exchange("https://jsonplaceholder.typicode.com/posts", HttpMethod.GET, httpEntity, JsonPayload[].class).getBody();
        }

        @PostMapping("/post")
        public String create(@RequestBody JsonPayload jsonPayload){
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            HttpEntity<JsonPayload> httpEntity = new HttpEntity<>(jsonPayload, httpHeaders);
            return restTemplate.exchange("https://jsonplaceholder.typicode.com/posts", HttpMethod.POST, httpEntity, String.class).getBody();
        }

        @RequestMapping(value = "/posts/{id}")
        public String updatePost(@PathVariable("id") int id, @RequestBody JsonPayload post) {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            HttpEntity<JsonPayload> entity = new HttpEntity<>(post, httpHeaders);
            return restTemplate.exchange("https://jsonplaceholder.typicode.com/posts/" + id, HttpMethod.PUT, entity, String.class).getBody();
        }

        @RequestMapping(value = "/posts/{id}")
        public String deletePost(@PathVariable("id") int id) {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
            return restTemplate.exchange("https://jsonplaceholder.typicode.com/posts/" + id, HttpMethod.DELETE, entity, String.class).getBody();
        }
    }

}
