package view;

public interface Menu {
//    void show();

    void exit();

    default void showItems(String[] items) {
        System.out.println("Choose operation(enter operation's number)");
        for (String item : items) {
            System.out.printf("%-20s", item);
        }
        System.out.println("");
    }
}
