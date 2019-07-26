
package DATABASE_WORK;
import java.sql.*;
//import java.util.Arrays;


public class dbDemo2 
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
            Connection c;
            Statement st;
            ResultSet rs;
            Class.forName("com.mysql.jdbc.Driver");
            c= DriverManager.getConnection("jdbc:mysql://localhost:3306/karyanadb","surbhit","12345");
            
            st = c.createStatement();
            rs =st.executeQuery("select item_no,item,spu,qih,rol,roq,unit from stock"
                    + " inner join units"
                    + " on stock.unit_no=units.unit_no");
            
            System.out.println("Item no.     Item         MRP Rs.  qih     rol     roq     unit");
            System.out.println("_______________________________________________________________");

            while(rs.next())
            { 
                space(String.valueOf(rs.getInt(1)),10);
               // System.out.print(Spacer.spaces(rs.getString("item"),15));                
space(rs.getString("item"),15);
                space(String.valueOf(rs.getDouble("spu")),7);
                space(String.valueOf(rs.getInt("qih")),7);
                space(String.valueOf(rs.getInt("rol")),7);
                space(String.valueOf(rs.getInt("roq") + " " + rs.getString("unit") ),7);
                //space(rs.getString("unit"),0);
                System.out.println(" ");
            }
             System.out.println("_______________________________________________________________");

        }
        
        
        catch(Exception ex)
        {
            System.out.println("Error "+ex.getMessage());
        }
        
    }
    
}
