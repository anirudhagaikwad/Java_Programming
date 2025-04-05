package com.weather.WeatherApp;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {
    
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/fetch")
    public WeatherEntity fetchWeather(
        @RequestParam double lat,
        @RequestParam double lon
    ) {
        return weatherService.fetchAndSaveWeather(lat, lon);
    }

    @GetMapping("/city/{cityName}")
    public WeatherEntity getWeatherByCity(@PathVariable String cityName) {
        return weatherService.getWeatherByCity(cityName);
    }
}

/*
GET http://localhost:8080/api/weather/fetch?lat=19.5761&lon=74.2070
Method: GET
Response: JSON with weather data

GET http://localhost:8080/api/weather/city/Sangamner
Method: GET
Response: JSON with stored weather data

*/