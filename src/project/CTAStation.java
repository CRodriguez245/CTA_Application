package project;

//import labs.lab5.GeoLocation;

//Carlos Rodriguez
//November 9, 2018
//This class creates, manipulates, and obtains the CTA stations and calculates the distance between two (inherently). In addition, this
//class has a detailed description of the station, including the wheelchair accessibility and location type.

public class CTAStation extends GeoLocation{

    private String name;
    private String location;
    private boolean wheelchair;
    private String string = "";

    public CTAStation() {
        super();
        name = " ";
        location = " ";

        wheelchair = false;

    }

    public CTAStation(String name, String location, boolean opened, boolean wheelchair) {
        super();
        this.name = name;
        this.location = location;

        this.wheelchair = wheelchair;

    }

    public String getName() {
        return this.name;

    }

    public String getLocation() {
        return this.location;

    }



    public boolean getWheelchair() {
        return this.wheelchair;

    }

    public void setName(String name) {
        this.name = name;

    }

    public void setLocation(String location) {
        this.location = location;
    }



    public void setWheelchair(boolean wheelchair) {
        this.wheelchair = wheelchair;

    }

    public String toString() {
        return " name: " + name + "\n (*" + super.getLat() + "*,*" + super.getLng() + "*)," + " location: " + location + ", wheelchair: " + wheelchair;

    }





}


