package com.fileprocess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 *
 * @author Jitu Patil
 */
public class NLP_Process {

    public static String resultdata = "";
    public static TreeSet<String> list = new TreeSet<String>();
    public static Map<String, Integer> map = new HashMap<>();

   
    public static String StateProcess(Connection con, String data) {
        String result_data;
        String colname = "State";
        if (data.isEmpty() || data == null || data.equals("0")) {
            result_data = "0";

        } else {
            result_data = "1";
        }

        return result_data;
    }

    public static String Account_lengthProcess(Connection con, String data) {

        String result_data;
        String colname = "Account_length";
        if (data.isEmpty() || data.equals("0") || Integer.valueOf(data) <= 0) {
            result_data = "0";

        } else {
            result_data = "1";
        }

        return result_data;
    }

    public static String Area_codeProcess(Connection con, String data) {
        String result_data;
        String colname = "Area_code";
        if (data.isEmpty() || data.equals("0") || Integer.valueOf(data) <= 0) {
            result_data = "0";

        } else {
            result_data = "1";
        }

        return result_data;

    }

    public static String International_planProcess(Connection con, String data) {
        String result_data;
        String colname = "International_plan";
        if (data.isEmpty() || data == null || data.equals("0")) {
            result_data ="0";

        } else {
            result_data ="1";
        }

        return result_data;
    }

    public static String Voice_mail_planProcess(Connection con, String data) {
        String result_data;
        String colname = "Voice_mail_plan";
        if (data.isEmpty() || data == null || data.equals("0")) {
            result_data = "0";

        } else {
            result_data = "1";
        }

        return result_data;

    }

    public static String Number_vmail_messagesProcess(Connection con, String data) {
        String result_data;
        String colname = "Number_vmail_messages";
        if (data.isEmpty() || data.equals("0") || Integer.valueOf(data) < 0) {
            result_data = "1";

        } else {
            result_data = "1";
        }

        return result_data;
    }

    public static String Total_day_minutesProcess(Connection con, String data) {
        String result_data;
        String colname = "Total_day_minutes";
        if (data.isEmpty() || data.equals("0") || Double.valueOf(data) < 0) {
            result_data = "0";

        } else {
            result_data = "1";
        }

        return result_data;
    }

    public static String Total_day_callsProcess(Connection con, String data) {
        String result_data;
        String colname = "Total_day_calls";
        if (data.isEmpty() || data.equals("0") || Integer.valueOf(data) < 0) {
            result_data = "0";

        } else {
            result_data = "1";
        }

        return result_data;
    }

    public static String Total_day_chargeProcess(Connection con, String data) {
        String result_data;
        String colname = "Total_day_charge";
        if (data.isEmpty() || data.equals("0") || Double.valueOf(data) < 0) {
            result_data = "0";

        } else {
            result_data = "1";
        }

        return result_data;
    }

    public static String Total_eve_minutesProcess(Connection con, String data) {
        String result_data;
        String colname = "Total_eve_minutes";
        if (data.isEmpty() || data.equals("0") || Double.valueOf(data) < 0) {
            result_data ="0";

        } else {
            result_data = "1";
        }

        return result_data;
    }

    public static String Total_eve_callsProcess(Connection con, String data) {
        String result_data;
        String colname = "Total_day_calls";
        if (data.isEmpty() || data.equals("0") || Integer.valueOf(data) < 0) {
            result_data ="0";

        } else {
            result_data = "1";
        }

        return result_data;
    }

    public static String Total_eve_chargeProcess(Connection con, String data) {
        String result_data;
        String colname = "Total_eve_charge";
        if (data.isEmpty() || data.equals("0") || Double.valueOf(data) < 0) {
            result_data = "0";

        } else {
            result_data = "1";
        }

        return result_data;
    }

    public static String Total_night_minutesProcess(Connection con, String data) {
        String result_data;
        String colname = "Total_night_minutes";
        if (data.isEmpty() || data.equals("0") || Double.valueOf(data) < 0) {
            result_data = "0";

        } else {
            result_data = "1";
        }

        return result_data;
    }

    public static String Total_night_callsProcess(Connection con, String data) {
        String result_data;
        String colname = "Total_night_calls";
        if (data.isEmpty() || data.equals("0") || Integer.valueOf(data) < 0) {
            result_data = "0";

        } else {
            result_data = "1";
        }

        return result_data;
    }

    public static String Total_night_chargeProcess(Connection con, String data) {
        String result_data;
        String colname = "Total_night_charge";
        if (data.isEmpty() || data.equals("0") || Double.valueOf(data) < 0) {
            result_data = "0";
        } else {
            result_data = "1";
        }

        return result_data;
    }

    public static String Total_intl_minutesProcess(Connection con, String data) {
        String result_data;
        String colname = "Total_intl_minutes";
        if (data.isEmpty() || data.equals("0") || Double.valueOf(data) < 0) {
            result_data = "0";

        } else {
            result_data = "1";
        }

        return result_data;
    }

    public static String Total_intl_callsProcess(Connection con, String data) {
        String result_data;
        String colname = "Total_intl_calls";
        if (data.isEmpty() || data.equals("0") || Integer.valueOf(data) < 0) {
        	result_data = "0";

        } else {
            result_data = "1";
        }
        return result_data;
    }

    public static String Total_intl_chargeProcess(Connection con, String data) {
        String result_data;
        String colname = "Total_intl_charge";
        if (data.isEmpty() || data.equals("0") || Double.valueOf(data) < 0) {
        	result_data = "0";

        } else {
            result_data = "1";
        }

        return result_data;
    }

    public static String Customer_service_callsProcess(Connection con, String data) {

        String result_data;
        String colname = "Customer_service_calls";
        if (data.isEmpty() || data.equals("0") || Integer.valueOf(data) < 0) {
        	result_data = "1";

        } else {
            result_data = "1";
        }

        return result_data;

    }

    public static String Churn_LabelProcess(Connection con, String data) {
        String result_data;
        String colname = "Churn_Label";
        if (data.isEmpty() || data == null || data.equals("0")) {
        	result_data = "0";

        } else {
            result_data = "1";
        }

        return result_data;
    }

}
