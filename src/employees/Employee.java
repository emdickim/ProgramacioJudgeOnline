package employees;

public class Employee{
    private String name;
    private String surname;

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    private int tel;
    private byte age;
    public Employee (String name, String surname, int tel, byte age) {
        this.name = name;
        this.surname = surname;
        this.tel = tel;
        this.age = age;
    }

    //Getters and setters

    //toString()
}