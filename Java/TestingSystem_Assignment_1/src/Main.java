

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        AccountDao accountDao = new AccountDao();
        Account[] lists = accountDao.getAllAccount();
        for (Account list : lists){
            System.out.println(list.email);
        }
    }
}