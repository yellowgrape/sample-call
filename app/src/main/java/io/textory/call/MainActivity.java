package io.textory.call;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;

import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public static class Observer extends PhoneStateListener {
        @Override
        public void onServiceStateChanged(ServiceState serviceState) {
            super.onServiceStateChanged(serviceState);
            functional.log.e("service state changed", serviceState);
        }

        @Override
        public void onMessageWaitingIndicatorChanged(boolean mwi) {
            super.onMessageWaitingIndicatorChanged(mwi);
            functional.log.e("message waiting indicator changed", mwi);
        }

        @Override
        public void onCallForwardingIndicatorChanged(boolean cfi) {
            super.onCallForwardingIndicatorChanged(cfi);
            functional.log.e("call forward indicator changed", cfi);
        }

        @Override
        public void onCellLocationChanged(CellLocation location) {
            super.onCellLocationChanged(location);
            functional.log.e("cell location changed", location);
        }
        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            super.onCallStateChanged(state, incomingNumber);
            functional.log.e("call state changed",
                    String.format(Locale.getDefault(), "{ \"state\": \"%s\" \"number\": \"%s\" }",
                            functional.telephony.phone.str("onCallStateChanged", "state", state),
                            incomingNumber));
        }

        @Override
        public void onDataConnectionStateChanged(int state) {
            super.onDataConnectionStateChanged(state);
            functional.log.e("data connection state changed", functional.telephony.phone.str("onDataConnectionStateChanged", "state", state));
        }

        @Override
        public void onDataConnectionStateChanged(int state, int networkType) {
            super.onDataConnectionStateChanged(state, networkType);
            functional.log.e("data connection state changed",
                    String.format(Locale.getDefault(), "{ \"state\": \"%s\", \"network type\": \"%s\" }",
                            functional.telephony.phone.str("onDataConnectionStateChanged", "state", state),
                            functional.telephony.phone.str("onDataConnectionStateChanged", "networkType", networkType)));
        }

        @Override
        public void onDataActivity(int direction) {
            super.onDataActivity(direction);
            functional.log.e("data activity", functional.telephony.phone.str("onDataActivity", "direction", direction));
        }

        @Override
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            super.onSignalStrengthsChanged(signalStrength);
            functional.log.e("signal strengths changed", signalStrength);
        }

        @Override
        public void onCellInfoChanged(List<CellInfo> informationList) {
            super.onCellInfoChanged(informationList);
            functional.log.e("cell info changed", informationList);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TelephonyManager manager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        manager.listen(new Observer(), PhoneStateListener.LISTEN_CALL_FORWARDING_INDICATOR |
                                            PhoneStateListener.LISTEN_CALL_STATE |
                                            PhoneStateListener.LISTEN_CELL_INFO |
                                            PhoneStateListener.LISTEN_CELL_LOCATION |
                                            PhoneStateListener.LISTEN_DATA_ACTIVITY |
                                            PhoneStateListener.LISTEN_DATA_CONNECTION_STATE |
                                            PhoneStateListener.LISTEN_MESSAGE_WAITING_INDICATOR |
                                            PhoneStateListener.LISTEN_SERVICE_STATE |
                                            PhoneStateListener.LISTEN_SIGNAL_STRENGTHS);
    }
}
