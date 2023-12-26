public class Department {
long id;
    String departmentName ;
    @Override
    public boolean equals(Object o ){
        if (this == o) return  true;
        Department department = (Department) o;
         if(departmentName.equals(department.departmentName))return true;

        return false;
    }
    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + departmentName.hashCode();
        return result;
    }
}
