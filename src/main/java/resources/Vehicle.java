package resources;

import enums.VehicleType;

public class Vehicle {
    private String vehicleId;
    private String licensePlate;
    private VehicleType type;
    private boolean isAvailable;

    public Vehicle(String vehicleId, String licensePlate, VehicleType type) {
        this.vehicleId = vehicleId;
        this.licensePlate = licensePlate;
        this.type = type;
        this.isAvailable = true;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public VehicleType getType() {
        return type;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailability(boolean availability) {
        this.isAvailable = availability;
    }
}
