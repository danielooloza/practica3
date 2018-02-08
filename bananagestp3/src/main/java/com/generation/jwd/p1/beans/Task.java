package com.generation.jwd.p1.beans;

public class Task  {

	private int id;
	private String name;
	private String desc;
	private String notes;
	private String dateBegin;
	private String dateEnd;
	private String idResponsible;
	private int status;
	private int id_project;
	
	public Task() {};
	
	public Task(int id, String name, String desc, String notes, String dateBegin, String dateEnd,
			String idResponsible, int status, int id_project) {
		
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.notes = notes;
		this.dateBegin = dateBegin;
		this.dateEnd = dateEnd;
		this.idResponsible = idResponsible;
		this.status = status;
		this.id_project = id_project;
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

	public String getIdResponsible() {
		return idResponsible;
	}

	public void setIdResponsible(String idResponsible) {
		this.idResponsible = idResponsible;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getId_project() {
		return id_project;
	}

	public void setId_project(int id_project) {
		this.id_project = id_project;
	}
	
}

