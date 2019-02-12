package ua.lviv.lgs;

import java.sql.Date;

public class Subscriptions {
	private int id;
	private int user_id;
	private int jornal_id;
	private Date start;
	private Date end;
	
	public Subscriptions(int id, int user_id, int jornal_id, Date start, Date end) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.jornal_id = jornal_id;
		this.start = start;
		this.end = end;
	}
	
	public Subscriptions(int user_id, int jornal_id, Date start, Date end) {
		super();
		this.user_id = user_id;
		this.jornal_id = jornal_id;
		this.start = start;
		this.end = end;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getJornal_id() {
		return jornal_id;
	}

	public void setJornal_id(int jornal_id) {
		this.jornal_id = jornal_id;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}
	

}
