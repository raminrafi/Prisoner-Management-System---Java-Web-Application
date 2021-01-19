/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "signupServlet", urlPatterns = {"/signupServlet"})
public class signupServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet signupServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet signupServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        String name=request.getParameter("name");
        int age=Integer.parseInt(request.getParameter("age"));
        String gender=request.getParameter("gender");
        String contact=request.getParameter("contact");
        String email=request.getParameter("email");
        String password=request.getParameter("psw");
        String passwordRepeat=request.getParameter("pswrepeat");
        System.out.println("Name: "+name);
       
        System.out.println("Gender: "+gender);
        if(password.equals(passwordRepeat))
        {
            PMS obj=PMS.getInstance();
            if(obj.validUser(email)==true)
            {
                obj.signup(name, age, gender, contact, email, password);
                PrintWriter out = response.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Congratulations !! Your account has been created.');");
                out.println("location='login.jsp';");
                out.println("</script>");
            }
            else
            {
                PrintWriter out = response.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Email already exists!! Try signing up with a different account');");
                out.println("location='signup.jsp';");
                out.println("</script>");
            }
        }
        else
        {
            PrintWriter out = response.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Both passswords should be same');");
                out.println("location='signup.jsp';");
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
