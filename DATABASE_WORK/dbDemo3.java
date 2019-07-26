
package DATABASE_WORK;
import java.sql.*;
import java.util.Scanner;
//import java.util.Arrays;


public class dbDemo3 
{
    public static void space(String st,int size)
    {
        String str="";
            for(int i=size;i>=st.length();i--)
                {
                    str = str+" ";
                }
            System.out.print(st+str);
    }
    public static void main(String arg[])
    {
        try
        {
            int flag=0;
            Connection c;
            Statement st;
            ResultSet rs1,rs2;
            Class.forName("com.mysql.jdbc.Driver");
            c= DriverManager.getConnection("jdbc:mysql://localhost:3306/karyanadb","surbhit","12345");
            
            System.out.println("Enter your email_id");
            Scanner input = new Scanner(System.in);
            String email=input.next();
            System.out.println("Enter your password");
            String pass = input.next();
            st = c.createStatement();
            rs1 =st.executeQuery("select email_id , password,name from customers where email_id = '" + email +"'and password ='" +pass+"'");
                if(rs1.next())
                {
                    System.out.println("Welcome "+rs1.getString("name")+" to this application");
                }
                else
                {
                    System.out.println("Access denied");
                    int a ;
                    System.out.println("Enter your choice : ");
                    System.out.println("1. Forget Password.");
                    System.out.println("2. Exit");
                    a = input.nextInt();
                    switch(a)
                            {
                        case 1 :
                            System.out.println("Enter your email_id");
                            String emp_id;
                            emp_id= input.next();
                            rs2 =st.executeQuery("select * from customers where email_id='"+emp_id+"'");
                            if(rs2.next())
                            {
                                System.out.println("Answer your security question : "+rs2.getString("sq"));
                                String ans=input.next();
                                if(rs2.getString("ans").equals(ans))
                                {
                                    String str4;
                                    System.out.println("Enter a new password");
                                    str4 = input.next();
                                    System.out.println("Enter the password again");
                                    String str5 = input.next();
                                    if(str4.equals(str5))
                                    {
                                        st.executeUpdate("update customers set password = '"+str4+"' where email_id='"+emp_id+"'");
                                        System.out.println("The password is updated");
                                    }
                                    else
                                    {
                                        System.out.println("Both the passwords must be same");
                                    }
                                }
                                else
                                {
                                    System.out.println("Enter the valid ans");
                                }
                               
                            }
                            break;
                        case 2 :
                            System.exit(0);
                            break;
                            }
                }

        }
        
        
        catch(Exception ex)
        {
            System.out.println("Error "+ex.getMessage());
        }
        
    }
    
}
