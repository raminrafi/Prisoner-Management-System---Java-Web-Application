/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

public class Jail {
    private String area;
    private int capacity;
    private ArrayList <Prisoner> prisoners;    
    Connection con;
    Statement stmt;
    Jail()
    {
        area="";
        capacity=0;
        ArrayList <Prisoner> prisoners=new ArrayList<Prisoner>();
        try{

            String connection = "jdbc:sqlserver://localhost:1433;databaseName=seproject";
            this.con= (Connection) DriverManager.getConnection(connection,"sa","12345678");
            this.stmt = (Statement) this.con.createStatement(); 
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    Jail(String j, int c, ArrayList <Prisoner> p)
    {
        area=j;
        capacity=c;
        ArrayList <Prisoner> prisoners=p;
    }
    /*public void AddJail(String n, int c, ArrayList <Prisoner> p)
    {
        try
            {
                con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=project","ramin_rafi","12569");
                stmt=con.createStatement();
                try
                {
                    String query = " insert into Jail" + " values (?, ?)";
                    PreparedStatement preparedStmt = con.prepareStatement(query);
                    preparedStmt.setString(1,n);
                    preparedStmt.setInt(2,c);
                    preparedStmt.execute(); 
                    // execute the preparedstatement
                    System.out.println("Jail Details have been added");
                    for(int i=0;i<p.size();i++)
                    {
                        String query1 = " insert into Cell" + " values (?, ?)";
                        PreparedStatement preparedStmt1 = con.prepareStatement(query1);
                        preparedStmt.setInt(1,p.get(i).getCellNumber());
                        preparedStmt.setString(2,p.get(i).getID());
                        preparedStmt.execute(); 
                    }
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
    }*/
    public String getArea()
    {
        return area;
    }
    public void setArea(String n)
    {
        area=n;
    }
     public int getCapacity()
    {
        return capacity;
    }
    public void setCapacity(int c)
    {
        capacity=c;
    }
    public ArrayList<Prisoner> getPrisoners()
    {
        return prisoners;
    }
}
