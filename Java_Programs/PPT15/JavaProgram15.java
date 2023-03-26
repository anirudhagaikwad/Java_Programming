package PPT15;


import static java.lang.String.format;
import java.util.*;
// Person class
class Person {
    private String firstName, lastName;
    private int age;
    public Person(){ }
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    //getters and setters
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getAge() {
        return age;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return format("First Name:\t%s\tLast Name:\t%s\tAge:\t%d", firstName, lastName, age);
    }
}
// PersonArrayList class
public class JavaProgram15 implements Iterable<Person> {
    private List<Person> persons;
    private static final int MIN_AGE = 10;
    public JavaProgram15() {
        persons = new ArrayList<Person>(MIN_AGE);
    }
    public JavaProgram15(int age) {
        persons = new ArrayList<Person>(age);
    }
    public void addPerson(Person p) {
        persons.add(p);
    }
    public void removePerson(Person p) {
        persons.remove(p);
    }
    public int age() {
        return persons.size();
    }
    //override iterator
    @Override
    public Iterator<Person> iterator() {
        return persons.iterator();
    }
    public static void main(String[] args) {
        Person p1 = new Person("Sakshi", "Desai", 20);
        Person p2 = new Person("Abhinav","Pandit", 30);
        JavaProgram15 pList = new JavaProgram15();
        pList.addPerson(p1);
        pList.addPerson(p2);
        for (Person person : pList) {
            System.out.println(person);
        }
    }
}