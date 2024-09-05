package resources;

import enums.PaymentMethod;
import enums.PaymentStatus;

public class Payment {
    private String paymentId;
    private Bill bill;
    private PaymentMethod method;

    public Payment(String paymentId, Bill bill, PaymentMethod method) {
        this.paymentId = paymentId;
        this.bill = bill;
        this.method = method;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public Bill getBill() {
        return bill;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public void processPayment() {
        // Assume payment is processed successfully
        bill.setPaymentStatus(PaymentStatus.PAID);
        System.out.println("Payment for bill " + bill.getBillId() + " processed successfully.");
    }
}
