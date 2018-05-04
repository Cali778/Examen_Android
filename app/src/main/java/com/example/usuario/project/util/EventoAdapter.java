package com.example.usuario.project.util;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.usuario.project.R;
import com.example.usuario.project.projectasistencia.EventoViewHolder;
import com.example.usuario.project.to.EventoTO;

import java.util.List;

/**
 * Created by davidmp on 26/04/2018.
 */

public class EventoAdapter extends RecyclerView.Adapter<EventoViewHolder> {
    private List<EventoTO> evento;

    public EventoAdapter(List<EventoTO> eventos){
        this.evento=eventos;
    }

    @Override
    public EventoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        View view= LayoutInflater.from(context).inflate(R.layout.lista, parent, false);
        EventoViewHolder viewHolder=new EventoViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(EventoViewHolder holder, int position) {
        EventoTO eventox=evento.get(position);

        holder.setEvento(eventox);
    }

    @Override
    public int getItemCount() {
        return evento.size();
    }
}
