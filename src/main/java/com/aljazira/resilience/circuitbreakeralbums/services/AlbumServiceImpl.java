package com.aljazira.resilience.circuitbreakeralbums.services;

import com.aljazira.resilience.circuitbreakeralbums.services.AlbumService;
import org.springframework.stereotype.Service;

@Service
public class AlbumServiceImpl implements AlbumService {
    @Override
    public String getAlbums() {
        return "Hello World";
    }
}
