package com.example.fragmenttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Fragment fg1, fg2, fg3, fg4;
    FragmentManager fragmentManager;
    ImageView iv1, iv2, iv3, iv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        /*
//        动态加载碎片
//         */
//        MyFragment myFragment = new MyFragment();
//        //获取碎片管理器
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        //获取碎片事务管理器
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        //添加碎片到帧布局上
//        fragmentTransaction.add(R.id.frameLayout, myFragment);
//        //提交事务
//        fragmentTransaction.commit();


//        //Fragment获取Activity组件
//        myFragment.getActivity().findViewById(R.id.frameLayout);
//        //Activity获取Fragment组件
//        myFragment.getView().findViewById(R.id.fragment_iv);


        fragmentManager = getSupportFragmentManager();
        //把四个按钮的点击事件监听接口都设置为MainActivity
        //用户点击任意按钮，都将调用onClick函数
        iv1 = findViewById(R.id.btn_msg);
        iv1.setOnClickListener(this);
        iv2 = findViewById(R.id.btn_cot);
        iv2.setOnClickListener(this);
        iv3 = findViewById(R.id.btn_find);
        iv3.setOnClickListener(this);
        iv4 = findViewById(R.id.btn_me);
        iv4.setOnClickListener(this);

        //初始化，默认第一个图标被选中
        iv1.setImageResource(R.drawable.xiaoxi2);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fg1 = new MyFragment(R.drawable.img1, "第1个碎片");
        fragmentTransaction.add(R.id.frameLayout, fg1);

    }

    @Override
    public void onClick(View v) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //隐藏所有碎片
        if (fg1 != null) fragmentTransaction.hide(fg1);
        if (fg2 != null) fragmentTransaction.hide(fg2);
        if (fg3 != null) fragmentTransaction.hide(fg3);
        if (fg4 != null) fragmentTransaction.hide(fg4);
        //所有按钮变灰色
        iv1.setImageResource(R.drawable.xiaoxi1);
        iv2.setImageResource(R.drawable.tongxunlu1);
        iv3.setImageResource(R.drawable.faxian1);
        iv4.setImageResource(R.drawable.wode1);

        int id = v.getId();
        switch (id){
            case R.id.btn_msg:
                if (fg1 == null) {
                    fg1 = new MyFragment(R.drawable.img1, "第1个碎片");
                    fragmentTransaction.add(R.id.frameLayout, fg1);
                }
                fragmentTransaction.show(fg1);
                iv1.setImageResource(R.drawable.xiaoxi2);
                break;
            case R.id.btn_cot:
                if (fg2 == null) {
                    fg2 = new MyFragment(R.drawable.img2, "第2个碎片");
                    fragmentTransaction.add(R.id.frameLayout, fg2);
                }
                fragmentTransaction.show(fg2);
                iv2.setImageResource(R.drawable.tongxunlu2);
                break;
            case R.id.btn_find:
                if (fg3 == null) {
                    fg3 = new MyFragment(R.drawable.img3, "第3个碎片");
                    fragmentTransaction.add(R.id.frameLayout, fg3);
                }
                fragmentTransaction.show(fg3);
                iv3.setImageResource(R.drawable.faxian2);
                break;
            case R.id.btn_me:
                if (fg4 == null) {
                    fg4 = new MyFragment(R.drawable.img4, "第4个碎片");
                    fragmentTransaction.add(R.id.frameLayout, fg4);
                }
                fragmentTransaction.show(fg4);
                iv4.setImageResource(R.drawable.wode2);
                break;
        }
        fragmentTransaction.commit();
    }


}