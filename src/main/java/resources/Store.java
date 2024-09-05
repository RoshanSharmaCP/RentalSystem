package resources;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private String storeId;
    private Location location;
    private List<Vehicle> vehicles;

    public Store(String storeId, Location location) {
        this.storeId = storeId;
        this.location = location;
        this.vehicles = new ArrayList<>();
    }

    public String getStoreId() {
        return storeId;
    }

    public Location getLocation() {
        return location;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }
}
