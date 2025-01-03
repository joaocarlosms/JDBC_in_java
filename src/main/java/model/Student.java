package model;

public class Student {
	private Long id;
	private String name_st;
	private String email;
	
	public Student(Long id, String name_st, String email) {
		this.id = id;
		this.name_st = name_st;
		this.email = email;
	}
	
	public Student() {
		this.id = null;
		this.name_st = "";
		this.email = "";
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setNameSt(String name_st) {
		this.name_st = name_st;
	}
	
	public String getNameSt() {
		return name_st;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name_st=" + name_st + ", email=" + email + "]";
	}
}
