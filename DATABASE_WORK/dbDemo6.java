
package DATABASE_WORK;
import java.sql.*;
import java.util.Scanner;
//import java.util.Arrays;


public class dbDemo6 
{
    
    public static void main(String arg[])
    {
        
        try
        {
            Connection c;
            Statement st ;
            
            ResultSet rs;
            Scanner input = new Scanner(System.in);
            Class.forName("com.mysql.jdbc.Driver");
           
            c= DriverManager.getConnection("jdbc:mysql://localhost:3306/karyanadb","surbhit","12345");
             st= c.createStatement();
             
             String new_name=null,new_street=null,new_city=null,new_email_id=null;
             Long new_phone=9999999L,new_balance=99999999L,new_pincode=99999999L;
             
            System.out.println("Enter the customer number");
            int cus_no = input.nextInt();
            rs = st.executeQuery("select * from customers where cust_no = '"+cus_no+"'");
            if(rs.next())
            {
                System.out.println("The detail of the person is : ");
                System.out.println("name        = "+rs.getString("name"));
                System.out.println("phone no.   = "+rs.getLong("ph_no"));
                System.out.println("balance     = "+rs.getLong("balance"));
                System.out.println("street      = "+rs.getString("street"));
                System.out.println("city        = "+rs.getString("city"));
                System.out.println("pincode     = "+rs.getLong("pincode"));
                System.out.println("email_id is = "+rs.getString("email_id"));
               // System.out.println("password is = "+rs.getString("password"));
                //System.out.println("Security Question = "+rs.getString("sq"));
               // System.out.println("Answer is = "+rs.getString("ans"));
                
                
                System.out.println();
                System.out.println();
                
                //name
                System.out.println("do you want to update the name");
                int choice;
                System.out.println("Press 1. YES");
                System.out.println("Press 2. NO");
                choice = input.nextInt();
               
                if(choice==1)
                {
                    System.out.println("Enter new name");
                    new_name = input.next();
                    st.executeUpdate("update customers set name = '"+new_name+"'");
                    System.out.println("Name has been SUCCESSFULLY UPDATED!!");
                }
                 else
                {
                    System.out.println("Name has not been altered!");
                    new_name=rs.getString("name");
                }
                //phone_number
                System.out.println("do you want to update the phone number");
                System.out.println("Press 1. YES");
                System.out.println("Press 2. NO");
                choice = input.nextInt();
                if(choice==1)
                {
                     System.out.println("Enter new phone number");
                     new_phone = input.nextLong();
                     st.executeUpdate("update customers set ph_no = '"+new_phone+"'");
                     System.out.println("Phone number has been SUCCESSFULLY UPDATED!!");
                }
                else
                {
                    System.out.println("phone number has not been altered!");
                    new_phone=rs.getLong("ph_no");
                }
                
                //balance
                System.out.println("do you want to update the balance");
                System.out.println("Press 1. YES");
                System.out.println("Press 2. NO");
                choice = input.nextInt();
                if(choice==1)
                {
                     System.out.println("Enter new balance");
                     new_balance = input.nextLong();
                     st.executeUpdate("update customers set balance = '"+new_balance+"'");
                     System.out.println("balance has been SUCCESSFULLY UPDATED!!");
                }
                else
                {
                    System.out.println("balance has not been altered!");
                    new_balance=rs.getLong("balance");
                }
                
                //street
                System.out.println("do you want to update the Street number");
                System.out.println("Press 1. YES");
                System.out.println("Press 2. NO");
                choice = input.nextInt();
                if(choice==1)
                {
                     System.out.println("Enter new street");
                     new_street = input.nextLine();
                     st.executeUpdate("update customers set street = '"+new_street+"'");
                     System.out.println("street has been SUCCESSFULLY UPDATED!!");
                }
                else
                {
                    System.out.println("street has not been altered!");
                    new_street=rs.getString("street");
                }
                
                //city
                System.out.println("do you want to update the city");
                System.out.println("Press 1. YES");
                System.out.println("Press 2. NO");
                choice = input.nextInt();
                if(choice==1)
                {
                     System.out.println("Enter new city");
                     new_city = input.nextLine();
                     st.executeUpdate("update customers set ph_no = '"+new_city+"'");
                     System.out.println("city has been SUCCESSFULLY UPDATED!!");
                     
                     System.out.println("Enter new pincode");
                     new_pincode = input.nextLong();
                     st.executeUpdate("update customers set pincode = '"+new_pincode+"'");
                     System.out.println("pincode has been SUCCESSFULLY UPDATED!!");
                }
                else
                {
                    System.out.println("city has not been altered!");
                    new_city=rs.getString("city");
                }
                
                //email_id
                System.out.println("do you want to update the email_id");
                System.out.println("Press 1. YES");
                System.out.println("Press 2. NO");
                choice = input.nextInt();
                if(choice==1)
                {
                     System.out.println("Enter new email_id");
                     new_email_id = input.nextLine();
                     st.executeUpdate("update customers set email_id = '"+new_email_id+"'");
                     System.out.println("email_id has been SUCCESSFULLY UPDATED!!");
                }
                else
                {
                    System.out.println("email_id has not been altered!");
                    new_email_id=rs.getString("email_id");
                }
            }
            else
            {
                System.out.println("Such custumer number doesnot exist....Plz try again!!!");
            }
             System.out.println("The updated detail of the person is : ");
                System.out.println("name        = "+new_name);
                System.out.println("phone no.   = "+new_phone);
                System.out.println("balance     = "+new_balance);
                System.out.println("street      = "+new_street);
                System.out.println("city        = "+new_city);
                System.out.println("pincode     = "+new_pincode);
                System.out.println("email_id is = "+new_email_id);
        }
        
        
        catch(Exception ex)
        {
            System.out.println("Error "+ex.getMessage());
        }
        
    }
    
}
