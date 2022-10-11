package entity;


public class Author {
    private String name;
    private String lastName;

    public Author() {       // this is constructor. rbm -> insert code... -> constructor... must be in all classes
    }

    public Author(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
//  -------------------------------- // rbm -> insert code... getters and setters, choose all, choose incapsulate
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
//  --------------------------------

    @Override   // // rbm -> insert code... -> toString...
    public String toString() {
        return "Author{" 
                + "name=" 
                + name 
                + ", lastName=" 
                + lastName 
                + '}';
        
    }
    
}
