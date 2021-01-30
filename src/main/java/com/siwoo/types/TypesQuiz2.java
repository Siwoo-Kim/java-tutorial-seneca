package com.siwoo.types;

import com.siwoo.Quiz;

public class TypesQuiz2 {
    
    private static class Q1 implements Quiz<Integer> {
        private int[] nums;

        public Q1(int[] nums) {
            this.nums = nums;
        }

        public Integer ask() {
            return -1;
        }
    }
    
    private static class Q2 implements Quiz<Integer> {
        private int[] nums;

        public Q2(int[] nums) {
            this.nums = nums;
        }
        
        public Integer ask() {
            return -1;
        }
    }
    
    private static class Q3 implements Quiz<Dog[]> {
        
        public Dog[] ask() {
            return null;
        }
    }

    private static class Q4 implements Quiz<int[]> {
        private int[] nums;

        public Q4(int[] nums) {
            this.nums = nums;
        }

        public int[] ask() {
            return null;
        }
    }

    private static class Q5 implements Quiz<int[]> {
        private int[] nums;

        public Q5(int[] nums) {
            this.nums = nums;
        }

        public int[] ask() {
            return null;
        }
    }


    private static class Q6 implements Quiz<int[]> {
        private int[] nums;

        public Q6(int[] nums) {
            this.nums = nums;
        }

        public int[] ask() {
            return null;
        }
    }
    
    private static class Q7 implements Quiz<Void>  {
        private int[] nums;

        public Q7(int[] nums) {
            this.nums = nums;
        }

        public Void ask() {
            return null;
        }
    }
    
    // 문서에 나온대로 Dog 구현해보기.
    private static class Dog {
        
    }
}
