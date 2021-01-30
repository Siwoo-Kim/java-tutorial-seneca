package com.siwoo.types;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Q1 ~ Q4 까지 시간 복잡도를 추측해보자.
 * 
 */
public class TimeComplexity {

    public static void main(String[] args) {
        Student red = new Student("red", 5);
        Student blue = new Student("blue", 7);
        Student green = new Student("green", 3);
        Student yellow = new Student("yellow", 2);
        red.add(blue);
        red.add(red);
        blue.add(yellow);
        yellow.add(blue);

        Student[] students = new Student[]{red, blue, green, yellow};
        Q2 q2 = new Q2(students);
        System.out.println(Arrays.toString(q2.ask()));
        Q3 q3 = new Q3(students);
        System.out.println(Arrays.toString(q3.ask()));
        Q4 q4 = new Q4(students);
        System.out.println(q4.ask());
    }
    
    private static class Q1 {
        private Student[] students;
        
        public Q1(Student[] students) {
            this.students = students;
        }

        public Student ask() {
            return students[0];
        }
    }
    
    private static class Q2 {
        private Student[] students;

        public Q2(Student[] students) {
            this.students = students;
        }

        public Student[] ask() {
            int N = students.length;
            Student[] tmp = new Student[N];
            for (int i=N-1; i>=0; i--)
                tmp[i] = students[i];
            return tmp;
        }
    }
    
    private static class Q3 {
        private Student[] students;

        public Q3(Student[] students) {
            this.students = students;
        }

        public Student[] ask() {
            Stack<Student> friendMyself = new Stack<>();
            for (Student s1: students)
                for (Student s2: s1.friends)
                    if (s1 == s2)
                        friendMyself.push(s2);
            return friendMyself.toArray(new Student[0]);
        }
    }
    
    private static class Q4 {
        private Student[] students;
        private int N, MAX = -1;
        
        public Q4(Student[] students) {
            this.students = students;
            this.N = students.length;
        }

        public int ask() {
            Stack<Student> students = new Stack<>();
            return select(0, this.students, new Stack<>());
        }

        private int select(int index, Student[] students, Stack<Student> picked) {
            if (index == N/2) {
                int total = 0;
                for (Student s: picked)
                    total += s.score;
                return total;
            }
            if (index == N) return -1;
            picked.push(students[index]);
            int answer = select(index + 1, students, picked);
            picked.pop();
            answer = Math.max(select(index + 1, students, picked), answer);
            return answer;
        }
    }
    
    private static class Student {
        private final String name;
        private final int score;
        private final List<Student> friends = new ArrayList<>();
        
        private Student(String name, int score) {
            this.name = name;
            this.score = score;
        }
        
        public void add(Student friend) {
            friends.add(friend);
        }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(name);
            sb.append(": ");
            for (Student f: friends)
                sb.append(f.name).append(" ");
            return sb.toString();
        }
    }
}
