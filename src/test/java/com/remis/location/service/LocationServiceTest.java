package com.remis.location.service;

import com.remis.location.domain.Location;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LocationServiceTest {

    @Autowired
    private LocationService locationService;

    private Location location;

    private Location locationCreator(){
        Location location = new Location();
        location.setChCode("AAAAA");
        location.setLatitude(32.9697);
        location.setLongitude(-96.80322);
        location.setRefId("AAAAA");
        location.setTnxNum("AAAAA");
        location.setTrackingCode("AAAAA");
        return location;
    }

    @Test
    public void create(){
        Location location = locationCreator();
        Location returnedLocation = locationService.create(location);
        assertEquals(location.getRefId(), returnedLocation.getRefId());
    }
}
