interface Payment {

    public void paymentMethodDetail();
    public void pay(double amount) throws PaymentFailedException;
}
