import java.util.*;

public class AcademicClass{
  public AcademicClass(Teacher teacher){
    this.teacher = teacher;
    students = new ArrayList<Student>();
  }

  public void addStudent(String name, int favNum){
    students.add(new Student(name, favNum));
  }

  public void printClass(){
    System.out.println("teacher: " + teacher.getName());
    System.out.println("students: ");
    for(Student s : students){
      System.out.println(s.getName() + ", fav #: " + s.getFavNum());
    }
  }

  public ArrayList<String> favNumOf(int num){
    ArrayList<String> result = new ArrayList<String>();
    for(Student s : students){
      if(s.getFavNum() == num){
        result.add(s.getName());
      }
    }
    return result;
  }

  public ArrayList<String> oddFavNums(){
    ArrayList<String> result = new ArrayList<String>();
    for(Student s : students){
      if(s.getFavNum()%2 == 1){
        result.add(s.getName());
      }
    }
    return result;
  }

  private Teacher teacher;
  private ArrayList<Student> students;
}
