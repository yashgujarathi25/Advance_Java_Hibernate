package pojos;

import java.time.LocalDate;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "admission_tbl", 
uniqueConstraints = @UniqueConstraint(columnNames = {"course_id","student_id"}))
public class Admission extends BaseEntity {
	@Column(name="application_date")
	@CreationTimestamp
	private LocalDate applicationDate;
	//How 
	@Column(name="result_date")
	
	private LocalDate resultDate;
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private AdmissionStatus status;
	//admission *-->1 student
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student candidate;
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course chosenCourse;
	
	
	public Admission() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Admission(LocalDate resultDate, AdmissionStatus status, Student candidate, Course chosenCourse) {
		super();
		this.resultDate = resultDate;
		this.status = status;
		this.candidate = candidate;
		this.chosenCourse = chosenCourse;
	}



	public LocalDate getApplicationDate() {
		return applicationDate;
	}



	public void setApplicationDate(LocalDate applicationDate) {
		this.applicationDate = applicationDate;
	}



	public LocalDate getResultDate() {
		return resultDate;
	}
	public void setResultDate(LocalDate resultDate) {
		this.resultDate = resultDate;
	}
	


	public Student getCandidate() {
		return candidate;
	}


	public void setCandidate(Student candidate) {
		this.candidate = candidate;
	}


	public Course getChosenCourse() {
		return chosenCourse;
	}


	public void setChosenCourse(Course chosenCourse) {
		this.chosenCourse = chosenCourse;
	}



	@Override
	public String toString() {
		return "Admission Id = "+ getId()+" [applicationDate=" + applicationDate + ", resultDate=" + resultDate + ", status=" + status
				+ "]";
	}



	


	
	
	
}
