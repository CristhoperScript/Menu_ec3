package com.cristhoper.aplicacionmen;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    private List<Dish> dishes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Crea una lista de platillos
        dishes = new ArrayList<>();
        dishes.add(new Dish("Ceviche", "Ceviche es un plato tradicional peruano", "Pescado, limón, cebolla, ají", 20.99, R.drawable.cevi));
        dishes.add(new Dish("Lomo Saltado", "Lomo Saltado es un plato de carne con vegetales y papas fritas", "Carne de res, cebolla, tomate, papas", 18.50, R.drawable.lomito));
        dishes.add(new Dish("Aji de Gallina", "Aji de Gallina es un delicioso plato hecho con una crema espesa de ají amarillo, pollo desmenuzado y nueces.", "Pollo, ají amarillo, leche, nueces, pan, queso", 15.75, R.drawable.ajic));
        dishes.add(new Dish("Causa Rellena", "Causa Rellena es una especie de pastel de papa amarilla relleno con pollo, atún o mariscos y aliñado con ají amarillo.", "Papa amarilla, pollo, atún o mariscos, ají amarillo, limón", 12.80, R.drawable.causi));
        dishes.add(new Dish("Anticuchos", "Anticuchos son brochetas de corazón de res marinadas en una mezcla de ají panca, ajo y vinagre, asadas a la parrilla.", "Corazón de res, ají panca, ajo, vinagre", 14.50, R.drawable.anti));
        dishes.add(new Dish("Rocoto Relleno", "Rocoto Relleno es un plato típico de Arequipa que consiste en pimientos rocotos rellenos de carne, cebolla y maní.", "Rocotos, carne, cebolla, maní, queso", 16.25, R.drawable.rokotin));
        dishes.add(new Dish("Tacu Tacu", "Tacu Tacu es un plato hecho con arroz y frijoles refritos, acompañado de carne, mariscos o huevos fritos.", "Arroz, frijoles, carne o mariscos, huevos", 13.90, R.drawable.tacytacy));
        dishes.add(new Dish("Papa a la Huancaina", "Papa a la Huancaina es una entrada deliciosa que consiste en papas sancochadas cubiertas con una crema de ají amarillo y queso.", "Papas, ají amarillo, queso, leche, galletas", 10.50, R.drawable.huancaina));
        // Agrega más platillos aquí...

        // Configura el RecyclerView y el adaptador
        RecyclerView recyclerViewMenu = findViewById(R.id.recyclerViewMenu);
        recyclerViewMenu.setLayoutManager(new LinearLayoutManager(this));
        MenuAdapter menuAdapter = new MenuAdapter(dishes, new MenuAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Dish dish) {
                // Abre la actividad de detalle del platillo al hacer clic
                Intent intent = new Intent(MenuActivity.this, DishDetailActivity.class);
                intent.putExtra("dish", dish);
                startActivity(intent);
            }
        });
        recyclerViewMenu.setAdapter(menuAdapter);
    }
}