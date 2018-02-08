package com.generation.jwd.p1.servlets;

import com.generation.jwd.p1.beans.Project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/createproject")
public class ProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement stmt;
	private Context initContext;
	private Context envContext;
	private DataSource ds;	
 
    public ProjectServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}
	
		Context initContext = null;
		Context envContext = null;
		Map <Integer, String> users = new HashMap <Integer, String>();
	
		try {
		
			initContext = new InitialContext();
			envContext = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/banana_gest_new");
			conn = (Connection) ds.getConnection();
			stmt = (PreparedStatement)conn.prepareStatement("SELECT id, name FROM user ORDER BY name ASC");	
			rs = stmt.executeQuery();
		
			while(rs.next()) {
			
				users.put(rs.getInt("id"), rs.getString("name"));
			}		
		
			rs.close();
			stmt.close();
			conn.close();
		
		} catch (SQLException e) {		
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	
		request.setAttribute("userList", users.values());
		request.getRequestDispatcher("createproject.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Project project = new Project();
		
		project.setId(Integer.parseInt(request.getParameter("id")));
		project.setName(request.getParameter("name"));
		project.setDesc(request.getParameter("desc"));
		project.setDateBegin(request.getParameter("dateBegin"));
		project.setDateEnd(request.getParameter("dateEnd"));
		project.setIdResponsible(Integer.parseInt(request.getParameter("idResponsible")));
		project.setNotes(request.getParameter("notes"));
		project.setStatus(request.getParameter("status"));
		project.setId_task(Integer.parseInt(request.getParameter("id_task")));
		
				
		String q = "INSERT INTO project"
				+ "(id, name, desc, dateBegin, dateEnd, idResponsible, notes, satus, id_task)"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
		
		try {
				
			initContext = new InitialContext();
			envContext = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/banana_gest_new");
			conn = (Connection) ds.getConnection();			
				
			stmt = (PreparedStatement)conn.prepareStatement(q);				
			stmt.setInt(1, project.getId());
			stmt.setString(2, project.getName());
			stmt.setString(3, project.getDesc());
			stmt.setString(4, project.getDateBegin());
			stmt.setString(5, project.getDateEnd());
			stmt.setInt(6, project.getIdResponsible());
			stmt.setString(7, project.getNotes());
			stmt.setString(8, project.getStatus());
			stmt.setInt(9, project.getId_task());
			stmt.executeUpdate();
				
			stmt.close();
			conn.close();
					
		    } catch (SQLException e) {
				e.printStackTrace();
			} catch (NamingException e) {
				e.printStackTrace();
			} finally {
		    }
		     response.sendRedirect("homeuser");
	}
}