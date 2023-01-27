package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "student_tbl")
public class Student extends BaseEntity{
	@Column(name = "first_name", length = 30)
	private String firstName;
	@Column(name = "last_name", length = 30)
	private String lastName;
	@Column(unique = true, length = 50)
	private String email;
	@OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Admission> admissionlist = new ArrayList<Admission>();
	public List<Admission> getAdmissionlist() {
		return admissionlist;
	}


	public void setAdmissionlist(List<Admission> admissionlist) {
		this.admissionlist = admissionlist;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Student() {
		// TODO Auto-generated constructor stub
	}

	
	public Student(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmal(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Student ID = "+getId()+" [firstName=" + firstName + ", lastName=" + lastName + ", emal=" + email + "]";
	}
	
	
public void addAdmissionList(Admission adobj) {
		
		admissionlist.add(adobj);
		adobj.setCandidate(this);
	}
}
