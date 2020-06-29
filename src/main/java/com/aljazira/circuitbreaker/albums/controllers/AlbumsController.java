package com.aljazira.circuitbreaker.albums.controllers;

import com.aljazira.circuitbreaker.albums.services.AlbumService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlbumsController {

    private final AlbumService albumService;

    public AlbumsController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/albums")
    @HystrixCommand(fallbackMethod = "reliable", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    public String getAlbums() throws InterruptedException {
//        return albumService.getAlbums();
        Thread.sleep(2000);
        return "Hello World";
    }

    private String reliable(){
//        try {
//            return new String(Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource("fallback-album-list.json").toURI())));
//        } catch (Exception e) {
//            System.out.println("Error in reading from cache");
//        }
        return "Sorry our system is down";
//        return null;
    }
}
