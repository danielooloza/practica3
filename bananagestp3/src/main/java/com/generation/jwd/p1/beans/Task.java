package com.generation.jwd.p1.beans;

public class Task  {

	private int id;
	private String name;
	private String desc;
	private String notes;
	private String dateBegin;
	private String dateEnd;
	private int idResponsible;
	private int id_project;
	private String status;
	private int id_user;
	
	public Task() {
		super();
	}
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public String getNotes() {
		return notes;
	}
	
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public String getDateBegin() {
		return dateBegin;
	}
	
	public void setDateBegin(String dateBegin) {
		this.dateBegin = dateBegin;
	}
	
	public String getDateEnd() {
		return dateEnd;
	}
	
	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}
	
	public int getIdResponsible() {
		return idResponsible;
	}
	
	public void setIdResponsible(int idResponsible) {
		this.idResponsible = idResponsible;
	}
	
	public int getId_project() {
		return id_project;
	}
	
	public void setId_project(int id_project) {
		this.id_project = id_project;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public int getId_user() {
		return id_user;
	}
	
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	
}

