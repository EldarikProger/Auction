package com.egar.auction.client.console.userConsole;

import com.egar.auction.exceptions.UserException;
import com.egar.auction.model.AuthorizedUser;
import com.egar.auction.model.Category;
import com.egar.auction.model.Good;
import com.egar.auction.model.requests.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * User ActionConsole is the action user
 *
 * @author Eldar Ziatdinov
 * @version 1.0
 */
public class UserActionConsole {

    private BufferedReader br;
    private AuthorizedUser myUser;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    /**
     * Create UserActionConsole for presentation it actions
     *
     * @param in  read data from server
     * @param out send request to server
     * @param br  to input data
     */
    public UserActionConsole(BufferedReader br, AuthorizedUser user,
                             ObjectInputStream in, ObjectOutputStream out) {
        this.br = br;
        this.myUser = user;
        this.out = out;
        this.in = in;
    }

    /**
     * Method print list their goods
     */
    public void viewListUserGoods() {
        try {
            out.writeObject(new ViewUserListOfGoods(myUser));
            List list = (List) in.readObject();
            printList(list);
        } catch (ClassNotFoundException | IOException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Method print list their bids
     */
    public void viewListUserBids() {
        try {
            out.writeObject(new ViewUserListOfBids(myUser));
            List list = (List) in.readObject();
            printList(list);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method print list all goods
     */
    public void viewAllGoodsByCategory() {
        try {
            out.writeObject(new ViewListCategory());
            List listCategory = (List) in.readObject();
            Category category = selectCategory(listCategory);
            out.writeObject(new ViewAllGoods(category));
            List listGoods = (List) in.readObject();
            printList(listGoods);
        } catch (UserException | IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method print list all bids
     */
    public void viewAllBidsByGood() {
        try {
            out.writeObject(new ViewListCategory());
            List listCategory = (List) in.readObject();
            Category category = selectCategory(listCategory);
            out.writeObject(new ViewAllGoods(category));
            List listGoods = (List) in.readObject();
            Good good = selectGood(listGoods);
            out.writeObject(new ViewAllBids(good));
            List listBids = (List) in.readObject();
            printList(listBids);
        } catch (UserException | IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method add good to user
     */
    public void addGood() {
        String nameGood, description;
        double minPrice, maxPrice, length, width, height, weight;
        int day, hour, minutes, count;
        while (true) {
            try {
                System.out.println();
                System.out.println("Введите название товара: ");
                nameGood = br.readLine();
                System.out.println("Введите описание товара: ");
                description = br.readLine();
                System.out.println("Введите min цену: ");
                minPrice = Double.parseDouble(br.readLine());
                System.out.println("Введите max цену: ");
                maxPrice = Double.parseDouble(br.readLine());
                System.out.println("Сколько дней, часов и минут длится аукцион для товара: ");
                day = Integer.parseInt(br.readLine());
                hour = Integer.parseInt(br.readLine());
                minutes = Integer.parseInt(br.readLine());
                System.out.println("Введите длину, ширину, высоту товара: ");
                length = Double.parseDouble(br.readLine());
                width = Double.parseDouble(br.readLine());
                height = Double.parseDouble(br.readLine());
                System.out.println("Введите массу товара: ");
                weight = Double.parseDouble(br.readLine());
                System.out.println("Введите количество вашего товара: ");
                count = Integer.parseInt(br.readLine());
                break;
            } catch (IOException | NumberFormatException e) {
                System.out.println("Неккоректный ввод данных, введите заново:");
            }
        }

        try {
            out.writeObject(new ViewListCategory());
            List listCategory = (List) in.readObject();
            Category category = selectCategory(listCategory);
            out.writeObject(new AddGood(category, nameGood, description, minPrice, count, day, hour, minutes, maxPrice,
                    myUser, weight, length, width, height));
            boolean check = (boolean) in.readObject();
            if (check)
                System.out.println("Товар добавлен!");
            else
                System.out.println("Ошибка сервера при добавлении товара, попробуйте позже!");
        } catch (UserException | IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method make bet (add bid to user)
     */
    public void makeBet() {
        try {
            out.writeObject(new ViewListCategory());
            List listCategory = (List) in.readObject();
            Category category = selectCategory(listCategory);
            out.writeObject(new ViewAllGoods(category));
            List listGoods = (List) in.readObject();
            Good good = selectGood(listGoods);
            System.out.println();
            System.out.println("Введите цену(ставку): ");
            double price;
            while (true) {
                try {
                    price = Double.parseDouble(br.readLine());
                    break;
                } catch (IOException | NumberFormatException e) {
                    System.out.println("Вы ввели не корректные данные, введите число заново");
                }
            }
            out.writeObject(new MakeBet(price, good, myUser));
            boolean check = (boolean) in.readObject();
            if (check)
                System.out.println("Ставка сделана!");
            else
                System.out.println("Ошибка сервера при добавлении ставки, попробуйте позже!");
        } catch (UserException | ClassNotFoundException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method change user data
     */
    public void changeUserData() {
        try {
            System.out.println();
            System.out.println("Введите имя:");
            String name = br.readLine();
            System.out.println("Введите пароль:");
            String password = br.readLine();
            out.writeObject(new ChangeUserData(name, password, myUser));
            myUser = (AuthorizedUser) in.readObject();
            System.out.println("Данные изменены!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    public void addUserCoordinate() {
        try {
            System.out.println("Введите широту и долготу: ");
            System.out.println("Введите градусы, минуты, секунды широты: ");
            double degreesA = Double.parseDouble(br.readLine());
            double minutesA = Double.parseDouble(br.readLine());
            double secondsA = Double.parseDouble(br.readLine());
            System.out.println("Введите градусы, минуты, секунды долготы: ");
            double degreesB = Double.parseDouble(br.readLine());
            double minutesB = Double.parseDouble(br.readLine());
            double secondsB = Double.parseDouble(br.readLine());
            out.writeObject(new SetUserCoordinates(myUser, degreesA, minutesA, secondsA, degreesB, minutesB, secondsB));
            myUser = (AuthorizedUser) in.readObject();
            System.out.println("Координаты добавлены/изменены!");
        } catch (NumberFormatException e) {
            System.out.println("Вы ввели некоректные данные!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при передаче или получении данных!");
        }
    }

    /**
     * exit
     */
    public void exit(){
        try {
            out.writeObject(new Exit());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private Good selectGood(List<Good> list) throws UserException {
        System.out.println();
        if (list.size() != 0) {
            System.out.println("Выберите товар:");
            int i = 1;
            for (Good c : list) {
                System.out.println((i++) + ") " + c.toString());
            }
            int j;
            while (true) {
                try {
                    j = Integer.parseInt(br.readLine());
                    break;
                } catch (IOException | NumberFormatException e) {
                    System.out.println("Вы ввели не число, введите число заново");
                }
            }
            if (j <= 0 || j > list.size())
                throw new UserException("Вы выбрали не существующую товар!");
            return list.get(j - 1);
        } else
            throw new UserException("Список товаров пуст!");
    }

    private Category selectCategory(List<Category> list) throws UserException {
        System.out.println();
        System.out.println("Выберите категорию:");
        int i = 1;
        for (Category c : list) {
            System.out.println((i++) + ") " + c.getName());
        }
        int j;
        while (true) {
            try {
                j = Integer.parseInt(br.readLine());
                break;
            } catch (IOException | NumberFormatException e) {
                System.out.println("Вы ввели не число, введите число заново");
            }
        }
        if (j <= 0 || j > list.size())
            throw new UserException("Вы выбрали не существующую категорию!");
        return list.get(j - 1);
    }

    private void printList(List list) {
        System.out.println();
        if (list.size() == 0)
            System.out.println("Список пуст!");
        int i = 1;
        for (Object obj : list) {
            System.out.println((i++) + ") " + obj.toString());
        }
    }
}
