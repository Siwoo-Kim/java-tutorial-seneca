package com.siwoo.types;

public class 기본형과참조형 {

    //main { data = 1 }
    //primivive { data = 2 }
    public static void main(String[] args) {
        int data = 1;
        primitive(data);
        System.out.println(data); //1


        // main { counter.elemnt = 1 }
        // reference { counter.element = 1 }
        // reference { counter.elemnt = 2 } ++ 연산
        // main { counter.element = 2 }
        Counter counter = new Counter(1);
        reference(counter);
        System.out.println(counter.element); //2
        
        data = 1;
        int date2 = data;
        date2++;
        System.out.println(data); //1
        System.out.println(date2); //2
        System.out.println(data == date2); //false
        
        counter = new Counter(1);
        Counter counter2 = counter;
        counter.increment(); //2
        counter2.increment(); //3
        System.out.println(counter.element); //3
        System.out.println(counter2.element); //3
        System.out.println(counter == counter2); //true
        counter = new Counter(1);
        int count = 1;
        doCount(count); //1
        doCount(counter); //2
        System.out.println(count); //1
        System.out.println(counter.element); //2
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

    private static void primitive(int data) { data++; }

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
