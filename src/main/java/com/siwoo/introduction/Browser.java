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
        webPages.push(page);
    }

    /**
     * the current page of the browser.
     * if visited page is empty return empty string.
     * 
     * @return
     */
    public String currentPage() {
        if(webPages.isEmpty()){
            return "";
        }
        return webPages.peek();
    }

    /**
     * return the previous visited page.
     */
    public void back() {
        webPages.pop();
    }

    public static void main(String[] args) {
        Browser browser = new Browser();
        browser.visit("www.naver.com");
        browser.visit("google.com");
        browser.visit("yahoo.com");
        System.out.println(browser.currentPage());  //yahoo
        browser.back(); //google
        browser.back(); //naver
        System.out.println(browser.currentPage()); //naver
        browser.visit("senecacollege.ca");
        System.out.println(browser.currentPage()); //seneca

        while (!"".equals(browser.currentPage())) {
            System.out.println(browser.currentPage()); //seneca
            browser.back(); //naver
        }
    }
}
