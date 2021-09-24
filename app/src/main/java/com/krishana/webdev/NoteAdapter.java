package com.krishana.webdev;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class NoteAdapter extends FirestoreRecyclerAdapter <Note,NoteAdapter.NoteHolder> {

    public NoteAdapter(@NonNull FirestoreRecyclerOptions<Note> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull NoteHolder holder, int position, @NonNull Note model) {
            holder.textviewtitle.setText(model.getTitle());
            holder.textviewdescription.setText(model.getDescription());
            holder.textviewPriority.setText(String.valueOf(model.getPriority()));
    }
    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item,
                parent, false);
        return new NoteHolder(v);

    }

    class NoteHolder extends RecyclerView.ViewHolder{
        TextView textviewtitle;
        TextView textviewdescription;
        TextView textviewPriority;

        public NoteHolder(View itemView){
            super(itemView);
            textviewtitle = itemView.findViewById(R.id.text_view_title);
            textviewdescription = itemView.findViewById(R.id.text_view_description);
            textviewPriority = itemView.findViewById(R.id.text_priority);

        }
    }
}
