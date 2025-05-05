package com.example.tareascg;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import android.content.Context;


public class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.ProjectViewHolder> {
    private List<Project> projects;
    private Context context;

    public ProjectsAdapter(Context context, List<Project> projects) {
        this.context = context;
        this.projects = projects;
    }

    @NonNull
    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_project, parent, false);
        return new ProjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder holder, int position) {
        Project project = projects.get(position);
        holder.titleTextView.setText(project.getTitle());
        holder.descriptionTextView.setText(project.getDescription());
        holder.imageView.setImageResource(project.getImageResourceId());
    }

    @Override
    public int getItemCount() {
        return projects.size();
    }

    static class ProjectViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleTextView;
        TextView descriptionTextView;

        ProjectViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.project_image);
            titleTextView = itemView.findViewById(R.id.project_title);
            descriptionTextView = itemView.findViewById(R.id.project_description);
        }
    }
}