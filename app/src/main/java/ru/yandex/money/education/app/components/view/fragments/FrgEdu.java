package ru.yandex.money.education.app.components.view.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ru.yandex.money.education.app.R;
import ru.yandex.money.education.app.components.view.listeners.ListenerEdu;

public class FrgEdu extends Fragment {

    public static final String TAG = FrgEdu.class.getName();

    private ListenerEdu someEventListener;

    public static FrgEdu create() {
        return new FrgEdu();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.frg_edu, container, false);
        TextView label = (TextView) contentView.findViewById(R.id.label);
        EditText input = (EditText) contentView.findViewById(R.id.input);
        Button button = (Button) contentView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                someEventListener.doSomeThing();
            }
        });
        return contentView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            someEventListener = (ListenerEdu) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement ListenerEdu");
        }
    }
}
