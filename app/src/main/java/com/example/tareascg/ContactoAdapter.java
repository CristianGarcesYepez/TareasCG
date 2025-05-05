package com.example.tareascg;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import com.example.tareascg.Contacto;

public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.ViewHolder> {
    private List<Contacto> lista;

    public ContactoAdapter(List<Contacto> lista) {
        this.lista = lista;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nombre, apellido, correo, celular;

        public ViewHolder(View view) {
            super(view);
            nombre = view.findViewById(R.id.textNombre);
            apellido = view.findViewById(R.id.textApellido);
            correo = view.findViewById(R.id.textCorreo);
            celular = view.findViewById(R.id.textCelular);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_contact, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Contacto contacto = lista.get(position);
        holder.nombre.setText("Nombre: " + contacto.getNombre());
        holder.apellido.setText("Apellido: " + contacto.getApellido());
        holder.correo.setText("Correo: " + contacto.getCorreo());
        holder.celular.setText("Celular: " + contacto.getCelular());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public void actualizarLista(List<Contacto> nuevaLista) {
        this.lista = nuevaLista;
        notifyDataSetChanged();
    }
}
