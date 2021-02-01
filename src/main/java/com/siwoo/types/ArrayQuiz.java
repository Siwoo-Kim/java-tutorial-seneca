package com.siwoo.types;

import com.siwoo.Quiz;


public class ArrayQuiz {

    /**
     * 문제를 먼저 이해해보자.
     * pair of adjacent elements 이 무엇인지 이해한다.
     * pair of adjacent elements 의 product (곱셈) 을 어떤식으로 표현할지 생각한다.
     * 가장 큰 값을 어떻게 구할지 생각한다. (예외 상황을 생각해본다)
     * 
     * adjacentElementsProduct
     * 
     * Given an array of integers, find the pair of adjacent elements that has the largest product and return that product.
     * 
     * 2 ≤ inputArray.length ≤ 10
     * -1000 ≤ inputArray[i] ≤ 1000
     * 
     * Example
     *
     * For inputArray = [3, 6, -2, -5, 7, 3], the output should be
     * adjacentElementsProduct(inputArray) = 21.
     *
     * 7 and 3 produce the largest product.
     */
    private static class Q1 implements Quiz<Integer> {

        private Q1(int[] params) {
            
        }

        @Override
        public Integer answer() {
            return null;
        }
    }

    /**
     *  Pascal's Triangle
     *  
     *  파스칼 삼각형 그림을 보고 패턴을 이해하자.
     *  각 라인별로 어떤식으로 값을 도출할지 생각하자.
     *  예외 케이스는 어떨지 생각해보자.
     *  
     *  Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
     */
    private static class Q2 implements Quiz<int[][]> {
        private int[][] triangles;
        
        private Q2(int N) {
        }
        
        @Override
        public int[][] answer() {
            return null;
        }
    }

    /**
     * Binary Search (이진 탐색)
     * 
     * 
     * "정렬된 배열 a" 의 요소 e 의 인덱스을 찾아서 리턴하자.
     * 
     */
    private static class Q3 implements Quiz<Integer> {

        @Override
        public Integer answer() {
            return null;
        }
    }
}
