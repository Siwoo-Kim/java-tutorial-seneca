package com.siwoo.types;

public class 기본형과참조형 {

    public static void main(String[] args) {
        int data = 1;
        primitive(data);
        System.out.println(data);
        
        Counter counter = new Counter(1);
        reference(counter);
        System.out.println(counter.element);
        
        data = 1;
        int date2 = data;
        date2++;
        System.out.println(data);
        System.out.println(date2);
        System.out.println(data == date2);
        
        counter = new Counter(1);
        Counter counter2 = counter;
        counter.increment();
        counter2.increment();
        System.out.println(counter.element);
        System.out.println(counter2.element);
        System.out.println(counter == counter2);
        
        counter = new Counter(1);
        int count = 1;
        doCount(count);
        doCount(counter);
        System.out.println(count);
        System.out.println(counter.element);
    }

    private static void doCount(int count) {
        count++;
    }

    private static void doCount(Counter counter) {
        counter.element++;
    }

    private static void reference(Counter counter) {
        counter.increment();
    }

    private static void primitive(int data) {
        data++;
    }

    private static class Counter {
        int element;

        public Counter(int element) {
            this.element = element;
        }
        
        public void increment() {
            element++;
        }
    }
}
