package ro.itschool.project.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.itschool.project.models.entities.Weather;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
public class WeatherServiceImpl implements  WeatherService{

    private final WeatherValidationService weatherValidationService;
    private final ObjectMapper objectMapper;

    public WeatherServiceImpl(WeatherValidationService weatherValidationService) {
        this.weatherValidationService = weatherValidationService;
        objectMapper = new ObjectMapper();
    }


    @Override
    public Weather getWeather(String city) throws IOException {
        weatherValidationService.validateCity(city);

        String APIKey = "c95443508af34df68be161532231011";

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://api.weatherapi.com/v1/current.json?key="+APIKey+"&q="+city)
                .build();
        Response response = client.newCall(request).execute();

        String responseBody = response.body().string();

        log.info(responseBody);

        JsonNode jsonNode = objectMapper.readTree(responseBody);


        String weatherCity = jsonNode.get("location").get("name").asText();
        String weatherDescription = jsonNode.get("current").get("condition").get("text").asText();
        String weatherLastUpdatedText = jsonNode.get("current").get("last_updated").asText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime weatherLastUpdated = LocalDateTime.parse( weatherLastUpdatedText, formatter);

        Weather weather = new Weather();
        weather.setCity(weatherCity);
        weather.setDescription(weatherDescription);
        weather.setLastUpdated(weatherLastUpdated);

        return weather;
    }
}
