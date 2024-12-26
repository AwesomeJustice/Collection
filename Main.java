import java.util.*;

class Human implements Comparable<Human> {
    private String firstName;
    private String lastName;
    private int age;

    public Human(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Human other) {
        return this.lastName.compareTo(other.lastName); // Сортировка по фамилии
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", " + age + " лет";
    }
}

class HumanComparatorByLastName implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
}

public class Main {
    public static void main(String[] args) {
        List<Human> humans = Arrays.asList(
                new Human("John", "Doe", 25),
                new Human("Jane", "Smith", 30),
                new Human("Alice", "Johnson", 22),
                new Human("Bob", "Brown", 35)
        );

        // a) HashSet
        Set<Human> hashSet = new HashSet<>(humans);
        System.out.println("HashSet: " + hashSet);

        // b) LinkedHashSet
        Set<Human> linkedHashSet = new LinkedHashSet<>(humans);
        System.out.println("LinkedHashSet: " + linkedHashSet);

        // c) TreeSet
        Set<Human> treeSet = new TreeSet<>(humans);
        System.out.println("TreeSet (по фамилии): " + treeSet);

        // d) TreeSet с компаратором
        Set<Human> treeSetByLastName = new TreeSet<>(new HumanComparatorByLastName());
        treeSetByLastName.addAll(humans);
        System.out.println("TreeSet с компаратором по фамилии: " + treeSetByLastName);

        // e) TreeSet с анонимным компаратором по возрасту
        Set<Human> treeSetByAge = new TreeSet<>(new Comparator<Human>() {
            @Override
            public int compare(Human h1, Human h2) {
                return Integer.compare(h1.getAge(), h2.getAge());
            }
        });
        treeSetByAge.addAll(humans);
        System.out.println("TreeSet с анонимным компаратором по возрасту: " + treeSetByAge);
    }
}