package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
Button datlich;
RadioGroup radioGroupCharacter;
    private RadioGroup radioGroupLevel;
 RadioButton btxemay,btxedap,btradio4cho,btradio7cho,btradioxetai,btradiothuong,btradiovip;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        radioGroupCharacter= (RadioGroup) v.findViewById(R.id.radioGroup_character);
        btxemay = (RadioButton) v.findViewById(R.id.radioxemay);
        btxedap = (RadioButton) v.findViewById(R.id.radioxedap);
        btradio7cho = (RadioButton) v.findViewById(R.id.radio7cho);
        btradio4cho = (RadioButton) v.findViewById(R.id.radio4cho);
        btradioxetai = (RadioButton) v.findViewById(R.id.radioxetai);
        btradiothuong = (RadioButton) v.findViewById(R.id.radiothuong);
        btradiovip = (RadioButton) v.findViewById(R.id.radiovip);

        radioGroupLevel= (RadioGroup) v.findViewById(R.id.radioGroup_Level);
        datlich = v.findViewById(R.id.btndatlich);
        btxemay.setChecked(true);
        btradiothuong.setChecked(true);
        int idchecked = radioGroupCharacter.getCheckedRadioButtonId();
        switch (idchecked){
            case R.id.radioxemay:
                break;
            case R.id.radioxedap:
                break;
            case R.id.radio4cho:
                break;
            case R.id.radio7cho:
                break;
            case R.id.radioxetai:
                break;
        }
//        radioGroupLevel.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                doOnDifficultyLevelChanged(group, checkedId);
//            }
//        });
//        btxemay.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
//
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                doOnGameCharacterChanged(buttonView,isChecked);
//            }
//        });
//        btxedap.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
//
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                doOnGameCharacterChanged(buttonView,isChecked);
//            }
//        });
//        btradio4cho.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
//
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                doOnGameCharacterChanged(buttonView,isChecked);
//            }
//        });
//       btradio7cho.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
//
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                doOnGameCharacterChanged(buttonView,isChecked);
//            }
//        });
//        btradioxetai.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
//
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                doOnGameCharacterChanged(buttonView,isChecked);
//            }
//        });
        datlich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),Main3Activity.class);
                startActivity(intent);

            }
        });


        return v;
    }
//    private void doOnGameCharacterChanged(CompoundButton buttonView, boolean isChecked)  {
//        RadioButton radio =(RadioButton) buttonView;
//
//        Log.i("KT", "RadioButton "+ radio.getText()+" : "+ isChecked);
//    }
//
//    private void doOnDifficultyLevelChanged(RadioGroup group, int checkedId) {
//        int checkedRadioId = group.getCheckedRadioButtonId();
//
//        if(checkedRadioId == R.id.radiothuong) {
//            Toast.makeText(getContext(),"You choose: Thường",Toast.LENGTH_SHORT).show();
//        } else if(checkedRadioId== R.id.radiovip ) {
//            Toast.makeText(getContext(),"You choose : VIP",Toast.LENGTH_SHORT).show();
//        }
//    }


}
