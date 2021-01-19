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
import javax.swing.JOptionPane;

public class Prisoner {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String address;
    private String crimeDetails;
    private String typeOfPrisoner;
    private String categoryOfPrisoner;
    private String Assets;
    private int cellNumber;
    private String admitDate;
    Connection con;
    Statement stmt;
    Prisoner(int i,String fn,String ln,int a,String g,String add,String cd,String type,String cat, String assets,String adm)
    {
        id=i;
        firstName=fn;
        lastName=ln;
        age=a;
        gender=g;
        address=add;
        crimeDetails=cd;
        typeOfPrisoner=type;
        categoryOfPrisoner=cat;
        String Assets=assets;
        admitDate=adm;
    }
    Prisoner()
    {
        firstName="";
        lastName="";
        age=0;
        gender="";
        address="";
        crimeDetails="";
        typeOfPrisoner="";
        categoryOfPrisoner="";
        id=0;
        cellNumber=0;
        admitDate="";
        Assets="";
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
    Prisoner(Prisoner P)
    {
        this.firstName=P.firstName;
        this.lastName=P.lastName;
        this.age=P.age;
        this.gender=P.gender;
        this.address=P.address;
        this.categoryOfPrisoner=P.categoryOfPrisoner;
        this.crimeDetails=P.crimeDetails;
        this.typeOfPrisoner=P.typeOfPrisoner;
        this.id=P.id;
        this.Assets=P.Assets;
        this.cellNumber=P.cellNumber;
    }
    //getters
    public String getFirstName()
    {
        return firstName;
    }
    public int getID()
    {
        return id;
    }
    public String getLastName()
    {
        return lastName;
    }
    public int getAge()
    {
        return age;
    }
    public int getCellNumber()
    {
        return cellNumber;
    }
    public String getAddress()
    {
        return address;
    }
    public String getGender()
    {
        return gender;
    }
    public String getTypeOfPrisoner()
    {
        return typeOfPrisoner;
    }
    public String getCategoryOfPrisoner()
    {
        return categoryOfPrisoner;
    }
    public String getCrimeDetails()
    {
        return crimeDetails;
    }
    public String getPrisonerAssets()
    {
        return Assets;
    }
    //setters
    public void setFirstName(String fn)
    {
        firstName=fn;
    }
    public void setID(int i)
    {
        id=i;
    }
    public void setLastName(String ln)
    {
        lastName=ln;
    }
    public void setAge(int a)
    {
        age=a;
    }
    public void setCellNumber(int c)
    {
        cellNumber=c;
    }
    public void setAddress(String a)
    {
        address=a;
    }
    public void setGender(String g)
    {
        gender=g;
    }
    public void setTypeOfPrisoner(String type)
    {
        typeOfPrisoner=type;
    }
    public void setCategoryOfPrisoner(String cat)
    {
        categoryOfPrisoner=cat;
    }
    public void setCrimeDetails(String c)
    {
        crimeDetails=c;
    }
    public void setPrisonerAssets(String a)
    {
        Assets=a;
    }
    public void setAdmitDate(String d)
    {
        admitDate=d;
    }
    public String getAdmitDate()
    {
        return admitDate;
    }
}
