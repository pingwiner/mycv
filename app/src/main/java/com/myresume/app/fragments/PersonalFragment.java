package com.myresume.app.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.myresume.app.R;

public class PersonalFragment extends BaseFragment implements View.OnClickListener {
    private static final String MY_PHONE_URL = "tel:+79879467359";

    public static PersonalFragment newInstance() {
        return new PersonalFragment();
    }

    public PersonalFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_personal, container, false);
        View emailView = rootView.findViewById(R.id.email);
        emailView.setOnClickListener(this);
        View phoneView = rootView.findViewById(R.id.phone);
        phoneView.setOnClickListener(this);
        return rootView;
    }

    private void sendEmail() {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType(getString(R.string.message_type));
        String email = getString(R.string.email);
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{email});
        i.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.message_subject));
        i.putExtra(Intent.EXTRA_TEXT   , "");
        try {
            startActivity(Intent.createChooser(i, getString(R.string.send_mail)));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getActivity(),
                    getString(R.string.no_email_client),
                    Toast.LENGTH_SHORT).show();
        }
    }

    private void callMe() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse(MY_PHONE_URL));
        try {
            startActivity(intent);
        } catch (android.content.ActivityNotFoundException e) {
            Toast.makeText(getActivity(), R.string.no_telephony_support, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.email:
                sendEmail();
                break;
            case R.id.phone:
                callMe();
                break;
        }
    }

}
