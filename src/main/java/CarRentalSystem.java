import enums.PaymentMethod;
import enums.VehicleType;
import resources.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class CarRentalSystem {
    private List<Store> stores;
    private List<User> users;
    private List<Reservation> reservations;

    public CarRentalSystem() {
        this.stores = new ArrayList<>();
        this.users = new ArrayList<>();
        this.reservations = new ArrayList<>();
    }

    public void addStore(Store store) {
        stores.add(store);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public Store findStoreByLocation(Location location) {
        for (Store store : stores) {
            if (store.getLocation().getCity().equals(location.getCity())) {
                return store;
            }
        }
        return null;
    }

    public User findUserById(String userId) {
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    public Vehicle findAvailableVehicle(VehicleType type, Store store) {
        for (Vehicle vehicle : store.getVehicles()) {
            if (vehicle.getType() == type && vehicle.isAvailable()) {
                return vehicle;
            }
        }
        return null;
    }

    public Reservation createReservation(String userId, VehicleType vehicleType, Store store, Date startDate, Date endDate) {
        User user = findUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return null;
        }

        Vehicle vehicle = findAvailableVehicle(vehicleType, store);
        if (vehicle == null) {
            System.out.println("No available vehicles of type " + vehicleType);
            return null;
        }

        Reservation reservation = new Reservation(UUID.randomUUID().toString(), user, vehicle, startDate, endDate);
        reservations.add(reservation);
        reservation.confirmReservation();
        System.out.println("Reservation created successfully.");
        return reservation;
    }

    public Bill generateBill(Reservation reservation) {
        double amount = calculateRentalCost(reservation.getStartDate(), reservation.getEndDate());
        Bill bill = new Bill(UUID.randomUUID().toString(), reservation, amount);
        System.out.println("Bill generated with amount: $" + amount);
        return bill;
    }

    public double calculateRentalCost(Date startDate, Date endDate) {
        long diffInMillies = Math.abs(endDate.getTime() - startDate.getTime());
        long diffDays = diffInMillies / (24 * 60 * 60 * 1000);
        return diffDays * 50; // assuming $50 per day rental cost
    }

    public static void main(String[] args) {
        CarRentalSystem system = new CarRentalSystem();

        // Add sample data
        Location location1 = new Location("123 Main St", "New York", "NY", "10001");
        Store store1 = new Store("S1", location1);
        system.addStore(store1);

        User user1 = new User("U1", "John Doe", "john@example.com", "1234567890");
        system.addUser(user1);

        Vehicle vehicle1 = new Vehicle("V1", "ABC123", VehicleType.CAR);
        store1.addVehicle(vehicle1);

        // Create reservation
        Reservation reservation = system.createReservation("U1", VehicleType.CAR, store1, new Date(), new Date(System.currentTimeMillis() + 2 * 24 * 60 * 60 * 1000));

        // Generate bill
        Bill bill = system.generateBill(reservation);

        // Process payment
        Payment payment = new Payment("P1", bill, PaymentMethod.CREDIT_CARD);
        payment.processPayment();
    }
}
