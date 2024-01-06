package com.vti.ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Studen implements IStuden{
    private long id;
    private String name;
    private int group;
    private List<Studen> list = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
   private  Random ran = new Random();

    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public Studen(String name, int group) {
        this.name = name;
        this.group = group;
    }

    public Studen() {

    }

    @Override
    public void addHocsinh() {
        for (int i = 1 ; i <= 10; i++) {
            System.out.println("Nhập học sinh thứ :" + i);
            String name = scanner.nextLine();
            Studen st = new Studen( name,ran.nextInt(2)+1);
            list.add(st);

        }


    }

    @Override
    public void diemdanh() {
        for (Studen stu : list){
            System.out.println(stu.getName() +" " +"Điểm danh");
        }
    }

    @Override
    public void hocbai() {
        for(Studen stu : list){
            if(stu.group == 1){
                System.out.println(stu.getName() +" " +"Đi học bài");
            }
        }


    }

    @Override
    public void didonvesinh() {
        for(Studen stu : list){
            if(stu.group == 2){
                System.out.println(stu.getName() +" " +"Đi dọn vệ sinh");
            }
        }

    }
}
