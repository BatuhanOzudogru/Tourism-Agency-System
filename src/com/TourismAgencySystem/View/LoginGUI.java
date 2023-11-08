package com.TourismAgencySystem.View;

import com.TourismAgencySystem.Helper.Config;
import com.TourismAgencySystem.Helper.Helper;
import com.TourismAgencySystem.Model.Admin;
import com.TourismAgencySystem.Model.Employee;
import com.TourismAgencySystem.Model.User;
import com.TourismAgencySystem.Model.UserOp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginGUI extends JFrame {
    private JPanel wrapper;
    private JPanel wtop;
    private JPanel wbottom;
    private JTextField fieldUsername;
    private JPasswordField fieldPassword;
    private JButton buttonLogin;
    private JCheckBox checkBoxShowPass;

    public LoginGUI() {
        add(wrapper);
        setSize(400, 400);
        setLocation(Helper.screenCenterLocation("x", getSize()), Helper.screenCenterLocation("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);
        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Helper.isFieldEmpty(fieldUsername) || Helper.isFieldEmpty(fieldPassword)) {
                    Helper.showMessage("fill");
                } else {
                    User u = UserOp.getFetch(fieldUsername.getText(), fieldPassword.getText());
                    if (u == null) {
                        Helper.showMessage("User not found !");
                    } else {
                        switch (u.getType()) {
                            case "admin":
                                AdminGUI adminGUI = new AdminGUI((Admin) u);
                                break;
                            case "employee":
                                EmployeeGUI employeeGUI = new EmployeeGUI((Employee) u);
                                break;

                        }
                        dispose();
                    }
                }
            }
        });
        fieldUsername.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (Helper.isFieldEmpty(fieldUsername) || Helper.isFieldEmpty(fieldPassword)) {
                        Helper.showMessage("fill");
                    } else {
                        User u = UserOp.getFetch(fieldUsername.getText(), fieldPassword.getText());
                        if (u == null) {
                            Helper.showMessage("User not found !");
                        } else {
                            switch (u.getType()) {
                                case "admin":
                                    AdminGUI adminGUI = new AdminGUI((Admin) u);
                                    break;
                                case "employee":
                                    EmployeeGUI employeeGUI = new EmployeeGUI((Employee) u);
                                    break;

                            }
                            dispose();
                        }
                    }
                }
            }
        });
        fieldPassword.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);


                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (Helper.isFieldEmpty(fieldUsername) || Helper.isFieldEmpty(fieldPassword)) {
                        Helper.showMessage("fill");
                    } else {
                        User u = UserOp.getFetch(fieldUsername.getText(), fieldPassword.getText());
                        if (u == null) {
                            Helper.showMessage("User not found !");
                        } else {
                            switch (u.getType()) {
                                case "admin":
                                    AdminGUI adminGUI = new AdminGUI((Admin) u);
                                    break;
                                case "employee":
                                    EmployeeGUI employeeGUI = new EmployeeGUI((Employee) u);
                                    break;

                            }
                            dispose();
                        }
                    }
                }

            }
        });

        checkBoxShowPass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBoxShowPass.isSelected()) {
                    fieldPassword.setEchoChar((char) 0);
                } else {
                    fieldPassword.setEchoChar('*');
                }
            }
        });
    }

    public static void main(String[] args) {
        Helper.setLayout();
        LoginGUI loginGUI = new LoginGUI();
    }
}
