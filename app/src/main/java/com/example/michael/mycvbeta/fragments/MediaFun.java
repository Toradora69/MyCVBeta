package com.example.michael.mycvbeta.fragments;


        import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

        import com.example.michael.mycvbeta.R;


/**
 * Created by Michael on 16-03-2016.
 */
public class MediaFun extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment3_layout,container, false );

        return v;
    }
}
