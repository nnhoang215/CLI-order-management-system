import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

public class Customer extends User {
    private String customerName;
    private String phone;
    private double totalSpending;
    private String memberType;

    protected Customer(String username, String password, Date date){
        super(username, password, date);
        customerName = " ";
        phone = " ";
        totalSpending = 0.0;
        memberType = " ";
    }
    protected Customer(String username, String password){
        super(username, password);
    }

    private Customer(String username,String password, Date date, String customerName, String phone, double totalSpending, String memberType){
        super(username, password, date);;
        this.customerName = customerName;
        this.phone = phone;
        this.totalSpending = totalSpending;
        this.memberType = memberType;
    }

    private Customer(String username,String password, Date date, String customerName, String phone, double totalSpending){
        super(username, password, date);;
        this.customerName = customerName;
        this.phone = phone;
        this.totalSpending = totalSpending;
    }

    private Customer(String username, String password, Date date, String customerName, String phone){
        super(username, password, date);;
        this.customerName = customerName;
        this.phone = phone;
    }

    public String getCustomerName(){
        return customerName;
    }

    public String getPhone(){
        return phone;
    }

    public double getTotalSpending(){
        return totalSpending;
    }

    public String getMemberType(){
        return memberType;
    }

    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public void setTotalSpending(double totalSpending){
        this.customerName = customerName;
    }

    public void setMemberType(){
        String type = "";
        if(this.getTotalSpending() > 5000000){
            type = "Silver";
        } else if (this.getTotalSpending() > 10000000){
            type = "Gold";
        } else if (this.getTotalSpending() > 25000000){
            type = "Platinum";
        }

        this.memberType = type;
    }

    // @Override
    public String toString(){
        return "Name: " + this.customerName + '\n' 
                + "Phone number: " + this.phone + "\n" 
                + "Total Spending: " + this.totalSpending + "\n"
                + "Member type: " + this.memberType + "\n";
    }

    public static Customer getCustomerInfo(){
        Scanner sc = new Scanner(System.in);
        Date date = new Date();

        System.out.print("Enter your username: ");
        String username = sc.nextLine();
        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        System.out.print("Enter your name: ");
        String customerName = sc.nextLine();
        System.out.print("Enter you phone number: ");
        String phone = sc.nextLine();

        return new Customer(username, password, date, customerName, phone);
    }

    public void recordCustomerInfo(){
        String filepath = "Customer.csv";
        try {
            FileWriter fw = new FileWriter(filepath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println(this.getUserName()+","+this.getCustomerName() + "," + this.getPhone() + "," + this.getTotalSpending() + "," + this.getMemberType());
            pw.flush();
            pw.close();

        } catch (Exception E) {
            System.out.println("Exception E");
        }        
    }

    public static Customer getCustomer(){
        Scanner sc = new Scanner(System.in);
        Console c = System.console();

        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        char[] passString = c.readPassword();
        String password = String.valueOf(passString);

        return new Customer(username, password);

    }
    
    

    public void checkInFo(){
        String filepath = "Customer.csv";

        String line = " ";
        try {
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr) ;

            while((line =br.readLine()) != null){
                String [] user_information = line.split(",");
                if(user_information[0].equals(super.getUserName())){
                    System.out.printf("Name: %s \nPhone number: %s \nTotal Spending: %s \nMember Type: %s \n", 
                    user_information[1], user_information[2], user_information[3], user_information[4]);
                }
            }

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException E){
            E.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e1){
            e1.printStackTrace();
        }
    }

   
    public void upDateInfo(){
        Scanner sc = new Scanner(System.in);
        String filepath = "Customer.csv";

        System.out.print("Enter a new name: ");
        String customerName = sc.nextLine();
        System.out.print("Enter a new phone number: ");
        String phone = sc.nextLine();

        String line = " ";
        int i = 0;
        
        try {
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr) ;
            

            while((br.readLine()) != null){
                i++;
            }

            int j = 0;

            String [][] arr = new String[i][5];


            FileReader fr1 = new FileReader(filepath);
            BufferedReader br1 = new BufferedReader(fr1) ;
            
            while( (line=br1.readLine()) != null){
                String [] user_information = line.split(",");
                arr[j++] = user_information;
            }

            for(int k = 0; k < i; k++){
                for(int h = 0; h < 5; h++){
                    if(arr[k][0].equals(super.getUserName())){
                        arr[k][1] = customerName;
                        arr[k][2] = phone;
                    }
                }
            }
            try {
                FileWriter fw = new FileWriter(filepath);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
    
                for(int k = 0; k < i; k++){
                    pw.println(arr[k][0] + "," +arr[k][1] + "," + arr[k][2] + "," + arr[k][3] + "," + arr[k][4]);
                }
    
                pw.flush();
                pw.close();
    
            } catch (Exception E) {
                System.out.println("Exception E");
            }        

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException E){
            E.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e1){
            e1.printStackTrace();
        }
        
    }

    


}
