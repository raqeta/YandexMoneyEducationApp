package ru.yandex.money.education.app.components;

import android.app.Application;

import ru.yandex.money.education.app.data.DbHelper;

/**
 * Created by Aleksandr Ershov (asershov@yamoney.com) on 28.08.15.
 */
public class App extends Application {

    private static App instance;

    public App() {
        instance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // Init global things: Analytics, BugTrackers etc.
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public static App getContext() {
        return instance;
    }

    public static DbHelper getDbHelper() {
        return DbHelper.getInstance(instance);
    }
}
