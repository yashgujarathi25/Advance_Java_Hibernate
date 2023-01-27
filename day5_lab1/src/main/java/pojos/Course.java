package pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="course_tbl")
public class Course extends BaseEntity {
	@Column(name = "course_title", length = 100, unique = true)
	private String CourseTitle;
	@Column(name = "start_date")
	private LocalDate startDate;
	@Column(name = "end_date")
	private LocalDate endDate;
	private double fees;
	private int capacity;
	@OneToMany(mappedBy = "chosenCourse", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Admission> admissionlist= new ArrayList<Admission>();
	
	public List<Admission> getAdmissionlist() {
		return admissionlist;
	}

	public void setAdmissionlist(List<Admission> admissionlist) {
		this.admissionlist = admissionlist;
	}

	public Course() {
		// TODO Auto-generated constructor stub
	}
	
	public String getCourseTitle() {
		return CourseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		CourseTitle = courseTitle;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public Course(String courseTitle, LocalDate startDate, LocalDate endDate, double fees, int capacity) {
		super();
		CourseTitle = courseTitle;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fees = fees;
		this.capacity = capacity;
	}
	@Override
	public String toString() {
		return "Course ID = "+ getId()+" [CourseTitle=" + CourseTitle + ", startDate=" + startDate + ", endDate=" + endDate + ", fees="
				+ fees + ", capacity=" + capacity + "]";
	}
	
	public void addAdmissionList(Admission adobj) {
		
		admissionlist.add(adobj);
		adobj.setChosenCourse(this);
	}
	
}
