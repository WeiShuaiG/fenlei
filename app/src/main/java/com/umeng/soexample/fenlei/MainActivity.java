package com.umeng.soexample.fenlei;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager vp;
    private TextView txtShou;
    private TextView txtGou;
    private List<Fragment> list;
    private ShouFragment shouFragment;
    private GwcFragment gwcFragment;
    private int page = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp = findViewById(R.id.vp);
        txtShou = findViewById(R.id.txt_shouye);
        txtGou = findViewById(R.id.txt_gwc);
        list = new ArrayList<>();
        list.add(new ShouFragment());
        list.add(new GwcFragment());
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        getData(page);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                getData(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        txtShou.setOnClickListener(this);
        txtGou.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.txt_shouye:
                page = 0;
                break;
            case R.id.txt_gwc:
                page = 1;
                break;
        }
        getData(page);
    }
    private void getData(int page) {
        vp.setCurrentItem(page);
        txtShou.setBackgroundColor(page == 0? Color.GRAY:Color.WHITE);
        txtGou.setBackgroundColor(page == 1? Color.GRAY:Color.WHITE);
    }
}
