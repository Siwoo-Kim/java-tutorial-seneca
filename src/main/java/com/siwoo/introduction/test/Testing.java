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
     *  1905 / 100 = 19.01 (ceiling) = 20
     *  
     * centuryFromYear(year) = 20;
     * 
     * For year = 1700, the output should be
     * centuryFromYear(year) = 17.
     *  1700 / 100 = 17.00 (ceiling) = 17
     * 
     */
    private static class Test2 implements Test<Integer> {
        private Integer answer;
        
        public Test2(int year) {
            answer = (int) Math.ceil(year / 100.0);
        }

        @Override
        public Integer answer() {
            return answer;
        }
    }

    /**
     * Given the string, check if it is a palindrome.
     * 
     * 01234
     * aabaa
     * 
     * 팰린드롬
     * 문자를 뒤집어도 같은 단어가 되는걸 팰린드롬
     * 
     * aabaa => aabaa
     * dog => god
     * 
     * For inputString = "aabaa", the output should be
     * checkPalindrome(inputString) = true;
     * For inputString = "abac", the output should be
     * checkPalindrome(inputString) = false;
     * For inputString = "a", the output should be
     * checkPalindrome(inputString) = true.
     */
    private static class Test3 implements Test<Boolean> {
        private String s;
        int e = -1;
        
        public Test3(String string) {
            this.s = string;
        }

        @Override
        public Boolean answer() {
            StringBuilder sb = new StringBuilder(s);
            String reverse = sb.reverse().toString();
            return reverse.equals(s);
        }

        private Boolean isPalindrome(int start, int end) {
            if (start >= end) return true;
            if (s.charAt(start) != s.charAt(end)) return false;
            return isPalindrome(start+1, end-1);
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
        
        @Override
        public String answer() {
            return star(0, new StringBuilder()).toString();
        }

        private StringBuilder star(int line, StringBuilder sb) {
            if (line == LINES) {    // 현재 라인이 제일 마지막 라인에 도달했을
                printStar(line, sb);
                sb.append("\n");
                return sb;
            }
            printStar(line, sb); // 현재 라인의 윗쪽 부분
            sb.append("\n");
            star(line+1, sb);   // 현재 라인의 별찍기.
            printStar(line, sb);    // 현재 라인의 아랫쪽 부분
            sb.append("\n");
            return sb;
        }

        private void printStar(int line, StringBuilder sb) {          
            int stars = (line * 2) - 1; // line 1 = 별 1개, line 2 = 별 3개, line 3 = 별 5개.
            int blanks = ((LINES * 2) - 1) - stars; // 빈 공간의 크기 = 최대 별의 갯수 - 현재 별의 갯수 
            for (int i=0; i<blanks/2; i++)  // 앞쪽 빈공간
                sb.append(" ");
            for (int i=0; i<stars; i++)
                sb.append("*");
            for (int i=0; i<blanks/2; i++)
                sb.append(" ");
        }
    }

    public static void main(String[] args) {
        Test<Integer> test2 = new Test2(1);
        System.out.println(test2.answer());
        test2 = new Test2(1905);
        System.out.println(test2.answer());
        test2 = new Test2(1700);
        System.out.println(test2.answer());
        System.out.println("========================================================");

        Test<Boolean> test3 = new Test3("aabaa");
        System.out.println(test3.answer());
        test3 = new Test3("dog");
        System.out.println(test3.answer());
        test3 = new Test3("abac");
        System.out.println(test3.answer());
        test3 = new Test3("a");
        System.out.println(test3.answer());
        test3 = new Test3("hannah");
        System.out.println(test3.answer());
        test3 = new Test3("haeun");
        System.out.println(test3.answer());
        
        for (int i=1; i<=10; i++)
            System.out.println(new Test4(i).answer());
    }
    
}
