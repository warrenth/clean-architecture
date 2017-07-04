package com.tylersuehr.cleanarchitecture.ui.a_people;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.view.View;
import com.tylersuehr.cleanarchitecture.R;
/**
 * Copyright 2017 Tyler Suehr
 * Created by tyler on 7/4/2017.
 */
public class PersonBottomSheet extends BottomSheetDialogFragment implements View.OnClickListener {
    private AppCompatEditText inputFirst;
    private AppCompatEditText inputLast;
    private AppCompatEditText inputAge;
    private PersonDialogListener listener;


    public static void show(FragmentManager fm, PersonDialogListener callback) {
        PersonBottomSheet dialog = new PersonBottomSheet();
        dialog.listener = callback;
        dialog.show(fm, "PersonDialog");
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = View.inflate(getContext(), R.layout.fragment_dialog_person, null);
        this.inputFirst = (AppCompatEditText)v.findViewById(R.id.input_first);
        this.inputLast = (AppCompatEditText)v.findViewById(R.id.input_last);
        this.inputAge = (AppCompatEditText)v.findViewById(R.id.input_age);
        v.findViewById(R.id.button_create).setOnClickListener(this);

        BottomSheetDialog dialog = new BottomSheetDialog(getContext());
        dialog.setContentView(v);
        return dialog;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_create) {
            // Validate fields
            String first = inputFirst.getText().toString();
            if (TextUtils.isEmpty(first)) {
                this.inputFirst.setError("First name is required!");
                return;
            }

            String last = inputLast.getText().toString();
            if (TextUtils.isEmpty(last)) {
                this.inputLast.setError("Last name is required!");
                return;
            }

            String age = inputAge.getText().toString();
            if (TextUtils.isEmpty(age)) {
                this.inputAge.setError("Age is required!");
                return;
            }

            // Trigger callback and dismiss
            listener.onPersonAdded(first, last, "img_profile_0", Integer.parseInt(age));
            dismiss();
        }
    }

    /**
     * Callbacks for this dialog.
     */
    interface PersonDialogListener {
        void onPersonAdded(String first, String last, String image, int age);
    }
}