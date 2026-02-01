package edu.narxoz.galactic;
import edu.narxoz.galactic.bodies.Planet;
import edu.narxoz.galactic.bodies.SpaceStation;
import edu.narxoz.galactic.cargo.Cargo;
import edu.narxoz.galactic.dispatcher.Dispatcher;
import edu.narxoz.galactic.dispatcher.Result;
import edu.narxoz.galactic.drones.HeavyDrone;
import edu.narxoz.galactic.drones.LightDrone;
import edu.narxoz.galactic.task.DeliveryTask;

public class Main{
    public static void main(String[] args){
        Planet earth = new Planet("Earth", 0, 0, "Oxygen");
        SpaceStation spaceStation = new SpaceStation("Station", 50, 70, 5);
        Cargo cargo = new Cargo(8, "Drugs");

        LightDrone light = new LightDrone("Light", 5.0);
        HeavyDrone heavy = new HeavyDrone("Heavy", 20.0);

        DeliveryTask task = new DeliveryTask(earth, station, cargo);
        Dispatcher dispatcher = new Dispatcher();

        Result r1 = dispatcher.assignTask(task, light);
        System.out.println("Assign to LightDrone: " + r1);

    
        Result r2 = dispatcher.assignTask(task, heavy);
        System.out.println("Assign to HeavyDrone: " + r2);


        double time = task.estimateTime();
        System.out.println("Estimated time (min): " + time);


        Result r3 = dispatcher.completeTask(task);
        System.out.println("Complete task: " + r3);

        System.out.println("Final drone status: " + heavy.getStatus());
        System.out.println("Final task state: " + task.getState());
    }
}