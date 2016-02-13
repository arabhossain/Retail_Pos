/*
    Software Engineer
    ---------------------------------------
    Md. Arab Hossain
    Email: arabhossain317@diu.edu.bd
           green.arab1995@gmail.com
    Mobile: +8801827-464330
            +8801737-331037
    Daffodil International University(Student)
 */
package BusniessObjects;

/**
 *
 * @author Loser
 */
public class UserRole {

    /**
     *
     */
    public UserRole(){}
    
    //Accessable Getters and setters methods--------------------

    /**
     *
     * @return
     */
    public  String getTxtRoleName() {
        return txtRoleName;
    }

    /**
     *
     * @param RoleName
     */
    public void setTxtRoleName(String RoleName) {
        txtRoleName = RoleName;
    }

    /**
     *
     * @return
     */
    public int getSales() {
        return Sales;
    }

    /**
     *
     * @param txtSales
     */
    public void setSales(int txtSales) {
        Sales = txtSales;
    }

    /**
     *
     * @return
     */
    public int getEditSales() {
        return EditSales;
    }

    /**
     *
     * @param txtEditSales
     */
    public void setEditSales(int txtEditSales) {
        EditSales = txtEditSales;
    }

    /**
     *
     * @return
     */
    public int getCustomerPayment() {
        return CustomerPayment;
    }

    /**
     *
     * @param txtCustomerPayment
     */
    public void setCustomerPayment(int txtCustomerPayment) {
        CustomerPayment = txtCustomerPayment;
    }

    /**
     *
     * @return
     */
    public int getExpence() {
        return Expence;
    }

    /**
     *
     * @param txtExpence
     */
    public void setExpence(int txtExpence) {
        Expence = txtExpence;
    }

    /**
     *
     * @return
     */
    public int getCashClose() {
        return CashClose;
    }

    /**
     *
     * @param txtCashClose
     */
    public void setCashClose(int txtCashClose) {
        CashClose = txtCashClose;
    }

    /**
     *
     * @return
     */
    public int getCustomers() {
        return Customers;
    }

    /**
     *
     * @param txtCustomers
     */
    public void setCustomers(int txtCustomers) {
       Customers = txtCustomers;
    }

    /**
     *
     * @return
     */
    public int getUsers() {
        return Users;
    }

    /**
     *
     * @param txtUsers
     */
    public void setUsers(int txtUsers) {
       Users = txtUsers;
    }

    /**
     *
     * @return
     */
    public int getStoke() {
        return Stoke;
    }

    /**
     *
     * @param txtStoke
     */
    public void setStoke(int txtStoke) {
        Stoke = txtStoke;
    }

    /**
     *
     * @return
     */
    public int getReports() {
        return Reports;
    }

    /**
     *
     * @param txtReports
     */
    public void setReports(int txtReports) {
        Reports = txtReports;
    }

    /**
     *
     * @return
     */
    public int getPresenceMangae() {
        return PresenceMangae;
    }

    /**
     *
     * @param txtPresenceMangae
     */
    public void setPresenceMangae(int txtPresenceMangae) {
        PresenceMangae = txtPresenceMangae;
    }

    /**
     *
     * @return
     */
    public int getUserRole() {
        return UserRole;
    }

    /**
     *
     * @param txtUserRole
     */
    public void setUserRole(int txtUserRole) {
        UserRole = txtUserRole;
    }

    /**
     *
     * @return
     */
    public int getTools() {
        return Tools;
    }

    /**
     *
     * @param txtTools
     */
    public void setTools(int txtTools) {
        Tools = txtTools;
    }

    /**
     *
     * @return
     */
    public int getConfig() {
        return Config;
    }

    /**
     *
     * @param txtConfig
     */
    public void setConfig(int txtConfig) {
        Config = txtConfig;
    }

    /**
     *
     * @return
     */
    public int getTaxes() {
        return Taxes;
    }

    /**
     *
     * @param txtTaxes
     */
    public void setTaxes(int txtTaxes) {
        Taxes = txtTaxes;
    }

    /**
     *
     * @param getRoleID
     */
    public void setUserRoleID(int getRoleID){
        UserRoleID=getRoleID;
    }

    /**
     *
     * @return
     */
    public int getUserRoleID(){
        return UserRoleID;
    }
   
    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    } 

    /**
     *
     * @return
     */
    public String[] getNames() {
        return names;
    }

    /**
     *
     * @param names
     */
    public void setNames(String[] names) {
        this.names = names;
    }

    //Variables
    private int id;

    /**
     *
     */
    public static String[] names;




    private static String txtRoleName;
    private static int Sales;
    private static int EditSales;
    private static int CustomerPayment;
    private static int Expence;
    private static int CashClose;
    
    private static int Customers;
    private static int Users;
    private static int Stoke;
    private static int Reports;
    private static int PresenceMangae;
    private static int UserRole;
    
    private static int Tools;
    private static int Config;
    private static int Taxes;
    private static int UserRoleID;
    
    
}
