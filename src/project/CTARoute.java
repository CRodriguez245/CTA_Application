package project;

import java.util.ArrayList;

//import labs.lab6.CTAStation;
//import labs.lab5.GeoLocation;

//Carlos Rodriguez
//November 12, 2018
//This class takes CTA stations and is able to group them. In this case, the group can be according to the line.
//In addition, this class get stop, name, add station, remove station, look up station, and display nearest station
//relative to the array list

public class CTARoute extends CTAStation{
    private String name;
    private String string = "";

    private ArrayList<CTAStation> stops;

    public CTARoute() {
        super();
        name = " ";
        stops = new ArrayList<CTAStation>(); //not sure about this one

    }

    public CTARoute(String name, ArrayList<CTAStation> stops){
        this.name = name;
        this.stops = stops;

    }

    public String getName() {
        return this.name;

    }

    public ArrayList<CTAStation> getStops(){
        return this.stops;

    }

    public void setName(String name) {
        this.name = name;

    }

    public void setStops(ArrayList<CTAStation> stops) {
        this.stops = stops;

    }

    public void addStation(CTAStation station) {
        stops.add(station);

    }

    public void removeStation(CTAStation station) {
        stops.remove(station);

    }

    public void insertStation(int index, CTAStation station) {
        stops.add(index,station);

    }

    public CTAStation lookUpStation(String station) {

        for(int i = 0; i < stops.size(); i++) {
            if(station.equals(stops.get(i).getName())) {
                return stops.get(i);
            }

        }
        return null;


    }

    public void displayNearest( double userLatitude, double userLongitude) {
        CTAStation min = stops.get(0);

        for(int i = 1; i < stops.size(); i++) {

            double minDistance = min.calcDistance(userLatitude, userLongitude);
            double stationDistance = stops.get(i).calcDistance(userLatitude, userLongitude);

            if( minDistance > stationDistance ) {
                min = stops.get(i);

            }
        }

        System.out.println("Closest station: " + min.getName());


    }

    public void displayNearest(GeoLocation location) {
        CTAStation min = stops.get(0);

        for(int i = 1; i < stops.size(); i++) {

            double minDistance = min.calcDistance(location.getLat(),location.getLng());
            double stationDistance = stops.get(i).calcDistance(location.getLat(), location.getLng());

            if( minDistance > stationDistance ) {
                min = stops.get(i);

            }
        }

        System.out.println("Closest station: " + min.getName());


    }







}
