package com.remis.location.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Location {

    @Id
    private String id;

    private String refId;
    private double latitude;
    private double longitude;
    private String tnxNum;
    private String trackingCode;
    private String chCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTnxNum() {
        return tnxNum;
    }

    public void setTnxNum(String tnxNum) {
        this.tnxNum = tnxNum;
    }

    public String getTrackingCode() {
        return trackingCode;
    }

    public void setTrackingCode(String trackingCode) {
        this.trackingCode = trackingCode;
    }

    public String getChCode() {
        return chCode;
    }

    public void setChCode(String chCode) {
        this.chCode = chCode;
    }

    @Override
    public String toString() {
        return "{\"Location\":{"
                + "                        \"id\":\"" + id + "\""
                + ",                         \"refId\":\"" + refId + "\""
                + ",                         \"latitude\":\"" + latitude + "\""
                + ",                         \"longitude\":\"" + longitude + "\""
                + ",                         \"tnxNum\":\"" + tnxNum + "\""
                + ",                         \"trackingCode\":\"" + trackingCode + "\""
                + ",                         \"chCode\":\"" + chCode + "\""
                + "}}";
    }
}
