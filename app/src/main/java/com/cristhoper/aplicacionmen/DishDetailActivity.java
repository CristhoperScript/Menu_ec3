package com.cristhoper.aplicacionmen;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DishDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish_detail);

        // Obtiene el platillo de la actividad anterior
        Dish dish = getIntent().getParcelableExtra("dish");

        // Muestra los detalles del platillo en la nueva actividad
        ImageView ivDishImage = findViewById(R.id.ivDishImage);
        TextView tvDishName = findViewById(R.id.tvDishName);
        TextView tvDishDescription = findViewById(R.id.tvDishDescription);
        TextView tvIngredients = findViewById(R.id.tvIngredients);
        TextView tvPrice = findViewById(R.id.tvPrice);

        ivDishImage.setImageResource(dish.getImageResourceId());
        tvDishName.setText(dish.getName());
        tvDishDescription.setText(dish.getDescription());
        tvIngredients.setText(dish.getIngredients());
        tvPrice.setText("Precio: $" + dish.getPrice());
    }
}
