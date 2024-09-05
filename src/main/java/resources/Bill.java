package resources;

import enums.PaymentStatus;

public class Bill {
    private String billId;
    private Reservation reservation;
    private double amount;
    private PaymentStatus paymentStatus;

    public Bill(String billId, Reservation reservation, double amount) {
        this.billId = billId;
        this.reservation = reservation;
        this.amount = amount;
        this.paymentStatus = PaymentStatus.UNPAID;
    }

    public String getBillId() {
        return billId;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus status) {
        this.paymentStatus = status;
    }
}
