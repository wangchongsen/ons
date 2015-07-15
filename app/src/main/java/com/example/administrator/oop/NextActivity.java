package com.example.administrator.oop;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.example.administrator.oop.fragments.NineSquares00;
import com.example.administrator.oop.fragments.NineSquares01;
import com.example.administrator.oop.fragments.NineSquares04;

public class NextActivity extends FragmentActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        Bundle bundle = this.getIntent().getExtras();
        //����nameֵ
        int name = bundle.getInt("num");
        String a = name+"";
        Log.i(NextActivity.ACTIVITY_SERVICE, "============================="+(name));
        //Toast.makeText(getApplicationContext(),(name+' '), Toast.LENGTH_SHORT).show();
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /* Inflate the menu; this adds items to the action bar if it is present. */
        getMenuInflater().inflate(R.menu.menu_next, menu);
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



    private static class MyPagerAdapter extends FragmentPagerAdapter
    {
        private Fragment[] mFragments = new Fragment[3];

        private MyPagerAdapter(FragmentManager fm)
        {
            super(fm);
            mFragments[0] = new NineSquares00();
            mFragments[1] = new NineSquares01();
            mFragments[2] = new NineSquares04();
/*
mFragments[2] = new ChartFragment();
mFragments[3] = new ChartFragment();
mFragments[4] = new ChartFragment();
mFragments[5] = new ChartFragment();
mFragments[6] = new ChartFragment();
mFragments[7] = new ChartFragment();
mFragments[8] = new ChartFragment();
*/


        }

        @Override
        public Fragment getItem(int i)
        {
            return mFragments[i];
        }

        @Override
        public int getCount()
        {
            return mFragments.length;
        }
    }
}
