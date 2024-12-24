package SomeTest.demo;

import java.util.concurrent.PriorityBlockingQueue;

public class MyPriporityBlockingQueue {

    public static void main(String[] args) throws InterruptedException {
        PriorityBlockingQueue<Customer> blockingQueue = new PriorityBlockingQueue<>();
        blockingQueue.add(new Customer(1,"task1"));
        blockingQueue.add(new Customer(10,"task10"));
        blockingQueue.add(new Customer(8,"task8"));

        while (!blockingQueue.isEmpty()){
            Customer take = blockingQueue.take();
            System.out.println(take.getName());
        }
    }

    static class Customer implements Comparable<Customer>{

        private int id;
        private String name;

        public Customer(int i, String n){
            this.id=i;
            this.name=n;
        }
        public int getId() {
            return id;
        }
        public String getName() {
            return name;
        }

        @Override
        public int compareTo(Customer o) {
            return Integer.compare(o.getId(),this.getId());
        }
    }
}
