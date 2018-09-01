package com.remis.location.service;

import com.remis.location.domain.Location;
import com.remis.location.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public Location create(Location location) {
        return locationRepository.save(location);
    }

    public Location update(Location location) {
        return locationRepository.save(location);
    }

    public Location get(String id) {
        Optional<Location> optionalLocation = locationRepository.findById(id);
        return optionalLocation.get();
    }

    public void delete(String id) {
        locationRepository.deleteById(id);
    }
}
