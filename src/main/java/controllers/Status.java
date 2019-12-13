package controllers;

public class Status {
	private int id;
	private String message;
	
	Status(int id, String message){
		this.id = id;
		this.message = message;
	}
	public int getId() {
		return id;
	}
	public String getMessage() {
		return message;
	}
}
