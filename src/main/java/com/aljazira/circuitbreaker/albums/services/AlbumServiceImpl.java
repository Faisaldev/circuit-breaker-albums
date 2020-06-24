package com.aljazira.circuitbreaker.albums.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final static String url = "https://jsonplaceholder.typicode.com/albums";

    @Override
    @HystrixCommand(fallbackMethod = "reliable")
    public String getAlbums() {
        return new RestTemplate().getForObject(url,String.class);
    }

    private String reliable(){
        try {
            return new String(Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource("fallback-album-list.json").toURI())));
        } catch (Exception e) {
            System.out.println("Error in reading from cache");
        }
        return null;
    }
}
