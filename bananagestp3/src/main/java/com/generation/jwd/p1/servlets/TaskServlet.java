package com.generation.jwd.p1.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.generation.jwd.p1.beans.*;


@WebServlet("/createtask")
public class TaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement stmt;
	private Context initContext;
	private Context envContext;
	private DataSource ds;	
       
    public TaskServlet() {
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
		Map <Integer, String> projects = new HashMap <Integer, String>();
		
		//Set Attribute for users
		try {
			
			initContext = new InitialContext();
			envContext = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/banana_gest_new");
			conn = (Connection) ds.getConnection();
			stmt = (PreparedStatement)conn.prepareStatement("SELECT id, name FROM users ORDER BY id ASC");	
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
		
		try {
			
			initContext = new InitialContext();
			envContext = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/banana_gest_new");
			conn = (Connection) ds.getConnection();
			stmt = (PreparedStatement)conn.prepareStatement("SELECT id, name FROM projects ORDER BY id ASC");	
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				projects.put(rs.getInt("id"), rs.getString("name"));
			}		
			
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {		
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("projectList", projects.values());
		
		request.getRequestDispatcher("createtask.jsp").forward(request, response);
	}
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 		 
		 Task task = new Task();
		 
		 task.setName(request.getParameter("name"));
		 task.setDesc(request.getParameter("desc"));
	     task.setNotes(request.getParameter("notes"));
	     task.setDateBegin(request.getParameter("dateBegin"));
	     task.setDateEnd(request.getParameter("dateEnd"));
	     task.setIdResponsible(Integer.parseInt(request.getParameter("idResponsible")));
	     task.setId_project(Integer.parseInt(request.getParameter("id_project")));
	     task.setStatus(request.getParameter("status"));
	     task.setId_user(Integer.parseInt(request.getParameter("id_user")));

  
	     String q = "INSERT INTO task"
					+ "(id, name, desc, notes, dateBegin, dateEnd, idResponsible, id_project, status, id_user)"
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	     
	     try {
		
			initContext = new InitialContext();
			envContext = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/banana_gest_new");
			
			conn.setAutoCommit(false);
			
			conn = (Connection) ds.getConnection();			
			stmt = (PreparedStatement)conn.prepareStatement(q);				
			stmt.setInt(1, task.getId());
			stmt.setString(2, task.getName());
			stmt.setString(3, task.getDesc());
			stmt.setString(4, task.getNotes());
			stmt.setString(5, task.getDateBegin());
			stmt.setString(6, task.getDateEnd());
			stmt.setInt(7, task.getIdResponsible());
			stmt.setInt(8, task.getId_project());
			stmt.setString(9, task.getStatus());
			stmt.setInt(10, task.getId_user());
			stmt.executeUpdate();
			stmt.close();
			conn.close();
			
			conn.commit();
				
	     } catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} catch (NamingException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
	    	 System.out.println("Finally");
	    }
	     response.sendRedirect("homeuser");
	 }
}