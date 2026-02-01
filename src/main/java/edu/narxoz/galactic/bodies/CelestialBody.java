package edu.narxoz.galactic.bodies;

private String name;
private double x; 
private double y;

protected CelestialBody(String name, double x, double y){
    this.name = name;
    this.x = x;
    this.y = y;
}

public String getName(){
    return name;
}

public double getX(){
    return x;
}

public double getY(){
    return y;
} 

public double distanceTo(CelestialBody other){
    if(other == null){
        throw new IllegalArgumentException("Other body cannot be null");
     
    }
    return Math.sqrt(((other.x - this.x) * (other.x - this.x)) + ((other.y - this.y) * (other.y - this.y)));    
}

