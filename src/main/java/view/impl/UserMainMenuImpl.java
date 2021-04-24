package view.impl;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class UserMenu implements SubMenu {
    private Scanner scanner;
    private Order order;
    private final ProductServiceImpl productServiceImpl;
    String answer;

    public UserMenu() {
        this.productServiceImpl = new ProductServiceImpl();
    }

    @Override
    void productsSubMenuShow() {
        String[] productItems = {"1.Choose product", "2.Search product", "3.Order checkout", "0.Exit"};
        scanner = new Scanner(System.in);
        answer = scanner.nextLine();
        switch (answer) {
            case ("1") :
                productChooserMenu();
                break;
            case ("2") :
                searchingProductByName();
                break;
            case ("3") :
                checkoutOrder();
                break;
            case ("0") :
                exit();
            default :
                System.out.println("Wrong number. Please, enter correct number");
                this.productChooserMenu();
        }
    }

    @Override
    void ordersMenuShow(User user) {
        ordersShow(user);
    }

    @Override
    void usersMenuShow(User user){
        usersMenuShow();
    }

    public void productsShow() {
        for (Product product : productServiceImpl.getAllProducts()) {
            System.out.println(currentProduct.toString());
        }
        printMessage("choose products");
        answer = scanAnswer(this::productsShow);
        if (answer.equals("1")) {
            productChooserMenu();
        }
    }

    void ordersShow(User user) {
        ArrayList<Order> orders = user.getOrderList();
        for (Order currentOrder : orders) {
            System.out.println(currentOrder.toString());
        }
        printMessage("checkout order");
        answer = scanAnswer(() -> ordersShow(user));
        if (answer.equals("1")) {
            checkoutOrder();
        }
    }

    void usersMenuShow(){

    }

    void productChooserMenu(){
        printMessage("choose product by id");
        String input = scanAnswer(this::productChooserMenu);
        if (input.equals("1")) {
            System.out.println("Enter id of product");
        }
        scanner = new Scanner(System.in);
        answer = scanner.nextLine();
        Product product = productServiceImpl.getProduct(answer);
        if (Optional.ofNullable(product).isPresent()) {
            order.getListProducts().add(product);
        }
        else {
            System.out.println("not product");
            this.productChooserMenu();
        }
    }

    void searchingProductByName(){
        printMessage("enter product name");
        scanner = new Scanner(System.in);
        String nameProduct = scanner.nextLine();
        Product product = productServiceImpl.getProductByName(nameProduct);
        if (Optional.ofNullable(product).isPresent()) {
            printMessage("add to list products");
            answer = scanAnswer(this::searchingProductByName);
            if (answer.equals("1")) {
                order.getListProducts().add(product);
            }
        }
        else {
            System.out.println("not product");
            this.searchingProductMenu();
        }
    }

    void checkoutOrder(){
//        1. проверка корзины;
//        если да
//          "do chose your order";
//          confirmOrder(order) - находится в сервисном уровне;
//        если нет
//          ретерн назад;
    }

    void exit();
    {
        new LoginMenu.show();
    }

    private void checkOrderForExistence() {
        this.order == null ? this.order = new Order() : 0;
    }

    private void printMessage(String string) {
        System.out.println("1. " + string + " 2. back to main menu");
    }

    private String scanAnswer(Runnable method) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        if (input == "1") {
            return "1";
        }
        if (input == "2") {
            showSubMenu(SubMenu submenu, User user);
        }
        else {
            System.out.println("Wrong number. Please, enter correct number");
            method.run();
        }
        return null;
    }
}
