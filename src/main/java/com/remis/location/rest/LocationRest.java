package com.remis.location.rest;

import com.remis.location.domain.Location;
import com.remis.location.rest.exception.LocationDoesNotExistException;
import com.remis.location.rest.exception.LocationIsExistException;
import com.remis.location.service.LocationService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value="Remis", description="Location")
@RestController
@RequestMapping("/location")
public class LocationRest {

    private static final Logger logger = LoggerFactory.getLogger(LocationRest.class);

    @Autowired
    private LocationService locationService;

    @RequestMapping("/create")
    @PostMapping
    public ResponseEntity<String> create(@RequestBody Location location) {
        if (location.getId() != null){
            logger.debug("The location is exist");
            throw new LocationIsExistException();
        }
        location = locationService.create(location);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        return new ResponseEntity<String>("{" +
                "\"message\": \"successful\"," +
                "\"code\": \"200\",  " +
                location.toString() +
                "}", headers, HttpStatus.OK);
    }

    @RequestMapping("/get/{id}")
    @GetMapping
    public ResponseEntity<String> get(@PathVariable String id) {
        Location location = locationService.get(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        return new ResponseEntity<String>("{" +
                "\"message\": \"successful\"," +
                "\"code\": \"200\",  " +
                location.toString() +
                "}", headers, HttpStatus.OK);
    }

    @RequestMapping("/update")
    @PostMapping
    public ResponseEntity<String> update(@RequestBody Location location) {
        if (location.getId() == null){
            logger.debug("The location does not exist");
            throw new LocationDoesNotExistException();
        }
        location = locationService.update(location);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        return new ResponseEntity<String>("{" +
                "\"message\": \"successful\"," +
                "\"code\": \"200\",  " +
                location.toString() +
                "}", headers, HttpStatus.OK);
    }

    @RequestMapping("/delete/{id}")
    @PostMapping
    public ResponseEntity<String> create(@PathVariable String id) {
        locationService.delete(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        return new ResponseEntity<String>("{" +
                "\"message\": \"successful\"," +
                "\"code\": \"200\"" +
                "}", headers, HttpStatus.OK);
    }
}
