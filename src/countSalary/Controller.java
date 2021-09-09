package countSalary;


public class Controller {
    private static Model model = new Model();
    public static View view = new View(model);

    public static void main(String[] args) {
        ConsoleHelper.writeMessage("Выбрать мастеров");
        ConsoleHelper.writeMessage(view.writeAvailableMaster());



            int num = 0;
           ConsoleHelper.writeMessage("Введите номер мастера которого хотите включить в список для расчёта и нажмите\"Enter\".");
           ConsoleHelper.writeMessage("Если нужного нет. Введите 10 для добовления нового мастера.");
            while (true) {
                num = ConsoleHelper.readInt();

                if (num == 11) {
                    ConsoleHelper.writeMessage("Список мастеров для расчёта.");
                    ConsoleHelper.writeMessage(view.writeAddedMasters());
                    ConsoleHelper.writeMessage("Если список полный введите \"да\", если нет введите любой символ.");

                    if(ConsoleHelper.readString().equalsIgnoreCase("да")) {
                        break;
                    }else {
                        ConsoleHelper.writeMessage("Для добавления из списка введите его номер. Для добавления нового введите 10. Введите 11 для расчёта.");
                        continue;
                    }

                } else if (num > 0 && num <= model.getAvailableMasters().size()) {

                    if(model.getAddedMasters().contains(model.getAvailableMasters().get(num - 1))){
                        ConsoleHelper.writeMessage("Этот мастер был добавлен ранее список для расчёта.");
                        ConsoleHelper.writeMessage("Для добавления из списка введите его номер. Для добавления нового введите 10. Введите 11 для расчёта.");
                        continue;
                    }else {
                        model.getAddedMasters().add(model.getAvailableMasters().get(num - 1));
                        ConsoleHelper.writeMessage("Мастер добавлен.");
                        ConsoleHelper.writeMessage("Для добавления из списка введите его номер. Для добавления нового введите 10. Введите 11 для расчёта.");

                        continue;
                    }
                } else if (num == 10) {
                    model.addMaster(ConsoleHelper.insertMasterName(), ConsoleHelper.insertMasterCategory());
                    ConsoleHelper.writeMessage("Мастер добавлен. Для добавления следующего введите 10. Для того чтобы расчитать зарплату введите 11.");
                    continue;
                }else {
                    ConsoleHelper.writeMessage("Не корректный ввод. Попробуй ещё.");
                    continue;
                }

            }
        model.countSalary(ConsoleHelper.insertRevenue());
        ConsoleHelper.writeMessage(view.writeAddedMasters());

    }
}