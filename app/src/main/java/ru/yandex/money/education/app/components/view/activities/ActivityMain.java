package ru.yandex.money.education.app.components.view.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import ru.yandex.money.education.app.R;
import ru.yandex.money.education.app.components.EduService;
import ru.yandex.money.education.app.components.view.fragments.FrgEdu;
import ru.yandex.money.education.app.components.view.listeners.ListenerEdu;

public class ActivityMain extends AppCompatActivity implements ListenerEdu {

    public static final String ACTION_BROADCAST = "ru.yandex.money.education.app.ACTION_BROADCAST";
    public static final String NAME = "ru.yandex.money.education.app.EXTRA_NAME";
    public static final int DEFAULT_VALUE = 0;

    private IntentFilter intentFilter = new IntentFilter(ACTION_BROADCAST);
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int data = intent.getIntExtra(NAME, DEFAULT_VALUE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.frg_edu_container, FrgEdu.create(), FrgEdu.TAG)
                    .commit();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(broadcastReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(broadcastReceiver);
    }

    public void startEduService() {
        startService(new Intent(this, EduService.class));
    }

    public void stopEduService() {
        stopService(new Intent(this, EduService.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void doSomeThing() {
        Toast.makeText(ActivityMain.this, R.string.edu_listener_says, Toast.LENGTH_SHORT).show();
    }
}
