package entity;

import lombok.Getter;
import lombok.Setter;

import javax.management.relation.Role;
@Getter
@Setter
public class User {
    private int id;
    private String fullname;
    private String email;
    private String password;
    private Role role;
    private String proskill;
    private int exp_in_year;
    private int project_id;
    public void setRole(String role){
        this.role = Role.valueOf(role);
    }

    public enum Role{
        MANAGER,EMPLOYEE
    }
}
