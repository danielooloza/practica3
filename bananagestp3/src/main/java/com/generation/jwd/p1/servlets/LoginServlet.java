package com.generation.jwd.p1.servlets;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.getRequestDispatcher("login.jsp").forward(request, response);
        System.out.println("Get");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        if(email.isEmpty() || password.isEmpty()) {
            
            //Si el formulario estï¿½ vacï¿½o, manda un mensaje de error
            request.setAttribute("error", "El/los campo/s de usuario y/o la contraseña están vacíos. Inténtelo de nuevo.");
            request.getRequestDispatcher("/login").forward(request, response);
            
        } 
        
        String url = "jdbc:mysql://127.0.0.1:3306/bananagest";
        String user = "root";
        String password1 = "@p0cal1p515";
        
        Connection conn;
        ResultSet rs;
        PreparedStatement stmt;
        int id_user = 0;            
            
        try {    
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, user, password1);
            stmt = conn.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?");
            
            stmt.setString(1, email);
            stmt.setString(2, password);
            
            rs = stmt.executeQuery();
            
            if (rs.next()) {                
            
                id_user = rs.getInt("id");                    
            }            
            
            rs.close();
            stmt.close();
            conn.close();            
            
        } catch(Exception e) {
            System.out.println("Excepcion SQL: " + e.getMessage());                
        }
        
        if (id_user != 0) {        
            
            HttpSession session = (HttpSession)request.getSession();
            session.setAttribute("id_user",id_user);        
            request.getRequestDispatcher("/homeuser").forward(request, response);
            
        } else {
            
            request.setAttribute("error", "Usuario y/o contraseña incorrectos. Inténtelo de nuevo.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        
        }                
    }
}
 


 



 
