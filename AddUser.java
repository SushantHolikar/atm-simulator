
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

    public class AddUser {

        public static boolean Viewer(User user){
            Scanner sc=new Scanner(System.in);
    boolean a=true;
    int min=10000,max=99999;
    Header.head();
            System.out.println("        path : management transaction --> add user ");
    System.out.println("ENTER USER ID");
    int ID=sc.nextInt();

    System.out.println("ENTER USER NAME");
    String name=sc.next();

    System.out.println("ENTER USER PIN");
    int PIN=sc.nextInt();

    int ab=0;

    System.out.println("ENTER CITY");
    String city=sc.next();
    
    
    System.out.println("Enter Mail");
    String Mail=sc.next();

    int card = (int)(Math.random()*(max-min+1)+min);  
    //generate a random number


            Header.head();
            System.out.println("        path : management transaction --> add user --> processing ");
            System.out.println("PROCESSING...PLESASE WAIT PATIENTLY...");

    boolean ans=AddUser.InsertStudentToDB(ID , name, PIN, ab,city,card,Mail);
if(!ans)
{
    Header.head();
    System.out.println("        path : management transaction --> add user --> failure ");
    System.out.println("FAILED TO ADD A NEW USER");
}

    return a;


        }
        public static boolean InsertStudentToDB(int ID ,String Name, int PIN, int acc_bal,String CITY,int cardNumber, String Mail) {
            boolean f=false;
            try {
               Class.forName("com.mysql.cj.jdbc.Driver");
             String user="root";
               String password="a1b2c3d4.";
               String url="jdbc:mysql://localhost:3306/grp_project";
               Connection con = DriverManager.getConnection(url,user,password);
                Connection con=JDBC.CreateC();
                String q="insert into cards(ID,Name,PIN,acc_bal,city,cardNumber,Mail) values(?,?,?,?,?,?,?)";
                PreparedStatement pstmt=con.prepareStatement(q);
                pstmt.setInt(1,ID);
                pstmt.setString(2,Name);
                pstmt.setInt(3,PIN);
                pstmt.setInt(4,acc_bal);
                pstmt.setString(5,CITY);
                pstmt.setInt(6,cardNumber);
                pstmt.setString(7, Mail);

                pstmt.executeUpdate();
                Header.head();
                System.out.println("        path : management transaction --> add user --> successful");
                System.out.println("NEW USER ADDED SUCCESSFULLY!!");
                System.out.println("\nPLEASE NOTE : \nTHE ACCOUNT BALANCE OF THE NEW ADDED USER IS ₹0 AND THE CARD NUMBER IS AUTOMATICALLY GENERATED\n\nTHE NEW USER'S CARD NUMBER IS : " +cardNumber);
                f=true;
                return f;

            }
            catch(Exception e) {
                e.printStackTrace();

            }
            return false;

        }
    }