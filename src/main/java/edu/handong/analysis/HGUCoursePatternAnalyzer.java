package edu.handong.analysis;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;

public class HGUCoursePatternAnalyzer {
	
	String[] lines = {	"1999-1, JC Nam, Java Programming",
						"1999-2, JC Nam, Programming Language Theory",
						"1999-1, JC Nam, Data Structures",
						"2001-1, JC Nam, Database Systems",
						"2018-1, SB Lim, Java Programming",
						"2018-2, SB Lim, Programming Language Theory",
						"2019-1, SB Lim, Data Structures",
						"2019-1, SB Lim, Algorithm Analysis",
						"2018-1, SJ Kim, Java Programming",
						"2018-2, SJ Kim, Programming Language Theory",
						"2019-1, SJ Kim, Logic Design",
						"2019-1, SJ Kim, Algorithm Analysis",
						};

	int numOfStudents;
	int numOfCourses;
	Student[] students;
	Course[] courses;
	
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) {
		
		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);
	
		students = initiateStudentArrayFromLines(lines);
		
		System.out.println("Number of All Students: " + numOfStudents);
		for(Student student: students) {
			System.out.println(student.getName());
		}
		
		courses = initiateCourseArrayFromLines(lines);
		System.out.println("Number of All Courses: " + numOfCourses);
		for(Course course: courses) {
			System.out.println(course.getCourseName());
		}
		
	}

	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return array of Student
	 */
	private Student[] initiateStudentArrayFromLines(String[] lines) {
		
		Student[] newStudents = new Student[numOfStudents];	// 배열 인스턴스
		
		int i = 0;
		for (String line : lines)		// 라인마다 파싱하기 위한 for loop
		{
			String[] studentData = line.split(", ");
			
			Student newStudent = new Student(studentData[1]);
			
			if (!studentExist(newStudents, newStudent))		// 같은 이름을 찾지 못했을 경우, append.
			{
				newStudents[i] = newStudent;
				i++;
			}
		}
		
		return newStudents;
	}

	/**
	 * This method check if there is the same name of the second arugement in the array, students
	 * @param students
	 * @param student
	 * @return boolean value. if student find, it returns true. or false.
	 */
	private boolean studentExist(Student[] students, Student student) {
		for (Student existStudent : students) // 현재 등록된 student중에 같은 이름이 있는지 탐색.
			if (existStudent != null && student.getName().contentEquals(existStudent.getName()))
				return true;
		return false;
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return array of Course
	 */
	private Course[] initiateCourseArrayFromLines(String[] lines) {
		Course[] newCourses = new Course[numOfCourses];	// 배열 인스턴스
		
		int i = 0;
		for (String line : lines)		// 라인마다 파싱하기 위한 for loop
		{
			String[] courseData = line.split(", ");
			
			Course newCourse = new Course(courseData[2]);
			
			if (!courseExist(newCourses, newCourse))		// 같은 이름을 찾지 못했을 경우, append.
			{
				newCourses[i] = newCourse;
				i++;
			}
		}
		
		return newCourses;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean value. if student find, it returns true. or false.
	 */
	private boolean courseExist(Course[] courses, Course course) {
		for (Course existCourse : courses) // 현재 등록된 course중에 같은 course 이름이 있는지 탐색.
			if (existCourse != null && course.getCourseName().contentEquals(existCourse.getCourseName()))
				return true;
		return false;
	}

}
