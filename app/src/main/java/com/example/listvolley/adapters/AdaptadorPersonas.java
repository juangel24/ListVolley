package com.example.listvolley.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.listvolley.R;
import com.example.listvolley.models.Persona;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorPersonas extends BaseAdapter {
    private List<Persona> listPersonas;
    private Context context;

    public AdaptadorPersonas(Context context, List<Persona> listPersonas){
        this.listPersonas = listPersonas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listPersonas.size();
    }

    @Override
    public Object getItem(int position) {
        return listPersonas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listPersonas.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /*if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.row, null)
        }*/

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.row, null);

        Persona persona = listPersonas.get(position);

        TextView nom = convertView.findViewById(R.id.nom);
        nom.setText(persona.getNombre());

        TextView sex = convertView.findViewById(R.id.ape);
        sex.setText(persona.getApellido());

        TextView age = convertView.findViewById(R.id.age);
        age.setText(persona.getEdad().toString());

        return convertView;
    }
}
