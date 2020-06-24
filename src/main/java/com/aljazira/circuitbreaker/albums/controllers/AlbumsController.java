package com.aljazira.circuitbreaker.albums.controllers;

import com.aljazira.circuitbreaker.albums.services.AlbumService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlbumsController {

    private final AlbumService albumService;

    public AlbumsController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/albums")
    public String getAlbums(){
        return albumService.getAlbums();
    }
}
