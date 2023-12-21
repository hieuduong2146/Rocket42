import java.util.Date;

public class Java01 {

    public static void main(String [] args){
        System.out.println("Hello word");

        Account account = new Account();
        account.userName = "test1";
        account.fullName = "Axx Bxx Cxx";
        account.gender = Gender.MALE;
        Department department = new Department();
        account.department = department;
        Group group1 = new Group();
        Group group2 = new Group();
        Group[] groups = {group1,group2};
        account.groups = groups;

        System.out.println("User Name:" + account.userName);
        System.out.println("Full Name:" + account.fullName);
        System.out.println("Gender :" + account.gender);
        Student student = new Student();
        student.isGraduated = false;
        System.out.println("Graduates :" + student.isGraduated);

        account.createdDate = new Date();
        System.out.println("Creacted Date :" + account.createdDate);



    }

}
