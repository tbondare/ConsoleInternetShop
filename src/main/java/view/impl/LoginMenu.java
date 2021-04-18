package view.impl;


import service.UserService;
import view.Menu;

import java.util.Scanner;

public class LoginMenu implements Menu {

    private Scanner scanner = new Scanner(System.in);
    private UserService userService = new UserServiceImpl();

    private String[] items = {"1.Login", "2.Register", "3.Back", "0.Exit"};


    @Override
    public void show() {
        while (true) {
            for (String item : items) {
                System.out.println(item);
            }
            System.out.println("Choose option:");

            switch (scanner.nextLine()) {
                case "1":
                    loginSubMenu();
                    break;

                case "2":
                    registerSubMenu();
                    break;
                case "9":
                    back();
                    break;
                case "0":
                    exitProgram();
                    break;
            }
        }
    }

    private void registerSubMenu() {
        System.out.println("login:");
        String login = scanner.nextLine();

        System.out.println("password:");
        String password = scanner.nextLine();

        Response<User> registerResponse = userService.register(user);
        if(registerResponse.isSuccess())
        {
            new AdminMenu().show();
        }
        else {
            System.out.println(registerResponse.getErrorMessage());
        }
    }

    private void loginSubMenu() {
        System.out.println("your login:");
        String login = scanner.nextLine();

        System.out.println("your password:");
        String password = scanner.nextLine();

        Response<User> loginResponse = userService.login(login, password);
        if (loginResponse.isSuccess()) {
            User u = loginResponse.getData();
            System.out.println("user logged in :" + u);
            new AdminMenu().show();
        } else {
            System.out.println(loginResponse.getErrorMessage());
        }
    }

    @Override
    public void back () {
        exitProgram();
    }
}
