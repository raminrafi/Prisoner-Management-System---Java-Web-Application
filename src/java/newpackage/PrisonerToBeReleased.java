package newpackage;


import java.awt.HeadlessException;
import java.time.LocalDate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PrisonerToBeReleased extends Prisoner {
    private String dateofRelease;
    Connection con;
    Statement stmt;
    PrisonerToBeReleased()
    {
        dateofRelease="";
        try{

            String connection = "jdbc:sqlserver://localhost:1433;databaseName=seproject2";
            this.con= (Connection) DriverManager.getConnection(connection,"sa","12345678");
            this.stmt = (Statement) this.con.createStatement(); 
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    PrisonerToBeReleased(int i,String fn,String ln,int a,String g,String add,String cd,String type,String cat, String assets,String date,String adm)
    {
        super(i,fn,ln,a,g,add,cd,type,cat,assets,adm);
        dateofRelease=date;
    }
    public void AddPrisonerToBeReleased(String i,String d)
    {
        try
            {
                con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=seproject2","sa","123456");
                stmt=con.createStatement();
                try
                {
                    String query = " insert into PrisonerToBeReleased" + " values (?, ?)";
                    PreparedStatement preparedStmt = con.prepareStatement(query);
                    preparedStmt.setString(1,i);
                    preparedStmt.setString(2,d);
                    preparedStmt.execute(); 
                       // execute the preparedstatement
                    System.out.println("Release Details have been added!");
                }
                catch(SQLException | HeadlessException E)
                {
                    System.out.println(E);
                }       
            }
        catch(Exception e)
        {
            System.out.println(e);
        }     
    }

    public String getDateOfRelease()
    {
        return dateofRelease;
    }
    public void setDateOfRelease(String date)
    {
        dateofRelease=date;
    }
}
