import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            displayInterface();
            
            String key = sc.nextLine().toUpperCase();
            if(key.equals("A")){
                displayAmain();

            } else if(key.equals("B")){
                displayBmain();
            } else if(key.equals("C")){
                displayCmain();
                break;
            }
        }
        
    }

    public static void displayInterface(){
        System.out.println("---------------------------------------------");
        System.out.println("COSC2081 GROUP ASSIGNMENT ");
        System.out.println("---------------------------------------------");
        System.out.println("---------------------------------------------");
        System.out.println("STORE ORDER MANAGEMENT SYSTEM");
        System.out.println("---------------------------------------------");
        System.out.println("---------------------------------------------");
        System.out.println("Instructor: Mr. Minh Vu ");
        System.out.println("---------------------------------------------");
        System.out.println("Group: LOL");
        System.out.println("---------------------------------------------");
        System.out.println("---------------------------------------------");
        System.out.println("sXXXXXXX, Student Name ");
        System.out.println("sXXXXXXX, Student Name ");
        System.out.println("sXXXXXXX, Student Name ");
        System.out.println("---------------------------------------------");
        System.out.println("Press key to execute actions:");
        System.out.println("A: Sign in");
        System.out.println("B: Sign Up");
        System.out.println("C: Out");
        System.out.print("Enter the key: ");
        
    }

    public static void displayAmain(){
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------------------------------");
        System.out.println("Please sign in!");
        System.out.println();
        userLogin();
                
                
    }

    public static void displayBmain(){
        System.out.println("---------------------------------------------");
                Customer c = Customer.getCustomerInfo();
                c.signUp();
                c.recordCustomerInfo();
    }

    public static void displayCmain(){
        System.out.println("---------------------------------------------");
        System.out.println("Thank you for joining us <3");
        System.out.println("---------------------------------------------");
    }

    public static void userLogin(){
        Scanner sc = new Scanner(System.in);
        User u1 = User.userLogin();

        if(u1.isAdmin()){
            User a1 = new Admin(u1.getUserName(),u1.getPassword());
            System.out.println("Hello admin");
            System.out.print("\n\n\n");

        } else {
            User c1 = new Customer(u1.getUserName(),u1.getPassword());

            if(c1.signIn()){
                customerMethods(c1.getUserName());
                }
            }

    }

    public static void customerMethods(String username){
        Scanner sc = new Scanner(System.in);
        while(true){
                System.out.println("Press M to check your information.");
                System.out.println("Press N to update your information.");
                System.out.println("Press K to back to the main menu.");
                System.out.print("Enter the key: ");
                String key_customer = sc.nextLine().toUpperCase();
                if(key_customer.equals("M")){
                    System.out.println("---------------------------------------------");
                    System.out.println();
                    System.out.println();
                    Customer.checkInFo(username);
                    System.out.println();
                    System.out.println();
                } else if(key_customer.equals("N")){
                    System.out.println("---------------------------------------------");
                    Customer.upDateInfo(username);
                    System.out.println("Update completed!");
                    System.out.println();
                    System.out.println();
                } else if(key_customer.equals("K")){
                    break;
                }
        }
    }
}
