package countSalary;

import countSalary.serializableHelpers.WriteObjectMasterList;

import java.util.Collections;
import java.util.List;

public class Model {



    public List<Master> getAddedMasters() {
        return Master.getMasters();
    }

    public void addMaster(String name, int category){
        new Master(name, category);
    }

    public void countSalary(int revenue){
        Master.countSalary(revenue);
        if(Master.getAvailableMasters().isEmpty()){
            Master.setAvailableMasters(Master.getMasters());

        } else if(Master.getAvailableMasters().size() < 10) {
            for (Master master : Master.getMasters()) {
                if (!Master.getAvailableMasters().contains(master)){
                    Master.getAvailableMasters().add(master);
                    if(Master.getAvailableMasters().size() == 10){
                        break;
                    }
                }
            }
        }
        Collections.sort(Master.getAvailableMasters());
        Collections.reverse(Master.getAvailableMasters());
        WriteObjectMasterList.saveListMasters(Master.getAvailableMasters());
    }
    public List<Master> getAvailableMasters(){

        return Master.getAvailableMasters();
    }
    public Model() {
    }
}
