package com.netcracker.lesson;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        List<Verbs> verbs = new ArrayList<>();
        long id = 1;
        try (Scanner sc = new Scanner(new File
                ("E:\\NetCracker2021\\jdbсExample\\src\\main\\java\\com\\netcracker\\lesson\\verbs.csv"),
                String.valueOf(StandardCharsets.UTF_8))) {
            while (sc.hasNextLine()) {
                String s = sc.nextLine();
                String[] split = s.split(";");
                Verbs verb = new Verbs(id,
                        split[0], split[1], split[2], split[3]);
                verbs.add(verb);
                id++;
            }
        } catch (IOException ex) {
            System.out.println("Файл не найден!");
        }

        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:testa")) {
            connection.setAutoCommit(false);

            PreparedStatement create = connection.prepareStatement(CREATE_TABLE);
            create.execute();

            for(Verbs v : verbs){
                applyQuery(v, connection);
            }

            PreparedStatement selectStatement = connection.prepareStatement("select RUS_NAME from VERBS");
            ResultSet resultSet1 = selectStatement.executeQuery();
            while (resultSet1.next()) {
                    System.out.println(resultSet1.getString(1));
                }
            System.out.println();
            PreparedStatement selectStatement1 = connection.prepareStatement("select RUS_NAME from VERBS " +
                    "WHERE ID > 50 AND ID < 60");
            ResultSet resultSet2 = selectStatement1.executeQuery();
            while (resultSet2.next()) {
                System.out.println(resultSet2.getString(1));
            }
            connection.commit();
        }
    }

    public static void applyQuery (Verbs verb, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_VERB);
        preparedStatement.setLong(1, verb.getId());
        preparedStatement.setString(2, verb.getPresentSimple());
        preparedStatement.setString(3, verb.getPastSimple());
        preparedStatement.setString(4, verb.getPerfectSimple());
        preparedStatement.setString(5, verb.getRusName());
        preparedStatement.execute();
    }


    public static final String INSERT_VERB = "insert into VERBS " +
            "(\"ID\",\"INFINITIVE\",\"PAST_SIMPLE\", \"PAST_PARTICIPLE\"," +
            "\"RUS_NAME\")  values (?,?,?,?,?)";

public static final String CREATE_TABLE = "CREATE TABLE \"VERBS\" (\n" +
        "\tid int NOT NULL,\n" +
        "\tINFINITIVE varchar (12) NOT NULL,\n" +
        "\tPAST_SIMPLE varchar,\n" +
        "\tPAST_PARTICIPLE varchar,\n" +
        " \tRUS_NAME varchar,\n" +
        " \tPRIMARY KEY (id),\n" +
        " \tunique (INFINITIVE)\n" +
        ")";
}
