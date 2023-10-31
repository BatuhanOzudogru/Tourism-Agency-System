package com.TourismAgencySystem.View;

import com.TourismAgencySystem.Helper.Config;
import com.TourismAgencySystem.Helper.Helper;
import com.TourismAgencySystem.Model.Admin;
import com.TourismAgencySystem.Model.AdminOp;
import com.TourismAgencySystem.Model.User;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

public class AdminGUI extends JFrame {
    private JPanel wrapper;
    private JLabel labelAdminWelcome;
    private JButton buttonExit;
    private JTable tableUserList;
    private JTextField fieldUserFullName;
    private JTextField fieldUserUsername;
    private JTextField fieldUserPassword;
    private JComboBox comboUserType;
    private JTextField fieldUserId;
    private JButton buttonDelete;
    private JButton buttonAddUser;
    private JTextField fieldSearchUserFullName;
    private JTextField fieldSearchUserUsername;
    private JButton buttonSearch;
    private JComboBox comboSearchUserType;
    private DefaultTableModel modelUserList;
    private Object[] rowUserList;
    private final Admin admin;

    public AdminGUI(Admin admin) {
        this.admin = admin;
        add(wrapper);
        setSize(1000, 500);
        int x = Helper.screenCenterLocation("x", getSize());
        int y = Helper.screenCenterLocation("y", getSize());
        setLocation(x, y);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);
        labelAdminWelcome.setText("Welcome"+ admin.getName());
        fieldUserId.setVisible(false);

        modelUserList = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0 || column == 4) {
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };


        Object[] colUserList = {"ID", "Name Surname", "Username", "Password", "Type"};
        modelUserList.setColumnIdentifiers(colUserList);
        rowUserList = new Object[colUserList.length];

        loadUserModel();

        tableUserList.setModel(modelUserList);
        tableUserList.getTableHeader().setReorderingAllowed(false);

        tableUserList.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    String selectUserId = tableUserList.getValueAt(tableUserList.getSelectedRow(), 0).toString();
                    fieldUserId.setText(selectUserId);
                } catch (Exception exception) {

                }
            }
        });

        tableUserList.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    int userId = Integer.parseInt(tableUserList.getValueAt(tableUserList.getSelectedRow(), 0).toString());
                    String userName = tableUserList.getValueAt(tableUserList.getSelectedRow(), 1).toString();
                    String userUsername = tableUserList.getValueAt(tableUserList.getSelectedRow(), 2).toString();
                    String userPassword = tableUserList.getValueAt(tableUserList.getSelectedRow(), 3).toString();
                    String userType = tableUserList.getValueAt(tableUserList.getSelectedRow(), 4).toString();

                    if (AdminOp.update(userId, userName, userUsername, userPassword, userType)) {
                        Helper.showMessage("done");
                    }
                    loadUserModel();
                }
            }
        });


        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginGUI loginGUI = new LoginGUI();
            }
        });
        buttonAddUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (Helper.isFieldEmpty(fieldUserFullName) || Helper.isFieldEmpty(fieldUserUsername) || Helper.isFieldEmpty(fieldUserPassword)) {
                    Helper.showMessage("fill");
                } else {
                    String name = fieldUserFullName.getText();
                    String username = fieldUserUsername.getText();
                    String pass = fieldUserPassword.getText();
                    String type = comboUserType.getSelectedItem().toString();
                    if (AdminOp.add(name, username, pass, type)) {
                        Helper.showMessage("done");
                        loadUserModel();
                        fieldUserFullName.setText(null);
                        fieldUserUsername.setText(null);
                        fieldUserPassword.setText(null);
                    }
                }

            }
        });
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Helper.isFieldEmpty(fieldUserId)) {
                    Helper.showMessage("fill");
                } else {
                    if (Helper.confirm("sure")) {
                        int userId = Integer.parseInt(tableUserList.getValueAt(tableUserList.getSelectedRow(), 0).toString());
                        if (AdminOp.delete(userId)) {
                            Helper.showMessage("done");
                            loadUserModel();
                           fieldUserId.setText(null);
                        } else {
                            Helper.showMessage("error");
                        }
                    }
                }
            }
        });
        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = fieldSearchUserFullName.getText();
                String username= fieldSearchUserUsername.getText();
                String type= comboSearchUserType.getSelectedItem().toString();
                String query=AdminOp.searchQuery(name,username,type);
                ArrayList<User> searchUser = AdminOp.searchUserList(query);
                loadUserModel(searchUser);
            }
        });
    }

    public void loadUserModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tableUserList.getModel();
        clearModel.setRowCount(0);
        int i;
        for (User obj : AdminOp.getList()) {
            i = 0;
            rowUserList[i++] = obj.getId();
            rowUserList[i++] = obj.getName();
            rowUserList[i++] = obj.getUsername();
            rowUserList[i++] = obj.getPassword();
            rowUserList[i++] = obj.getType();
            modelUserList.addRow(rowUserList);
        }

    }
    public void loadUserModel(ArrayList<User> list) {
        DefaultTableModel clearModel = (DefaultTableModel) tableUserList.getModel();
        clearModel.setRowCount(0);
        for (User obj : list) {
            int i = 0;
            rowUserList[i++] = obj.getId();
            rowUserList[i++] = obj.getName();
            rowUserList[i++] = obj.getUsername();
            rowUserList[i++] = obj.getPassword();
            rowUserList[i++] = obj.getType();
            modelUserList.addRow(rowUserList);
        }
    }

    public static void main(String[] args) {
        Admin a = new Admin();
        AdminGUI aa = new AdminGUI(a);
    }
}
