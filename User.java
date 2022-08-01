import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class User{
    private String username;
    private String password;
    private boolean loginStatus;
    private Date registerDate;


    protected User(){
        username = " ";
        password = " ";
        loginStatus = false;
        registerDate = new Date();
    }

    private User(String username, String password, boolean loginStatus, Date registerDate){
        this.username = username;
        this.password = password;
        this.loginStatus = loginStatus;
        this.registerDate = registerDate;
    }

    protected User(String username, String password, Date registerDate){
        this.username = username;
        this.password = password;
        this.registerDate = registerDate;
    }

    protected User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUserName(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public boolean getLoginStatus(){
        return loginStatus;
    }

    public Date getRegisterDate(){
        return registerDate;
    }

    public void setUserName(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setRegisterDate(Date registerDate){
        registerDate = new Date();

        this.registerDate = registerDate;
    }

    public String toString(){
        return "Username: " + username + "\n" + 
                "Password: " + password + "\n" +
                "Register date: " + registerDate + "\n"; 
    }
    
    public static User getUser(){
        Scanner sc = new Scanner(System.in); 

        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();


        return new User(username, password);
    }


    public void signUp(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Retype your password: ");
        String password2 = sc.nextLine();
        String filepath = "User.csv";
        try {
            FileWriter fw = new FileWriter(filepath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            if(password2.equals(this.getPassword())){
                pw.println(this.getUserName() + "," + this.getPassword() + "," + this.getLoginStatus() + "," + this.getRegisterDate());
            } else {
                System.out.print("Please type again!");
            }
            pw.flush();
            pw.close();

        } catch (Exception E) {
            System.out.println("Exception E");
        }        
    }

    public boolean signIn(){
        String filepath = "User.csv";

        String line = " ";
        try {
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr) ;

            while((line =br.readLine()) != null){
                String [] user_information = line.split(",");
                if(user_information[0].equals(this.getUserName()) && user_information[1].equals(this.getPassword())){
                    return true;
                }
            }

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException E){
            E.printStackTrace();
        }
        return false;
    }
    
    public boolean isAdmin(){
        String filepath = "Admin.csv";

        String line = " ";
        try {
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr) ;

            while((line =br.readLine()) != null){
                String [] user_information = line.split(",");
                if(user_information[0].equals(this.getUserName()) && user_information[1].equals(this.getPassword())){
                    return true;
                }
            }

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException E){
            E.printStackTrace();
        }
        return false;
    }

    public static void changeStatus(){
        
    }

}