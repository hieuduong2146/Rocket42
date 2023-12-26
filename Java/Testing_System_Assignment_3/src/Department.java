import java.util.Objects;

public class Department {
    long id;
    String name;


    @Override
    public String toString(){
        return "id phòng ban :" + id  +"\n"+ "Tên phòng ban : "+ name ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Department))
            return false;
        Department that = (Department) o;
        return  Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
