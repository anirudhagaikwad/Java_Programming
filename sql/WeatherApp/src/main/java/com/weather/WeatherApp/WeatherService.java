package com.weather.WeatherApp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestClientException;

@Service
public class WeatherService {
    
    @Value("${openweather.api.key}")
    private String apiKey;
    
    private final WeatherRepository weatherRepository;
    private final RestTemplate restTemplate;

    public WeatherService(WeatherRepository weatherRepository, RestTemplate restTemplate) {
        this.weatherRepository = weatherRepository;
        this.restTemplate = restTemplate;
    }

    public WeatherEntity fetchAndSaveWeather(double lat, double lon) {
        // Validate input parameters
        if (lat < -90 || lat > 90 || lon < -180 || lon > 180) {
            throw new IllegalArgumentException("Invalid latitude or longitude values");
        }

        String url = String.format(
            "https://api.openweathermap.org/data/2.5/weather?lat=%f&lon=%f&appid=%s",
            lat, lon, apiKey
        );
        
        try {
            // Fetch data from OpenWeather API
            WeatherResponse response = restTemplate.getForObject(url, WeatherResponse.class);
            
            // Check if response is null
            if (response == null) {
                throw new RuntimeException("Failed to fetch weather data from OpenWeather API");
            }

            // Create and populate WeatherEntity
            WeatherEntity entity = new WeatherEntity();
            entity.setLatitude(response.getCoord().getLat());
            entity.setLongitude(response.getCoord().getLon());
            entity.setCity(response.getName());
            entity.setCountry(response.getSys().getCountry());
            entity.setHumidity(response.getMain().getHumidity());
            entity.setWindSpeed(response.getWind().getSpeed());
            entity.setTemperature(response.getMain().getTemp() - 273.15); // Convert Kelvin to Celsius
            
            // Save to database and return
            return weatherRepository.save(entity);
        } catch (RestClientException e) {
            throw new RuntimeException("Error fetching weather data: " + e.getMessage(), e);
        }
    }

    public WeatherEntity getWeatherByCity(String city) {
        // Validate input
        if (city == null || city.trim().isEmpty()) {
            throw new IllegalArgumentException("City name cannot be null or empty");
        }
        
        WeatherEntity entity = weatherRepository.findByCity(city);
        if (entity == null) {
            throw new RuntimeException("No weather data found for city: " + city);
        }
        return entity;
    }
}