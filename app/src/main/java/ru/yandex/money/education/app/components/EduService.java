package ru.yandex.money.education.app.components;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by Aleksandr Ershov (asershov@yamoney.com) on 28.08.15.
 */
public class EduService extends Service {

    public EduService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
