package com.example.michael.mycvbeta.dialogs;

import android.app.Dialog;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.michael.mycvbeta.R;

/**
 * Created by Michael on 31-03-2016.
 */
public class GreenbyteIconDialog extends DialogFragment {

    LayoutInflater layoutInflater;
    View v;
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        layoutInflater = getActivity().getLayoutInflater();
        v = layoutInflater.inflate(R.layout.greenbyte_dialog, null);

        return super.onCreateDialog(savedInstanceState);
    }
}
