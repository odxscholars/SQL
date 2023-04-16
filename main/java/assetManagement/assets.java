package assetManagement;

import java.util.ArrayList;
import java.sql.*;
public class assets {
    public int asset_id;
    public String asset_name;
    public int asset_status;

    public ArrayList<Integer> asset_idlist = new ArrayList<Integer>();
    public ArrayList<String> asset_namelist = new ArrayList<String>();
    public ArrayList<Integer> asset_statuslist = new ArrayList<Integer>();
    public assets() {

    }


    public int register_asset(){
        try {
            /*Class.forName("com.mysql.jdbc.Driver");*/
            /*Class.forName("com.mysql.jdbc.Driver");*/

            Connection conn;

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assetsdb", "root", "12345678");
            System.out.println("Connected to the database!");

            //preparestatement
            PreparedStatement stmt = conn.prepareStatement("SELECT MAX(asset_id) + 1 AS newID FROM assets");
            ResultSet rst = stmt.executeQuery();
            while(rst.next()){
                asset_id = rst.getInt("newID");
            }
            //save new asset_id
            stmt = conn.prepareStatement("INSERT INTO assets (asset_id, asset_name, status) VALUES (?, ?, ?)");
            stmt.setInt(1, asset_id);
            stmt.setString(2, asset_name);
            asset_status = 9001; // new assets will always be available thus 9001
            stmt.setInt(3, asset_status);

            stmt.executeUpdate();
            System.out.println("Asset registered successfully!");
            stmt.close();
            conn.close();
            return 1;


        }catch (Exception e){
            System.out.println("Error: " + e);
            System.out.println(e.getMessage());
            return 0;
        }

    }

    public int assets_fortransfer() {
        try{
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assetsdb", "root", "12345678");
            System.out.println("Connected to the database!");
            PreparedStatement stmt = conn.prepareStatement("SELECT asset_id, asset_name, status FROM assets WHERE status = 9001");
            ResultSet rst = stmt.executeQuery();
            //clear the arraylist
            asset_idlist.clear();
            asset_namelist.clear();
            asset_statuslist.clear();

            while(rst.next()){
                asset_idlist.add(rst.getInt("asset_id"));
                asset_namelist.add(rst.getString("asset_name"));
                asset_statuslist.add(rst.getInt("status"));
            }
            stmt.close();
            conn.close();
            return 1;

        }catch (Exception e) {
            System.out.println("Error: " + e);
            System.out.println(e.getMessage());
            return 0;
        }
    }


    public static void main(String[] args) {
        assets A = new assets();
        /*A.asset_name = "Laptop";
        A.register_asset();*/

        A.assets_fortransfer();
        for (int i = 0; i < A.asset_idlist.size(); i++) {
            System.out.println(A.asset_idlist.get(i));
            System.out.println(A.asset_namelist.get(i));
            System.out.println(A.asset_statuslist.get(i));
        }







    }
}
