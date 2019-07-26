
package DATABASE_WORK;
import java.sql.*;
import java.util.Scanner;
//import java.util.Arrays;


public class dbDemo4 
{
    
    public static void main(String arg[])
    {
        
        try
        {
            Connection c;
            Statement st ;
            
            ResultSet rs1,rs2;
            Scanner input = new Scanner(System.in);
            Class.forName("com.mysql.jdbc.Driver");
           
            c= DriverManager.getConnection("jdbc:mysql://localhost:3306/karyanadb","surbhit","12345");
             st= c.createStatement();
            
            String item_name,descrip;
            Double cost_price,selling_price;
            int quantity,re_order_level,re_order_quantity,unit;
            
            
            System.out.println("Enter the name of the item");
            item_name = input.nextLine();
            System.out.println("Enter the description");
            descrip = input.nextLine();
            System.out.println("Enter the cost price of the item");
            cost_price = input.nextDouble();
            System.out.println("Enter the selling price of the item");
            selling_price = input.nextDouble();
            System.out.println("Enter the quantity u ordered");
            quantity = input.nextInt();
            System.out.println("Enter the re-order_level of your item");
            re_order_level = input.nextInt();
            System.out.println("Enter the re-order_quantity of your item");
            re_order_quantity = input.nextInt();
            System.out.println("Enter 1. Kg");
            System.out.println("Enter 2. Gm");
            System.out.println("Enter 3. Ltr");
            System.out.println("Enter 4. Pack");
            unit = input.nextInt();
            
            
            
            st.executeUpdate("INSERT INTO `stock`(`item`, `des`, `cpu`, `spu`, `qih`, `rol`, `roq`, `unit_no`) VALUES ('"+ item_name +"',' "+descrip+"','"+cost_price+"','"+selling_price+"','"+quantity+"','"+re_order_level+"','"+re_order_quantity+"','"+unit+"'juice"
                    + ")");

        }
        
        
        catch(Exception ex)
        {
            System.out.println("Error "+ex.getMessage());
        }
        
    }
    
}
