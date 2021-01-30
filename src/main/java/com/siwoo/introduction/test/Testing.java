package com.siwoo.introduction.test;

public class Testing {
    
    private interface Test<Answer> {
        
        Answer answer();
    }

    /**
     * write a function that returns the sum of two numbers.
     *
     * Example
     *
     * For param1 = 1 and param2 = 2, the output should be
     * add(param1, param2) = 3.
     */
    private static class Test1 implements Test<Integer> {
        private Integer answer;

        public Test1(int p1, int p2) {
            this.answer = p1 + p2;
        }

        @Override
        public Integer answer() {
            return answer;
        }
    }

    /**
     * Given a year, return the century it is in.
     * The first century spans from the year 1 up to and including the year 100, 
     * the second - from the year 101 up to and including the year 200, etc.
     * 
     * For year = 1905, the output should be
     * centuryFromYear(year) = 20;
     * For year = 1700, the output should be
     * centuryFromYear(year) = 17.
     * 
     */
    private static class Test2 implements Test<Integer> {
        private Integer answer;
        
        public Test2(int year) {
            
        }

        @Override
        public Integer answer() {
            return answer;
        }
    }

    /**
     * Given the string, check if it is a palindrome.
     * 
     * For inputString = "aabaa", the output should be
     * checkPalindrome(inputString) = true;
     * For inputString = "abac", the output should be
     * checkPalindrome(inputString) = false;
     * For inputString = "a", the output should be
     * checkPalindrome(inputString) = true.
     */
    private static class Test3 implements Test<Boolean> {

        @Override
        public Boolean answer() {
            return null;
        }
    }

    /**
     * 별 찍기
     * 
     * 예제를 보고 규칙을 유추한 뒤에 별을 찍어 보세요.
     * 
     * lines = 5
     *     *
     *    ***
     *   *****
     *  *******
     * *********
     *  *******
     *   *****
     *    ***
     *     *
     */
    private static class Test4 implements Test<String> {
        private String answer;
        private final int LINES;

        public Test4(int LINES) {
            assert LINES > 0;
            this.LINES = LINES;
        }

        public String answer() {
            return null;
        }
    }

    public static void main(String[] args) {
        for (int i=1; i<10; i++)
            System.out.println(new Test4(i).answer());
    }
}
