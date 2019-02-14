package com.linglingyi.siinax.sample;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.sdsmdg.tastytoast.TastyToast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/2/11.
 */

public class PrefereActivity extends AppCompatActivity {

    private ListView prefere_lv;

    private static Class<?>[] activity = {MainActivity.class};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prefere);

        prefere_lv = findViewById(R.id.prefere_lv);
        ArrayList<String> objects = new ArrayList<>();
        String[] name = new String[]{};
        Log.e("ppppp","leng = " + activity.length);

        for (Class<?> aClass : activity) {
            objects.add(aClass.getSimpleName());
        }




        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, objects);
        prefere_lv.setAdapter(adapter);
        prefere_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(PrefereActivity.this, activity[position]));
                TastyToast.makeText(PrefereActivity.this, "点击了" + activity[position].getSimpleName(), 1500, TastyToast.INFO);
            }
        });

    }
}
