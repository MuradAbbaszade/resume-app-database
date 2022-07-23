package entity;

import java.util.List;

public class User {
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname + ", phone=" + phone + ", email=" + email
				+ ", nationality=" + nationality + "]";
	}

	private Integer id;
	private String name;
	private String surname;
	private String phone;
	private String email;
	private String nationality;
	private Employment employment;
	private List<UserSkill> userskills;

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public User(Integer id, String name, String surname, String phone, String email, String nationality) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.email = email;
		this.nationality = nationality;
	}

	public User(Integer id, String name, String surname, String phone, String email, String nationality,
			Employment employment) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.email = email;
		this.nationality = nationality;
		this.employment = employment;
	}

	public User(Integer id, String name, String surname, String phone, String email, String nationality,
			Employment employment, List<UserSkill> userskills) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.email = email;
		this.nationality = nationality;
		this.employment = employment;
		this.userskills = userskills;
	}

	public Employment getEmployment() {
		return employment;
	}

	public void setEmployment(Employment employment) {
		this.employment = employment;
	}

}
