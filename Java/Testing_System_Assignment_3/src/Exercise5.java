import java.util.ArrayList;

public class Exercise5 {
    public static void main(String[] args){
        ArrayList<Department> departments = new ArrayList<>();
        Department department = new Department();
        Department department1 = new Department();
        Department department2 = new Department();
        department.id = 1;
        department.name = "Sale";
        department1.id = 2;
        department1.name = "Sale";
        department2.id = 3;
        department2.name ="DEV";
        departments.add(department);
        departments.add(department1);
        departments.add(department2);
        System.out.println("<<< Question1");
        System.out.println("-- phòng ban thứ nhất --");
        for (Department d : departments){
            if(d.id == 1){
                System.out.println(d);
            }
        }
        System.out.println("<<< Question2");
        System.out.println("-- Tất cả phòng ban --");
        for (Department d : departments){

                System.out.println(d);

        }
        System.out.println("<<< Question4");
        System.out.println("--tìm phòng ban 'Phòng A'  --");
        for (Department d : departments){
            if (d.id == 1){
                System.out.println("Có phòng ban 'Phòng A' không:" + d.name.equals("Phòng A"));
            }
        }

        System.out.println("<<< Question5");
        System.out.println("-- So sánh phòng ban thứ nhất và phòng ban thứ 2  --");


        System.out.println("Phòng ban thứ nhất và phòng bàn thứ 2 có bằng nhau không:"
                + department.name.equals(department1.name));



    }
}
