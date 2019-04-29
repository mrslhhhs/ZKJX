package com.zkjx.myapplication.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.zkjx.myapplication.R;
import com.zkjx.myapplication.fragment.AskDoctorFragment;
import com.zkjx.myapplication.fragment.HealthFragment;
import com.zkjx.myapplication.fragment.MessageFragment;
import com.zkjx.myapplication.fragment.MineFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private FrameLayout fragLay;
    private RadioGroup rg;
    private Fragment mFragment;//当前显示的Fragment
    private List<Fragment> fragmentList;
    private HealthFragment healthFragment;
    private AskDoctorFragment asdDoctorFragment;
    private MessageFragment messageFragment;
    private MineFragment mineFragment;
    private FragmentManager supportFragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initView();

        initData();
    }

    private void initData() {
        healthFragment = new HealthFragment();
        asdDoctorFragment = new AskDoctorFragment();
        messageFragment = new MessageFragment();
        mineFragment = new MineFragment();
        fragmentList = new ArrayList<>();
        fragmentList.add(healthFragment);
        fragmentList.add(asdDoctorFragment);
        fragmentList.add(messageFragment);
        fragmentList.add(mineFragment);

        supportFragmentManager = getSupportFragmentManager();
        fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragLay, healthFragment);
        fragmentTransaction.commit();

        mFragment= healthFragment;
    }

    private void initView() {


        fragLay = (FrameLayout) findViewById(R.id.fragLay);

        rg = (RadioGroup) findViewById(R.id.rg);

        RadioButton[] radioButtons=new RadioButton[rg.getChildCount()];
        for (int i = 0; i < rg.getChildCount(); i++) {
            radioButtons[i]= (RadioButton) rg.getChildAt(i);
        }

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                for (int i = 0; i <rg.getChildCount() ; i++) {
                    if (rg.getChildAt(i).getId()==checkedId){
                        showFragment(fragmentList.get(i));
                    }
                }
            }
        });
    }

    private void showFragment(Fragment fragment) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        if(mFragment != fragment) {
            //判断切换的Fragment是否已经添加过
            if (!fragment.isAdded()) {
                //如果没有，则先把当前的Fragment隐藏，把切换的Fragment添加上
                getSupportFragmentManager().beginTransaction().hide(mFragment)
                        .add(R.id.fragLay,fragment).commit();
            } else {
                //如果已经添加过，则先把当前的Fragment隐藏，把切换的Fragment显示出来
                getSupportFragmentManager().beginTransaction().hide(mFragment).show(fragment).commit();
            }
            mFragment = fragment;
        }
    }

}
