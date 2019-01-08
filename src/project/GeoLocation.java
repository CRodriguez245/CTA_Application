package project;

//import labs.lab5.GeoLocation;

//Carlos Rodriguez
//November 2, 2018
//This class creates, manipulates, and obtains the coordinates (Geo Location) of stations and calculates the distance between two.

public class GeoLocation {
    private double lat;
    private double lng;
    private String string = "";

    public GeoLocation() {
        lat = 0.0;
        lng = 0.0;

    }

    public GeoLocation(double lats, double lngs) {
        lat = lats;
        lng = lngs;

    }

    public GeoLocation(String lati) {
        String[] array = lati.split("[*(),]");
        lat = Double.parseDouble(array[2]);
        lng = Double.parseDouble(array[5]);

    }

    public double getLat() {
        return lat;

    }

    public double getLng() {
        return lng;

    }

    public void setLat(double lats) {
        lat = lats;

    }

    public void setLng(double lngs) {
        lng = lngs;

    }

    public String toString() {
        return "(*" + lat + "*,*" + lng + "*)";

    }

    public boolean validLatitude() {
        boolean check;
        if(lat >= -90 && lat <= 90) {
            check = true;

        }
        else {
            check = false;

        }

        return check;

    }

    public boolean validLongitude() {
        boolean check;
        if(lng >= -180 && lng <= 180) {
            check = true;

        }
        else {
            check = false;

        }

        return check;

    }

    public double calcDistance(GeoLocation d) {
        return Math.sqrt(Math.pow(lat-d.getLat(), 2)+ Math.pow(lng-d.getLng(), 2));

    }

    public double calcDistance(double lat1, double long1 ) {
        return Math.sqrt(Math.pow(lat-lat1, 2)+ Math.pow(lng-long1, 2));

    }

}



