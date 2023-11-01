package com.TourismAgencySystem.View;

import com.TourismAgencySystem.Helper.Config;
import com.TourismAgencySystem.Helper.Helper;
import com.TourismAgencySystem.Model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeGUI extends JFrame {
    private JPanel wrapper;
    private JTabbedPane tabbedPane1;
    private JTabbedPane tabbedPane2;
    private JLabel labelWelcome;
    private JTabbedPane tabbedPane3;
    private JTabbedPane tabbedPane4;
    private JTable tableLogResReservationList;
    private JTable tableLogGuestGuestList;
    private JButton buttonHotelDelete;
    private JButton buttonHotelSelect;
    private JTable tableHotelHotelList;
    private JTextField fieldHotelName;
    private JTextField fieldHotelCity;
    private JTextField fieldHotelDistrict;
    private JTextField fieldHotelStar;
    private JTextField fieldHotelAddress;
    private JTextField fieldHotelMail;
    private JTextField fieldHotelPhone;
    private JCheckBox checkBoxParking;
    private JCheckBox checkBoxWifi;
    private JCheckBox checkBoxPool;
    private JCheckBox checkBoxGym;
    private JCheckBox checkBoxConcierge;
    private JCheckBox checkBoxSpa;
    private JCheckBox checkBoxRoomService;
    private JRadioButton radioButtonSeason;
    private JRadioButton radioButtonOffSeason;
    private JTextField fieldSeasonStartDate;
    private JTextField fieldOffSeasonStartDate;
    private JTextField fieldSeasonEndDate;
    private JTextField fieldOffSeasonEndDate;
    private JButton buttonHotelAdd;
    private JButton buttonHotelUpdate;
    private JPanel roomPanelTop;
    private JComboBox comboBoxRoomType;
    private JButton buttonRoomTypeSelect;
    private JButton buttonRoomTypeUpdate;
    private JButton buttonRoomTypeAdd;
    private JTextField fieldRoomTypeName;
    private JTextField fieldRoomStock;
    private JTextField fieldRoomBedCount;
    private JTextField fieldRoomSize;
    private JTextField fieldRoomTv;
    private JTextField fieldRoomMinibar;
    private JButton buttonDeletePrice;
    private JRadioButton radioButtonSingle;
    private JComboBox comboBoxPeriodSingle;
    private JComboBox comboBoxGuestTypeSingle;
    private JComboBox comboBoxHostelTypeSingle;
    private JTextField fieldPriceSingle;
    private JTextField fieldPriceDouble;
    private JTextField fieldPriceKingSuite;
    private JComboBox comboBoxHostelTypeDouble;
    private JComboBox comboBoxHostelTypeKingSuite;
    private JComboBox comboBoxGuestTypeDouble;
    private JComboBox comboBoxGuestTypeKingSuite;
    private JComboBox comboBoxPeriodDouble;
    private JComboBox comboBoxPeriodKingSuite;
    private JRadioButton radioButtonDouble;
    private JRadioButton radioButtonKingSuite;
    private JButton buttonAddSingle;
    private JButton buttonAddDouble;
    private JButton buttonAddKingSuite;
    private JTable tablePriceRoomList;
    private JTable tableSearchHotelList;
    private JButton buttonSearchSelect;
    private JButton buttonSearchSearch;
    private JTextField fieldSearchHotelCityDistrict;
    private JTextField fieldSearchStar;
    private JTextField fieldSearchChild;
    private JTextField fieldSearchAdult;
    private JTextField fieldSearchCheckin;
    private JTextField fieldSearchCheckout;
    private JTextField fieldHotelHotelCityDistrictSearch;
    private JTextField fieldHotelStarSearch;
    private JButton buttonHotelSearch;
    private JLabel labelHotelName;
    private JTextField fieldResDetailCity;
    private JTextField fieldResDetailDistrict;
    private JTextField fieldResDetailAddress;
    private JTextField fieldResDetailPhone;
    private JTextField fieldResDetailStar;
    private JCheckBox freeParkingCheckBox;
    private JCheckBox wiFiCheckBox;
    private JCheckBox swimmingPoolCheckBox;
    private JCheckBox fitnessCenterCheckBox;
    private JCheckBox conciergeCheckBox;
    private JCheckBox spaCheckBox;
    private JCheckBox a724RoomServicesCheckBox;
    private JTextField fieldResBed;
    private JTextField fieldResRoomSize;
    private JTextField fieldResTv;
    private JTextField fieldResMinibar;
    private JLabel labelResRoomType;
    private JTextField fieldResCheckin;
    private JTextField fieldResCheckout;
    private JLabel labelResAdult;
    private JLabel labelResChild;
    private JLabel labelResDuration;
    private JComboBox comboBoxResHostelType;
    private JButton buttonResHostelTypeSelect;
    private JTextField fieldResPrice;
    private JButton buttonResReserve;
    private JLabel labelGuestRoomType;
    private JLabel labelGuestBed;
    private JLabel labelGuestRoomSize;
    private JLabel labelGuestTv;
    private JLabel labelGuestMinibar;
    private JTextField fieldLogResHotelNameSearch;
    private JButton buttonLogResSearch;
    private JTextField fieldLogResCheckinSearch;
    private JTextField fieldLogResCheckout;
    private JTextField fieldLogResMinPriceSearch;
    private JTextField fieldLogResMaxPriceSearch;
    private JTextField fieldLogGuestResId;
    private JTextField fieldLogGuestFullname;
    private JTextField fieldLogGuestIdNumber;
    private JButton buttonLogGuestSearch;
    private DefaultTableModel modelHotelHotelList;
    private Object[] rowHotelHotelList;

    private Employee employee;
    public EmployeeGUI(Employee employee){
        this.employee = employee;
        add(wrapper);
        setSize(1000, 700);
        int x = Helper.screenCenterLocation("x", getSize());
        int y = Helper.screenCenterLocation("y", getSize());
        setLocation(x, y);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);

        modelHotelHotelList = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0 || column == 4) {
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };


        Object[] colHotelHotelList = {"ID", "Name", "City", "District","Star","E-Mail","Phone"};
        modelHotelHotelList.setColumnIdentifiers(colHotelHotelList);
        rowHotelHotelList = new Object[colHotelHotelList.length];

        loadHotelModel();

        tableHotelHotelList.setModel(modelHotelHotelList);
        tableHotelHotelList.getTableHeader().setReorderingAllowed(false);




        radioButtonSeason.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fieldSeasonStartDate.setEnabled(true);
                fieldSeasonStartDate.setEditable(true);
                fieldSeasonEndDate.setEnabled(true);
                fieldSeasonEndDate.setEditable(true);
                if(!radioButtonSeason.isSelected()){
                    fieldSeasonStartDate.setEnabled(false);
                    fieldSeasonStartDate.setEditable(false);
                    fieldSeasonEndDate.setEnabled(false);
                    fieldSeasonEndDate.setEditable(false);
                    fieldSeasonEndDate.setText(null);
                    fieldSeasonStartDate.setText(null);
                }

            }
        });
        radioButtonOffSeason.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fieldOffSeasonStartDate.setEnabled(true);
                fieldOffSeasonStartDate.setEditable(true);
                fieldOffSeasonEndDate.setEnabled(true);
                fieldOffSeasonEndDate.setEditable(true);
                if(!radioButtonOffSeason.isSelected()){
                    fieldOffSeasonStartDate.setEnabled(false);
                    fieldOffSeasonStartDate.setEditable(false);
                    fieldOffSeasonEndDate.setEnabled(false);
                    fieldOffSeasonEndDate.setEditable(false);
                    fieldOffSeasonEndDate.setText(null);
                    fieldOffSeasonStartDate.setText(null);
                }
            }
        });
        radioButtonSingle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            comboBoxPeriodSingle.setEnabled(true);
            comboBoxGuestTypeSingle.setEnabled(true);
            comboBoxHostelTypeSingle.setEnabled(true);
            fieldPriceSingle.setEnabled(true);
            fieldPriceSingle.setEditable(true);
            buttonAddSingle.setEnabled(true);
            if(!radioButtonSingle.isSelected()){
                comboBoxPeriodSingle.setEnabled(false);
                comboBoxGuestTypeSingle.setEnabled(false);
                comboBoxHostelTypeSingle.setEnabled(false);
                fieldPriceSingle.setEnabled(false);
                fieldPriceSingle.setEditable(false);
                buttonAddSingle.setEnabled(false);
                fieldPriceSingle.setText(null);
            }
            }
        });
        radioButtonDouble.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboBoxPeriodDouble.setEnabled(true);
                comboBoxGuestTypeDouble.setEnabled(true);
                comboBoxHostelTypeDouble.setEnabled(true);
                fieldPriceDouble.setEnabled(true);
                fieldPriceDouble.setEditable(true);
                buttonAddDouble.setEnabled(true);
                if(!radioButtonDouble.isSelected()){
                    comboBoxPeriodDouble.setEnabled(false);
                    comboBoxGuestTypeDouble.setEnabled(false);
                    comboBoxHostelTypeDouble.setEnabled(false);
                    fieldPriceDouble.setEnabled(false);
                    fieldPriceDouble.setEditable(false);
                    buttonAddDouble.setEnabled(false);
                    fieldPriceDouble.setText(null);
                }
            }
        });
        radioButtonKingSuite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboBoxPeriodKingSuite.setEnabled(true);
                comboBoxGuestTypeKingSuite.setEnabled(true);
                comboBoxHostelTypeKingSuite.setEnabled(true);
                fieldPriceKingSuite.setEnabled(true);
                fieldPriceKingSuite.setEditable(true);
                buttonAddKingSuite.setEnabled(true);
                if(!radioButtonKingSuite.isSelected()){
                    comboBoxPeriodKingSuite.setEnabled(false);
                    comboBoxGuestTypeKingSuite.setEnabled(false);
                    comboBoxHostelTypeKingSuite.setEnabled(false);
                    fieldPriceKingSuite.setEnabled(false);
                    fieldPriceKingSuite.setEditable(false);
                    buttonAddKingSuite.setEnabled(false);
                    fieldPriceKingSuite.setText(null);
                }
            }
        });
        buttonHotelAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((Helper.isFieldEmpty(fieldHotelName) || Helper.isFieldEmpty(fieldHotelCity)|| Helper.isFieldEmpty(fieldHotelAddress)|| Helper.isFieldEmpty(fieldHotelDistrict) ||
                        Helper.isFieldEmpty(fieldHotelMail)|| Helper.isFieldEmpty(fieldHotelPhone)|| Helper.isFieldEmpty(fieldHotelStar))||
                        ((!radioButtonOffSeason.isSelected())&&(!radioButtonSeason.isSelected()))) {
                    Helper.showMessage("fill");
                } else {
                    String name = fieldHotelName.getText();
                    String city = fieldHotelCity.getText();
                    String district = fieldHotelDistrict.getText();
                    String address = fieldHotelAddress.getText();
                    String mail = fieldHotelMail.getText();
                    String phone = fieldHotelPhone.getText();
                    String star = fieldHotelStar.getText();

                    String pool = "No";
                    String wifi = "No";
                    String parking = "No";
                    String gym = "No";
                    String concierge = "No";
                    String spa = "No";
                    String roomService = "No";
                    if (checkBoxPool.isSelected()) {
                        pool = "Yes";
                    }
                    if (checkBoxWifi.isSelected()) {
                        wifi = "Yes";
                    }
                    if (checkBoxParking.isSelected()) {
                        parking = "Yes";
                    }
                    if (checkBoxGym.isSelected()) {
                        gym = "Yes";
                    }
                    if (checkBoxConcierge.isSelected()) {
                        concierge = "Yes";
                    }
                    if (checkBoxSpa.isSelected()) {
                        spa = "Yes";
                    }
                    if (checkBoxRoomService.isSelected()) {
                        roomService = "Yes";
                    }


                    if (EmployeeOp.add(name, city, district, star, address, mail, phone, parking, wifi, pool, gym, concierge, spa, roomService)) {
                        Helper.showMessage("done");
                        loadHotelModel();

                        Helper.resetFormFields(fieldHotelName, fieldHotelCity, fieldHotelAddress, fieldHotelDistrict, fieldHotelMail, fieldHotelPhone, fieldHotelStar);
                        Helper.resetCheckBoxes(checkBoxPool, checkBoxWifi, checkBoxParking, checkBoxGym, checkBoxConcierge, checkBoxSpa, checkBoxRoomService);
                        Helper.resetDateFields(fieldSeasonStartDate, fieldSeasonEndDate, fieldOffSeasonStartDate, fieldOffSeasonEndDate);
                        Helper.resetRadioButtons(radioButtonSeason, radioButtonOffSeason);
                    }
                }
            }
        });
        buttonHotelUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((Helper.isFieldEmpty(fieldHotelName) || Helper.isFieldEmpty(fieldHotelCity) || Helper.isFieldEmpty(fieldHotelAddress) || Helper.isFieldEmpty(fieldHotelDistrict)
                        || Helper.isFieldEmpty(fieldHotelMail) || Helper.isFieldEmpty(fieldHotelPhone) || Helper.isFieldEmpty(fieldHotelStar)) || ((!radioButtonSeason.isSelected()) && (!radioButtonOffSeason.isSelected()))) {
                    Helper.showMessage("fill");
                } else {
                    int id = Integer.parseInt(tableHotelHotelList.getValueAt(tableHotelHotelList.getSelectedRow(), 0).toString());
                    String name = fieldHotelName.getText();
                    String city = fieldHotelCity.getText();
                    String address = fieldHotelAddress.getText();
                    String district = fieldHotelDistrict.getText();
                    String mail = fieldHotelMail.getText();
                    String phone = fieldHotelPhone.getText();
                    String star = fieldHotelStar.getText();

                    String pool = "No";
                    String wifi = "No";
                    String parking = "No";
                    String gym = "No";
                    String concierge = "No";
                    String spa = "No";
                    String roomService = "No";

                    if (checkBoxPool.isSelected()) {
                        pool = "Yes";
                    }
                    if (checkBoxWifi.isSelected()) {
                        wifi = "Yes";
                    }
                    if (checkBoxParking.isSelected()) {
                        parking = "Yes";
                    }
                    if (checkBoxGym.isSelected()) {
                        gym = "Yes";
                    }
                    if (checkBoxConcierge.isSelected()) {
                        concierge = "Yes";
                    }
                    if (checkBoxSpa.isSelected()) {
                        spa = "Yes";
                    }
                    if (checkBoxRoomService.isSelected()) {
                        roomService = "Yes";
                    }

                    if (EmployeeOp.update(id, name, city, district, star, address, mail, phone, parking, wifi, pool, gym, concierge, spa, roomService)) {
                        Helper.showMessage("done");
                        loadHotelModel();

                        Helper.resetFormFields(fieldHotelName, fieldHotelCity, fieldHotelAddress, fieldHotelDistrict, fieldHotelMail, fieldHotelPhone, fieldHotelStar);
                        Helper.resetCheckBoxes(checkBoxPool, checkBoxWifi, checkBoxParking, checkBoxGym, checkBoxConcierge, checkBoxSpa, checkBoxRoomService);
                        Helper.resetDateFields(fieldSeasonStartDate, fieldSeasonEndDate, fieldOffSeasonStartDate, fieldOffSeasonEndDate);
                        Helper.resetRadioButtons(radioButtonSeason, radioButtonOffSeason);
                    }
                }
            }
        });
    }
    public void loadHotelModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tableHotelHotelList.getModel();
        clearModel.setRowCount(0);
        int i;
        for (Hotel obj : EmployeeOp.getList()) {
            i = 0;
            rowHotelHotelList[i++] = obj.getId();
            rowHotelHotelList[i++] = obj.getName();
            rowHotelHotelList[i++] = obj.getCity();
            rowHotelHotelList[i++] = obj.getDistrict();
            rowHotelHotelList[i++] = obj.getStar();
            rowHotelHotelList[i++] = obj.getEmail();
            rowHotelHotelList[i++] = obj.getPhoneNumber();
            modelHotelHotelList.addRow(rowHotelHotelList);
        }

    }
}
