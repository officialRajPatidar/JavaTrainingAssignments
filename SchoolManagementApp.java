package wiprotraining;

import java.util.Scanner;

interface SchoolService {
    void create();
    void read();
    void update(String name);
    void delete();
}

class User implements SchoolService {
    protected String name;

    public User() {}

    public User(String name) {
        this.name = name;
    }

    public void create() {
        System.out.println("Created entity: " + name);
    }

    public void read() {
        System.out.println("Entity name: " + name);
    }

    public void update(String name) {
        this.name = name;
        System.out.println("Updated entity to: " + name);
    }

    public void delete() {
        System.out.println("Deleted entity: " + name);
    }
}

class Student extends User {
    private int studentId;

    public Student() {}

    public Student(String name, int studentId) {
        this.name = name;
        this.studentId = studentId;
    }

    public void read() {
        System.out.println("Student ID: " + studentId + ", Name: " + name);
    }

    public void enroll() {
        System.out.println("Student " + name + " enrolled.");
    }

    public void graduate() {
        System.out.println("Student " + name + " graduated.");
    }
}

class Teacher extends User {
    private String subject;

    public Teacher() {}

    public Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public void read() {
        System.out.println("Teacher: " + name + ", Subject: " + subject);
    }

    public void assignSubject(String subject) {
        this.subject = subject;
        System.out.println("Assigned subject: " + subject + " to teacher " + name);
    }
}

public class SchoolManagementApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name for student: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine(); 

        Student student = new Student(studentName, studentId);
        student.create();
        student.read();

        System.out.print("Do you want to update the student's name? (yes/no): ");
        String response = scanner.nextLine();
        if (response.equalsIgnoreCase("yes")) {
            System.out.print("Enter new name for student: ");
            String newStudentName = scanner.nextLine();
            student.update(newStudentName);
        }

        student.enroll();
        student.read();

        System.out.print("Do you want to graduate the student? (yes/no): ");
        response = scanner.nextLine();
        if (response.equalsIgnoreCase("yes")) {
            student.graduate();
        }

        student.delete();

        System.out.print("Enter name for teacher: ");
        String teacherName = scanner.nextLine();
        System.out.print("Enter subject for teacher: ");
        String subject = scanner.nextLine();

        Teacher teacher = new Teacher(teacherName, subject);
        teacher.create();
        teacher.read();

        System.out.print("Do you want to assign a new subject to the teacher? (yes/no): ");
        response = scanner.nextLine();
        if (response.equalsIgnoreCase("yes")) {
            System.out.print("Enter new subject: ");
            String newSubject = scanner.nextLine();
            teacher.assignSubject(newSubject);
        }

        System.out.print("Do you want to update the teacher's name? (yes/no): ");
        response = scanner.nextLine();
        if (response.equalsIgnoreCase("yes")) {
            System.out.print("Enter new name: ");
            String newName = scanner.nextLine();
            teacher.update(newName);
        }

        System.out.println("Final data after updates:");
        student.read();
        teacher.read();

        teacher.delete();
        
        scanner.close();
    }
}
