package com.TourismAgencySystem.Helper;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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

    public static boolean areFieldsEmpty(JTextField... field) {
        for (JTextField fields : field) {

           return fields.getText().trim().isEmpty();

        }
        return false;
    }
    //Değerlendirme Formu 19-20
    //Kullanıcıya başarılı işlemler için uygun pop up mesajları veriliyor mu?
    //Kullanıcıya hatalı işlemler için uygun hata mesajları veriliyor mu?
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
                title = "Error";
        }
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
    }
    public static boolean isValidDateFormat(String input) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);

        try {
            dateFormat.parse(input);
            return true;
        } catch (ParseException e) {
            return false;
        }
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
    public static void resetLabels(JLabel... labels) {
        for (JLabel label : labels) {
            label.setText(null);
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


    public static void visibleJLabel(JLabel... JLabels) {
        for (JLabel lbl : JLabels) {
            lbl.setVisible(true);
        }
    }
    public static void resetHideTextFields(JTextField... dateFields) {
        for (JTextField field : dateFields) {
            field.setText(null);
            field.setEnabled(false);
            field.setEditable(false);
            field.setVisible(false);
        }
    }

    public static void resetHideComboBoxes(JComboBox... comboBoxes) {
        for (JComboBox box : comboBoxes) {
            box.setSelectedIndex(0);
            box.setEnabled(false);
            box.setVisible(false);
        }
    }

    public static void showTextFields(JTextField... dateFields) {
        for (JTextField field : dateFields) {
            field.setEnabled(true);
            field.setEditable(true);
            field.setVisible(true);
        }
    }

    public static void showComboBoxes(JComboBox... comboBoxes) {
        for (JComboBox box : comboBoxes) {
            box.setEnabled(true);
            box.setVisible(true);
        }
    }

    public static void hiddenJLabel(JLabel... labels) {
        for (JLabel lbl : labels) {
            lbl.setVisible(false);
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


    public static int daysBetweenToDates(JTextField d1, JTextField d2) {
        LocalDate date1 = LocalDate.parse(d1.getText());
        LocalDate date2 = LocalDate.parse(d2.getText());
        int daysBetween = (int) ChronoUnit.DAYS.between(date1, date2);
        return daysBetween;
    }

    public static int resPrice(JTextField adultNumber, JTextField childNumber, int adultPrice, int childPrice, int duration) {

        int a = Integer.parseInt(adultNumber.getText());
        int b = Integer.parseInt(childNumber.getText());
        int totalAdultPrice = a * adultPrice;
        int totalChildPrice = b * childPrice;
        int totalPrice = totalChildPrice + totalAdultPrice;

        return totalPrice * duration;
    }

}