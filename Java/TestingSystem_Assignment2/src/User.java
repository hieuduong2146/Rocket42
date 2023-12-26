import java.util.Comparator;

public class User implements Comparable<User> {

    long id;
    String userName;

    @Override
    public String toString() {
        return "id: " + id + " userName: " + userName;
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        return userName.equals(user.userName);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + userName.hashCode();
        return result;
    }*/

    /*@Override
    public int compare(User o1, User o2) {
        return o1.userName.compareTo(o2.userName);
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        return userName != null && userName.equals(user.userName);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + userName.hashCode();
        return result;
    }

    @Override
    public int compareTo(User o) {
        return userName.compareTo(o.userName);
    }
}
