package com.carlos.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener {
    private ListView listView;
    private MainAdatper mainAdatper;
    public List<MianModel> datas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(this);
        createModel();
        mainAdatper = new MainAdatper(this,datas);
        listView.setAdapter(mainAdatper);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void createModel() {
        for (int i = 0; i < 100; i++) {
            MianModel mianModel = new MianModel();
            mianModel.i = 1;
            mianModel.string = "任务正在进行中";
            datas.add(mianModel);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        StaticTool.hashMap.put(SecondActivity.class.getName(),datas.get(position));
        Intent intent = new Intent(this,SecondActivity.class);
        this.startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mainAdatper != null) {
            mainAdatper.notifyDataSetChanged();
        }
    }
}
