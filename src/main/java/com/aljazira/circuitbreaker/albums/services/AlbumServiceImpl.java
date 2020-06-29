package com.aljazira.circuitbreaker.albums.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final static String url = "https://jsonplaceholder.typicode.com/albums";

    @Override
    public String getAlbums() {
        return new RestTemplate().getForObject(url,String.class);
    }
}
