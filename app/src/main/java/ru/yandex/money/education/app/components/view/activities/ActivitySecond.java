package ru.yandex.money.education.app.components.view.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ru.yandex.money.education.app.R;
import ru.yandex.money.education.app.data.models.EduObj;

public class ActivitySecond extends AppCompatActivity {

    public static final String EXTRA_NAME = "ru.yandex.money.education.app.EXTRA_NAME";

    private EduObj eduObj;

    public static void start(Context context, EduObj data) {
        Intent intent = new Intent(context, ActivitySecond.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        intent.putExtra(EXTRA_NAME, new EduObj.Parc(data));
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        EduObj.Parc eduObjParc = getIntent().getParcelableExtra(EXTRA_NAME);
        if (eduObjParc != null) {
            eduObj = eduObjParc.getEduObj();
        }
        TextView label = (TextView) findViewById(R.id.label);
        EditText input = (EditText) findViewById(R.id.input);
        Button button = (Button) findViewById(R.id.button);

        input.setText(R.string.hello_world);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivitySecond.this, R.string.hello_world, Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (android.os.Build.VERSION.SDK_INT < 5
                && keyCode == KeyEvent.KEYCODE_BACK
                && event.getRepeatCount() == 0) {
            onBackPressed();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        // moveTaskToBack(true);
    }
}
