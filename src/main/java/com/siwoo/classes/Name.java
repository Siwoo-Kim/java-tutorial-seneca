package com.siwoo.classes;

import java.util.Arrays;

/**
 * 생성자의 규칙을 알아보자.
 * 
 *  1. Name 클래스를 생성하기 위한 생성자가 총 몇 개 있을까?
 *  2. 컴파일러는 default 생성자를 생성할까?
 *  3. 이 클래스를 초기화하는 방법은?
 *  4. new Name("Siwoo", "Kim") 을 호출하면 어떻게 코드가 수행될지 예측해보자.
 *  
 */
public class Name {
    private String first, middle, last;
    
    public Name(String first, String last) {
        this(first, null, last);
    } 

    public Name(String first, String middle, String last) {
        for (String part: Arrays.asList(first, last))
            if (part == null)
                throw new IllegalArgumentException();
        this.first = first;
        this.middle = middle;
        this.last = last;
    }

}
