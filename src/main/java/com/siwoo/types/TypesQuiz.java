package com.siwoo.types;

import com.siwoo.Quiz;

import java.util.ArrayList;
import java.util.List;

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
            //문자 - 숫자
            // 붙이기
            //*10
            int sum = 0;
            for (int i = 0; i < nums.length; i++){
                int temp = (int)nums[i] - (int)'0';
                sum *= 10;
                sum += temp;
            }

            answer = sum;
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

            int temp = 0;

            if(a > b){
                temp = a;
            }else{
                temp =b;
            }

            for(int i =1; i <= temp; i++){
                if(a % i == 0 && b % i==0){
                    answer = i;
                }
            }
        }

        @Override
        public Integer answer() {
            return answer;
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
        List<Integer> primes = new ArrayList<>();

        public Q3(int N) {
            for (int i = 2; i <= N; i++){
                boolean isPrime = true;
                for (int j = 2; j<= i-1; j++){
                    if (i % j == 0){
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime){
                    primes.add(i);
                }
            }
        }

        @Override
        public int[] answer() {
            int[] a = new int[primes.size()];
            for (int i=0; i<primes.size(); i++)
                a[i] = primes.get(i);
            return a;
        }
    }
    
    public static void main(String[] args) {
        // do test
        Q3 q3 = new Q3(15);
        int [] a = q3.answer();
        for (int i =0; i< a.length; i++){
            System.out.println(a[i]);
        }
//        System.out.println((int)'0'- (int)'0');  //48
//        System.out.println((int)'1' - (int)'0');  //49
//        System.out.println((int)'2'- (int)'0');  //50


        char [] num = {'1','2','3','4','5'};
        Q1 q1 = new Q1(num);
        System.out.println("Answer #1: " + q1.answer());

        Q2 q2 = new Q2(16,24);
        System.out.println("Answer #2: " + q2.answer());

        String [] names = {"Paul", "Art"};

        for(int i =0; i< names.length; i++){
            System.out.println(names[i]);
        }

        System.out.println(names[0]);
        System.out.println(names[names.length -1]);

        String s = "haeun";
        s.length();

    }
}
