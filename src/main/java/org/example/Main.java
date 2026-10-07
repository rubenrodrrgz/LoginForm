package org.example;


import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    static void main() {
        JFrame ventana = new JFrame("Login Form");

        LoginForm form = new LoginForm();

        ventana.setContentPane(form.getPanelPrincipal());

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ventana.pack();

        ventana.setLocationRelativeTo(null);

        ventana.setVisible(true);
    }
}
