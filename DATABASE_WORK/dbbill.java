
package DATABASE_WORK;
import java.sql.*;
import java.util.Scanner;
//import java.util.Arrays;


public class dbbill 
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
            Statement st ;
            
            ResultSet rs;
            Scanner input = new Scanner(System.in);
            Class.forName("com.mysql.jdbc.Driver");
           
            c= DriverManager.getConnection("jdbc:mysql://localhost:3306/karyanadb","surbhit","12345");
             st= c.createStatement();
             
             //String new_name=null,new_street=null,new_city=null,new_email_id=null;
             //Long new_phone=9999999L,new_balance=99999999L,new_pincode=99999999L;
             
            System.out.println("Enter the bill number");
            int bil_no = input.nextInt();
            rs = st.executeQuery("SELECT sale.bill_no,b_date,sale.cust_no,customers.name,customers.city,sale_detail.item_no,sale_detail.qty,stock.spu,units.unit,item\n" +
                    "from sale,sale_detail,customers,stock,units\n" +
                    "where sale.bill_no=sale_detail.bill_no AND\n" +
                    "sale.cust_no=customers.cust_no AND\n" +
                    "sale_detail.item_no=stock.item_no AND\n" +
                    "stock.unit_no=units.unit_no AND\n" +
                    "sale.bill_no='"+bil_no+"'");
            if(rs.next())
            {
                System.out.println("───────────────────────────────────────────");
                System.out.println("                        WALLMART Departmental store       ");
                System.out.println("                                    BILL                ");
                System.out.println("Customer number : "+rs.getInt("cust_no")+"                                 Date :"+rs.getDate("b_date"));
                System.out.println("Customer name   : "+rs.getString("name")   +"("+rs.getString("city")+")");
                System.out.println("───────────────────────────────────────────");
                System.out.print("S.No.    Particular         Qty      M.R.P  Amount\n");
                System.out.println("───────────────────────────────────────────");
                
                int s_no=1;
                int total=0;
                do
                {
                    space(String.valueOf(s_no),10);
                    space(rs.getString("item"),15);
                    space(String.valueOf(rs.getInt("qty")),1);
                    space(rs.getString("unit"),7);
                    space(String.valueOf(rs.getInt("spu")),7);
                    int amount=0;
                    amount=rs.getInt("qty")*rs.getInt("spu");
                    space(String.valueOf(amount),7);
                    total=total+amount;
                    s_no++;
                    System.out.println("");
                }while(rs.next());
                 System.out.println("───────────────────────────────────────────");
               System.out.println("                                     Total : "+total);
                 System.out.println("───────────────────────────────────────────");
               
                System.out.println();
                System.out.println("                           Thank you VISIT US AGAIN!!!!!!!   ");
                
                System.out.println();
            }
        }
        
        
        catch(Exception ex)
        {
            System.out.println("Error "+ex.getMessage());
        }
        
    }
}
    

