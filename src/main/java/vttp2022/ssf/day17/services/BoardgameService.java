package vttp2022.ssf.day17.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import vttp2022.ssf.day17.repositories.BoardgameRepository;

@Service
public class BoardgameService {

    @Autowired
    private BoardgameRepository boardgameRepo;

    public getBoardgame(String id) {
        Optional<String> opt = boardgameRepo.get(id);
        String payload;

        System.out.printf(">>> id: %s\n", id);
    }


    // private static final String URL = "https://api.openweathermap.org/data/2.5/weather";

    // @Value("${API_KEY}")
    // private String key;

    // @Autowired
    // private WeatherRepository weatherRepo;

    //     return list;
    // }

}