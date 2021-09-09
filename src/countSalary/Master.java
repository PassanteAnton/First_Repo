package countSalary;

import countSalary.serializableHelpers.ReadObjectMasterList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Master implements Comparable, Serializable {
    static transient List<Master> masters = new ArrayList<>();
    static transient List<Master> availableMasters = ReadObjectMasterList.getMastersFromBank();
    private String name;
    private EmployerType type;
    private transient int salary;

    public static void setAvailableMasters(List<Master> availableMasters) {
        Master.availableMasters = availableMasters;
    }

    public String getName() {
        return name;
    }

    public static List<Master> getAvailableMasters() {
        return availableMasters;
    }



    public Master(String name, int category)throws RuntimeException {
        this.name = name;
        switch (category){
            case 1:
                this.type = EmployerType.SENIOR_MASTER;
                break;
            case 2:
                this.type = EmployerType.MASTER;
                break;
            case 3:
                this.type = EmployerType.HELPER;
                break;
            default:
                throw new RuntimeException("Incorrect category master" + category);
        }
        masters.add(this);
    }

    public static void countSalary (int revenue) {
       List<Master> mastersCopy = new ArrayList<Master>(masters);
        Collections.sort(mastersCopy);
//        setSalaryForMaster(mastersCopy, (int) (revenue * .4f));
        System.out.println("Сумма Зарплаты: " + revenue * .35f);
        setSalaryForMaster(mastersCopy, (int) (revenue * .35f));

    }
    public static void setSalaryForMaster(List<Master> masters , int totalSalary){
        if(masters.isEmpty()){return;}
        Master masterMin = masters.get(0);
        int count = 0;
        int salary = 0;
        for(Master master : masters){
            if(masterMin.type == master.type){
                count ++;
                salary = (int) (totalSalary / masters.size() * master.type.ratio);
                master.salary = salary;
            }
        }
        masters.removeIf(master1 -> master1.type == masterMin.type);
        setSalaryForMaster(masters, totalSalary - salary * count);
    }

    public static List<Master> getMasters() {
        return masters;
    }

    @Override
    public int compareTo(Object o) {
        return Float.compare(this.type.getRatio(),((Master) o).type.getRatio());
    }

    @Override
    public String toString() {
        String category = "";

        switch (this.type){
            case SENIOR_MASTER:
                category = "Старший мастер";
                break;
            case MASTER:
                category = "Мастер";
                break;
            case HELPER:
                category = "Помошник";
                break;
        }
        return this.name +
                " - категория: " + category +
                " - зарплата: " + this.salary;
    }

     enum EmployerType {
        HELPER(0.6f),
        MASTER(0.9f),
        SENIOR_MASTER(1);

        float ratio;

        EmployerType(float v) {
            this.ratio = v;
        }

        public float getRatio() {
            return ratio;
        }
    }

}
