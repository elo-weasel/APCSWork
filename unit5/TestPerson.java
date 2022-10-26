public class TestPerson{
  public static void main(String[] args){
    Person p1 = new Person("Eloise", 0);
    Person p2 = new Person("Audrey", 1);
    Person p3 = new Person("Taryn", 2);

    testPerson(p1);
    testPerson(p2);
    testPerson(p3);
  }

  public static void testPerson(Person p){
    System.out.println("person: " + p.getName() + ", number of pets: " + p.getPets());
    System.out.println("greeting: " + p.greeting());
    System.out.println();
  }
}
