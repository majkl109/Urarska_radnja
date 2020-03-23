package com.majkl.urarskaradnja;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements Satovi{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void loadSatovi(View view){
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        lst.setText(dbHandler.loadHandler());
        satID.setText("");
        nazivSata.setText("");

    }
    public void addSatovi(View view){
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        int id = Integer.parseInt(satID.getText().toString());
        String name = nazivSata.getText().toString();
        Satovi satovi = new Satovi(id,name);
        dbHandler.addHandler(satovi);
        satID.setText("");
        nazivSata.setText("");
    }
    public void findSatovi(View view){
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        Satovi satovi = dbHandler.findHandler(nazivSata.getText().toString());
        if(satovi != null) {
            lst.setText(satovi.getSatID()) + " " +
                    satovi.getNazivSata() + System.getProperty("line.separator");
            satID.setText("");
            nazivSata.setText("");
        }else
            lst.setText("No match found");
            satID.setText("");
            nazivSata.setText("");
    }
    public void removeSatovi(View view){
        MyDBHandler dbHandler = new MyDBHandler(this,
                null, null, 1);
        boolean result = dbHandler.deleteHandler(Integer.parseInt
                (satID.getText().toString));
        if(result) {
            satID.setText("");
            nazivSata.setText("");
            lst.setText("Record deleted");
        }else
            satID.setText("No match found");
        }
    public  void updateStudent(View view){
        MyDBHandler dbHandler = new MyDBHandler(this, null ,
                null,1);
        boolean result = dbHandler.updateHandler(Integer.parseInt(
                satID.getText().toString()), nazivSata.getText().toString());
        if(result) {
            satID.setText("");
            nazivSata.setText("");
            lst.setText("Record updated");
        }else
            satID.setText("No match found");
        }

    }




