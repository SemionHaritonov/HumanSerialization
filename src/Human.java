import java.io.*;

public class Human implements Serializable{
    private static final long serialVersionUID = 1L;
    private String name;
    private String passportNumber;

    public Human(String name, String passportNumber) {
        this.name = name;
        this.passportNumber = passportNumber;
    }

    public String getName() {
        return name;
    }

    public String getPassportNumber() {
        return passportNumber;
    }




}
