package com.vti.ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class DemoStuden {

static List<Studen> list ;
    public static void main(String[] args) {
        Studen studen = new Studen();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("===Studen===");
            System.out.println("1.Thêm Học sinh");
            System.out.println("2.Điểm danh ");
            System.out.println("3.Gọi đi học bài(Group-1)");
            System.out.println("4.Gọi đi dọn vệ sinh(Group-2)");
            System.out.println("5.Exit");
            int chon = scanner.nextInt();
            scanner.nextLine();
            switch (chon) {
                case 1:
                    studen.addHocsinh();
                break;
                case 2:
                    studen.diemdanh();
                    break;
                case 3:
                    studen.hocbai();
                    break;
                case 4:
                    studen.didonvesinh();
                    break;
                case 5:
                    System.out.println("Cảm ơn đã sử dụng chương trình");
                    break;
                default:
                    System.out.println("Baạn đã nhập sai !! vui Lòng nhập lại");
            }
        }
    }
}
