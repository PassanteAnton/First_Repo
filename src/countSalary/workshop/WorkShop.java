package countSalary.workshop;

import countSalary.Master;

import java.util.ArrayList;
import java.util.List;

public class WorkShop {
    private List<Master> worker;
    private List<Integer> cashController ;
    public WorkShop() {
        this.worker = new ArrayList<>();
        this.cashController = new ArrayList<>();
        cashController.add(1000);
        cashController.add(2500);
        cashController.add(7200);
        cashController.add(5800);
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
