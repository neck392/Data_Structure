import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Student2 {
	String studentNumber;
	String name;
	String department;
	int grade;

	public Student2(String studentNumber, String name, String department, int grade) {
		this.studentNumber = studentNumber;
		this.name = name;
		this.department = department;
		this.grade = grade;
	}
}

class StudentComparator implements Comparator<Student2> {
	private int sortingCriteria;

	public StudentComparator(int sortingCriteria) {
		this.sortingCriteria = sortingCriteria;
	}

	@Override
	public int compare(Student2 s1, Student2 s2) {
		switch (sortingCriteria) {
		case 0:
			return s1.studentNumber.compareTo(s2.studentNumber);
		case 1:
			return s1.name.compareTo(s2.name);
		case 2:
			return s1.department.compareTo(s2.department);
		case 3:
			return Integer.compare(s1.grade, s2.grade);
		default:
			return 0;
		}
	}

}

public class ComparatorEx {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Student2> studentList = new ArrayList<Student2>();
		studentList.add(new Student2("202234001", "김", "AI", 4));
		studentList.add(new Student2("202234002", "이", "Computer Science", 3));
		studentList.add(new Student2("202234003", "박", "Software Engineering", 2));
		studentList.add(new Student2("202234004", "최", "Information and Communication Engineering", 1));

		System.out.println("정렬 기준을 입력해주세요.");
		System.out.println("학번 : 0  이름 : 1  학과 : 2 학년 : 3");
		int sortingCriteria = scanner.nextInt();

		Collections.sort(studentList, new StudentComparator(sortingCriteria));

		for (Student2 student : studentList) {
			System.out.println(
					student.studentNumber + " " + student.name + " " + student.department + " " + student.grade);
		}
		scanner.close();
	}

}