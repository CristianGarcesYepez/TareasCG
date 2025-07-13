package com.example.tareascg.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.tareascg.R;
import com.example.tareascg.model.Meal;
import java.util.List;

public class MealsAdapter extends RecyclerView.Adapter<MealsAdapter.MealViewHolder> {
    
    private List<Meal> mealsList;
    private Context context;
    private OnMealClickListener onMealClickListener;

    public interface OnMealClickListener {
        void onMealClick(Meal meal);
    }

    public MealsAdapter(Context context, List<Meal> mealsList) {
        this.context = context;
        this.mealsList = mealsList;
    }

    public void setOnMealClickListener(OnMealClickListener listener) {
        this.onMealClickListener = listener;
    }

    @NonNull
    @Override
    public MealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_meal, parent, false);
        return new MealViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MealViewHolder holder, int position) {
        Meal meal = mealsList.get(position);
        
        holder.textMealName.setText(meal.getStrMeal());
        holder.textMealCategory.setText(meal.getStrCategory());
        holder.textMealArea.setText(meal.getStrArea());
        
        // Cargar imagen con Glide
        Glide.with(context)
                .load(meal.getStrMealThumb())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(holder.imageMeal);

        holder.itemView.setOnClickListener(v -> {
            if (onMealClickListener != null) {
                onMealClickListener.onMealClick(meal);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mealsList != null ? mealsList.size() : 0;
    }

    public void updateMeals(List<Meal> newMeals) {
        this.mealsList = newMeals;
        notifyDataSetChanged();
    }

    public static class MealViewHolder extends RecyclerView.ViewHolder {
        ImageView imageMeal;
        TextView textMealName, textMealCategory, textMealArea;

        public MealViewHolder(@NonNull View itemView) {
            super(itemView);
            imageMeal = itemView.findViewById(R.id.imageMeal);
            textMealName = itemView.findViewById(R.id.textMealName);
            textMealCategory = itemView.findViewById(R.id.textMealCategory);
            textMealArea = itemView.findViewById(R.id.textMealArea);
        }
    }
}
