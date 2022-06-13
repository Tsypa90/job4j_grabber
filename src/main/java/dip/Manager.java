package dip;

public class Manager {
    private Worker worker;
    private SuperWorker superWorker;

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public void setSuperWorker(SuperWorker superWorker) {
        this.superWorker = superWorker;
    }

    public void work() {
        if (worker == null) {
            superWorker.work();
        } else {
            worker.work();
        }
    }
}
