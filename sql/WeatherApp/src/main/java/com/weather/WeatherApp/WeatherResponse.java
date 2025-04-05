package com.weather.WeatherApp;

public class WeatherResponse {
    private Coord coord;
    private Main main;
    private Wind wind;
    private Sys sys;
    private String name;

    public static class Coord {
        private double lon;
        private double lat;

        public double getLon() { return lon; }
        public void setLon(double lon) { this.lon = lon; }
        public double getLat() { return lat; }
        public void setLat(double lat) { this.lat = lat; }
    }

    public static class Main {
        private double temp;
        private double humidity;

        public double getTemp() { return temp; }
        public void setTemp(double temp) { this.temp = temp; }
        public double getHumidity() { return humidity; }
        public void setHumidity(double humidity) { this.humidity = humidity; }
    }

    public static class Wind {
        private double speed;

        public double getSpeed() { return speed; }
        public void setSpeed(double speed) { this.speed = speed; }
    }

    public static class Sys {
        private String country;

        public String getCountry() { return country; }
        public void setCountry(String country) { this.country = country; }
    }

    public Coord getCoord() { return coord; }
    public void setCoord(Coord coord) { this.coord = coord; }
    public Main getMain() { return main; }
    public void setMain(Main main) { this.main = main; }
    public Wind getWind() { return wind; }
    public void setWind(Wind wind) { this.wind = wind; }
    public Sys getSys() { return sys; }
    public void setSys(Sys sys) { this.sys = sys; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
