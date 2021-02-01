package com.siwoo.introduction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 코드로 의사를 표현할 줄 알려면 읽은 것이 먼저.
 * 옆에다 자기가 이해하는 코드의 의미를 적어보기.  (문법을 모른다면 최대한 추측해보기)
 * 
 *  1. count 와 size 을 비교해보기.
 *  2. size 와 dog 을 비교해보기.
 *  3. 처음보거나 생소한 문법은 눈에 익혀두기.
 *  
 *  4. javac 로 컴파일 해보기.
 *  5. java 로 컴파일 된 바이트 코드를 실행해보기.
 */
public class 해석해보기 {
    private static String root = "/home/siwoo/workspace/java-tutorial/src/main/resources";
    private static int count;
    
    public static void main(String[] args) {
        int size = 27;  // size 에 27 대입
        String name = "Fido";   // name 에 "Fido" 대입
        Dog dog = new Dog(name, size);  // Dog 클래스 생성
        count = size - 5;   //
        if (count < 15)
            dog.bark(8);
        while (count > 3) {
            dog.play();
        }
        greetingDog(dog);
        int[] numbers = {2, 4, 6, 8};
        for (int e: numbers)
            System.out.println(e);
        String num = "10";
        int casted = Integer.parseInt(num);
        System.out.println(casted);
        try {
            readFile("별헤는밤.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void greetingDog(Dog dog) {
        System.out.println("Hello");
        System.out.println("Dog: " + dog.name);
    }

    private static void readFile(String file) throws IOException {
        assert file != null;
        BufferedReader reader = new BufferedReader(new FileReader(root + "/" + file));
        String line;
        while ((line = reader.readLine()) != null)
            System.out.println(line);
    }

    private static class Dog {
        private final String name;
        private final int size;

        public Dog(String name, int size) {
            this.name = name;
            this.size = size;
        }

        public void bark(int numberOfBarks) {
            for (int i=0; i<numberOfBarks; i++)
                System.out.println("왈왈");
        }

        public void play() {
            System.out.println("놀자");
            count--;
        }
    }
}
