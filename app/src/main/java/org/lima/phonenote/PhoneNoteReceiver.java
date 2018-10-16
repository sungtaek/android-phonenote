package org.lima.phonenote;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class PhoneNoteReceiver extends BroadcastReceiver {
    private Context c;

    @Override
    public void onReceive(Context context, Intent intent) {
        c = context;
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        MyPhoneStateListener listener = new MyPhoneStateListener();

        tm.listen(listener, PhoneStateListener.LISTEN_CALL_STATE);
    }

    private class MyPhoneStateListener extends PhoneStateListener {
        private Context context;

        public void onCallStateChanged(int state, String incomingNumber) {

            if (state == TelephonyManager.CALL_STATE_RINGING) {
                String msg = "Incomming Number : " + incomingNumber;
                Toast.makeText(c, msg, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
