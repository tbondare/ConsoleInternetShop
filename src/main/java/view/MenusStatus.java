package view;

public enum MenusStatus {
    LOGINMENU(String[])

    {
        show {
        System.out.println("Chose oper 1...2");
        new LoginMunu.answerHanler();
    }
    }

    USER {
        show {
            System.out.println("Chose oper 1...2");
            new User.answerHanler();
        }
    }
}
