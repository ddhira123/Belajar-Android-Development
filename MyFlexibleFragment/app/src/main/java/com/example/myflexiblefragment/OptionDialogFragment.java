package com.example.myflexiblefragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OptionDialogFragment#} factory method to
 * create an instance of this fragment.
 */
public class OptionDialogFragment extends DialogFragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    Button btnChoose, btnClose;
    RadioGroup rgOptions;
    RadioButton rbTS, rbKP, rbWH, rbA;
    OnOptionDialogListener optionDialogListener;


    public OptionDialogFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_option_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View v, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);
        btnChoose = v.findViewById(R.id.btn_choose);
        btnClose = v.findViewById(R.id.btn_close);
        btnChoose.setOnClickListener(this);
        btnClose.setOnClickListener(this);
        rgOptions = v.findViewById(R.id.rg_options);
        rbTS = v.findViewById(R.id.rb_ts);
        rbA = v.findViewById(R.id.rb_a);
        rbKP = v.findViewById(R.id.rb_kp);
        rbWH = v.findViewById(R.id.rb_wh);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Fragment fragment = getParentFragment();

        if (fragment instanceof CategoryDetailFragment) {
            CategoryDetailFragment detailCategoryFragment = (CategoryDetailFragment) fragment;
            this.optionDialogListener = detailCategoryFragment.optionDialogListener;
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        this.optionDialogListener = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_close:
                getDialog().cancel();
                break;
            case R.id.btn_choose:
                int checkedRadioButtonId = rgOptions.getCheckedRadioButtonId();
                if (checkedRadioButtonId != -1) {
                    String coach = null;
                    switch (checkedRadioButtonId) {
                        case R.id.rb_ts:
                            coach = rbTS.getText().toString().trim();
                            break;
                        case R.id.rb_a:
                            coach = rbA.getText().toString().trim();
                            break;
                        case R.id.rb_kp:
                            coach = rbKP.getText().toString().trim();
                            break;
                        case R.id.rb_wh:
                            coach = rbWH.getText().toString().trim();
                            break;
                    }
                    if (optionDialogListener != null) {
                        optionDialogListener.onOptionChosen(coach);
                    }
                    getDialog().dismiss();
                }
                break;
        }
    }

    public interface OnOptionDialogListener {
        void onOptionChosen(String text);
    }


}