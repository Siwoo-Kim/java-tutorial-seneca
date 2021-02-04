package com.siwoo.types;

import com.siwoo.Quiz;

public class TypesQuiz {
    

    /**
     * 배열의 각 숫자 요소를 붙여 하나의 int 로 반환.
     * 
     * example 
     * params = ['1', '2', '3', '4', '5']
     * answer = 12345
     * 
     */
    public static class Q1 implements Quiz<Integer> {
        private int answer;
        
        public Q1(char[] nums) {
        }

        @Override
        public Integer answer() {
            return answer;
        }
    }

    /**
     * a 와 b 의 최대 공약수 (GCD) 을 구해보자.
     *  (두 수 A, B 의 공통된 약수 중 가장 큰 수)
     *
     * example 
     * params = 24, 16
     * answer = 8
     * 
     */
    public static class Q2 implements Quiz<Integer> {
        private int answer;
        
        private Q2(int a, int b) {
        }

        @Override
        public Integer answer() {
            return null;
        }
    }

    /**
     * N 이하의 소수를 구해보자.
     *  소수 - 약수가 1 과 자신밖에 없는 수.
     *  
     *  params = 15
     *  answer = {2, 3, 5, 7, 11, 13}
     */
    public static class Q3 implements Quiz<int[]> {

        public Q3(int N) {}


        @Override
        public int[] answer() {
            return new int[0];
        }
    }
    
    public static void main(String[] args) {
        // do test
    }
}
