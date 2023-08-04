package com.cristhoper.aplicacionmen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    private List<Dish> dishes;
    private OnItemClickListener listener;

    // Interfaz para manejar los clicks en los elementos del RecyclerView
    public interface OnItemClickListener {
        void onItemClick(Dish dish);
    }

    public MenuAdapter(List<Dish> dishes, OnItemClickListener listener) {
        this.dishes = dishes;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Dish dish = dishes.get(position);
        holder.tvDishName.setText(dish.getName());
        holder.tvDishDescription.setText(dish.getDescription());
        holder.ivDishImage.setImageResource(dish.getImageResourceId());

        // Escucha el click en el elemento del RecyclerView y notifica al listener
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(dish);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dishes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivDishImage;
        private TextView tvDishName;
        private TextView tvDishDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivDishImage = itemView.findViewById(R.id.ivDishImage);
            tvDishName = itemView.findViewById(R.id.tvDishName);
            tvDishDescription = itemView.findViewById(R.id.tvDishDescription);
        }
    }
}
