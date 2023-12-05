package ro.itschool.project.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_REQUEST;


// @NoArgsConstructor // mankes you not need to write a constructor, not reccomended because it abstacts things, but it can be more elegant
@Slf4j
@ControllerAdvice
public class ExceptionHandlerAdvice {

    private final ObjectMapper objectMapper;

    public ExceptionHandlerAdvice(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @ExceptionHandler(UserCreateException.class)
    public ResponseEntity<String> userCreateException( UserCreateException userCreateException){
        return new ResponseEntity<>(objectToString(Map.of("message", userCreateException.getMessage())), BAD_REQUEST);
    }

    private String objectToString(Object response) {
        try {
            return  objectMapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            log.error("Error processing response to string.");
            return "Internal error";
        }
    }

}
