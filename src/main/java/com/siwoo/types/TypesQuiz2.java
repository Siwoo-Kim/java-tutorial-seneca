package com.siwoo.types;

import com.siwoo.Quiz;

import java.util.Arrays;

public class TypesQuiz2 {
    
    private static class Q1 implements Quiz<Integer> {
        private int[] nums;

        public Q1(int[] nums) {
            this.nums = nums;
        }

        public Integer answer() {
            return nums[0];
        }
    }
    
    private static class Q2 implements Quiz<Integer> {
        private int[] nums;

        public Q2(int[] nums) {
            this.nums = nums;
        }
        
        public Integer answer() {
            return nums[nums.length-1];
        }
    }
    
    private static class Q3 implements Quiz<Dog[]> {
        
        public Dog[] answer() {

            Dog [] dogs = new Dog[3];

            for(int i=0; i< dogs.length; i++){
                dogs[i] = new Dog();
            }
            return dogs;
        }
    }

    private static class Q4 implements Quiz<int[]> {
        private int[] nums;

        public Q4(int[] nums) {
            this.nums = nums;

            //1,2,3,4  -> 4,3,2,1
            int [] temp = new int[nums.length];
            for(int i = nums.length-1, j = 0; i >=0; i--, j++){
                temp[j] = nums[i];
            }

            this.nums = temp;
        }

        public int[] answer() {
            return nums;
        }
    }

    private static class Q5 implements Quiz<int[]> {
        private int[] nums;

        public Q5(int[] nums) {
            this.nums = nums;
            Arrays.sort(nums);

            this.nums = nums;
        }
        public int[] answer() {
            return nums;
        }
    }


    private static class Q6 implements Quiz<int[]> {
        private int[] nums;

        public Q6(int[] nums) {
            this.nums = nums;
            Dog dogs = new Dog();

//            while(dogs){
//                dogs.bark();
//            }
        }

        public int[] answer() {
            return null;
        }
    }
    
    private static class Q7 implements Quiz<Void>  {
        private int[] nums;

        public Q7(int[] nums) {
            this.nums = nums;
        }

        public Void answer() {
            return null;
        }
    }
    
    // 문서에 나온대로 Dog 구현해보기.
    private static class Dog {
        private String name;
        public void bark(){
            System.out.println("bark");
        }

        public void eat(){
            System.out.println("Eat");
        }

        public void chaseCat(){

        }
    }
}
