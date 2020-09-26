package com.example.biodata;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
EditText namapanjang,namapanggilan,tempatlahir,alamat,hobi,pekerjaan;
Spinner jkelamin;
Button tgllahir,peroses;
TextView kalimatpengenalandiri;
private  int mtahun,mbulan,mhari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        namapanjang  = (EditText)findViewById(R.id.edt_namapanjang);
        namapanggilan = (EditText)findViewById(R.id.edt_namapamggilan);
        tempatlahir = (EditText)findViewById(R.id.edt_tempatlahir);
        alamat = (EditText)findViewById(R.id.edt_alamat);
        hobi = (EditText)findViewById(R.id.edt_hobi);
        pekerjaan = (EditText)findViewById(R.id.edt_pekerjaan);

        jkelamin  = (Spinner)findViewById(R.id.spnjkelamin);

        tgllahir = (Button)findViewById(R.id.btn_tgllahir);
        peroses = (Button)findViewById(R.id.btn_peroses);

        kalimatpengenalandiri = (TextView)findViewById(R.id.txt_kalimatpengenalan);

        List<String> listKelamin = new ArrayList<String>();
        listKelamin.add("Laki-Laki");
        listKelamin.add("Perempuan");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listKelamin);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jkelamin.setAdapter(adapter);

        tgllahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                mtahun = cal.get(Calendar.YEAR);
                mbulan = cal.get(Calendar.MONTH);
                mhari = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDateDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tgllahir.setText(String.valueOf(dayOfMonth)+"-"+String.valueOf(month+1)+"-"+String.valueOf(year));

                    }
                },mtahun,mbulan,mhari);
                mDateDialog.setTitle("Pilih Tanggal Lahir");
                mDateDialog.show();
            }
        });

        peroses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kalimatpengenalandiri.setText("Hai nama saya adalah "+namapanjang.getText().toString()+",  Saya biasa dipanggil "+namapanggilan.getText().toString()+", Tempat Lahir "+
                        tempatlahir.getText().toString()+", Tanggal Lahir "+tgllahir.getText().toString()+", Alamat saya di "
                        +alamat.getText().toString()+", Hobi "+hobi.getText().toString()+", Pekerjaan "+pekerjaan.getText().toString());
            }
        });


    }
}