package model;

public class BeanStudentPhone {
	private String name_st;
	private String number_phone;
	private String email;
	
	public String getName_st() {
		return name_st;
	}
	
	public void setName_st(String name_st) {
		this.name_st = name_st;
	}
	
	public String getNumber_phone() {
		return number_phone;
	}
	
	public void setNumber_phone(String number_phone) {
		this.number_phone = number_phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "BeanStudentPhone [name_st=" + name_st + ", number_phone=" + number_phone + ", email=" + email + "]";
	}
}
