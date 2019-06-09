package com.swjtu;


import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = null;

        System.out.print("请输入英语句子：");
        text = scan.nextLine();

        System.out.println(getWords(text));
    }

    public static int getWords(String text) {
        int count = 0;
        int len = text.length();
        int i, j;

        i = 0;
        while (true) {
            for (; i < len && text.charAt(i) == ' '; i++) ;
            if (i >= len) {
                break;
            }
            count++;
            for (; i < len && text.charAt(i) != ' '; i++) ;
        }
        return count;
    }
}