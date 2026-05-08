package a23_01_clientManager;

import java.util.Objects;

public class Client {

    private String account;
    private String dni;
    private String name;
    private String surname;
    private String phone;
    private float balance;

    public Client(String account, String dni, String phone, String surname, String name, float balance) {
        this.account = account;
        this.dni = dni;
        this.phone = phone;
        this.surname = surname;
        this.name = name;
        this.balance = balance;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }


    @Override
    public String toString() {
        return "Client{" +
                "account='" + account + '\'' +
                ", dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(account, client.account) && Objects.equals(dni, client.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account, dni);
    }
}
