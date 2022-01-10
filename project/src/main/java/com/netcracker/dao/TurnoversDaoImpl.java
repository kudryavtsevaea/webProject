package com.netcracker.dao;

import com.netcracker.models.Book;
import com.netcracker.models.Reader;
import com.netcracker.models.Turnover;
import com.netcracker.services.DataManagerService;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TurnoversDaoImpl implements TurnoversDao {

    @Override
    public List<Turnover> getAllBooksOnHnd() {
        List<Turnover> turnovers = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DataManagerService.getInstance()
                    .getConnection().prepareStatement("select * from book_turnover_with_info2");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Reader reader = new Reader(resultSet.getString(1));
                Book book = new Book(resultSet.getLong(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getInt(5),
                        resultSet.getInt(6));
                book.setHandedOut(resultSet.getBoolean(8));

                turnovers.add(new Turnover(reader, book, resultSet.getDate(7)));
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при загрузке выданных книг.");
        }
        return turnovers;
    }

    @Override
    public boolean getBook(String name) {
        try {
            CallableStatement stmt = DataManagerService.getConnection().prepareCall
                    ("update book_turnover_with_info2 set is_handed_out = ? where book_name = ?");
            stmt.setBoolean(1, true);
            stmt.setString(2,name);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Ошибка при выдаче книги.");
        }
        return false;
    }

    @Override
    public boolean returnBook(long id) {
        try {
            CallableStatement stmt = DataManagerService.getConnection().prepareCall
                    ("update book_turnover_with_info2 set is_handed_out = ? where inventory_number = ?");
            stmt.setBoolean(1, false);
            stmt.setLong(2, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Ошибка при возврате книги.");
        }
        return false;
    }
}