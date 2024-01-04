package com.vti.prontend;

import java.util.ArrayList;

public  class Ex4  {



   public static void main(String[] args){

       ArrayList<Studen> list = new ArrayList<>();
       Studen studen = new Studen("hiếu","Đà Nẵng",5);
       Studen studen1 = new Studen("Quân","Hà Nội",9);
       Studen studen2 = new Studen("Quyên","tp HCM",3);
       Studen studen3 = new Studen("Phượng","tp HCM",9);

       list.add(studen);
       list.add(studen1);
       list.add(studen2);
       list.add(studen3);
       studen.setPoint(6);
       System.out.println(studen.getPoint());
       studen.setPoint((float) (studen.getPoint() + 6));
       System.out.println(studen.getPoint());

       for (Studen stu : list){
           if(stu.getPoint() < 4){
               System.out.println(stu.getName());
               System.out.println(stu.getHometow());
               System.out.println(stu.getPoint());
               System.out.println("Học sinh yếu");
           } else if (stu.getPoint() > 4 && stu.getPoint() < 6) {
               System.out.println(stu.getName());
               System.out.println(stu.getHometow());
               System.out.println(stu.getPoint());
               System.out.println("Học sinh trung bình");
           } else if (stu.getPoint() > 6 && stu.getPoint() < 8) {
               System.out.println(stu.getName());
               System.out.println(stu.getHometow());
               System.out.println(stu.getPoint());
               System.out.println("Học sinh khá");
           } else
               System.out.println(stu.getHometow());
           System.out.println(stu.getName());
             System.out.println(stu.getPoint());
             System.out.println("Học sinh giỏi");
       }


   }




}
