package edu.narxoz.galactic.bodies;

public class Planet extends CelestialBody{
    private String atmoshpereType;

    public Planet(String name, double x, double y, String atmoshpereType){
        super(name, x, y);
        this.atmoshpereType = atmoshpereType;
    }

    String getAtmosphereType(){
        return atmoshpereType;
    }
}