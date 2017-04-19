package com.example.uberv.accountmanagerdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * A service where our custom account authenticator lives. Account authenticator needs
 * to be available to multiple applications
 */
public class AuthService extends Service {
    public AuthService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
