package com.example.administrator.oop;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;


public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nine_squares);
        GridView gridview = (GridView) findViewById(R.id.gridView1);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub


            }
        });

        gridview.setAdapter(new NineSquareAdaper(this));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                OpenNew(arg2);
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void OpenNew(int arg2){
        //新建一个显式意图，第一个参数为当前Activity类对象，第二个参数为你要打开的Activity类
//        Intent intent=new Intent(GroupActivity.this,ListViewGroup.class);
//        GroupActivity.this.startActivity(intent);
//   Intent intent =new Intent(MainActivity.this,PhotoActivity.class);
//

              Intent intent=new Intent();
        Bundle bundle=new Bundle();
        switch(arg2){
            case 0:
                intent.setClass(MainActivity.this, NextActivity.class);
               startActivity(intent);
                break;
            case 1:
                intent.setClass(MainActivity.this, PhotoActivity.class);
                startActivity(intent);
                break;
            case 2:
                intent.setClass(MainActivity.this, PhotoActivity.class);
                startActivity(intent);
                break;
            case 3:
                intent.setClass(MainActivity.this, SysPhotoActivity.class);
                startActivity(intent);
                break;
            case 4:
                intent.setClass(MainActivity.this, NextActivity.class);
                startActivity(intent);
                break;
            case 5:
                intent.setClass(MainActivity.this, NextActivity.class);
                startActivity(intent);
                break;
            case 6:
                intent.setClass(MainActivity.this, NextActivity.class);
                startActivity(intent);
                break;
            case 7:
                intent.setClass(MainActivity.this, NextActivity.class);
                startActivity(intent);
                break;
            case 8:
                intent.setClass(MainActivity.this, NextActivity.class);
                startActivity(intent);
                break;
            default:
                intent.setClass(MainActivity.this, NextActivity.class);
                startActivity(intent);

        }
//        intent.setComponent(NextActivity.class);
        //用Bundle携带数据

        //传递name参数为tinyphp

        bundle.putInt("num",arg2);
        intent.putExtras(bundle);

        startActivity(intent);
    }
}
