package com.xtremecoders.freedom.Fragments;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.xtremecoders.freedom.R;
import com.xtremecoders.freedom.mtplview.MtplButton;
import com.xtremecoders.freedom.mtplview.MtplEditText;


public class AccountFragment extends Fragment implements View.OnClickListener {

    View view;
    ImageView user_pic;
    MtplEditText edt_fname,edt_lname,edt_email,edt_password;
    String fname,lname,email,password;
    MtplButton btn_update;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        view=inflater.inflate(R.layout.fragment_account,container,false);

        init();

        return view;
    }

    public void init()
    {
        user_pic=(ImageView)view.findViewById(R.id.user_pic);
        user_pic.setOnClickListener(this);

        edt_fname=(MtplEditText)view.findViewById(R.id.edt_fname);
        edt_lname=(MtplEditText)view.findViewById(R.id.edt_lname);
        edt_email=(MtplEditText)view.findViewById(R.id.edt_email);
        edt_password=(MtplEditText)view.findViewById(R.id.edt_password);

        btn_update=(MtplButton)view.findViewById(R.id.btn_update);
        btn_update.setOnClickListener(this);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View view) {

        int id=view.getId();

        switch (id)
        {
            case R.id.user_pic:
                SelectUserPic();
                break;

            case R.id.btn_update:
                UpdateDatabase();
                break;
            default:
                break;
        }
    }

    public void UpdateDatabase()
    {

    }

    public void SelectUserPic()
    {

    }

}
