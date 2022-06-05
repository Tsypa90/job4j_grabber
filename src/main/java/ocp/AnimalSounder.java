package ocp;

public class AnimalSounder {
    private static final Cat CAT = new Cat();
    private static final Dog DOG = new Dog();

    public static void sounder(Animal animal) {
        if (animal == CAT) {
            CAT.sound();
        } else if (animal == DOG) {
            DOG.sound();
        }
    }
}
