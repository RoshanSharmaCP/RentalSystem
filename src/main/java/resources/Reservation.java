package resources;

import enums.ReservationStatus;

import java.util.Date;

public class Reservation {
    private String reservationId;
    private User user;
    private Vehicle vehicle;
    private Date startDate;
    private Date endDate;
    private ReservationStatus status;

    public Reservation(String reservationId, User user, Vehicle vehicle, Date startDate, Date endDate) {
        this.reservationId = reservationId;
        this.user = user;
        this.vehicle = vehicle;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = ReservationStatus.PENDING;
    }

    public String getReservationId() {
        return reservationId;
    }

    public User getUser() {
        return user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public ReservationStatus getStatus() {
        return status;
    }
    public void confirmReservation() {
        this.status = ReservationStatus.CONFIRMED;
        vehicle.setAvailability(false);
    }

    public void cancelReservation() {
        this.status = ReservationStatus.CANCELLED;
        vehicle.setAvailability(true);
    }
}
