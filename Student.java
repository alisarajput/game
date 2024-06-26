import java.util.ArrayList;
import java.util.List;
public class Student {
    private int id;
    private String name;
    private String grade;

    public Student(int id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Grade: " + grade;
    }
    public static class StudentManagementSystem {

        private List<Student> students = new ArrayList<>();

        // Create (Add) a student
        public void addStudent(Student student) {
            students.add(student);
        }

        // Read (View) all students
        public void viewStudents() {
            students.forEach(System.out::println);
        }

        // Update a student's details
        public void updateStudent(int id, String newName, String newGrade) {
            for (Student s : students) {
                if (s.getId() == id) {
                    s.setName(newName);
                    s.setGrade(newGrade);
                    break;
                }
            }
        }

        // Delete a student by ID
        public void deleteStudent(int id) {
            students.removeIf(s -> s.getId() == id);
        }

        // Search student by name
        public Student searchStudentByName(String name) {
            for (Student s : students) {
                if (s.getName().equalsIgnoreCase(name)) {
                    return s;
                }
            }
            return null;
        }
    }
    public class Main {
        public static void main(String[] args) {
            StudentManagementSystem sms = new StudentManagementSystem();

            // Create new students
            sms.addStudent(new Student(1, "Alice", "A"));
            sms.addStudent(new Student(2, "Bob", "B"));
            sms.addStudent(new Student(3, "Ramesh", "B+"));
            sms.addStudent(new Student(4, "Sanjay", "A-"));

            // Read and display students
            System.out.println("Students List:");
            sms.viewStudents();

            // Update student's details
            sms.updateStudent(2, "Robert", "A+");
            System.out.println("\nAfter updating Bob's details:");
            sms.viewStudents();

            // Search for a student by name
            System.out.println("\nSearching for Ramesh:");
            Student foundStudent = sms.searchStudentByName("Ramesh");
            System.out.println(foundStudent != null ? foundStudent : "Student not found.");

            // Delete a student
            sms.deleteStudent(1);
            System.out.println("\nAfter deleting Alice:");
            sms.viewStudents();
        }
    }
}