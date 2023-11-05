package com.TourismAgencySystem.View;

import com.TourismAgencySystem.Helper.Config;
import com.TourismAgencySystem.Helper.Helper;
import com.TourismAgencySystem.Helper.Item;
import com.TourismAgencySystem.Model.*;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.Date;

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
    private JButton buttonRoomTypeNew;
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
    private JComboBox comboBoxHostelTypeSingle;
    private JTextField fieldChildPriceSingle;
    private JTextField fieldChildPriceDouble;
    private JTextField fieldChildPriceKingSuite;
    private JComboBox comboBoxHostelTypeDouble;
    private JComboBox comboBoxHostelTypeKingSuite;
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
    private JCheckBox roomServiceCheckBox;
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
    private JScrollPane scrollPaneHotelDetails;
    private JLabel labelRoomHotelName;
    private JButton buttonHotelClear;
    private JTextField fieldAdultPriceSingle;
    private JTextField fieldAdultPriceDouble;
    private JTextField fieldAdultPriceKingSuite;
    private DefaultTableModel modelHotelHotelList;
    private Object[] rowHotelHotelList;
    private DefaultTableModel modelPriceRoomList;
    private Object[] rowPriceRoomList;
    private DefaultTableModel modelSearchHotelList;
    private Object[] rowSearchHotelList;
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
        labelWelcome.setText("Welcome "+employee.getName());


        modelHotelHotelList = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0 || column == 1 || column == 2 || column == 3
                        || column == 4|| column == 5|| column == 6) {
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

        modelPriceRoomList = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0 || column == 1 || column == 2 || column == 3) {
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };

        Object[] colPriceRoomList = {"ID", "Period", "Room Type", "Hostel Type", "Adult Price", "Child Price"};
        modelPriceRoomList.setColumnIdentifiers(colPriceRoomList);
        rowPriceRoomList = new Object[colPriceRoomList.length];

        tablePriceRoomList.setModel(modelPriceRoomList);
        tablePriceRoomList.getTableHeader().setReorderingAllowed(false);
        tablePriceRoomList.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    int id = Integer.parseInt(tablePriceRoomList.getValueAt(tablePriceRoomList.getSelectedRow(), 0).toString());
                    int hotel_id = Integer.parseInt(tableHotelHotelList.getValueAt(tableHotelHotelList.getSelectedRow(), 0).toString());
                    int period_id = EmployeeOp.getFetchPeriodIdByName(tablePriceRoomList.getValueAt(tablePriceRoomList.getSelectedRow(), 1).toString()).getId();
                    int room_type_id = EmployeeOp.getFetchRoomType(tablePriceRoomList.getValueAt(tablePriceRoomList.getSelectedRow(), 2).toString()).getId();
                    int acco_id = EmployeeOp.getFetchAccoIdByName(tablePriceRoomList.getValueAt(tablePriceRoomList.getSelectedRow(), 3).toString()).getId();
                    int adult_price = Integer.parseInt(tablePriceRoomList.getValueAt(tablePriceRoomList.getSelectedRow(), 4).toString());
                    int child_price = Integer.parseInt(tablePriceRoomList.getValueAt(tablePriceRoomList.getSelectedRow(), 5).toString());

                    if (EmployeeOp.updateRoomPrice(id, hotel_id, period_id, room_type_id, acco_id, adult_price, child_price)) {
                        Helper.showMessage("done");
                    }
                    loadPriceRoomModel();
                }
            }
        });

        modelSearchHotelList = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0 || column == 1 || column == 2 || column == 3) {
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };

        Object[] colSearchHotelList = {"ID", "Hotel ID", "Hotel Name", "City", "District", "Star", "Period", "Start Date", "End Date", "Room Type","Stock"};
        modelSearchHotelList.setColumnIdentifiers(colSearchHotelList);
        rowSearchHotelList = new Object[colSearchHotelList.length];

        loadSalesRoomModel();

        tableSearchHotelList.setModel(modelSearchHotelList);
        tableSearchHotelList.getTableHeader().setReorderingAllowed(false);


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
                Helper.enableComboBoxes(comboBoxPeriodSingle, comboBoxHostelTypeSingle);
                Helper.enableTextFields(fieldAdultPriceSingle, fieldChildPriceSingle);
                buttonAddSingle.setEnabled(true);
                if (!radioButtonSingle.isSelected()) {
                    Helper.resetComboBoxes(comboBoxPeriodSingle, comboBoxHostelTypeSingle);
                    Helper.resetTextFields(fieldAdultPriceSingle, fieldChildPriceSingle);
                    buttonAddSingle.setEnabled(false);
                }
            }
        });
        radioButtonDouble.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Helper.enableComboBoxes(comboBoxPeriodDouble, comboBoxHostelTypeDouble);
                Helper.enableTextFields(fieldAdultPriceDouble, fieldChildPriceDouble);
                buttonAddDouble.setEnabled(true);

                if (!radioButtonDouble.isSelected()) {
                    Helper.resetComboBoxes(comboBoxPeriodDouble, comboBoxHostelTypeDouble);
                    Helper.resetTextFields(fieldAdultPriceDouble, fieldChildPriceDouble);
                    buttonAddDouble.setEnabled(false);
                }
            }
        });
        radioButtonKingSuite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Helper.enableComboBoxes(comboBoxPeriodKingSuite, comboBoxHostelTypeKingSuite);
                Helper.enableTextFields(fieldAdultPriceKingSuite, fieldChildPriceKingSuite);
                buttonAddKingSuite.setEnabled(true);

                if (!radioButtonKingSuite.isSelected()) {
                    Helper.resetComboBoxes(comboBoxPeriodKingSuite, comboBoxHostelTypeKingSuite);
                    Helper.resetTextFields(fieldAdultPriceKingSuite, fieldChildPriceKingSuite);
                    buttonAddKingSuite.setEnabled(false);
                }
            }
        });
        buttonHotelAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((Helper.isFieldEmpty(fieldHotelName) || Helper.isFieldEmpty(fieldHotelCity) || Helper.isFieldEmpty(fieldHotelAddress) || Helper.isFieldEmpty(fieldHotelDistrict)
                        || Helper.isFieldEmpty(fieldHotelMail) || Helper.isFieldEmpty(fieldHotelPhone) || Helper.isFieldEmpty(fieldHotelStar)) || ((!radioButtonSeason.isSelected()) && (!radioButtonOffSeason.isSelected()))) {
                    Helper.showMessage("fill");
                } else {
                    String name = fieldHotelName.getText();
                    String city = fieldHotelCity.getText();
                    String address = fieldHotelAddress.getText();
                    String district = fieldHotelDistrict.getText();
                    String mail = fieldHotelMail.getText();
                    String phone = fieldHotelPhone.getText();
                    String star = fieldHotelStar.getText();

                    String pool = "No"; String wifi = "No"; String parking = "No"; String gym = "No"; String concierge = "No"; String spa = "No"; String roomService = "No";

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
                    Date seasonStart = Helper.stringToDate(fieldSeasonStartDate.getText());
                    Date seasonEnd = Helper.stringToDate(fieldSeasonEndDate.getText());
                    Date offSeasonStart = Helper.stringToDate(fieldOffSeasonStartDate.getText());
                    Date offSeasonEnd = Helper.stringToDate(fieldOffSeasonEndDate.getText());

                    if (EmployeeOp.addHotelDetails(name, city, district, star, address, mail, phone, parking, wifi, pool, gym, concierge, spa, roomService)
                            && EmployeeOp.addHotelPeriodDetails(seasonStart,seasonEnd,offSeasonStart,offSeasonEnd)) {
                        Helper.showMessage("done");
                        loadHotelModel();

                        Helper.resetFormFields(fieldHotelName, fieldHotelCity, fieldHotelAddress, fieldHotelDistrict, fieldHotelMail, fieldHotelPhone, fieldHotelStar);
                        Helper.resetCheckBoxes(checkBoxPool, checkBoxWifi, checkBoxParking, checkBoxGym, checkBoxConcierge, checkBoxSpa, checkBoxRoomService);
                        Helper.resetTextFields(fieldSeasonStartDate, fieldSeasonEndDate, fieldOffSeasonStartDate, fieldOffSeasonEndDate);
                        Helper.resetRadioButtons(radioButtonSeason, radioButtonOffSeason);
                    }
                    scrollPaneHotelDetails.getVerticalScrollBar().setValue(0);
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
                    Date seasonStart = Helper.stringToDate(fieldSeasonStartDate.getText());
                    Date seasonEnd = Helper.stringToDate(fieldSeasonEndDate.getText());
                    Date offSeasonStart = Helper.stringToDate(fieldOffSeasonStartDate.getText());
                    Date offSeasonEnd = Helper.stringToDate(fieldOffSeasonEndDate.getText());

                    if (EmployeeOp.updateHotelDetails(id, name, city, district, star, address, mail, phone, parking, wifi, pool, gym, concierge, spa, roomService)&&
                            EmployeeOp.updateHotelPeriodDetails(id,seasonStart,seasonEnd,offSeasonStart,offSeasonEnd)) {
                        Helper.showMessage("done");
                        loadHotelModel();

                        Helper.resetFormFields(fieldHotelName, fieldHotelCity, fieldHotelAddress, fieldHotelDistrict, fieldHotelMail, fieldHotelPhone, fieldHotelStar);
                        Helper.resetCheckBoxes(checkBoxPool, checkBoxWifi, checkBoxParking, checkBoxGym, checkBoxConcierge, checkBoxSpa, checkBoxRoomService);
                        Helper.resetTextFields(fieldSeasonStartDate, fieldSeasonEndDate, fieldOffSeasonStartDate, fieldOffSeasonEndDate);
                        Helper.resetRadioButtons(radioButtonSeason, radioButtonOffSeason);
                    }
                    scrollPaneHotelDetails.getVerticalScrollBar().setValue(0);;
                }
            }
        });
        buttonHotelSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadHotelDetailsModel();
                loadPriceRoomModel();
                scrollPaneHotelDetails.getVerticalScrollBar().setValue(0);
                String hotelName= tableHotelHotelList.getValueAt(tableHotelHotelList.getSelectedRow(),1).toString();
                labelRoomHotelName.setText(hotelName);
            }
        });
        buttonHotelDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (Helper.confirm("sure")) {
                    int id = Integer.parseInt(tableHotelHotelList.getValueAt(tableHotelHotelList.getSelectedRow(), 0).toString());
                    if (EmployeeOp.deleteHotelDetails(id) && EmployeeOp.deleteHotelPeriodDetails(id)) {
                        Helper.showMessage("done");
                        loadHotelModel();
                        Helper.resetFormFields(fieldHotelName, fieldHotelCity, fieldHotelAddress, fieldHotelDistrict, fieldHotelMail, fieldHotelPhone, fieldHotelStar);
                        Helper.resetCheckBoxes(checkBoxPool, checkBoxWifi, checkBoxParking, checkBoxGym, checkBoxConcierge, checkBoxSpa, checkBoxRoomService);
                        Helper.resetTextFields(fieldSeasonStartDate, fieldSeasonEndDate, fieldOffSeasonStartDate, fieldOffSeasonEndDate);
                        Helper.resetRadioButtons(radioButtonSeason, radioButtonOffSeason);
                    } else {
                        Helper.showMessage("error");
                    }
                }
            }
        });
        buttonHotelSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = fieldHotelHotelCityDistrictSearch.getText();
                String star = fieldHotelStarSearch.getText();

                String query = EmployeeOp.searchHotelQuery(a, star);
                ArrayList<Hotel> searchHotel = EmployeeOp.searchHotelList(query);
                loadHotelModel(searchHotel);
            }
        });

        buttonRoomTypeNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Helper.resetFormFields(fieldRoomTypeName, fieldRoomBedCount, fieldRoomSize, fieldRoomTv, fieldRoomMinibar, fieldRoomStock);
                fieldRoomTypeName.setText(comboBoxRoomType.getSelectedItem().toString());
            }
        });
        comboBoxRoomType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadRoomDetailsModel();
            }
        });
        buttonHotelClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Helper.resetFormFields(fieldHotelName, fieldHotelCity, fieldHotelAddress, fieldHotelDistrict, fieldHotelMail, fieldHotelPhone, fieldHotelStar);
                Helper.resetCheckBoxes(checkBoxPool, checkBoxWifi, checkBoxParking, checkBoxGym, checkBoxConcierge, checkBoxSpa, checkBoxRoomService);
                Helper.resetTextFields(fieldSeasonStartDate, fieldSeasonEndDate, fieldOffSeasonStartDate, fieldOffSeasonEndDate);
                Helper.resetRadioButtons(radioButtonSeason, radioButtonOffSeason);
            }
        });
        buttonRoomTypeAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((Helper.isFieldEmpty(fieldRoomStock) || Helper.isFieldEmpty(fieldRoomBedCount) || Helper.isFieldEmpty(fieldRoomSize) || Helper.isFieldEmpty(fieldRoomTv)
                        || Helper.isFieldEmpty(fieldRoomMinibar))) {
                    Helper.showMessage("fill");
                } else {
                    int hotel_id = Integer.parseInt(tableHotelHotelList.getValueAt(tableHotelHotelList.getSelectedRow(), 0).toString());
                    int room_type_id = EmployeeOp.getFetchRoomType(comboBoxRoomType.getSelectedItem().toString()).getId();
                    int stock = Integer.parseInt(fieldRoomStock.getText());
                    int bed = Integer.parseInt(fieldRoomBedCount.getText());
                    int size = Integer.parseInt(fieldRoomSize.getText());
                    int tv = Integer.parseInt(fieldRoomTv.getText());
                    int minibar = Integer.parseInt(fieldRoomMinibar.getText());

                    if (EmployeeOp.addRoomDetails(hotel_id, room_type_id, stock, bed, size, tv, minibar)) {
                        Helper.showMessage("done");
                    }

                    String name = fieldHotelName.getText();
                    String city = fieldHotelCity.getText();
                    String district = fieldHotelDistrict.getText();
                    String star = fieldHotelStar.getText();
                    String periodName ;
                    String roomName = comboBoxRoomType.getSelectedItem().toString();
                    Date periodStart;
                    Date periodEnd;
                    if(radioButtonSeason.isSelected()){
                         periodName = "Season";
                        periodStart=EmployeeOp.getHotelPeriodDateByHotelId(hotel_id).getSeasonStart();
                        periodEnd=EmployeeOp.getHotelPeriodDateByHotelId(hotel_id).getSeasonEnd();

                        if (EmployeeOp.addRoomSalesDetails(hotel_id, name, city, district, star, periodName, periodStart, periodEnd, roomName,stock)) {

                        }
                    }
                    if(radioButtonOffSeason.isSelected()){
                        periodName = "Off Season";
                        periodStart=EmployeeOp.getHotelPeriodDateByHotelId(hotel_id).getOffSeasonStart();
                        periodEnd=EmployeeOp.getHotelPeriodDateByHotelId(hotel_id).getOffSeasonStart();
                        if (EmployeeOp.addRoomSalesDetails(hotel_id, name, city, district, star, periodName, periodStart, periodEnd, roomName,stock)) {

                        }
                    }
                    loadSalesRoomModel();

                    scrollPaneHotelDetails.getVerticalScrollBar().setValue(0);
                }
            }
        });
        buttonRoomTypeUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((Helper.isFieldEmpty(fieldRoomStock) || Helper.isFieldEmpty(fieldRoomBedCount) || Helper.isFieldEmpty(fieldRoomSize) || Helper.isFieldEmpty(fieldRoomTv)
                        || Helper.isFieldEmpty(fieldRoomMinibar))) {
                    Helper.showMessage("fill");
                } else {
                    int hotel_id = Integer.parseInt(tableHotelHotelList.getValueAt(tableHotelHotelList.getSelectedRow(), 0).toString());
                    int room_type_id = EmployeeOp.getFetchRoomType(comboBoxRoomType.getSelectedItem().toString()).getId();
                    int stock = Integer.parseInt(fieldRoomStock.getText());
                    int bed = Integer.parseInt(fieldRoomBedCount.getText());
                    int size = Integer.parseInt(fieldRoomSize.getText());
                    int tv = Integer.parseInt(fieldRoomTv.getText());
                    int minibar = Integer.parseInt(fieldRoomMinibar.getText());

                    if (EmployeeOp.updateRoomDetails(hotel_id, room_type_id, stock, bed, size, tv, minibar)) {
                        Helper.showMessage("done");
                    }
                    scrollPaneHotelDetails.getVerticalScrollBar().setValue(0);

                }
            }
        });
        buttonAddSingle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Helper.isFieldEmpty(fieldAdultPriceSingle) || Helper.isFieldEmpty(fieldChildPriceSingle)) {
                    Helper.showMessage("fill");
                } else {
                    int hotel_id = Integer.parseInt(tableHotelHotelList.getValueAt(tableHotelHotelList.getSelectedRow(), 0).toString());
                    int period_id = EmployeeOp.getFetchPeriodIdByName(comboBoxPeriodSingle.getSelectedItem().toString()).getId();
                    int room_type_id = 1;
                    int acco_id = EmployeeOp.getFetchAccoIdByName(comboBoxHostelTypeSingle.getSelectedItem().toString()).getId();
                    int adult_price = Integer.parseInt(fieldAdultPriceSingle.getText());
                    int child_price = Integer.parseInt(fieldChildPriceSingle.getText());

                    if (EmployeeOp.addPriceDetails(hotel_id, period_id, room_type_id, acco_id, adult_price, child_price)) {
                        Helper.showMessage("done");
                        loadPriceRoomModel();

                    } else {
                        Helper.showMessage("error");
                    }
//                    String name = fieldHotelName.getText();
//                    String city = fieldHotelCity.getText();
//                    String district = fieldHotelDistrict.getText();
//                    String star = fieldHotelStar.getText();
//                    String periodName = comboBoxPeriodSingle.getSelectedItem().toString();
//                    String roomName = radioButtonSingle.getText().toString();
//                    Date periodStart;
//                    Date periodEnd;
//
//                    if (periodName.equals("Season")){
//
//                        periodStart=EmployeeOp.getHotelPeriodDateByHotelId(hotel_id).getSeasonStart();
//                        periodEnd=EmployeeOp.getHotelPeriodDateByHotelId(hotel_id).getSeasonEnd();
//
//                        if (EmployeeOp.addRoomSalesDetails(hotel_id, name, city, district, star, periodName, periodStart, periodEnd, roomName)) {
//                            Helper.showMessage("done");
//                        }
//                    } else if (periodName.equals("Off Season")) {
//                        periodStart=EmployeeOp.getHotelPeriodDateByHotelId(hotel_id).getOffSeasonStart();
//                        periodEnd=EmployeeOp.getHotelPeriodDateByHotelId(hotel_id).getOffSeasonStart();
//                        if (EmployeeOp.addRoomSalesDetails(hotel_id, name, city, district, star, periodName, periodStart, periodEnd, roomName)) {
//                            Helper.showMessage("done");
//                        }
//                    }
                    radioButtonSingle.setSelected(false);
                    Helper.resetComboBoxes(comboBoxPeriodSingle, comboBoxHostelTypeSingle);
                    Helper.resetTextFields(fieldAdultPriceSingle, fieldChildPriceSingle);
                    buttonAddSingle.setEnabled(false);
                }
            }
        });
        buttonAddDouble.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Helper.isFieldEmpty(fieldAdultPriceDouble) || Helper.isFieldEmpty(fieldChildPriceDouble)) {
                    Helper.showMessage("fill");
                } else {
                    int hotel_id = Integer.parseInt(tableHotelHotelList.getValueAt(tableHotelHotelList.getSelectedRow(), 0).toString());
                    int period_id = EmployeeOp.getFetchPeriodIdByName(comboBoxPeriodDouble.getSelectedItem().toString()).getId();
                    int room_type_id = 2;
                    int acco_id = EmployeeOp.getFetchAccoIdByName(comboBoxHostelTypeDouble.getSelectedItem().toString()).getId();
                    int adult_price = Integer.parseInt(fieldAdultPriceDouble.getText());
                    int child_price = Integer.parseInt(fieldChildPriceDouble.getText());

                    if (EmployeeOp.addPriceDetails(hotel_id, period_id, room_type_id, acco_id, adult_price, child_price)) {
                        Helper.showMessage("done");
                        loadPriceRoomModel();
                        radioButtonDouble.setSelected(false);
                        Helper.resetComboBoxes(comboBoxPeriodDouble, comboBoxHostelTypeDouble);
                        Helper.resetTextFields(fieldAdultPriceDouble, fieldChildPriceDouble);
                        buttonAddDouble.setEnabled(false);
                    } else {
                        Helper.showMessage("error");
                    }
                }
            }
        });
        buttonAddKingSuite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Helper.isFieldEmpty(fieldAdultPriceKingSuite) || Helper.isFieldEmpty(fieldChildPriceKingSuite)) {
                    Helper.showMessage("fill");
                } else {
                    int hotel_id = Integer.parseInt(tableHotelHotelList.getValueAt(tableHotelHotelList.getSelectedRow(), 0).toString());
                    int period_id = EmployeeOp.getFetchPeriodIdByName(comboBoxPeriodKingSuite.getSelectedItem().toString()).getId();
                    int room_type_id = 3;
                    int acco_id = EmployeeOp.getFetchAccoIdByName(comboBoxHostelTypeKingSuite.getSelectedItem().toString()).getId();
                    int adult_price = Integer.parseInt(fieldAdultPriceKingSuite.getText());
                    int child_price = Integer.parseInt(fieldChildPriceKingSuite.getText());

                    if (EmployeeOp.addPriceDetails(hotel_id, period_id, room_type_id, acco_id, adult_price, child_price)) {
                        Helper.showMessage("done");
                        loadPriceRoomModel();
                        radioButtonKingSuite.setSelected(false);
                        Helper.resetComboBoxes(comboBoxPeriodKingSuite, comboBoxHostelTypeKingSuite);
                        Helper.resetTextFields(fieldAdultPriceKingSuite, fieldChildPriceKingSuite);
                        buttonAddKingSuite.setEnabled(false);
                    } else {
                        Helper.showMessage("error");
                    }

                }
            }
        });
        buttonDeletePrice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Helper.confirm("sure")) {
                    int id = Integer.parseInt(tablePriceRoomList.getValueAt(tablePriceRoomList.getSelectedRow(), 0).toString());
                    if (EmployeeOp.deleteRoomPriceDetails(id)) {
                        Helper.showMessage("done");
                        loadPriceRoomModel();
                    } else {
                        Helper.showMessage("error");
                    }
                }
            }
        });
        buttonSearchSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                boolean isRowSelected = !(tableSearchHotelList.getSelectionModel().isSelectionEmpty());
                if(isRowSelected){
                    int hotelId= Integer.parseInt(tableSearchHotelList.getValueAt(tableSearchHotelList.getSelectedRow(),1).toString());
                    labelHotelName.setText(tableSearchHotelList.getValueAt(tableSearchHotelList.getSelectedRow(),2).toString());
                    labelResRoomType.setText(tableSearchHotelList.getValueAt(tableSearchHotelList.getSelectedRow(),9).toString());
                    fieldResCheckin.setText(fieldSearchCheckin.getText().toString());
                    fieldResCheckout.setText(fieldSearchCheckout.getText().toString());

                    if(fieldSearchAdult.getText().isEmpty()){
                        labelResAdult.setText("");
                    }else if(Integer.parseInt(fieldSearchAdult.getText().toString())==0){
                        labelResAdult.setText("");
                    }else if(Integer.parseInt(fieldSearchAdult.getText().toString())>1){
                        labelResAdult.setText(fieldSearchAdult.getText().toString() + "x Adults");
                    }else {
                        labelResAdult.setText(fieldSearchAdult.getText().toString() + "x Adult");
                    }
                    if (fieldSearchChild.getText().isEmpty()) {
                        labelResChild.setText("");
                    }else if(Integer.parseInt(fieldSearchChild.getText().toString())==0){
                        labelResChild.setText("");
                    } else if(Integer.parseInt(fieldSearchChild.getText().toString())>1){
                        labelResChild.setText(fieldSearchChild.getText().toString() + "x Children");
                    }else {
                        labelResChild.setText(fieldSearchChild.getText().toString() + "x Child");
                    }
                    for (Hotel obj : EmployeeOp.getHotelDetailsByHotelId(hotelId)) {
                        fieldResDetailCity.setText(obj.getCity().toString());
                        fieldResDetailDistrict.setText(obj.getDistrict().toString());
                        fieldResDetailAddress.setText(obj.getAddress().toString());
                        fieldResDetailPhone.setText(obj.getPhoneNumber().toString());
                        fieldResDetailStar.setText(obj.getStar().toString());
                        if(obj.getParking().equals("Yes")){
                            freeParkingCheckBox.setSelected(true);
                        }
                        if(obj.getWifi().equals("Yes")){
                            wiFiCheckBox.setSelected(true);
                        }
                        if(obj.getPool().equals("Yes")){
                            swimmingPoolCheckBox.setSelected(true);
                        }
                        if(obj.getGym().equals("Yes")){
                            fitnessCenterCheckBox.setSelected(true);
                        }
                        if(obj.getConcierge().equals("Yes")){
                            conciergeCheckBox.setSelected(true);
                        }
                        if(obj.getSpa().equals("Yes")){
                            spaCheckBox.setSelected(true);
                        }
                        if(obj.getRoomService().equals("Yes")){
                            roomServiceCheckBox.setSelected(true);
                        }
                    }
                    String roomName = (tableSearchHotelList.getValueAt(tableSearchHotelList.getSelectedRow(),9).toString());
                    for (Room obj : EmployeeOp.getRoomDetailsByHotelId(hotelId,EmployeeOp.getFetchRoomIdByName(roomName).getId())){
                        fieldResBed.setText(String.valueOf(obj.getBed()));
                        fieldResMinibar.setText(String.valueOf(obj.getMinibar()));
                        fieldResRoomSize.setText(String.valueOf(obj.getRoomSize()));
                        fieldResTv.setText(String.valueOf(obj.getTv()));
                    }
                }else {
                    Helper.showMessage("Please make a selection from the table below");
                }
                loadAccoCombo();
                tabbedPane3.setSelectedIndex(1);

            }
        });
        buttonResReserve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane3.setSelectedIndex(2);
            }
        });
        buttonSearchSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Helper.isFieldEmpty(fieldSearchHotelCityDistrict) || Helper.isFieldEmpty(fieldSearchCheckin) || Helper.isFieldEmpty(fieldSearchCheckout)) {
                    Helper.showMessage("fill");
                } else {

                    String input = fieldSearchHotelCityDistrict.getText();
                    String star = fieldSearchStar.getText();
                    Date checkIn = Helper.stringToDate(fieldSearchCheckin.getText());
                    Date checkOut = Helper.stringToDate(fieldSearchCheckout.getText());


                    String query = EmployeeOp.searchRoomSalesQuery(input, star, checkIn, checkOut);
                    ArrayList<RoomSales> searchRoomSales = EmployeeOp.searchRoomSalesList(query);
                    loadSalesRoomModel(searchRoomSales);
                }
            }
        });
    }
    public void loadAccoCombo(){
        comboBoxResHostelType.removeAllItems();
        int hotelId= Integer.parseInt(tableSearchHotelList.getValueAt(tableSearchHotelList.getSelectedRow(),1).toString());
        int roomTypeId =EmployeeOp.getFetchRoomIdByName(tableSearchHotelList.getValueAt(tableSearchHotelList.getSelectedRow(),9).toString()).getId();
        int periodId = EmployeeOp.getFetchPeriodIdByName(tableSearchHotelList.getValueAt(tableSearchHotelList.getSelectedRow(),6).toString()).getId();
//        for(AccommodationType obj : EmployeeOp.getAccoNameByAccoIdList(EmployeeOp.getAccoIdByHotel(hotelId,roomTypeId,periodId),roomTypeId)){
//            comboBoxResHostelType.addItem(new Item(obj.getId(), obj.getAccoName()));
//        }
        for(RoomPrice obj : EmployeeOp.getAccoIdByHotel(hotelId,roomTypeId,periodId)){
            //EmployeeOp.getFetchAccoNameById(obj.getAccommodationId());
            comboBoxResHostelType.addItem(EmployeeOp.getFetchAccoNameById(obj.getAccommodationId()).getAccoName());
        }
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
    public void loadHotelModel(ArrayList<Hotel> list) {
        DefaultTableModel clearModel = (DefaultTableModel) tableHotelHotelList.getModel();
        clearModel.setRowCount(0);
        for (Hotel obj : list) {
            int i = 0;
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
    private void loadHotelDetailsModel() {
        int hotelId = Integer.parseInt(tableHotelHotelList.getValueAt(tableHotelHotelList.getSelectedRow(),0).toString());

        for (Hotel obj : EmployeeOp.getHotelDetailsByHotelId(hotelId)) {
            fieldHotelName.setText(obj.getName());
            fieldHotelCity.setText(obj.getCity());
            fieldHotelDistrict.setText(obj.getDistrict());
            fieldHotelStar.setText(obj.getStar());
            fieldHotelAddress.setText(obj.getAddress());
            fieldHotelMail.setText(obj.getEmail());
            fieldHotelPhone.setText(obj.getPhoneNumber());
            checkBoxParking.setSelected(false);
            checkBoxWifi.setSelected(false);
            checkBoxPool.setSelected(false);
            checkBoxGym.setSelected(false);
            checkBoxConcierge.setSelected(false);
            checkBoxSpa.setSelected(false);
            checkBoxRoomService.setSelected(false);

            if (obj.getParking().equals("Yes")) {
                checkBoxParking.setSelected(true);
            }
            if (obj.getWifi().equals("Yes")) {
                checkBoxWifi.setSelected(true);
            }
            if (obj.getPool().equals("Yes")) {
                checkBoxPool.setSelected(true);
            }
            if (obj.getGym().equals("Yes")) {
                checkBoxGym.setSelected(true);
            }
            if (obj.getConcierge().equals("Yes")) {
                checkBoxConcierge.setSelected(true);
            }
            if (obj.getSpa().equals("Yes")) {
                checkBoxSpa.setSelected(true);
            }
            if (obj.getRoomService().equals("Yes")) {
                checkBoxRoomService.setSelected(true);
            }
        }
        for (HotelPeriod obj : EmployeeOp.getHotelPeriodByHotelId(hotelId)) {
            if (obj.getSeasonStart() != null) {
                radioButtonSeason.setSelected(true);
                fieldSeasonStartDate.setText(obj.getSeasonStart().toString());
                fieldSeasonEndDate.setText(obj.getSeasonEnd().toString());
            }
            if (obj.getOffSeasonStart() != null) {
                radioButtonOffSeason.setSelected(true);
                fieldOffSeasonStartDate.setText(obj.getOffSeasonStart().toString());
                fieldOffSeasonEndDate.setText(obj.getOffSeasonEnd().toString());
            }
        }
        Helper.enableTextFields(fieldSeasonStartDate, fieldSeasonEndDate, fieldOffSeasonStartDate, fieldOffSeasonEndDate);
    }
    private void loadRoomDetailsModel() {
        int hotelId = Integer.parseInt(tableHotelHotelList.getValueAt(tableHotelHotelList.getSelectedRow(), 0).toString());
        int roomTypeId = 0;
        String roomTypeName = comboBoxRoomType.getSelectedItem().toString();

        switch (roomTypeName) {
            case "Single":
                roomTypeId = 1;
                break;
            case "Double":
                roomTypeId = 2;
                break;
            case "King Suite":
                roomTypeId = 3;
                break;
            default: {
                Helper.showMessage("error");;
            }
        }
        for (Room obj : EmployeeOp.getRoomDetailsByHotelId(hotelId,roomTypeId)) {
            fieldRoomTypeName.setText(roomTypeName);
            fieldRoomBedCount.setText(String.valueOf(obj.getBed()));
            fieldRoomSize.setText(String.valueOf(obj.getRoomSize()));
            fieldRoomTv.setText(String.valueOf(obj.getTv()));
            fieldRoomMinibar.setText(String.valueOf(obj.getMinibar()));
            fieldRoomStock.setText(String.valueOf(obj.getStock()));
        }
    }
    public void loadPriceRoomModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tablePriceRoomList.getModel();
        clearModel.setRowCount(0);
        int i;
        int id = Integer.parseInt(tableHotelHotelList.getValueAt(tableHotelHotelList.getSelectedRow(), 0).toString());
        for (RoomPrice obj : EmployeeOp.getRoomPriceListByHotelId(id)) {
            i = 0;
            rowPriceRoomList[i++] = obj.getId();
            rowPriceRoomList[i++] = EmployeeOp.getFetchPeriodNameById(obj.getPeriodId()).getPeriodName();
            rowPriceRoomList[i++] = EmployeeOp.getFetchRoomNameById(obj.getRoomTypeId()).getRoomName();
            rowPriceRoomList[i++] = EmployeeOp.getFetchAccoNameById(obj.getAccommodationId()).getAccoName();
            rowPriceRoomList[i++] = obj.getAdultPrice();
            rowPriceRoomList[i++] = obj.getChildPrice();

            modelPriceRoomList.addRow(rowPriceRoomList);
        }
    }
    public void loadSalesRoomModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tableSearchHotelList.getModel();
        clearModel.setRowCount(0);
        int i;
        for (RoomSales obj : EmployeeOp.getRoomSalesList()) {
            i = 0;
            rowSearchHotelList[i++] = obj.getId();
            rowSearchHotelList[i++] = obj.getHotelId();
            rowSearchHotelList[i++] = obj.getHotelName();
            rowSearchHotelList[i++] = obj.getCity();
            rowSearchHotelList[i++] = obj.getDistrict();
            rowSearchHotelList[i++] = obj.getStar();
            rowSearchHotelList[i++] = obj.getPeriod();
            rowSearchHotelList[i++] = obj.getStartDate();
            rowSearchHotelList[i++] = obj.getEndDate();
            rowSearchHotelList[i++] = obj.getRoomType();

            if (obj.getStock() != 0) {
                rowSearchHotelList[i++] = obj.getStock();
                modelSearchHotelList.addRow(rowSearchHotelList);
            }

        }
    }

    public void loadSalesRoomModel(ArrayList<RoomSales> list) {
        DefaultTableModel clearModel = (DefaultTableModel) tableSearchHotelList.getModel();
        clearModel.setRowCount(0);
        int i;
        for (RoomSales obj : list) {
            i = 0;
            rowSearchHotelList[i++] = obj.getId();
            rowSearchHotelList[i++] = obj.getHotelId();
            rowSearchHotelList[i++] = obj.getHotelName();
            rowSearchHotelList[i++] = obj.getCity();
            rowSearchHotelList[i++] = obj.getDistrict();
            rowSearchHotelList[i++] = obj.getStar();
            rowSearchHotelList[i++] = obj.getPeriod();
            rowSearchHotelList[i++] = obj.getStartDate();
            rowSearchHotelList[i++] = obj.getEndDate();
            rowSearchHotelList[i++] = obj.getRoomType();

            if (obj.getStock() != 0) {
                rowSearchHotelList[i++] = obj.getStock();
                modelSearchHotelList.addRow(rowSearchHotelList);
            }

        }
    }




}
