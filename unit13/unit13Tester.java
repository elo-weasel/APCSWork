import java.util.*;

public class unit13Tester{
  public static void main(String[] args){
    ShapeCollection sc = new ShapeCollection();
    System.out.println("shape collection: ");

    sc.addShape("rectangle", 4);
    sc.addShape("pentagon", 5);
    sc.addShape("octagon", 8);
    sc.addShape("triangle", 3);

    System.out.println("shapes:");
    for(Shape s : sc.getShapes()){
      System.out.println(s.getName() + ", " + s.getSides() + " sides");
    }

    System.out.println();
    System.out.println("number of sides in an octagon?: " + sc.numberOfSides("octagon"));
    System.out.println("number of sides in an triangle?: " + sc.numberOfSides("triangle"));

    System.out.println();
    System.out.println("average # of sides: " + sc.avgSides());

    System.out.println();
    System.out.println("shapes w/ even # of sides: ");
    for(Shape s : sc.evenSides()){
      System. out.print(s.getName() + " ");
    }
    System.out.println();
    System.out.println();
    System.out.println();


    Teacher teacher = new Teacher("Mr. Guevin", "chem");
    AcademicClass c = new AcademicClass(teacher);

    c.addStudent("Eloise", 7);
    c.addStudent("Audrey", 8);
    c.addStudent("Julia", 13);
    c.addStudent("Sabrina", 14);
    c.addStudent("Margo", 7);
    System.out.println("academic class: ");
    c.printClass();
    System.out.println();

    System.out.println("fav # of 7: ");
    for(String s : c.favNumOf(7)){
      System.out.print(s + " ");
    }
    System.out.println();
    System.out.println();

    System.out.println("odd fav #s: ");
    for(String s : c.oddFavNums()){
      System.out.print(s + " ");
    }
  }
}
