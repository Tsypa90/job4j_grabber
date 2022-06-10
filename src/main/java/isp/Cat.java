package isp;

public class Cat implements Animal {
    @Override
    public void voice() {
        System.out.println("Мяу");
    }

    @Override
    public void run() {
        System.out.println("Бежать");
    }

    @Override
    public void sit() {
        System.out.println("Сидеть");
    }

    @Override
    public void fly() {
        throw  new UnsupportedOperationException("Кошки не летают!");
    }
}
