package com.aljazira.resilience.circuitbreakeralbums.controllers;

import com.aljazira.resilience.circuitbreakeralbums.services.AlbumService;
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
