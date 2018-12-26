package com.example.shivam.mathstable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> arrayList = new ArrayList<String>();
    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    int min = 2, max = 20;

    public void genTable(int progress) {

        arrayList.clear();
        for (int i=1; i<=10; i++) {

            int p = progress * i;
            arrayList.add(Integer.toString(progress)+"  *   "+Integer.toString(i)+" =   "+Integer.toString(p));
        }
        Log.i("i:", Integer.toString(progress));
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.table);

        SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(max);
        seekBar.setProgress(min);
        genTable(min);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if (progress<min) {
                    seekBar.setProgress(min);
                    progress = min;
                }

                genTable(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
