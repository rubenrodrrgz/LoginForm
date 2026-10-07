package org.example;

import javax.swing.*;
import java.sql.*;

public class UserDAO {

    private static final String URL =
            "jdbc:mysql://localhost:3306/empresa";
    private static final String user = "user";
    private static final String password = "1234";

    public UserDAO(){}

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, user, password);
    }

    public LoginResult autenticarUser(JTextField user, JTextField password) {
        String sql = "Select username From usuarios where username = ?";
        String sql2 = "Select PASSWORD From usuarios where PASSWORD = ?";

        String usuario = user.getText().trim();
        String pass = password.getText().trim();

        System.out.println("Texto introducido Usuario: " + usuario);
        System.out.println("Texto introducido Password: " + pass);

        try (Connection con = connect(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                return LoginResult.USER_NOT_FOUND;
            } else if (rs.next()) {
                String UsuarioDB = rs.getString("username");
                System.out.println("Usuario encontrado en BD: " + UsuarioDB);

                if (UsuarioDB.equals(usuario)) {

                    try (Connection con2 = connect(); PreparedStatement ps2 = con2.prepareStatement(sql2)) {
                        ps2.setString(1, pass);
                        ResultSet rs2 = ps2.executeQuery();


                        if (rs2.next()) {
                            String PasswordDB = rs2.getString("password");
                            System.out.println("Contraseña en BD para este usuario: " + PasswordDB);

                            if (PasswordDB.equals(pass)) {
                                System.out.println("Acceso concedido");
                                return LoginResult.SUCCESS;
                            }


                        }

                    }

                }

            }

        } catch (Exception e) {

            e.printStackTrace();


        }

        return LoginResult.WRONG_PASSWORD;
    }
}
