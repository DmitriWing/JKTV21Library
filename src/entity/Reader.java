package entity;

import java.io.Serializable;


public class Reader implements Serializable{
    private String name;
    private String lastName;
    private String phone;

    public Reader() {
    }

    public Reader(String name, String lastName, String phone) {
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
    }

    public String getlastName() {
        return lastName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Reader{" 
                + "name=" 
                + name 
                + ", lastName=" 
                + lastName + '}';
    }

    
}
