package evm.cooker.views;

public class MenuView {
    private final String[] menuVariables = {
            "Показать салат",
            "Создание нового салата",
            "Показать овощи",
            "Калькуляция калорий",
            "Сортировка овощей",
            "Найти овощи в заданном диапазоне калорий",
            "Выход"
    };

    public String getActions() {
        StringBuilder menu = new StringBuilder();
        for (int i = 0; i < menuVariables.length; i++) {
            menu.append(i + 1).append(". ").append(menuVariables[i]).append("\n");
        }
        return menu.toString();
    }
}
