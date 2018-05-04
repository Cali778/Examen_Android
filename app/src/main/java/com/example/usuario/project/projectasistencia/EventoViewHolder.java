package com.example.usuario.project.projectasistencia;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.usuario.project.R;
import com.example.usuario.project.to.EventoTO;



/**
 * Created by davidmp on 26/04/2018.
 */

public class EventoViewHolder extends RecyclerView.ViewHolder {
    private TextView txtNombre;
    private TextView txtLugar;

    private EventoTO evento;


    public EventoViewHolder(View itemView) {
        super(itemView);
        this.txtNombre=(TextView) itemView.findViewById(R.id.txtNombre);
        this.txtLugar=(TextView) itemView.findViewById(R.id.txtLugar);

        itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Context context=v.getContext();
                Toast.makeText(context,evento.getNombreevento(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setEvento(EventoTO evento){
        this.evento=evento;
        this.txtNombre.setText(evento.getNombreevento());
        this.txtLugar.setText(evento.getLugarevento());
    }

}
