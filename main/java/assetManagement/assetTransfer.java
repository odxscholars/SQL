package assetManagement;

import java.sql.*;
import java.util.ArrayList;

public class assetTransfer {
    public int asset_id;
    public String transfer_date;
    public String from_location;
    public String to_location;
    public int status;

    public ArrayList<Integer> asset_idlist = new ArrayList<Integer>();
    public ArrayList<String> transfer_datelist = new ArrayList<String>();
    public ArrayList<String> from_locationlist = new ArrayList<String>();
    public ArrayList<String> to_locationlist = new ArrayList<String>();
    public ArrayList<Integer> statuslist = new ArrayList<Integer>();

    public assetTransfer() {
    }

    public int register_transfer(){
        Connection conn;


        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assetsdb", "root", "12345678");
            System.out.println("Connected to the database!");
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO asset_transfers (asset_id, transfer_date, from_location, to_location, status) VALUES (?, NOW(), ?, ?, 8001)");
            stmt.setInt(1, asset_id);
            stmt.setString(2, from_location);
            stmt.setString(3, to_location);
            stmt.executeUpdate();

            //update status of asset
            PreparedStatement stmt2 = conn.prepareStatement("UPDATE assets SET status = 9003 WHERE asset_id = ?");
            stmt2.setInt(1, asset_id);
            stmt2.executeUpdate();



            return 1;

        } catch (Exception e) {
            System.out.println("Error: " + e);
            System.out.println(e.getMessage());
            return 0;

        }

    }

    public static void main(String[] args) {
        assetTransfer assetTransfer = new assetTransfer();
        assetTransfer.asset_id = 1004;
        assetTransfer.from_location = "Lagos";
        assetTransfer.to_location = "Abuja";
        assetTransfer.register_transfer();

    }
}
