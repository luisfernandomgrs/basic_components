package com.luisfernandomgrs.learning.basicscomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private EditText txtPersonName;
    private TextInputEditText txtMail;
    private TextView txtStatusMessage;
    private CheckBox cbxSportsDesc1;
    private CheckBox cbxSportsDesc2;
    private CheckBox cbxSportsDesc3;
    private RadioGroup radioGrpSexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle(getString(R.string.app_title));

        // initialize variables and objects...
        txtPersonName = findViewById(R.id._txtPersonName);
        txtMail = findViewById(R.id._txtMail);
        txtStatusMessage = findViewById(R.id._txtStatusMessage);
        cbxSportsDesc1 = findViewById(R.id.cbxSportsDesc1);
        cbxSportsDesc2 = findViewById(R.id.cbxSportsDesc2);
        cbxSportsDesc3 = findViewById(R.id.cbxSportsDesc3);
        radioGrpSexo = findViewById(R.id.radioGrpSexo);

        // clear all content not essential on run...
        fnClearAll();

        // added event listener...
        radioGrpSexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rbtnSexMale) {
                    txtStatusMessage.setText("No mês do Novembro Azul, você ganha um super-desconto!");
                } else if (checkedId == R.id.rbtnSexFemale) {
                    txtStatusMessage.setText("No mês do Outubro Rosa, você ganha um super-desconto!");
                }
            }
        });
    }



    public void fnSendMessage(View view) {
        String sFavoriteSports;

        sFavoriteSports = "";
        if (cbxSportsDesc1.isChecked()) sFavoriteSports += cbxSportsDesc1.getText().toString();
        if (cbxSportsDesc2.isChecked()) {
            if (sFavoriteSports.trim().length() > 0)
                sFavoriteSports += ", ";
            sFavoriteSports += cbxSportsDesc2.getText().toString();
        }
        if (cbxSportsDesc3.isChecked()) {
            if (sFavoriteSports.trim().length() > 0)
                sFavoriteSports += ", ";
            sFavoriteSports += cbxSportsDesc3.getText().toString();
        }

        txtStatusMessage.setText(txtPersonName.getText().toString() + ", " + txtMail.getText().toString() + (sFavoriteSports.trim().length() > 0 ? "\nEsportes Selecionados: " + sFavoriteSports : ""));
    }

    private void fnClearAll() {
        txtPersonName.setText("");
        txtMail.setText("");
        txtStatusMessage.setText("");
    }
}