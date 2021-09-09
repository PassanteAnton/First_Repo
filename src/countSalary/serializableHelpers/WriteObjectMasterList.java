package countSalary.serializableHelpers;

import countSalary.Master;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class WriteObjectMasterList {
    public static void saveListMasters(List<Master> masters){

        try ( FileOutputStream fos = new FileOutputStream("C://Users/eltor/IdeaProjects/Tests/src/countSalary/masterBank.bin");
              ObjectOutputStream oos = new ObjectOutputStream(fos)        ){

            oos.writeObject(masters);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
