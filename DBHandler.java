import java.sql.*;
public class DBHandler 
{
    boolean addBook(String book_name,String author_name,String book_type,int book_nos,float book_price)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/library?user=root&password=pk1234");
            String query="INSERT INTO `library`.`book` (`book_name`,`author_name`,`book_type`,`book_nos`,`book_price`) VALUES(?,?,?,?,?);";
            PreparedStatement st=cn.prepareStatement(query);
            st.setString(1,book_name);
            st.setString(2,author_name);
            st.setString(3,book_type);
            st.setInt(4,book_nos);
            st.setFloat(5,book_price);
            st.executeUpdate(); 
            cn.close();           
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }

    boolean addCustomer(String customer_name,String mobile)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/library?user=root&password=pk1234");
            String query="INSERT INTO `library`.`customer` (`customer_name`, `customer_mobile`) VALUES (?,?);";
            PreparedStatement st=cn.prepareStatement(query);
            st.setString(1,customer_name);
            st.setString(2,mobile);
            st.executeUpdate(); 
            cn.close();           
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public static void main(String[] args)
    {
        //new DBHandler().searchCustomer(2,"97");                
    }
}