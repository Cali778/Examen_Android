package com.example.usuario.project.projectasistencia;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.usuario.project.R;
import com.example.usuario.project.dao.EventoDao;
import com.example.usuario.project.to.EventoTO;
import com.example.usuario.project.util.EventoAdapter;

import java.util.List;


public class ReporteFragment extends Fragment {
    private EventoDao dao;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter<EventoViewHolder> adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View myFragmentView= inflater.inflate(R.layout.fragment_reporte, container, false);

        this.recyclerView=(RecyclerView)myFragmentView.findViewById(R.id.recyclerView);
        this.layoutManager = new LinearLayoutManager(this.getContext());
        dao=new EventoDao(this.getContext());
        List<EventoTO> evento=dao.ListarEvento();
        Log.v("DMP", "Cantidad: "+evento.size());
        this.adapter=new EventoAdapter(evento);
        this.recyclerView.setLayoutManager(layoutManager);
        this.recyclerView.setAdapter(adapter);

        return myFragmentView;
    }


}
