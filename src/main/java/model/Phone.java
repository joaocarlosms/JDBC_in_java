package model;

public class Phone {
	private Long id;
	private String number_phone;
	private String type_phone;
	private Long student_phone;
	
	public Phone() {
		this.id = null;
		this.number_phone = "";
		this.type_phone = "";
		this.student_phone = null;
	}
	
	public Phone(Long id, String number_phone, String type_phone, Long student_phone) {
		this.id = id;
		this.number_phone = number_phone;
		this.type_phone = type_phone;
		this.student_phone = student_phone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber_phone() {
		return number_phone;
	}

	public void setNumber_phone(String number_phone) {
		this.number_phone = number_phone;
	}

	public String getType_phone() {
		return type_phone;
	}

	public void setType_phone(String type_phone) {
		this.type_phone = type_phone;
	}

	public Long getStudent_phone() {
		return student_phone;
	}

	public void setStudent_phone(Long student_phone) {
		this.student_phone = student_phone;
	}
}
