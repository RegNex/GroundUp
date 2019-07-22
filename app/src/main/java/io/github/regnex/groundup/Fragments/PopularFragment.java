package io.github.regnex.groundup.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import io.github.regnex.groundup.R;

public class PopularFragment extends Fragment {
private static PopularFragment INSTANCE = null;
    public PopularFragment() {
        // Required empty public constructor
    }

    public static PopularFragment getIntance(){
        if (INSTANCE == null)
            INSTANCE = new PopularFragment();
        return INSTANCE;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_popular, container, false);
    }

}
