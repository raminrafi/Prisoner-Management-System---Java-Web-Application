/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author abc
 */
@WebServlet(name = "afterLoginServlet", urlPatterns = {"/afterLoginServlet"})
public class afterLoginServlet extends HttpServlet {

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
            out.println("<title>Servlet afterLoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet afterLoginServlet at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        int id=Integer.parseInt(request.getParameter("id"));

        PMS obj=PMS.getInstance();
        ArrayList<Prisoner> p=obj.getPrisoners();
        
        for(int i=0;i<p.size();i++)
        {
                
            if(p.get(i).getID()==id)
            {
                System.out.println("---------AFTER LOGIN SERVLET-----------");
                System.out.println(p.get(i).getFirstName());
                 System.out.println("Type: "+p.get(i).getTypeOfPrisoner());
                if(p.get(i).getTypeOfPrisoner().equals("To be Executed"))
                {
                    System.out.println("---------AFTER LOGIN SERVLET-----------");
                    System.out.println(p.get(i).getTypeOfPrisoner());
                    PrisonerToBeExecuted pe=obj.getPrisonerE(id);
                    request.setAttribute("prisoner", pe);
                    String type="1";
                    request.setAttribute("type", type);
                    PrintWriter writer = response.getWriter();
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("prisonerDetails.jsp");
                    requestDispatcher.forward(request, response);
                }
                else if(p.get(i).getTypeOfPrisoner().equals("To be Released"))
                {
                    PrisonerToBeReleased pr=obj.getPrisonerR(id);
                    request.setAttribute("prisoner", pr);
                    String type="2";
                    request.setAttribute("type", type);
                    PrintWriter writer = response.getWriter();
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("prisonerDetails.jsp");
                    requestDispatcher.forward(request, response);
                }
            }
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
