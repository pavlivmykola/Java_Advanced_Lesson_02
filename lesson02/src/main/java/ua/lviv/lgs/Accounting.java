package ua.lviv.lgs;

public class Accounting {
	private int id;
	private int user_id;
	private int operation_id;
	private double sum;
	
	public Accounting(int id, int user_id, int operation_id, double sum) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.operation_id = operation_id;
		this.sum = sum;
	}
	
	public Accounting(int user_id, int operation_id, double sum) {
		super();
		this.user_id = user_id;
		this.operation_id = operation_id;
		this.sum = sum;
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

	public int getOperation_id() {
		return operation_id;
	}

	public void setOperation_id(int operation_id) {
		this.operation_id = operation_id;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}
	
	
	
}
