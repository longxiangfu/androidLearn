package com.example.uitest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

/**
 * 自定义View
 */
public class MyView extends LinearLayout {
    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.line_nest, this);
    }
}
