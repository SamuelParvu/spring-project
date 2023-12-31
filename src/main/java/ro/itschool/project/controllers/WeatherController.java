package ro.itschool.project.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ro.itschool.project.models.entities.Weather;
import ro.itschool.project.services.WeatherService;

import java.io.IOException;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    // no need for autowired in newer versions, it gets the dependencies on its own
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/api/weather")
    public ResponseEntity<Weather> getWeather(@RequestParam String city) throws IOException {
        return ResponseEntity.ok(weatherService.getWeather(city));
    }

}
