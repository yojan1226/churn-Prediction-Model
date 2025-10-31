package com.fileprocess;

import java.io.*;
import java.sql.*;
import java.util.*;

import com.connection.*;

public class arff_create {
	public static void Trainarff()
    {
     try {
            System.out.println("\t Data After Filteration");
            ArrayList<String> patterns = new ArrayList<>();
            File file = new File(Dbconn.trainarff_file+"\\Train.arff");
            FileWriter writer = null;
            writer = new FileWriter(file);
          
            writer.write("@relation 'dataset-information'");
            writer.write("\n");
            writer.write("@attribute 'id' numeric");
            writer.write("\n");
            writer.write("@attribute 'State' {AK, AL, AR, AZ, CA, CO, CT, DC, DE, FL, GA, HI, IA, ID, IL, IN, KS, KY, LA, MA, MD, ME, MI, MN, MO, MS, MT, NC, ND, NE, NH, NJ, NM, NV, NY, OH, OK, OR, PA, RI, SC, SD, TN, TX, UT, VA, VT, WA, WI, WV, WY}");
            writer.write("\n");
            writer.write("@attribute 'Account_length ' numeric");
            writer.write("\n");
             writer.write("@attribute 'Area_code ' numeric");
            writer.write("\n");
            writer.write("@attribute 'International_plan ' {No, Yes}");
            writer.write("\n");
            writer.write("@attribute 'Voice_mail_plan ' {No, Yes}");
            writer.write("\n");
            writer.write("@attribute 'Number_vmail_messages ' numeric");
            writer.write("\n");
            writer.write("@attribute 'Total_day_minutes ' numeric");
            writer.write("\n");
            writer.write("@attribute 'Total_day_calls' numeric");
            writer.write("\n");
            writer.write("@attribute 'Total_day_charge' numeric");
            writer.write("\n");
            writer.write("@attribute 'Total_eve_minutes' numeric");
            writer.write("\n");
            writer.write("@attribute 'Total_eve_calls' numeric");
            writer.write("\n");
            writer.write("@attribute 'Total_eve_charge' numeric");
            writer.write("\n");
            writer.write("@attribute 'Total_night_minutes' numeric");
            writer.write("\n");
            writer.write("@attribute 'Total_night_calls' numeric");
            writer.write("\n");
            writer.write("@attribute 'Total_night_charge' numeric");
            writer.write("\n");
            writer.write("@attribute 'Total_intl_minutes' numeric");
            writer.write("\n");
            writer.write("@attribute 'Total_intl_calls' numeric");
            writer.write("\n");
            writer.write("@attribute 'Total_intl_charge' numeric");
            writer.write("\n");
            writer.write("@attribute 'Customer_service_calls ' numeric");
            writer.write("\n");
            writer.write("@attribute 'Churn_Label' {FALSE, TRUE}");
            writer.write("\n");
            writer.write("@data");
            writer.write("\n");

            ////////////////////////////////////////////////////////////////////////////////////////////////////////
            patterns = Getdata("traindata");
            for (int i = 0; i < patterns.size(); i++) {
                System.out.println("Result \t" + patterns.get(i));
                String str = patterns.get(i).toString();
                if (!str.isEmpty()) {
                    writer.write(str);
                    writer.write("\n");
     }

            }
            writer.close();
            
        } catch (Exception ex) {
             }

    }
	public static ArrayList<String> Getdata(String tablename) throws Exception {
	      
        ArrayList<String> objlist = new ArrayList<>();
        Connection con = (Connection) Dbconn.conn();
        Statement st = (Statement) con.createStatement();
        ResultSet rs = (ResultSet) st.executeQuery("select * from " + tablename + "");
        while (rs.next()) {
      String data = rs.getString(1) + "," + rs.getString(2) + "," + rs.getString(3) + "," + rs.getString(4) + "," + rs.getString(5) + "," + rs.getString(6) + "," + rs.getString(7) + "," + rs.getString(8) + "," + rs.getString(9) + "," + rs.getString(10) + "," + rs.getString(11) + "," + rs.getString(12) + "," + rs.getString(13) + "," + rs.getString(14) + "," + rs.getString(15) + "," + rs.getString(16) + "," + rs.getString(17) + "," + rs.getString(18) + "," + rs.getString(19) + "," + rs.getString(20)+ "," + rs.getString(21) ;      
      objlist.add(data);
        }
        return objlist;
    }
	public static void Testarff()
    {
     try {
            System.out.println("\t Data After Filteration");
            ArrayList<String> patterns = new ArrayList<>();
            File file = new File(Dbconn.testarff_file+"\\Test.arff");
            FileWriter writer = null;
            writer = new FileWriter(file);
          
            writer.write("@relation 'dataset-information'");
            writer.write("\n");
            writer.write("@attribute 'id' numeric");
            writer.write("\n");
            writer.write("@attribute 'State' {AK, AL, AR, AZ, CA, CO, CT, DC, DE, FL, GA, HI, IA, ID, IL, IN, KS, KY, LA, MA, MD, ME, MI, MN, MO, MS, MT, NC, ND, NE, NH, NJ, NM, NV, NY, OH, OK, OR, PA, RI, SC, SD, TN, TX, UT, VA, VT, WA, WI, WV, WY}");
            writer.write("\n");
            writer.write("@attribute 'Account_length ' numeric");
            writer.write("\n");
             writer.write("@attribute 'Area_code ' numeric");
            writer.write("\n");
            writer.write("@attribute 'International_plan ' {No, Yes}");
            writer.write("\n");
            writer.write("@attribute 'Voice_mail_plan ' {No, Yes}");
            writer.write("\n");
            writer.write("@attribute 'Number_vmail_messages ' numeric");
            writer.write("\n");
            writer.write("@attribute 'Total_day_minutes ' numeric");
            writer.write("\n");
            writer.write("@attribute 'Total_day_calls' numeric");
            writer.write("\n");
            writer.write("@attribute 'Total_day_charge' numeric");
            writer.write("\n");
            writer.write("@attribute 'Total_eve_minutes' numeric");
            writer.write("\n");
            writer.write("@attribute 'Total_eve_calls' numeric");
            writer.write("\n");
            writer.write("@attribute 'Total_eve_charge' numeric");
            writer.write("\n");
            writer.write("@attribute 'Total_night_minutes' numeric");
            writer.write("\n");
            writer.write("@attribute 'Total_night_calls' numeric");
            writer.write("\n");
            writer.write("@attribute 'Total_night_charge' numeric");
            writer.write("\n");
            writer.write("@attribute 'Total_intl_minutes' numeric");
            writer.write("\n");
            writer.write("@attribute 'Total_intl_calls' numeric");
            writer.write("\n");
            writer.write("@attribute 'Total_intl_charge' numeric");
            writer.write("\n");
            writer.write("@attribute 'Customer_service_calls ' numeric");
            writer.write("\n");
            writer.write("@attribute 'Churn_Label' {FALSE, TRUE}");
            writer.write("\n");
            writer.write("@data");
            writer.write("\n");

            ////////////////////////////////////////////////////////////////////////////////////////////////////////
            patterns = Getdata("testdata");
            for (int i = 0; i < patterns.size(); i++) {
                System.out.println("Result \t" + patterns.get(i));
                String str = patterns.get(i).toString();
                if (!str.isEmpty()) {
                    writer.write(str);
                    writer.write("\n");
     }
  }
            writer.close();
        } catch (Exception ex) {
              }

    }
}
