package com.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;

public class configuration_matrix {
	public static DecimalFormat df = new DecimalFormat("#.##");
	public static String rf_acc = "";
	public static String rf_pre = "";
	public static String rf_recall = "";
	public static String rf_f1_score = "";

	// NB
	public static String nb_acc = "";
	public static String nb_pre = "";
	public static String nb_recall = "";
	public static String nb_f1_score = "";
	//ANN
	public static String nn_acc = "";
	public static String nn_pre = "";
	public static String nn_recall = "";
	public static String nn_f1_score = "";

	public static String configuration_matrix_values_RF() {
		Connection con;
		String data = "";
		try {
			con = (Connection) Dbconn.conn();

			Statement st = (Statement) con.createStatement();
			ResultSet rs = (ResultSet) st
					.executeQuery("select * from accuracydata where Algorithm_Name='RFClass'");
			if (rs.next()) {
				rf_acc = df.format(rs.getDouble(3));
				rf_pre = df.format(rs.getDouble(4)*100);
				rf_recall = df.format(rs.getDouble(5)*100);
				rf_f1_score = df.format(rs.getDouble(6)*100);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rf_acc;
	}

	public static String configuration_matrix_values_NB() {
		Connection con;
		String data = "";
		try {
			con = (Connection) Dbconn.conn();

			Statement st = (Statement) con.createStatement();
			ResultSet rs = (ResultSet) st
					.executeQuery("select * from accuracydata where Algorithm_Name='NBClass'");
			if(rs.next()) {
				nb_acc = df.format(rs.getDouble(3));
				nb_pre = df.format(rs.getDouble(4)*100);
				nb_recall = df.format(rs.getDouble(5)*100);
				nb_f1_score = df.format(rs.getDouble(6)*100);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nb_acc;
	}
	public static String configuration_matrix_values_ANN() {
		Connection con;
		String data = "";
		try {
			con = (Connection) Dbconn.conn();

			Statement st = (Statement) con.createStatement();
			ResultSet rs = (ResultSet) st
					.executeQuery("select * from accuracydata where Algorithm_Name='ANNClass'");
			if(rs.next()) {
				nn_acc = df.format(rs.getDouble(3));
				nn_pre = df.format(rs.getDouble(4)*100);
				nn_recall = df.format(rs.getDouble(5)*100);
				nn_f1_score = df.format(rs.getDouble(6)*100);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nn_acc;
	}
}
