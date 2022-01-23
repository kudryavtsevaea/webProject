package com.netcracker.dao;

import com.netcracker.models.Book;
import com.netcracker.models.Library;
import com.netcracker.models.Reader;
import com.netcracker.models.Turnover;
import com.netcracker.services.DataManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TurnoversDaoImpl implements TurnoversDao {
    private static final Logger log = LoggerFactory.getLogger(TurnoversDaoImpl.class);

    @Override
    public List<Turnover> getAllBooksOnHnd() {
        List<Turnover> turnovers = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DataManagerService.getInstance()
                    .getConnection().prepareStatement("select * from book_turnover_with_info3");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getString(1) == Library.getInstance().currentReader.getName()){
                Reader reader = new Reader(resultSet.getLong(1), resultSet.getString(2));
                Book book = new Book(resultSet.getLong(3), resultSet.getString(4),
                        resultSet.getString(5), resultSet.getInt(6),
                        resultSet.getInt(7));
                book.setHandedOut(resultSet.getBoolean(9));

                turnovers.add(new Turnover(reader, book, resultSet.getDate(8)));
                }
            }
        } catch (SQLException e) {
            log.error("Ошибка при загрузке выданных книг.");
        }
        return turnovers;
    }

    @Override
    public boolean getBook(long id) {
        try {
            CallableStatement stmt = DataManagerService.getConnection().prepareCall
                    ("update book_turnover_with_info2 set is_handed_out = ? where inventory_number = ?");
            stmt.setBoolean(1, true);
            stmt.setLong(2, id);
            stmt.executeUpdate();
            System.out.println(".");
            return true;
        } catch (SQLException e) {
            log.error("Ошибка при выдаче книги.");
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
            log.error("Ошибка при возврате книги.");
        }
        return false;
    }
}