
package DATABASE_WORK;
import java.sql.*;
//import java.util.Arrays;


public class dbDemo1 
{
    public static void space(String st)
    {
        String str="";
            for(int i=12;i>=st.length();i--)
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
            rs =st.executeQuery("select * from stock");
            System.out.println("Item no.     Item         MRP Rs.      qih ");
            System.out.println("-------------------------------------------");

            while(rs.next())
            { 
                space(String.valueOf(rs.getInt(1)));
                space(rs.getString(2));
                space(String.valueOf(rs.getDouble("spu")));
                space(String.valueOf(rs.getInt("qih")));
                System.out.println(" ");
            }
            System.out.println("___________________________________________");
        }
        
        
        catch(Exception ex)
        {
            System.out.println("Error "+ex.getMessage());
        }
        
    }
    
}
