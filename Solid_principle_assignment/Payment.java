package Solid_principle_assignment;

public class Payment {

    class OnlinePayment implements PaymentMethod{

        @Override
        public void processDetails(Order order, PaymentDetails paymentDetails) {
            System.out.println("online Payment");
        }
    }

    class CreditCardPayment implements PaymentMethod{

        @Override
        public void processDetails(Order order, PaymentDetails paymentDetails) {
            System.out.println("credit card payment");
        }
    }

    class CashOnDelivery implements PaymentMethod{

        @Override
        public void processDetails(Order order, PaymentDetails paymentDetails) {
            System.out.println("cash on delivery");
        }
    }
}
