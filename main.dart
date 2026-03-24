// Data Model (like a data class)
class Student {
  String name;
  int? marks; // nullable marks

  Student(this.name, this.marks);
}

// Function 1: Validate marks
bool validateStudent(Student student) {
  return student.marks != null && student.marks! >= 0 && student.marks! <= 100;
}

// Function 2: Format student information
String formatStudent(Student student) {
  return "${student.name} - Marks: ${student.marks}";
}

// Function 3: Calculate grade
String calculateGrade(Student student) {
  int score = student.marks ?? -1;

  if (score == -1) {
    return "No marks provided";
  } else if (score >= 80) {
    return "A";
  } else if (score >= 70) {
    return "B";
  } else if (score >= 60) {
    return "C";
  } else if (score >= 50) {
    return "D";
  } else {
    return "F";
  }
}

// Main demonstration
void main() {
  // List of student objects
  List<Student> students = [
    Student("Erika", 90),
    Student("Alex", null),
    Student("John", 49),
    Student("Maria", 75),
    Student("David", 60),
  ];

  print("Student Results:\n");

  // Collection operation (filter valid students)
  List<Student> validStudents = students
      .where((s) => validateStudent(s))
      .toList();

  // Higher-order functions with lambda expressions
  validStudents
      .map((s) => "${formatStudent(s)} | Grade: ${calculateGrade(s)}")
      .forEach((student) {
        print(student);
      });
}
