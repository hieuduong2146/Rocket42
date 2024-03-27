package prontend;

import entity.User;
import repository.UserRepository;
import util.ScannerUtil;

import java.sql.SQLException;
import java.util.List;

public class UserFunction {
    private UserRepository repository = new UserRepository();
    public void showMenu() throws SQLException {
        while (true) {
            System.out.println("1.Đăng nhập");
            System.out.println("2.Hiển Thị danh sách User");
            System.out.println("3.Tìm kiếm user theo id ");
            System.out.println("4.Thoát chương trình");
            System.out.println("Mời bạn chọn chức năng :");
            int menu = ScannerUtil.inputInt();
            if (menu == 1) {
                findByEmailAndPassword();
            } else if (menu == 2) {
                findAll();
            } else if (menu == 3) {
                findById();
            } else if (menu == 4) {
                return;
            } else {
                System.out.println("Yêu cầu chọn chưc năng .");
                System.out.println("Chọn lại.");
            }
        }
    }
    public void showAdminMenu() throws SQLException {
        while (true) {
            System.out.println("1.Thêm User");
            System.out.println("2.Hiển Thị danh sách User");
            System.out.println("3.Tìm kiếm user theo id ");
            System.out.println("4.Xóa user theo id");
            System.out.println("5.Thoát chương trình");
            System.out.println("Mời bạn chọn chức năng :");
            int menu = ScannerUtil.inputInt();
            if (menu == 1) {
                create();
            } else if (menu == 2) {
                findAll();
            } else if (menu == 3) {
                findById();
            } else if (menu == 4) {
                deleteById();
            } else if (menu == 5) {
                System.out.println("Đăng xuất thành công");
                return;
            } else {
                System.out.println("Yêu cầu chọn chư năng .");
                System.out.println("Chọn lại.");
            }
        }
    }
    public void showEployeeMenu() throws SQLException {
        while (true) {
            System.out.println("1.Đăng xuất");
            System.out.println("2.Hiển Thị danh sách User");
            System.out.println("3.Tìm kiếm user theo id ");
            System.out.println("Mời bạn chọn chức năng :");
            int menu = ScannerUtil.inputInt();
            if (menu == 1) {
                System.out.println("Đăng xuất thành công");
                return;
            } else if (menu == 2) {
                findAll();
            } else if (menu == 3) {
                findById();
            }
             else {
                System.out.println("Yêu cầu chọn chư năng .");
                System.out.println("Chọn lại.");
            }
        }
    }
    public void findAll() throws SQLException {
        List<User> users = repository.findAll();
        System.out.println("+-------+--------------------+--------------------+");
        System.out.println("|  ID  |+    Full NAME       +        EMAIL       +");
        for (User user : users) {
            int id = user.getId();
            String fullName = user.getFullName();
            String email = user.getEmail();
            System.out.printf("| %-4s | %-18s | %-18s |%n", id , fullName , email);
            System.out.println("+-------+--------------------+--------------------+");
        }
    }
    public void findById() throws SQLException {
        System.out.println("Nhập vào thông tin user.");
        System.out.println("NHập vào id");
        int id = ScannerUtil.inputInt();
        User user = repository.findById(id);
        System.out.println("+-------+--------------------+--------------------+");
        System.out.println("|  ID  |+    Full NAME       +        EMAIL       +");
        if(user == null){
            System.out.printf("| %-4s | %-18s | %-18s |%n", "NULL","NULL","NULL");
            System.out.println("+-------+--------------------+--------------------+");
        } else {
            String fullName = user.getFullName();
            String email = user.getEmail();
            System.out.printf("| %-4s | %-18s | %-18s |%n", id , fullName , email);
            System.out.println("+-------+--------------------+--------------------+");
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
                    user.getFullName() , user.getRole());
            if(user.getRole() == User.Role.ADMIN){
                showAdminMenu();
            } else if (user.getRole() == User.Role.EMPLOYEE) {
                showEployeeMenu();
            }
        }
    }
    public void create() throws SQLException {
        System.out.println("Mời bạn nhập vào thông tin user");
        System.out.println("Nhập vào full name");
        String fullname = ScannerUtil.inputFullName();
        System.out.println("Nhập vào email");
        String email = ScannerUtil.inputEmail();
        int result = repository.create(fullname,email);
        System.out.printf("Tạo thành công %d user(s).%n",result);
    }
    public void deleteById() throws SQLException {
        System.out.println("Mời bạn nhập vào thông user");
        System.out.println("Nhập vào id");
        int id = ScannerUtil.inputInt();
        int result = repository.delById(id);
        System.out.printf("Xóa thành công %d user(s).%n",result);
    }
}
