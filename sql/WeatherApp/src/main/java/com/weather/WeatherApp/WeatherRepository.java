package com.weather.WeatherApp;


import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<WeatherEntity, Long> {
    WeatherEntity findByCity(String city);
}
