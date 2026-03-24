class Student {
  String name;
  int? marks; // nullable marks

  Student(this.name, this.marks);
}

String calculateGrade(Student student) {
  //Handle null marks safely
  int score = student.marks ?? -1;

  if (score == -1) {
    return "No marks provided";
  }
  if (score >= 80 && score <= 100) {
    return "A";
  } else if (score >= 70) {
    return "B";
  } else if (score >= 60) {
    return "C";
  } else if (score >= 50) {
    return "D";
  } else if (score >= 0) {
    return "F";
  } else {
    return "invalid marks";
  }
}

//3. Main function
void main() {
  Student student1 = Student("Erika", 90);
  Student student2 = Student("Alex", null);
  Student student3 = Student("John", 49);
  print("${student1.name}:${calculateGrade(student1)}");
  print("${student2.name}:${calculateGrade(student2)}");
  print("${student3.name}:${calculateGrade(student3)}");
}
