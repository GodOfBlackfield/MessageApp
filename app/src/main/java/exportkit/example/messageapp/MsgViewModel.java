package exportkit.example.messageapp;

import android.telephony.SmsManager;

import androidx.lifecycle.ViewModel;

public class MsgViewModel extends ViewModel {
    private String phone_no;
    private String msg;

    public MsgViewModel() {
        phone_no = "";
        msg = "";
    }

    public boolean check1(String phone) {
        long phoneno = 0;
        try {
            phoneno = Long.parseLong(phone);
        } catch (NumberFormatException e) {
            return false;
        }
        if (!(phoneno >= 6000000000L && phoneno <= 9999999999L)) {
            return false;
        }
        return true;
    }

    public boolean check2(String message) {
        if (message.length() > 160) {
            return false;
        }
        return true;
    }

    public void initialise(String phone,String message) {
        phone_no = phone;
        msg = message;
    }

    public void send() {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phone_no,null,msg,null,null);
    }
}
