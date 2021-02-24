package adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.contact_naina_co789965.R;

import java.util.ArrayList;

import dashboard.OnItemClickListener;
import room.Contact;

public class NaiContactAdapter extends RecyclerView.Adapter<NaiContactAdapter.ViewHolder> {

    private ArrayList<Contact> contacts;
    private OnItemClickListener onItemClickListener;

    public NaiContactAdapter(ArrayList<Contact> list, @NonNull OnItemClickListener onItemClickListener) {
        contacts = list;
        this.onItemClickListener = onItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        int id;
        TextView firstName, number;
        public ViewHolder(@NonNull View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);

            firstName = itemView.findViewById(R.id.firstName);
            number = itemView.findViewById(R.id.number);
            itemView.findViewById(R.id.btnDelete).setOnClickListener(v -> onItemClickListener.onItemRemovedClicked(id));
            itemView.setOnClickListener(v -> onItemClickListener.onItemClick(id));
            itemView.setOnLongClickListener(v -> {onItemClickListener.onItemLongClick(id); return true;});
        }
    }


    @NonNull
    @Override
    public NaiContactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_contacts, parent, false);
        return new ViewHolder(v, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull NaiContactAdapter.ViewHolder holder, int position) {
        Contact contact = contacts.get(position);
        holder.id = contact.getId();
        holder.firstName.setText(contact.getFirstName() + " " + contact.getLastName());
        holder.number.setText(contact.getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        if (contacts == null) {
            return 0;
        } else {
            return contacts.size();
        }
    }
}










