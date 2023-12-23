import java.util.ArrayList;

public class Exercise1 {
    public static  void main (String[] args ){


        AccountDao accountDao = new AccountDao();
        Account[] lists = accountDao.getAllAccount();
        for (Account list : lists){
            System.out.println(list.email);
        }


        Department department = new Department();
        Position position = new Position();

        department.id = 1;
        department.departmentName ="Sale";
        position.positionName = "DEV";

        //Question1
        if(department.departmentName ==  null ){
            System.out.println("Nhân viên này chưa có phòng ban");
        }else{
            System.out.println("Phòng ban của nhân viên này là :" + department.departmentName );
        }
        System.out.println(">>>>> Question2");
        int number = 1;
        if(number == 0 ){
            System.out.println("Nhân viên này chưa có group");
        } else if (number == 1 || number == 2) {
            System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");

        } else if (number == 3) {
            System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
        }else {
            System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
        }
        System.out.println(">>>>> Question3");
        String r ;
        r = department.departmentName ==  null ?
                "Nhân viên này chưa có phòng ban" : "Phòng ban của nhân viên này là :" +
                department.departmentName ;
            System.out.println(r);

        System.out.println(">>>>> Question4");
        String e ;
        e = position.positionName.equals("DEV")  ? "Đây là Developer" : "Người này không phải là Developer";
        System.out.println(e);

        System.out.println(">>>>> Question5");

        int numberGr = 2;
        switch (numberGr){
            case 1:
                System.out.println( "Nhóm có một thành viên");
                break;
            case 2:
                System.out.println( "Nhóm có hai thành viên");
                break;
            case 3:
                System.out.println( "Nhóm có ba thành viên");
                break;
            default:
                System.out.println( "Nhóm có nhiều thành viên");
                break;
        }
        System.out.println(">>>>> Question6");
        int number1 = 2;
        switch (number1){
            case 0:
                System.out.println("Nhân viên này chưa có group");
                break;
            case 1:
                System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
                break;
            case 2:
                System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
                break;
            case 3:
                System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
                break;
            default:
                System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
        }
        System.out.println(">>>>> Question7");
            String pos = "DEV";
            switch (pos){
                case "DEV":
                    System.out.println("Đây là Developer");
                    break;
                default:
                    System.out.println("Người này không phải là Developer");
                    break;

            }
        System.out.println(">>>>> Question8");


            for (Account list : lists){
                System.out.println("Email của account là :" +list.email);
                System.out.println("Full name account là :" +list.fullName);

            }
        System.out.println(">>>>> Question9");
        for (Account list : lists){
            System.out.println("Id của account là :" +list.id);
            System.out.println("Name name account là :" +list.userName);

        }
        System.out.println(">>>>> Question10");

            for (Account list : lists){
                for (int i = 0;  i < 2; i++) {
                    System.out.println("Thông tin account thứ "+(i+1)+"là:");
                    System.out.println("Email của account là :" +list.email);
                    System.out.println("Full name account là :" +list.fullName);
                }
            break;
        }

        System.out.println(">>>>> Question11");

        for (Account list : lists){
            for (int i = 0;  i < 2; i++) {
                System.out.println("Thông tin department1 thứ "+(i+1)+"là:");
                System.out.println("Id :" +list.department.id);
                System.out.println(" name:" );
            }
            break;
        }

        System.out.println(">>>>> Question13");

        for (Account list : lists){
            if(list.id != 2){
                System.out.println("Email của account là :" +list.email);
                System.out.println("Full name account là :" +list.fullName);
                System.out.println("Id của account là :" +list.id);
                System.out.println("Name name account là :" +list.userName);
            }

        }

        System.out.println(">>>>> Question14");

        for (Account list : lists){
            if(list.id < 4){
                System.out.println("Email của account là :" +list.email);
                System.out.println("Full name account là :" +list.fullName);
                System.out.println("Id của account là :" +list.id);
                System.out.println("Name name account là :" +list.userName);
            }

        }
        System.out.println(">>>>> Question15");

        for (Account list : lists){
            if(list.id %2 == 0 && list.id <= 20 ){
                System.out.println("Email của account là :" +list.email);
                System.out.println("Full name account là :" +list.fullName);
                System.out.println("Id của account là :" +list.id);
                System.out.println("Name name account là :" +list.userName);
            }

        }



    }

}
