import java.io.Console;
import java.util.Date;
import java.util.Scanner;

public class Admin extends User{
    private String adminName;
    private String email;

    public Admin(){
        adminName = " ";
        email = " ";
    }

    protected Admin(String username, String password, Date date){
        super(username, password, date);
        this.adminName = " ";
        this.email = " ";
    }

    private Admin(String username, String password){
        super(username, password);
    }

    private Admin(String username, String password, String adminName, String email){
        super(username, password);
        this.adminName = adminName;
        this.email = email;
    }

    public String getAdminName(){
        return adminName;
    }

    public String getEmail(){
        return email;
    }

    public void setAdminName(String adminName){
        this.adminName = adminName;
    }

    public void setEmail(String email){
        this.email = email;  
    }

    public String toString(){
        return "Admin name: " + adminName + ", Email: " + email;
    }

    public static Admin getAdmin(){
        Scanner sc = new Scanner(System.in);
        Console c1 = System.console();

        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        char[] passString = c1.readPassword();
        String password = String.valueOf(passString);

        return new Admin(username, password);
    }

    
}

