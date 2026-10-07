package org.example;

import javax.swing.*;

public class LoginForm {
    private JTextField txtUser;
    private JTextField txtPassword;
    private JButton btnLogin;
    private JButton btnCancel;
    private JLabel lblUser;
    private JLabel lblPassword;
    private JLabel lblFeedback;
    private JPanel PanelPrincipal;

    public LoginForm(){
        btnLogin.addActionListener(e -> {
            System.out.println("Boton pulsado");
            UserDAO dao = new UserDAO();
            dao.autenticarUser(txtUser, txtPassword);
        });
        btnCancel.addActionListener(e -> {
            System.exit(0);
        });
    }



    public JPanel getPanelPrincipal() {
        return PanelPrincipal;
    }


}
