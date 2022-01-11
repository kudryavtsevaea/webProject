package com.netcracker.view;

public class LibrarySystem{

    public static void printMenu(){
        System.out.println(
                "Для Вас доступны следующие операции:\n"+
                "1.  Просмотреть все выданные книги;\n" +
                "2.  Просмотреть все книги в библиотеке;\n" +
                "3.  Взять книгу;\n" +
                "4.  Вернуть книгу;\n" +
                "5.  Найти книгу по регулярному выражению;\n" +
                "6.  Добавить книгу;\n" +
                "7.  Добавить список книг из файла;\n" +
                "8.  Удалить книгу;\n" +
                "9.  Добавить пользователя;\n" +
                "10. Удалить пользователя;\n" +
                "11. Редактировать имя пользователя;\n" +
                "q.  Выход.\n");
        System.out.print("Выберете операцию : ");
    }

    public static void backToMenu(){
        System.out.println("<- Назад         Выход(q)");
    }

    public static void authentication(){
        System.out.println("Добро пожаловать в библиотеку! \n" +
                "Авторизуйтесь.\n");
    }

}
