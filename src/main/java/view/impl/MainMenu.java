package view.impl;


import view.Menu;

public class MainMenu implements SubMenu {
    @Override
    public void show() {
        System.out.println("AHhaaa!!");
    }

    @Override
    public void exit() {
        new LoginMenu().show();
    }
}
