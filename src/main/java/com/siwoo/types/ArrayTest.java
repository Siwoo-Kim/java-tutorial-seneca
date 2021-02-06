package com.siwoo.types;

public class ArrayTest {
    
    public static void main(String[] args) {
        //Student 학생 배열을 선언해보자.
        int[] a = {1, 2, 3};
        
        //Student 학생 배열을 초기화해보자.
        
        
        //Student 학생 배열을 앞에서 순회해보자.
        
        //Student 학생 배열을 뒤에서 순회해보자.
        
        //Student 학생 배열을 한칸씩 뛰어서 순회해보자.
        
        
        final int[][] pascal = createPascalTriangle(5);
        // 파스칼의 삼각형을 순회해보자.
        
        // 파스칼의 삼각형 모양 그대로 순회해보자.
        
        // 파스칼의 삼각형 각 행 중 가장 큰 값만 순회해보자.
        
        
    }

    private static int[][] createPascalTriangle(int N) {
        if (N < 0) throw new IllegalArgumentException("overflow");
        int[][] triangle = new int[N][N];
        return go(triangle, 1, N);
    }

    private static int[][] go(int[][] triangle, int size, int MAX) {
        if (size > MAX) return triangle;
        triangle[size-1][0] = 1;
        triangle[size-1][size-1] = 1;
        for (int i=1; i<size-1; i++)
            triangle[size-1][i] = 
                    triangle[size-2][i-1] + triangle[size-2][i];
        return go(triangle, size+1, MAX);
    }
}
