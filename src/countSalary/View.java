package countSalary;

public class View {
    public View(Model model) {
        this.model = model;
    }

    private Model model;


    public String writeAvailableMaster(){

        return getInformationOboutMasters(true);
    }
    public String writeAddedMasters(){
        return getInformationOboutMasters(false);
    }


    // flag true get list available masters for add
    // flag false get list added masters
    private String getInformationOboutMasters(Boolean flag){
        if(flag ? model.getAvailableMasters().isEmpty() : model.getAddedMasters().isEmpty()){
            return "Список пуст";
        }

        StringBuilder stringBuilder = new StringBuilder();
        int index = 1;
        for(Master master: flag ? model.getAvailableMasters() : model.getAddedMasters()){
            stringBuilder.append(index);
            stringBuilder.append(": ");
            stringBuilder.append(master);
            stringBuilder.append("\n");
            index ++;
        }
        return stringBuilder.toString();
    }

}
