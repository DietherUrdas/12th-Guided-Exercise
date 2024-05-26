package com.example.proj12;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter extends ArrayAdapter<String> {
    private Context context;
    private ArrayList<String> contacts;

    public ContactAdapter(Context context, ArrayList<String> contacts) {
        super(context, 0, contacts);
        this.context = context;
        this.contacts = contacts;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false);
        }

        String contact = contacts.get(position);

        TextView tvContactName = convertView.findViewById(R.id.tvContactName);
        Button btnCall = convertView.findViewById(R.id.btnCall);

        tvContactName.setText(contact);

        btnCall.setOnClickListener(v -> {
            Intent intent = new Intent(context, DummyCallActivity.class);
            intent.putExtra("contact", contact);
            context.startActivity(intent);
        });

        return convertView;
    }
}
