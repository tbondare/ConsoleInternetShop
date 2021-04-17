package view;

import model.User;

public interface SubMenu extends Menu {
    void productsSubMenuShow();

    void ordersMenuShow(User user);

    void usersMenuShow(User user);
}
