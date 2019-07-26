package DATABASE_WORK;
import java.sql.*;
import java.util.Scanner;

public class DbDemo7 
{

    public static void main(String[] args)
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
            
                new_name=rs.getString("name");
                new_phone=rs.getLong("ph_no");
                new_balance=rs.getLong("balance");
                new_street=rs.getString("street");
                new_city=rs.getString("city");
                new_pincode=rs.getLong("pincode");
                new_email_id=rs.getString("email_id");
                int choice;
                
                //name
                System.out.println("Customer Name : " + new_name);
                System.out.println("Do you want to update the name (1 for Yes/ 2 for N0)");
                choice = input.nextInt();
               
                if(choice==1)
                {
                    System.out.println("Enter new name");
                    new_name = input.next();
                }

                //phone_number
                
                System.out.println("Customer phone number : " + new_phone);
                System.out.println("Do you want to update the phone number (1 for Yes/ 2 for N0)");
                choice = input.nextInt();
               
                if(choice==1)
                {
                    System.out.println("Enter new phone");
                    new_phone = input.nextLong();
                }
                
                //balance
                System.out.println("Customer balance : " + new_balance);
                System.out.println("Do you want to update the balance (1 for Yes/ 2 for N0)");
                choice = input.nextInt();
               
                if(choice==1)
                {
                    System.out.println("Enter new balance");
                    new_balance = input.nextLong();
                }
                
                //street
                System.out.println("Customer street : " + new_street);
                System.out.println("Do you want to update the street (1 for Yes/ 2 for N0)");
                choice = input.nextInt();
               
                if(choice==1)
                {
                    System.out.println("Enter new street");
                    new_street = input.nextLine();
                }
                
                
                //city
                System.out.println("Customer city : " + new_city);
                System.out.println("Customer pincode : " + new_pincode);
                System.out.println("Do you want to update the city (1 for Yes/ 2 for N0)");
                choice = input.nextInt();
               
                if(choice==1)
                {
                    System.out.println("Enter new street");
                    new_street = input.nextLine();
                    System.out.println("Enter new pincode");
                    new_pincode = input.nextLong();
                }
                
                
                //email_id
                System.out.println("Customer email_id: " + new_email_id);
                System.out.println("Do you want to update the email_id (1 for Yes/ 2 for N0)");
                choice = input.nextInt();
               
                if(choice==1)
                {
                    System.out.println("Enter new email_id");
                    new_street = input.next();
                }
                
                
                
               //updation
            st.executeUpdate("update customers set name='" + new_name + "', ph_no= "+ new_phone +",balance = "+new_balance+",street = '"+new_street+"',city = '"+new_city+"',pincode = "+new_pincode+",email_id = '"+new_email_id+"'where cust_no = "+cus_no );
                
            System.out.println("Data updated Successfully");
                
            }
            else
            {
                System.out.println("Such custumer number doesnot exist....Plz try again!!!");
            }

        }
        
        
        catch(Exception ex)
        {
            System.out.println("Error "+ex.getMessage());
        }
    }
}
