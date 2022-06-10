package isp;

public class FreeLancer implements Worker {
    @Override
    public void goToWork() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void makeWork() {
        System.out.println("Некая реализация");
    }

    @Override
    public void goFromWork() {
        throw new UnsupportedOperationException();
    }
}
