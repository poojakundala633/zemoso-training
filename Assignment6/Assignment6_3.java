package Assignment6;

class Person {
        private String name;

        public Person(String name) {
            this.name = name;
            System.out.println("New person created: " + name);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    public class Assignment6_3 {
        public static void main(String[] args) {
            Person[] people = new Person[3];
            // no initialization messages printed yet
            people[0] = new Person("Alice");
            people[1] = new Person("Bob");
            people[2] = new Person("Charlie");
        }
    }

