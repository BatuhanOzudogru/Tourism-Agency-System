package com.TourismAgencySystem.Helper;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {
    public static void setLayout() {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                         UnsupportedLookAndFeelException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }
    }

    public static int screenCenterLocation(String axis, Dimension size) {
        int point = 0;
        switch (axis) {
            case "x":
                point = (Toolkit.getDefaultToolkit().getScreenSize().width - size.width) / 2;
                break;
            case "y":
                point = (Toolkit.getDefaultToolkit().getScreenSize().height - size.height) / 2;
                break;
            default:
                point = 0;
        }
        return point;
    }

    public static boolean isFieldEmpty(JTextField field) {
        return field.getText().trim().isEmpty();
    }

    public static boolean isFieldEmpty(JTextArea area) {
        return area.getText().trim().isEmpty();
    }

    public static void showMessage(String str) {
        optionPage();
        String msg;
        String title;
        switch (str) {
            case "fill":
                msg = "Please fill all areas ! ";
                title = "Error !";
                break;
            case "done":
                msg = "The operation is successful";
                title = "Notification";
                break;
            case "error":
                msg = "An error has occurred";
                title = "Error";
                break;
            default:
                msg = str;
                title = "Massage";
        }
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void optionPage() {
        UIManager.put("OptionPane.okButtonText", "Okay");
        UIManager.put("OptionPane.yesButtonText", "YES");
        UIManager.put("OptionPane.noButtonText", "NO");
    }

    public static boolean confirm(String str) {
        String msg;
        switch (str) {
            case "sure":
                msg = "Are you sure ?";
                break;
            default:
                msg = str;
        }
        return JOptionPane.showConfirmDialog(null, msg, "Sure", JOptionPane.YES_NO_OPTION) == 0;
    }

    public static void resetFormFields(JTextField... fields) {
        for (JTextField field : fields) {
            field.setText(null);
        }
    }

    public static void resetCheckBoxes(JCheckBox... checkboxes) {
        for (JCheckBox checkbox : checkboxes) {
            checkbox.setSelected(false);
        }
    }

    public static void resetTextFields(JTextField... dateFields) {
        for (JTextField field : dateFields) {
            field.setText(null);
            field.setEnabled(false);
            field.setEditable(false);
        }
    }

    public static void resetRadioButtons(JRadioButton... radioButtons) {
        for (JRadioButton radioButton : radioButtons) {
            radioButton.setSelected(false);
        }
    }

    public static void enableTextFields(JTextField... dateFields) {
        for (JTextField field : dateFields) {
            field.setEnabled(true);
            field.setEditable(true);
        }
    }

    public static void enableComboBoxes(JComboBox... comboBoxes) {
        for (JComboBox box : comboBoxes) {
            box.setEnabled(true);
        }
    }

    public static void resetComboBoxes(JComboBox... comboBoxes) {
        for (JComboBox box : comboBoxes) {
            box.setEnabled(false);
            box.setSelectedIndex(0);
        }
    }

    public static java.sql.Date stringToDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date utilDate = dateFormat.parse(dateString);
            return new java.sql.Date(utilDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}