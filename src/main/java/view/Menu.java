package view;

public interface Menu {
    void show();
    void back();

    default void exitProgram() {System.exit(0);}

    default void showItems(String[] items) {
        for (String item : items) {
            System.out.println("-------------");
            System.out.println(item);
        }
    }
}
