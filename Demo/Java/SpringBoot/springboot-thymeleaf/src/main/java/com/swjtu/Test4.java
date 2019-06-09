package com.swjtu;


public class Test4 {

    public static void main(String[] args) {

    }

    public static void test(String article_data) {
        String[] arr = article_data.split("[^a-zA-Z0-9]+");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("There are " + arr.length + " words in the line!");
    }
}
