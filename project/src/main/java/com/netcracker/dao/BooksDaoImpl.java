package com.netcracker.dao;

import com.netcracker.models.Book;
import com.netcracker.services.DataManagerService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BooksDaoImpl implements BooksDao{
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
            System.out.println("Ошибка при загрузке книг.");
        }
        return books;
    }

    @Override
    public Book getBookById(long id) {
        List<Book> books = getAllBooks();
        for (Book b : books) {
            if (b.getId() == id){
                return b;
            }
        }
        return null;
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
                System.out.println("Нет подходящих книг.");
            }
        }
        catch (IllegalArgumentException e){
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
            System.out.println("Ошибка добавления книги.");
        }
        return false;
    }

    @Override
    public boolean deleteBook(Book book) {
        for (Book b : getAllBooks()) {
            if (b == book) {
                try {
                    CallableStatement stmt = DataManagerService.getConnection().prepareCall
                            ("delete * from book where book_name = ?");
                    stmt.setString(1, b.getBookName());
                    stmt.executeUpdate();
                } catch (SQLException e) {
                    System.out.println("Ошибка при удалении книги.");
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Book> addFromFile(String path) {
        List<Book> books = new ArrayList<>();
        books.addAll(getAllBooks());
        try(Scanner sc = new Scanner(new File(path))){
            while(sc.hasNextLine()){
                String s = sc.nextLine();
                String[] str = s.split(";");
                Book book = new Book(Integer.parseInt(str[0]), str[1], str[2], Integer.parseInt(str[3]),
                        Integer.parseInt(str[4]));
                books.add(book);
            }
        }
        catch(FileNotFoundException e2){
            System.out.println("Файл не найден.");
        }
        catch(IOException e1){
            System.out.println("Введена некорректная информация!");
        }
        return books;
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
            System.out.println("Ошибка при редактировании книги.");
        }
        return false;
    }
}
