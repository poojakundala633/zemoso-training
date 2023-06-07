package Solid_principle_assignment;

public class PaymentDetails {
        private PaymentMethod paymentMethod;

        public PaymentDetails(PaymentMethod paymentMethod){
            this.paymentMethod = paymentMethod;
        }

        public void processPayment(Order order,PaymentMethod paymentMethod){
            System.out.println("we can enter payment details .");
    }
}
