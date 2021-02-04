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
     * 1905 / 100 = 19.01
     * 올림 ceiling = 20
     * centuryFromYear(year) = 20;
     * For year = 1700, the output should be
     * centuryFromYear(year) = 17.
     * 1700 / 100 = 17.00 ceilining 안올라감
     */
    private static class Test2 implements Test<Integer> {
        private Integer answer;
        
        public Test2(int year) {
            answer = (int)Math.ceil(year / 100.0);
        }

        @Override
        public Integer answer() {
            return answer;
        }
    }

    /**
     * Given the string, check if it is a palindrome.
     * aabaa 펠린드롬
     * 문자를 뒤집어도 같은 단어가 되는걸
     *
     * For inputString = "aabaa", the output should be
     * checkPalindrome(inputString) = true;
     * For inputString = "abac", the output should be
     * checkPalindrome(inputString) = false;
     * For inputString = "a", the output should be
     * checkPalindrome(inputString) = true.
     */
    private static class Test3 implements Test<Boolean> {

        private boolean answer;

        public Test3(String original){

            String reverse = "";
            for(int i = original.length() -1; i>=0; i--){
                reverse += original.charAt(i);
                //System.out.println(reverse);
            }

            for(int i =0; i <original.length(); i++){
                if(original.charAt(i) != reverse.charAt(i))
                    answer = false;
            }
        }
        @Override
        public Boolean answer() {
            return answer;
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
        private int LINES;

        // 1. 줄 2. 공간 3. 별 출력

        public Test4(int LINES) {
            this.LINES = LINES;
        }



        public String answer() {
            return star(0, new StringBuilder()).toString();
        }

        private StringBuilder star(int line, StringBuilder sb){
            if(line == LINES){  // 현재라인이 제일 마지막 라인에 도달했을
                printStar(line, sb);
                sb.append("\n");
                return sb;
            }
            printStar(line, sb); //현재 라인의 윗쪽 부분
            sb.append("\n");
            star(line+1, sb);  // 현재 라인의 별찍기
            printStar(line, sb);
            sb.append("\n");  // 현재라인의 아래쪽 부
            return sb;
        }

        private void printStar(int line, StringBuilder sb){
            int stars = (line * 2) -1; // line1 =별 1개, line2 = 별3개, line 3
            int blanks = ((LINES *2) -1) - stars;
            for(int i=0; i<blanks/2; i++){
                sb.append(" ");
            }
            for(int i=0; i<stars; i++){
                sb.append("*");
            }
            for(int i=0; i<blanks/2; i++){
                sb.append(" ");
            }
        }
    }

//    public static void main(String[] args) {
//        for (int i=1; i<10; i++)
//            System.out.println(new Test4(i).answer());
//    }

    public static void main(String[] args) {
        Test2 test2 = new Test2(1);
        System.out.println(test2.answer());
        test2 = new Test2(1905);
        System.out.println(test2.answer());
        test2 = new Test2(1700);
        System.out.println(test2.answer());

        System.out.println("===================================");

        Test<Boolean> test = new Test3("aabaa");
        System.out.println(test.answer());
        test = new Test3("dog");
        System.out.println(test.answer());
        test = new Test3("abac");
        System.out.println(test.answer());
        test = new Test3("a");
        System.out.println(test.answer());
        test = new Test3("hannah");
        System.out.println(test.answer());
        test = new Test3("haeun");
        System.out.println(test.answer());

        System.out.println("===================================");

        for (int i=1; i<10; i++)
            System.out.println(new Test4(i).answer());

    }
}
