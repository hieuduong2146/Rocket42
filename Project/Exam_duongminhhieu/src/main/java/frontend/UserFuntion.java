package frontend;

import entity.User;
import repository.UserRepository;
import util.ScannerUtil;

import java.sql.SQLException;
import java.util.List;

public class UserFuntion {
    public void login() throws SQLException {
        while (true) {
            System.out.println("1.Đăng nhập");
            System.out.println("Mời bạn chọn 1 để đăng nhập");
            int menu = ScannerUtil.inputInt();
            if (menu == 1) {
                findByEmailAndPassword();
            } else {
                System.out.println("Yêu cầu chọn chưc năng .");
                System.out.println("Chọn lại.");
            }
        }
    }
    public void showMenu() throws SQLException {
        while (true) {
            System.out.println("1.Đăng xuất");
            System.out.println("2.Hiển Thị danh sách Employee theo id");
            System.out.println("3.Hiển Thị danh sách Manager ");
            System.out.println("Mời bạn chọn chức năng :");
            int menu = ScannerUtil.inputInt();
            if (menu == 1) {
                System.out.println("Đăng xuất thành công");
                return;
            }   else if (menu == 2) {
                findByIdEmployee();
            } else if (menu == 3) {
                findAllManager();
            }  else {
                System.out.println("Yêu cầu chọn chưc năng .");
                System.out.println("Chọn lại.");
            }
        }
    }
    private UserRepository repository = new UserRepository();
    public void findByIdEmployee() throws SQLException {
        System.out.println("Nhập vào thông tin user.");
        System.out.println("NHập vào id");
        int id = ScannerUtil.inputInt();
        User user = repository.findByIdEmployee(id);
        System.out.println("+-------+--------------------+--------------------+--------------------+");
        System.out.println("|  ID  |+    Full NAME       +        EMAIL       +       ROLE         +");
        if(user == null){
            System.out.printf("| %-4s | %-18s | %-18s | %-18s |%n", "NULL","NULL","NULL,NULL");
            System.out.println("+-------+--------------------+--------------------+--------------------+");
        } else {
            String fullName = user.getFullname();
            String email = user.getEmail();
            String role = String.valueOf(User.Role.EMPLOYEE);
            System.out.printf("| %-4s | %-18s | %-18s | %-18s |%n", id , fullName , email,role);
            System.out.println("+-------+--------------------+--------------------+--------------------+");
        }

    }



    public void findAllManager() throws SQLException {
        List<User> users = repository.findAllManager();
        System.out.println("+-------+--------------------+--------------------+");
        System.out.println("|  ID  |+    Full NAME       +        EMAIL       +");
        if (users == null) {
            System.out.printf("| %-4s | %-18s | %-18s | %-18s |%n", "NULL","NULL","NULL");
            System.out.println("+-------+--------------------+--------------------+");
        } else {
            for (User user : users) {
                int id = user.getId();
                String fullName = user.getFullname();
                String email = user.getEmail();

                System.out.printf("| %-4s | %-18s | %-18s |%n", id, fullName, email);
                System.out.println("+-------+--------------------+--------------------+");
            }
        }
    }

    public void findByEmailAndPassword() throws SQLException {
        System.out.println("Nhập vào thông tin đăng nhập");
        System.out.println("Nhập vào Email");
        String email = ScannerUtil.inputEmail();
        System.out.println("Nhập vào Password");
        String password = ScannerUtil.inputPassword();
        User user =  repository.findByEmailAndPassword(email,password);
        if(user == null) {
            System.err.println("Đăng nhập thât bại");
        } else {
            System.out.printf("Đăng nhập thành công: %s - %s.%n :" ,
                    user.getFullname() , user.getRole());
           showMenu();
        }
    }



}
