package com.example.fragmenttest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyFragment extends Fragment {

    private int img;
    private String text;

    public MyFragment(int img, String text){
        this.img = img;
        this.text = text;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);
        ImageView fragement_iv = view.findViewById(R.id.fragment_iv);
        fragement_iv.setImageResource(img);
        TextView fragment_tv = view.findViewById(R.id.fragment_tv);
        fragment_tv.setText(text);
        return view;
    }


}
