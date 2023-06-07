package Solid_principle_assignment;

import java.util.List;

public abstract class Order {
    private List<OrderItem> items;
    private Customer customer;
    private PaymentMethod paymentMethod;

    public Order(List<OrderItem> items , Customer customer ,PaymentMethod paymentMethod){
        this.items = items;
        this.customer =customer;
        this.paymentMethod = paymentMethod;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public Customer getCustomer() {
        return customer;
    }
     public abstract double getTotalOrder();

    class OrderOnline extends Order{

        public OrderOnline(List<OrderItem> items, Customer customer,PaymentMethod paymentMethod) {
            super(items, customer,paymentMethod);
        }

        @Override
        public double getTotalOrder() {
            return 0;
        }
    }

    class PhoneOrder extends Order{
        public PhoneOrder(List<OrderItem> items, Customer customer,PaymentMethod paymentMethod) {
            super(items, customer,paymentMethod);
        }

        @Override
        public double getTotalOrder() {
            return 0;
        }
    }

    class InPersonOrder extends Order{
        public InPersonOrder(List<OrderItem> items, Customer customer,PaymentMethod paymentMethod) {
            super(items, customer,paymentMethod);
        }

        @Override
        public double getTotalOrder() {
            return 0;
        }
    }

}

