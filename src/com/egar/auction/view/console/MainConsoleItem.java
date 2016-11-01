package com.egar.auction.view.console;


import java.util.Scanner;

public class MainConsoleItem {
    private Scanner scanner;


    public MainConsoleItem(){
        scanner = new Scanner(System.in);
        show();
    }

    private void show(){
        boolean runFlag = true;
        while (runFlag) {
            switch (mainMenu()) {
                case 1:
                    //MenuCreateUser
                    break;
                case 2: //TODO add menus actions!

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    ;
                case 6:

                    break;
                case 7:

                    break;
                case 8:
                    runFlag = false;
                    break;
                default:
                    System.out.println("Вы выбрали несуществующий вариант!");
            }
        }
    }

    private int mainMenu() {
        System.out.println();
        System.out.println("Выберите одно из действий");
        System.out.println("1) Создать пользователя");
        System.out.println("2) Создать администратора");
        System.out.println("3) Войти под пользователем");
        System.out.println("4) Войти гостем");
        System.out.println("5) Войти администратором");
        System.out.println("6) Удалить пользователя");
        System.out.println("7) Удалить администратора");
        System.out.println("8) Выход");
        return scanner.nextInt();
    }
}
