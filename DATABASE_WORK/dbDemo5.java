
package DATABASE_WORK;
import java.sql.*;
import java.util.Scanner;
//import java.util.Arrays;


public class dbDemo5 
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
                System.out.println("Are u sure you wanted to delete the details");
                int choice;
                System.out.println("Press 1. YES");
                System.out.println("Press 2. NO");
                choice = input.nextInt();
                switch(choice)
                {
                    case 1 :
                        st.executeUpdate("delete  customers.*,sale.*"
                                + "from customers"
                                + "inner join sale on customers.cust_no = sale.cust_no"
                                + "where customers.cust_no = '"+cus_no+"'");
                        //st.executeUpdate("delete from sale where cust_no = '"+cus_no+"'");
                        System.out.println("Record Successfully DELETED!!!!!!");
                        break;
                    case 2:
                        System.out.println("Record has not been ALTERED!!!!!!");
                        System.exit(0);
                }
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
