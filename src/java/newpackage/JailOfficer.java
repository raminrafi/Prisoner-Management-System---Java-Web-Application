package newpackage;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JailOfficer {
    private String name;
    private int capacity;
    private int age;
    private String gender;
    private String contact;
    private String password;
    private String email;
    Connection con;
    Statement stmt;
     private dbConnectivity db=dbConnectivity.getInstance();
    JailOfficer()
    {
        name="";
        age=40;
        gender="male";
        password="";
        email="";
        contact="";
        capacity=50;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  // load the driver
            String connection = "jdbc:sqlserver://localhost:1433;databaseName=seproject2";
            this.con= (Connection) DriverManager.getConnection(connection,"sa","12345678");
            this.stmt = (Statement) this.con.createStatement(); 
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void SignUp(String n,int a,String g, String cont, String ema, String pass)
    {
        try
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  // load the driver
                con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=seproject2","sa","123456");
                stmt=con.createStatement();
                try
                {
                    int c=50;
                    /*String q="insert into JailOfficer values('"+n+"',"+c+","+a+",'"+g+"','"+cont+"','"+pass+"','"+ema+"')";
                    Statement stmt=con.createStatement();
                    stmt.execute(q);*/
                    String query = " insert into JailOfficer" + " values ( ?, ?,?,?,?,?,?)";
                    PreparedStatement preparedStmt;
                    preparedStmt = con.prepareStatement(query);

                    preparedStmt.setString(1,n); 
                    preparedStmt.setInt(2,50);
                    preparedStmt.setInt(3,a);
                    preparedStmt.setString(4,g);
                    preparedStmt.setString(5,cont);
                    preparedStmt.setString(6,pass);
                    preparedStmt.setString(7,ema);
                    preparedStmt.execute(); 
                    System.out.println("You have successfully signed up!! ");
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
    JailOfficer(String n,int a,String g,String cont, String ema, String pass)
    {
        name=n;
        capacity=50;  
        age=a;
        gender=g;
        contact=cont;
        password=pass;
        email=ema;
    }
    public void RemovePrisoner(String id, String firstname, String lastname)
    {
        try
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  // load the driver
                con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=seproject2","sa","123456");
                stmt=con.createStatement();
                try
                {
                    String query = " delete from Prisoner where prisonerID = ? and firstName = ? and lastName=?";
                    PreparedStatement preparedStmt = con.prepareStatement(query);
                    preparedStmt.setString(1,id);
                    preparedStmt.setString(2,firstname);
                    preparedStmt.setString(3,lastname);
                   if( preparedStmt.executeUpdate()==0  || preparedStmt.executeUpdate()==-1)
                       System.out.println("Failed to remove prisoner. ");                       
                   else
                       System.out.println("Prisoner has been removed successfully! ");
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
    public int AddPrisonerToBeExecuted(String firstname, String lastname,int age, String address, String TypeOfPrisoner, String CategoryOfPrisoner, String CrimeDetails, String gender, String asset,String typeOfExecution, String date,String adm)
    {
        try
            {
                 
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  // load the driver
                con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=seproject2","sa","123456");
                stmt=con.createStatement();
                try
                {
                     
                    String query = " insert into Prisoner" + " values (?,?, ?, ?, ?, ?, ?, ?, ?,?)";
                    PreparedStatement preparedStmt = con.prepareStatement(query);
                    //int i=1;
                   /* System.out.println(i);
                    System.out.println(firstname);
                    System.out.println(lastname);
                    System.out.println(age);
                    System.out.println(address);
                    System.out.println(CrimeDetails);
                    System.out.println(TypeOfPrisoner);
                    System.out.println(CategoryOfPrisoner);
                    System.out.println(asset);
                    
                     preparedStmt.setInt(1,i); 
                    preparedStmt.setString(2,firstname);
                    preparedStmt.setString(3,lastname);
                    preparedStmt.setInt(4,age); 
                    preparedStmt.setString (5, gender);
                    preparedStmt.setString (6,address);
                    preparedStmt.setString (7, CrimeDetails);
                    preparedStmt.setString (8, TypeOfPrisoner);
                    preparedStmt.setString(9,CategoryOfPrisoner);
                    preparedStmt.setString(10,asset);
                    
                    //preparedStmt.setInt(10,cell);
                    preparedStmt.execute(); 
                    */
                   System.out.print("AddPrisonerToBeExecuted ");
                    String q="insert into Prisoner values('"+firstname+"','"+lastname+"',"+age+",'"+gender+"','"+address+"','"+CrimeDetails+"','"+TypeOfPrisoner+"','"+CategoryOfPrisoner+"','"+asset+"','"+adm+"')";
                    db.getStmt().execute(q);
                    
                    System.out.print("AddPrisonerToBeExecuted ");
                    q="select * from Prisoner";
                    ResultSet r=stmt.executeQuery(q);
                    int id=0;
                     System.out.print("AddPrisonerToBeExecuted ");
                    while(r.next())
                    {
                         System.out.print("AddPrisonerToBeExecuted ");
                        id=r.getInt(1);
                    }
                    System.out.print("ID = "+id);
                    q="insert into PrisonerToBeExecuted values("+id+",'"+typeOfExecution+"','"+date+"')";
                    stmt.execute(q);
                    
                    /*String query1 = " insert into PrisonerAssets" + " values (?, ?)";
                    PreparedStatement preparedStmt1 = con.prepareStatement(query1);
                    for(int i=0; i<asset.size();i++)
                    {
                        preparedStmt1.setString(1,id); 
                        preparedStmt1.setString(2,asset.get(i)); 
                        preparedStmt1.execute(); 
                    }*/
                       // execute the preparedstatement
                    System.out.println("Prisoner has been added!");
                    return id;
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
        return 0;
    }
    
    public int AddPrisonerToBeReleased(String firstname, String lastname,int age, String address, String TypeOfPrisoner, String CategoryOfPrisoner, String CrimeDetails, String gender, String asset,String date,String adm)
    {
        try
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  // load the driver
                con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=seproject2","sa","123456");
                stmt=con.createStatement();
                try
                {
                    /*String query = " insert into Prisoner" + " values (?, ?, ?, ?, ?, ?, ?, ?,?,?)";
                    PreparedStatement preparedStmt = con.prepareStatement(query);

                    preparedStmt.setString(2,firstname);
                    preparedStmt.setString(3,lastname);
                    preparedStmt.setInt(4,age); 
                    preparedStmt.setString (5, gender);
                    preparedStmt.setString (6,address);
                    preparedStmt.setString (7, CrimeDetails);
                    preparedStmt.setString (7, TypeOfPrisoner);
                    preparedStmt.setString(8,CategoryOfPrisoner);
                    preparedStmt.setString(9,asset);
                    
                    //preparedStmt.setInt(10,cell);
                    preparedStmt.execute(); */
                    String qq="insert into Prisoner values('"+firstname+"','"+lastname+"',"+age+",'"+gender+"','"+address+"','"+CrimeDetails+"','"+TypeOfPrisoner+"','"+CategoryOfPrisoner+"','"+asset+"','"+adm+"')";
                    db.getStmt().execute(qq);
                    
                    String q="select prisonerID from Prisoner";
                    ResultSet r=stmt.executeQuery(q);
                    int id=0;
                    while(r.next())
                    {
                        id=r.getInt(1);
                    }
                    
                    q="insert into PrisonerToBeReleased values("+id+",'"+date+"')";
                    stmt.execute(q);
                    
                    /*String query1 = " insert into PrisonerAssets" + " values (?, ?)";
                    PreparedStatement preparedStmt1 = con.prepareStatement(query1);
                    for(int i=0; i<asset.size();i++)
                    {
                        preparedStmt1.setString(1,id); 
                        preparedStmt1.setString(2,asset.get(i)); 
                        preparedStmt1.execute(); 
                    }*/
                       // execute the preparedstatement
                    System.out.println("Prisoner has been added!");
                    return id;
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
        return 0;
    }
    /*public void AddPrisonerToBeExecuted(String i,String type,String d)
    {
        try
            {
                con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=project","sa","123456");
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
    public void AddPrisonerToBeReleased(String i,String d)
    {
        try
            {
                con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=project","sa","123456");
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
    public void AddJail(String n, int c, ArrayList <Prisoner> p)
    {
        try
            {
                con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=project","sa","123456");
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
    //getters
    public String getName()
    {
        return name;
    }

    public String getContact()
    {
        return contact;
    }
    public String getEmail()
    {
        return email;
    }
    public String getPassword()
    {
        return password;
    }
    public String getGender()
    {
        return gender;
    }
    public int getAge()
    {
        return age;
    }
    public int getCapacity()
    {
        return capacity;
    }
    //setters
    public void setName(String n)
    {
        name=n;
    }

    public void setEmail(String fn)
    {
        email=fn;
    }
    public void setContact(String i)
    {
        contact=i;
    }
    public void setPassword(String ln)
    {
        password=ln;
    }
     public void setGender(String g)
    {
        gender=g;
    }
    public void setAge(int ln)
    {
        age=ln;
    }
    public void setCapacity(int j)
    {
        capacity=j;
    }
    
}
