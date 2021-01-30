package com.siwoo.introduction;

import java.util.Stack;

public class Browser {
    private final Stack<String> webPages = new Stack<>();

    /**
     * visit the given page.
     * 
     * @param page
     * @throws IllegalArgumentException if the page is empty
     */
    public void visit(String page) {
        
    }

    /**
     * the current page of the browser.
     * if visited page is empty return empty string.
     * 
     * @return
     */
    public String currentPage() {
        return null;
    }

    /**
     * return the previous visited page.
     */
    public void back() {
     
    }

    public static void main(String[] args) {
        Browser browser = new Browser();
        browser.visit("www.naver.com");
        browser.visit("google.com");
        browser.visit("yahoo.com");
        System.out.println(browser.currentPage());
        browser.back();
        browser.back();
        System.out.println(browser.currentPage());
        browser.visit("senecacollege.ca");
        System.out.println(browser.currentPage());
        while (!"".equals(browser.currentPage())) {
            System.out.println(browser.currentPage());
            browser.back();
        }
    }
}
