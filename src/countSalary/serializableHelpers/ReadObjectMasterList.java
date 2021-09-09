package countSalary.serializableHelpers;

import countSalary.Master;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadObjectMasterList {
    public static List<Master> getMastersFromBank(){
        List<Master> masters = null;
        ObjectInputStream objectInputStream = null;
        try{
                FileInputStream fis = new FileInputStream("C://Users/eltor/IdeaProjects/Tests/src/countSalary/masterBank.bin");
                if(fis.available() > 0){
                    objectInputStream = new ObjectInputStream(fis);
                    masters = (ArrayList<Master>) objectInputStream.readObject();
                }

        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }finally {
            try {
                objectInputStream.close();
            } catch (NullPointerException | IOException e) {

            }
        }

        if(masters != null){
            return masters;
        }else {return Collections.emptyList();}
    }
}
