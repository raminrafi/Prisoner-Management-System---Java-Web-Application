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

public class PrisonerToBeExecuted extends Prisoner {
    private String typeOfExecution;
    private String dateofExecution;
    Connection con;
    Statement stmt;
    PrisonerToBeExecuted()
    {
        typeOfExecution="";
        dateofExecution="";
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
    PrisonerToBeExecuted(int i,String fn,String ln,int a,String g,String add,String cd,String type,String cat, String assets,String typeofE,String date,String adm)
    {
        super(i,fn,ln,a,g,add,cd,type,cat,assets,adm);
        typeOfExecution=typeofE;
        dateofExecution=date;
    }
    public void AddPrisonerToBeExecuted(String i,String type,String d)
    {
        try
            {
                con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=seproject2","sa","123456");
                stmt=con.createStatement();
                try
                {
                    String query = " insert into PrisonerToBeExecuted" + " values (?, ?, ?)";
                    PreparedStatement preparedStmt = con.prepareStatement(query);
                    preparedStmt.setString(1,i);
                    preparedStmt.setString(2,type);
                    preparedStmt.setString(3,d);
                    preparedStmt.execute(); 
                       // execute the preparedstatement
                    System.out.println("Execution Details have been added!");
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
    PrisonerToBeExecuted(String t, String l)
    {
        typeOfExecution=t;
        dateofExecution=l;
    }
    public String getTypeOfExecution()
    {
        return typeOfExecution;
    }
    public String getDateOfExecution()
    {
        return dateofExecution;
    }
     public void setTypeOfExecution(String type)
    {
        typeOfExecution=type;
    }
    public void setDateOfExecution(String date)
    {
        dateofExecution=date;
    }
}
