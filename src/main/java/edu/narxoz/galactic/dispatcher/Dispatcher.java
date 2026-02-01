package edu.narxoz.galactic.dispatcher;

public Result assignTask(DesliveryTask task, Drone drone){
    if(task == null || drone == null){
        return Result(false, "Task or Drone is null");
    }
    
    if (drone.getStatus() != DroneStatus.IDLE) {
        return new Result(false, "Drone is not IDLE");
    }

    if (task.getState() != TaskState.CREATED) {
        return new Result(false, "Task is not in CREATED state");
    }

    if (task.getCargo().getWeightKg() > drone.getMaxPayloadKg()) {
         return new Result(false, "Cargo overweight for this drone");
    }

    task.setAssignedDrone(drone);
    task.setState(TaskState.ASSIGNED);
    drone.setStatus(DroneStatus.IN_FLIGHT);
    return new Result(true, "");
}   

public Result completeTask(DeliveryTask task){
    if (task == null) {
        return new Result(false, "Task is null");
    }

    if (task.getState() != TaskState.ASSIGNED) {
        return new Result(false, "Task is not ASSIGNED");
    }

    if (task.getAssignedDrone() == null) {
        return new Result(false, "Assigned drone is null");
    }

    if (task.getAssignedDrone().getStatus() != DroneStatus.IN_FLIGHT) {
        return new Result(false, "Drone is not IN_FLIGHT");
    }

    task.setState(TaskState.DONE);
    task.getAssignedDrone().setStatus(DroneStatus.IDLE);

    return new Result(true, "");
}