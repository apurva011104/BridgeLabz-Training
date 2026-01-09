class Bill{

    private IPayable patient;

    public Bill(IPayable patient) {
        this.patient = patient;
    }

    public void generateBill() {
        System.out.printf("Total Bill: %.2f INR%n" + patient.calculateBill());
    }

}
