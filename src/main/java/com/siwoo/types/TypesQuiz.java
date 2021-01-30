package com.siwoo.types;

public class TypesQuiz {
    
    public static void main(String[] args) {
        Q1 q1 = new Q1();
        q1.ask();
    }

    /**
     * 몇개의 숫자가 프린트될지 예상해보기.
     * 
     * 틀렸다면 count 을 선언해 한번 확인해보기.
     */
    private static class Q1 implements com.siwoo.Quiz<Void> {

        public Void ask() {
            for (int i = 0; i < 5; i++) {
                System.out.println(i);
                if (i < 3) {
                    continue;
                } else {
                    for (int j = 0; j < 5; j++) {
                        System.out.println(j);
                    }
                }
            }
            return null;
        }
    }

    private static class Q2 {
        /**
         * 아래중 가능한 변수를 골라보기.
         * 200, -20, 100, 1000, 150
         */
        public void ask() {
            int[] ints = {200, -20, 100, 1000, 150};
            for (int n: ints) {
                boolean result = (n < 100) || (n >= 200);
                System.out.println(result);
            }
        }
    }
    
}
