class Animal {
    public void printAnimal() {
        System.out.println("I am from animal class");
    }

    public void printAnimalTwo() {
        System.out.println("I am from animal class");
    }
}

class Lion extends Animal {
    public void printAnimal() {
        System.out.println("I am from lion class");
    }
}

public class Main {
    public static void main(String args[]) {
        Animal animal;
        Lion lion = new Lion();
        animal = lion;

        animal.printAnimal();
        animal.printAnimalTwo();
    }
}

// output -> I am fron the lion class(first method is used from the derived class)
        //   I am from the animal class