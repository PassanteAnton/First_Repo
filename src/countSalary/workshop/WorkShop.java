package countSalary.workshop;

import countSalary.Master;

import java.util.List;

public class WorkShop {
    private List<Master> worker;
    private List<Integer> cashController ;
    public WorkShop() {
    }

    public List<Master> getWorker() {
        return worker;
    }

    public void setWorker(List<Master> worker) {
        this.worker = worker;
    }

    public List<Integer> getCashController() {
        return cashController;
    }

    public void setCashController(List<Integer> cashController) {
        this.cashController = cashController;
    }
}
