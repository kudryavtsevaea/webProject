package com.netcracker.dao;

import com.netcracker.models.Book;
import com.netcracker.services.DataManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BooksDaoImpl implements BooksDao{
    private static final Logger log = LoggerFactory.getLogger(BooksDaoImpl.class);

    @Override
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DataManagerService.getInstance()
                    .getConnection().prepareStatement("select * from book");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                books.add(new Book(resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getInt(4),
                        resultSet.getInt(5)));
            }
        }
        catch(SQLException e){
            log.error("Ошибка при загрузке книг в классе BooksDaoImpl.");
        }
        return books;
    }

    @Override
    public List<Book> getBookByRegex(String reg) {
        List<Book> books = getAllBooks();
        try {
            Pattern pattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);
            boolean flag = false;
            for (Book w : books) {
                Matcher matcher = pattern.matcher(w.getNameOfBook());
                if (matcher.find()) {
                    System.out.println(w);
                    flag = true;
                }
            }
            if (!flag) {
                log.info("Не найдено подходящих книг.");
                System.out.println("Нет подходящих книг.");
            }
        }
        catch (IllegalArgumentException e){
            log.info("Некорректно введено регулярное выражение.");
            System.out.println("Некорректно введено регулярное выражение.");
        }
        return books;
    }

    @Override
    public boolean addBook(Book book) {
        try{
            CallableStatement stmt = DataManagerService.getConnection().prepareCall
                    ("insert into book(author, book_name, year_of_publishing, " +
                            "amount_of_pages, is_handed_out) values (?,?,?,?,?)");
            stmt.setString(1,book.getAuthor());
            stmt.setString(2,book.getNameOfBook());
            stmt.setInt(3,book.getYearOfPublishing());
            stmt.setInt(4,book.getAmountOfPages());
            stmt.setBoolean(5,book.isHandedOut());

            stmt.executeUpdate();

            return true;
        }
        catch (SQLException e){
            log.error("Ошибка добавления книги в классе BooksDaoImpl.");
        }
        return false;
    }

    @Override
    public boolean deleteBook(Book book) {
        for (Book b : getAllBooks()) {
            if (b.equals(book)) {
                System.out.println("equals");
                try {
                    CallableStatement stmt = DataManagerService.getConnection().prepareCall
                            ("delete from book where inventory_number = ?");
                    stmt.setLong(1, b.getId());
                    stmt.executeUpdate();
                } catch (SQLException e) {
                    log.error("Ошибка при удалении книги в классе BooksDaoImpl.");
                }
                log.info("Книга {} удалена", b.getBookName());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addFromFile(String path) {
        try(Scanner sc = new Scanner(new File(path))){
            while(sc.hasNextLine()) {
                String s = sc.nextLine();
                String[] str = s.split(";");
                Book book = new Book(Integer.parseInt(str[0]), str[1], str[2], Integer.parseInt(str[3]),
                        Integer.parseInt(str[4]));
                   addBook(book);
            }
            return true;
        }
        catch(FileNotFoundException e2){
            log.info("Файл не найден.");
           // System.out.println("Файл не найден.");
        }
        catch(IOException e1){
            log.info("Заданный путь не верный.");
            //System.out.println("Введена некорректная информация.");
        }

        return false;
    }

    @Override
    public boolean updateBook(Book oldBook, Book newBook) {
        try{
            CallableStatement stmt = DataManagerService.getConnection().prepareCall
                    ("update book set bookName = ? where inventory_number = ?");
            stmt.setString(1,oldBook.getBookName());
            stmt.setLong(2,newBook.getId());
            stmt.executeUpdate();
            return true;
        }
        catch (SQLException e){
            log.error("Ошибка при редактировании книги в классе BooksDaoImpl.");
        }
        return false;
    }
}
