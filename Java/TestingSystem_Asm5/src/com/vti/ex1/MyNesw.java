package com.vti.ex1;

import java.lang.reflect.Array;
import java.util.Scanner;

public class MyNesw {


    public static void main(String[] args) {

        News news = new News();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("===Mynews===");
            System.out.println("1.Insert News");
            System.out.println("2.Views lits news ");
            System.out.println("3.Average rate 3");
            System.out.println("4.Exit");
            int chon = scanner.nextInt();
            scanner.nextLine();
            switch (chon) {
                case 1:
                    System.out.println("Title:");
                    String title = scanner.nextLine();
                    System.out.println("PublishDate:");
                    String publishDate = scanner.nextLine();
                    System.out.println("Author:");
                    String author = scanner.nextLine();
                    System.out.println("Content:");
                    String content = scanner.nextLine();
                    System.out.println("Rates 1");
                    int rate1 = scanner.nextInt();
                    System.out.println("Rates 2");
                    int rate2 = scanner.nextInt();
                    System.out.println("Rates 3");
                    int rate3 = scanner.nextInt();
                    news.rates[0] = rate1;
                    news.rates[1] = rate2;
                    news.rates[2] = rate3;

                    news.setTitle(title);
                    news.setPublishDate(publishDate);
                    news.setAuthor(author);
                    news.setContent(content);


                    break;
                case 2:
                    news.Display();
                    break;

                case 3:
                    news.Calculate();
                    news.Display();
                    break;
                case 4:
                   System.out.println("Cảm ơn đã sử dụng chương trình");
                    break;

                default:
                    System.out.println("---");
            }
        }
    }
}
