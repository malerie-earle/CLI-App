package com.keyin.cli.api.models;

public class Airport {
    private long airport_ID;
    private String name;
    private String code;
    private String city;
    private String province;

    public Airport(){

    }

    public Airport(long airport_ID, String name, String code,  String city, String province) {
        this.airport_ID = airport_ID;
        this.code = code;
        this.name = name;
        this.city = city;
        this.province = province;
    }

    public long getAirport_ID() {
        return airport_ID;
    }

    public void setAirport_ID(long airport_ID) {
        this.airport_ID = airport_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "Airport - " +
                "ID: " + airport_ID +
                ", Name: " + name +
                ", Code: " + code +
                ", City: " + city +
                ", Province: " + province +
                '.';
    }

    @Override
    public boolean equals(Object o){
        //  If we are comparing it to itself, we return true
        if(o == this){
            return true;
        }
        // If other object is not airport, we return false
        if (!(o instanceof Airport)) {
            return false;
        }
        // Else, we set the object/cast the object to be an airport, then compare attributes
        Airport otherAirport = (Airport) o;

        if(this.airport_ID != otherAirport.getAirport_ID() || this.name != otherAirport.getName() || this.code != otherAirport.code || !this.city.equals(otherAirport.getCity()) || this.province != otherAirport.province ){
            return false;
        }
        return true;
    }
}
