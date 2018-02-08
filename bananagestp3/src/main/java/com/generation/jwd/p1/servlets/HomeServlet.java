package com.generation.jwd.p1.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.generation.jwd.p1.beans.Task;


@WebServlet("/homeuser")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public HomeServlet() {
        super();
    }
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "jdbc:mysql://127.0.0.1:3306/bananagest";
        String user = "root";
        String password1 = "admin";
        
        Connection conn;
        ResultSet rs;
        PreparedStatement stmt;

		ArrayList<Task> taskList = new ArrayList<Task>();
		Task myTask ;
		HttpSession session = (HttpSession)request.getSession();
		int user_id = (Integer)session.getAttribute("id_user");

		
		try {    
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, user, password1);
            stmt = conn.prepareStatement("SELECT * FROM tasks WHERE id_user = ?");
            
            stmt.setInt(1, user_id);
            
            rs = stmt.executeQuery();	
			 			
			while(rs.next()) {
				myTask = new Task();
				myTask.setId(rs.getInt(1));
				myTask.setName(rs.getString(2));
				myTask.setDesc(rs.getString(3));
				myTask.setNotes(rs.getString(4));
				myTask.setDateBegin(rs.getString(5));
				myTask.setDateEnd(rs.getString(6));
				myTask.setIdResponsible(rs.getInt(7));
				myTask.setId_project(rs.getInt(8));
				myTask.setStatus(rs.getString(9));
				myTask.setId_user(rs.getInt(10));

				taskList.add(myTask);	
			}			
			
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		request.setAttribute("taskList",taskList);
		request.getRequestDispatcher("homeuser.jsp").forward(request, response);		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
