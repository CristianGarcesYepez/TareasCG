package com.example.tareascg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView; // Add this import
import java.util.ArrayList;
import java.util.List;


public class ProjectsFragment extends Fragment {
    public RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.projects, container, false);
        
        recyclerView = view.findViewById(R.id.projects_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext())); // Fixed method call
        
        List<Project> projects = new ArrayList<>();
        projects.add(new Project("App Books", "Aplicación de biblioteca", R.drawable.appbooks));
        // Add more projects as needed

        ProjectsAdapter adapter = new ProjectsAdapter(getContext(), projects);
        recyclerView.setAdapter(adapter);
        
        return view;
    }
}