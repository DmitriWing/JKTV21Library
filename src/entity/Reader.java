package entity;


public class Reader {
    private String name;
    private String lastName;

    public Reader() {
    }

    public Reader(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
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

    @Override
    public String toString() {
        return "Reader{" 
                + "name=" 
                + name 
                + ", lastName=" 
                + lastName + '}';
    }
    
    
    
    
}
