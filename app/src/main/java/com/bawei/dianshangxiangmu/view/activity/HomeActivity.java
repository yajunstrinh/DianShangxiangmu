package com.bawei.dianshangxiangmu.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bawei.dianshangxiangmu.R;
import com.bawei.dianshangxiangmu.view.adpater.FragmentAdpater;
import com.bawei.dianshangxiangmu.view.fragment.FragmentDing;
import com.bawei.dianshangxiangmu.view.fragment.FragmentHome;
import com.bawei.dianshangxiangmu.view.fragment.FragmentLie;
import com.bawei.dianshangxiangmu.view.fragment.FragmentWo;
import com.bawei.dianshangxiangmu.view.fragment.FragmentZhu;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.viewpager)
    ViewPager mViewpager;
    @BindView(R.id.but1)
    RadioButton mBut1;
    @BindView(R.id.but2)
    RadioButton mBut2;
    @BindView(R.id.but3)
    RadioButton mBut3;
    @BindView(R.id.but4)
    RadioButton mBut4;
    @BindView(R.id.but5)
    RadioButton mBut5;
    @BindView(R.id.group)
    RadioGroup mGroup;
    private FragmentHome fragmentHome;
    private FragmentDing fragmentDing;
    private FragmentLie fragmentLie;
    private FragmentWo fragmentWo;
    private FragmentZhu fragmentZhu;
    private List<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        fragmentHome = new FragmentHome();
        fragmentDing = new FragmentDing();
        fragmentLie = new FragmentLie();
        fragmentWo = new FragmentWo();
        fragmentZhu = new FragmentZhu();
        list = new ArrayList<>();
        list.add(fragmentHome);
        list.add(fragmentDing);
        list.add(fragmentLie);
        list.add(fragmentZhu);
        list.add(fragmentWo);
        FragmentAdpater fragmentAdpater = new FragmentAdpater(getSupportFragmentManager(), list);
        mViewpager.setAdapter(fragmentAdpater);
        mViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                switch (i) {
                    case 0:
                        mGroup.check(R.id.but1);
                        break;
                    case 1:
                        mGroup.check(R.id.but2);
                        break;
                    case 2:
                        mGroup.check(R.id.but3);
                        break;
                    case 3:
                        mGroup.check(R.id.but4);
                        break;
                    case 4:
                        mGroup.check(R.id.but5);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
      mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(RadioGroup group, int checkedId) {
              switch (checkedId){
                  case R.id.but1:
                      mViewpager.setCurrentItem(0);
                      break;
                  case R.id.but2:
                      mViewpager.setCurrentItem(1);
                      break;
                  case R.id.but3:
                      mViewpager.setCurrentItem(2);
                      break;
                  case R.id.but4:
                      mViewpager.setCurrentItem(3);
                      break;
                  case R.id.but5:
                      mViewpager.setCurrentItem(4);
                      break;

              }
          }
      });
    }

}
