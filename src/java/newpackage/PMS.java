package newpackage;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PMS {
    private ArrayList <JailOfficer> listOfJailOfficers=new ArrayList<>();
    private ArrayList <Prisoner> listOfPrisoners=new ArrayList<>();
    private ArrayList<PrisonerToBeExecuted> listOfPE=new ArrayList<>();
    private ArrayList<PrisonerToBeReleased> listOfPR=new ArrayList<>();
    private ArrayList <Jail> listOfJails;
    private JailOfficer currentUser;
    private dbConnectivity db=dbConnectivity.getInstance();
    Connection con;
    Statement stmt;
    private static PMS pms_instance = null;
	
	public static PMS getInstance()
	{
		
		if(pms_instance==null)
		{
			pms_instance=new PMS();
		}
		
		return pms_instance;
		
	}
    
    private PMS()
    {
        System.out.println("_____________IN PMS__________________");
        // Loading Data from Database
        try
        {
            String q="select * from JailOfficer";
            ResultSet r=db.getStmt().executeQuery(q);
            while(r.next())
            {
                String n=r.getString(1);
                int c=r.getInt(2);
                int age=r.getInt(3);
                String gender=r.getString(4);
                String contact=r.getString(5);
                String pass=r.getString(6);
                String email=r.getString(7);
                JailOfficer j=new JailOfficer(n,age,gender,contact,email,pass);
                j.setCapacity(c);
                listOfJailOfficers.add(j);
            }
            System.out.println("______Jail Officer_______");
             for(int i=0;i<listOfJailOfficers.size();i++)
             {
                 System.out.println(listOfJailOfficers.get(i).getName());
             }
            String qq="select * from PrisonerToBeExecuted";
            ResultSet r1=db.getStmt().executeQuery(qq);
            ArrayList<PrisonerToBeExecuted> PE=new ArrayList<>();
            ArrayList<Integer> ids=new ArrayList<>();
            while(r1.next())
            {
                int id=r1.getInt(1);
                System.out.println("ID= "+id);
                String Type=r1.getString(2);
                System.out.println("Type: "+Type);
                String d=r1.getString(3);
                System.out.println("Date: "+d);
                PrisonerToBeExecuted p=new PrisonerToBeExecuted();
                p.setTypeOfExecution(Type);
                p.setDateOfExecution(d);
                PE.add(p);
                
                ids.add(id);
            }
             System.out.println("______Prisoner to be executed_______");
             for(int i=0;i<PE.size();i++)
             {
                 System.out.println(PE.get(i).getTypeOfExecution());
             }
            String qqq="select * from PrisonerToBeReleased";
            ResultSet r2=db.getStmt().executeQuery(qqq);
            ArrayList<PrisonerToBeReleased> PR=new ArrayList<>();
            ArrayList<Integer> ids2=new ArrayList<>();
            while(r2.next())
            {
                int id=r2.getInt(1);
                String d=r2.getString(2);
                PrisonerToBeReleased p=new PrisonerToBeReleased();
                p.setDateOfRelease(d);
                PR.add(p);
                
                ids2.add(id);
            }

            String s="select * from Prisoner";
            ResultSet rs=db.getStmt().executeQuery(s);
            ArrayList<Prisoner> p=new ArrayList<>();
            while(rs.next())
            {
                int ii=rs.getInt(1);
                String f=rs.getString(2);
                String l=rs.getString(3);
                int a=rs.getInt(4);
                String g=rs.getString(5);
                String add=rs.getString(6);
                String cd=rs.getString(7);
                String ty=rs.getString(8);
                String cat=rs.getString(9);
                String ass=rs.getString(10);
                String adm=rs.getString(11);
                Prisoner np=new Prisoner(ii,f,l,a,g,add,cd,ty,cat,ass,adm);
                p.add(np);
            }
            for(int i=0;i<p.size();i++)
            {
                for(int j=0;j<ids.size();j++)
                {
                     if(p.get(i).getID()==ids.get(j))
                     {
                         PrisonerToBeExecuted pe=new PrisonerToBeExecuted(p.get(i).getID(),p.get(i).getFirstName(),p.get(i).getLastName(),p.get(i).getAge(),p.get(i).getGender(),p.get(i).getAddress(),p.get(i).getCrimeDetails(),p.get(i).getTypeOfPrisoner(),p.get(i).getCategoryOfPrisoner(),p.get(i).getPrisonerAssets(),PE.get(j).getTypeOfExecution(),PE.get(j).getDateOfExecution(),p.get(i).getAdmitDate());
                         listOfPrisoners.add(pe);
                         listOfPE.add(pe);
                     }
                }
            }
            for(int i=0;i<p.size();i++)
            {
                for(int j=0;j<ids2.size();j++)
                {
                     if(p.get(i).getID()==ids2.get(j))
                     {
                         PrisonerToBeReleased pr=new PrisonerToBeReleased(p.get(i).getID(),p.get(i).getFirstName(),p.get(i).getLastName(),p.get(i).getAge(),p.get(i).getGender(),p.get(i).getAddress(),p.get(i).getCrimeDetails(),p.get(i).getTypeOfPrisoner(),p.get(i).getCategoryOfPrisoner(),p.get(i).getPrisonerAssets(),PR.get(j).getDateOfRelease(),p.get(i).getAdmitDate());
                         listOfPrisoners.add(pr);
                         listOfPR.add(pr);
                     }
                }
            }
            //printing prisoners
            System.out.println("PRINTING PRISONERS");
            for(int i=0;i<listOfPrisoners.size();i++)
            {
                System.out.println(listOfPrisoners.get(i).getFirstName());
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  // load the driver
            String connection = "jdbc:sqlserver://localhost:1433;databaseName=seproject2";
            this.con= (Connection) DriverManager.getConnection(connection,"sa","12345678");
            this.stmt = (Statement) this.con.createStatement(); 
            System.out.println("Connection Succesful");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    PMS(ArrayList <JailOfficer> jo, ArrayList <Prisoner> p, ArrayList <Jail> j)
    {
        listOfPrisoners=p;
        listOfJailOfficers=jo;
        listOfJails=j;
    }
    void loadData()
    {
        try
        {
            String q="select * from JailOfficer";
            ResultSet r=db.getStmt().executeQuery(q);
            while(r.next())
            {
                String n=r.getString(1);
                int c=r.getInt(2);
                int age=r.getInt(3);
                String gender=r.getString(4);
                String contact=r.getString(5);
                String pass=r.getString(6);
                String email=r.getString(7);
                JailOfficer j=new JailOfficer(n,age,gender,contact,email,pass);
                j.setCapacity(c);
                listOfJailOfficers.add(j);
            }

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    boolean login(String email,String pass)
    {
        if(listOfJailOfficers!=null)
        {
            for(int i=0;i<listOfJailOfficers.size();i++)
            {
                if(listOfJailOfficers.get(i).getEmail().equals(email) && listOfJailOfficers.get(i).getPassword().equals(pass))
                {
                //return listOfJailOfficers.get(i);
                    currentUser=listOfJailOfficers.get(i);
                    return true;
                }
            }
        }
        
        return false;
    }
    boolean validUser(String email)
    {
        if(listOfJailOfficers!=null)
        {
            for(int i=0;i<listOfJailOfficers.size();i++)
            {
                if(listOfJailOfficers.get(i).getEmail().equals(email))
                {
                    return false;
                }
            }
        }
        return true;
    }
    public void signup(String n,int a,String g,String cont, String ema, String pass)
    {
        JailOfficer j=new JailOfficer(n,a,g,cont,ema,pass);       
        addJailOfficer(j);
        j.SignUp(n, a, g, cont, ema, pass);
        //currentUser=j;
    }
    public void addJailOfficer(JailOfficer j)
    {
        listOfJailOfficers.add(j);
    }
    public void addPrisonerE(String firstname, String lastname,int age, String address, String TypeOfPrisoner, String CategoryOfPrisoner, String CrimeDetails, String gender, String asset,String typeOfExecution, String date,String adm)
    {
        System.out.println("Current User= "+currentUser.getEmail());
        int id=currentUser.AddPrisonerToBeExecuted(firstname, lastname, age, address, TypeOfPrisoner, CategoryOfPrisoner, CrimeDetails, gender, asset, typeOfExecution, date,adm);
        System.out.print("HELLLOOOO   "+id);
        Prisoner p=new PrisonerToBeExecuted(id,firstname,lastname,age,gender,address,CrimeDetails,TypeOfPrisoner,CategoryOfPrisoner,asset,typeOfExecution,date,adm);
        listOfPrisoners.add(p);
        PrisonerToBeExecuted pe=new PrisonerToBeExecuted(id,firstname,lastname,age,gender,address,CrimeDetails,TypeOfPrisoner,CategoryOfPrisoner,asset,typeOfExecution,date,adm);
        listOfPE.add(pe);
    }
    public void addPrisonerR(String firstname, String lastname,int age, String address, String TypeOfPrisoner, String CategoryOfPrisoner, String CrimeDetails, String gender, String asset,String date,String adm)
    {
        int id=currentUser.AddPrisonerToBeReleased(firstname, lastname, age, address, TypeOfPrisoner, CategoryOfPrisoner, CrimeDetails, gender, asset, date,adm);
        
        Prisoner p=new PrisonerToBeReleased(id,firstname,lastname,age,gender,address,CrimeDetails,TypeOfPrisoner,CategoryOfPrisoner,asset,date,adm);
        listOfPrisoners.add(p);
        PrisonerToBeReleased pr=new PrisonerToBeReleased(id,firstname,lastname,age,gender,address,CrimeDetails,TypeOfPrisoner,CategoryOfPrisoner,asset,date,adm);
        listOfPR.add(pr);
    }
    public PrisonerToBeExecuted getPrisonerE(int id)
    {
        for(int i=0;i<listOfPE.size();i++)
        {
            if(listOfPE.get(i).getID()==id)
            {
                return listOfPE.get(i);
            }
        }
        return null;
    }
    public PrisonerToBeReleased getPrisonerR(int id)
    {
        for(int i=0;i<listOfPR.size();i++)
        {
            if(listOfPR.get(i).getID()==id)
            {
                return listOfPR.get(i);
            }
        }
        return null;
    }
    public ArrayList <JailOfficer> getJailOfficers()
    {
        return listOfJailOfficers;
    }
    public ArrayList <Prisoner> getPrisoners()
    {
        return listOfPrisoners;
    }
    public ArrayList <Jail> getJails()
    {
        return listOfJails;
    }
    public void setJailOfficer(ArrayList <JailOfficer> jo)
    {
        listOfJailOfficers=jo;
    }
    public void setPrisoner(ArrayList <Prisoner> p)
    {
        listOfPrisoners=p;
    }
    public void setJail(ArrayList <Jail> j)
    {
        listOfJails=j;
    }
}
