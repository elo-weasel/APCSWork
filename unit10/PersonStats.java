import java.util.*;

class PersonStats{
  public static void main(String[] args){
    ArrayList<Person> people = new ArrayList<Person>();
    Person p1 = new Person("Eloise", 0);
    people.add(p1);
    Person p2 = new Person("Audrey", 1);
    people.add(p2);
    Person p3 = new Person("Taryn", 2);
    people.add(p3);
    Person p4 = new Person("Sasha", 1);
    people.add(p4);
    Person p5 = new Person("Preston", 3);
    people.add(p5);

    System.out.println("people:");
    printPeople(people);
    System.out.println();
    System.out.println("average # of pets: " + avgPets(people));
    System.out.println("highest # of pets: " + mostPets(people));
    System.out.print("owns multiple pets: ");
    ArrayList<Person> ps = multiplePets(people);
    for (Person p : ps){
      System.out.print(p.getName() + " ");
    }
  }

  public static void printPeople(ArrayList<Person> people){
    for(Person p : people){
      System.out.println(p.getName() + " | # of pets: " + p.getPets());
    }
  }

  public static float avgPets(ArrayList<Person> people){
    float sum = 0;
    for(Person p : people){
      sum += p.getPets();
    }
    return sum/people.size();
  }

  public static String mostPets(ArrayList<Person> people){
    float most = 0;
    String mostName = "";
    for(Person p : people){
      if(p.getPets() > most){
        most = p.getPets();
        mostName = p.getName();
      }
    }
    return mostName;
  }

  public static ArrayList<Person> multiplePets(ArrayList<Person> people){
    ArrayList<Person> result = new ArrayList<Person>();
    for (Person p : people){
      if(p.getPets() > 1){
        result.add(p);
      }
    }
    return result;
  }
}
