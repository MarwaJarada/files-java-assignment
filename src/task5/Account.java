package task5;

public class Account {
    String name;
    String password;

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Account(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "name :" + name
                +" password : " + password ;
    }
}
