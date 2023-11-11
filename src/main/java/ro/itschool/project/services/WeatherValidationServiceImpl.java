package ro.itschool.project.services;


import org.springframework.stereotype.Service;

@Service
public class WeatherValidationServiceImpl implements WeatherValidationService {

    @Override
    public void validateCity(String city){
        if(city.length() < 2){
            throw new RuntimeException("Invalid city name.");
        }
    }
}
