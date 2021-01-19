/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author abc
 */
@WebServlet(name = "addPrisonerServlet", urlPatterns = {"/addPrisonerServlet"})
public class addPrisonerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addPrisonerServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addPrisonerServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
       String fname=request.getParameter("fname");
       String lname=request.getParameter("lname");
       String address=request.getParameter("address");
       String gender=request.getParameter("gender");
       int age=Integer.parseInt(request.getParameter("age"));
       String reason=request.getParameter("reason");
       String category=request.getParameter("category");
       String date=request.getParameter("date");
       String R_E_Date=request.getParameter("redate");
       String type=request.getParameter("type");
       String assets=request.getParameter("asset");
        PMS obj=PMS.getInstance();
       if(type.equals("Release"))
       {
           //prisoner to be releasee
           String typeOfPrisoner="To be Released";
          
           obj.addPrisonerR(fname, lname, age, address, typeOfPrisoner, category, reason, gender, assets,R_E_Date, date);
        
                PrintWriter out = response.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Prisoner has been added');");
                out.println("location='afterLogin.jsp';");
                out.println("</script>");
       }
       else
       {
           //prisoner to be executed
           String typeOfPrisoner="To be Executed";
           String typeOfExecution=type;
           System.out.println("Name "+fname+lname);
           System.out.println("Type of Prisoner "+typeOfPrisoner);
           System.out.println("Type of Execution "+typeOfExecution);
           System.out.println("Assets "+assets);
           obj.addPrisonerE(fname, lname, age, address, typeOfPrisoner, category, reason, gender, assets,typeOfExecution, R_E_Date,date);
             PrintWriter out = response.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Prisoner has been added');");
                out.println("location='afterLogin.jsp';");
                out.println("</script>");
       }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
