package ru.yandex.money.education.app.components;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.concurrent.TimeUnit;

public class EduService extends Service {

    public static final String TAG = EduService.class.getName();

    public static void start(Context context) {
        context.startService(new Intent(context, EduService.class));
    }

    public static void stop(Context context) {
        context.stopService(new Intent(context, EduService.class));
    }

    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand");
        doSomeThingLong();
        return super.onStartCommand(intent, flags, startId);
    }

    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind");
        return null;
    }

    private void doSomeThingLong() {
        new Thread(new Runnable() {
            public void run() {
                for (int i = 1; i < 5; i++) {
                    Log.d(TAG, "i = " + i);
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                stopSelf();
            }
        }).start();
    }
}
