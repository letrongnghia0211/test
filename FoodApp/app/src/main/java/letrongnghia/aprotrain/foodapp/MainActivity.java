package letrongnghia.aprotrain.foodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import letrongnghia.aprotrain.foodapp.Adapter.CategoryAdapter;
import letrongnghia.aprotrain.foodapp.Adapter.PopularAdapter;
import letrongnghia.aprotrain.foodapp.database.CategoryData;
import letrongnghia.aprotrain.foodapp.database.FoodData;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter, adapterPopular;
    private RecyclerView recyclerViewCategoryList, recyclerViewPopularList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategory();
        recyclerViewPopular();
        bottomNavigation();
    }
    private void bottomNavigation(){
        FloatingActionButton floatingActionButton = findViewById(R.id.cartBtn);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CartListActivity.class));
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryData> category = new ArrayList<>();
        category.add(new CategoryData("Pizza", "cat_1"));
        category.add(new CategoryData("Burger", "cat_2"));
        category.add(new CategoryData("Hotdog", "cat_3"));
        category.add(new CategoryData("Drink", "cat_4"));
        category.add(new CategoryData("Donut", "cat_5"));

        adapter = new CategoryAdapter(category);
        recyclerViewCategoryList.setAdapter(adapter);
    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList = findViewById(R.id.recyclerView2);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);


        ArrayList<FoodData> foodList = new ArrayList<>();
        foodList.add(new FoodData("Pepperoni pizza", "pizza1", "slices pepperoni, mozzerella cheese, fresh oregano, ground black pepper, pizza sauce", 9.67));
        foodList.add(new FoodData("Cheese Burger", "burger", "beef, Gouda cheese, Special sauce, Lettuce, tomato", 8.79));
        foodList.add(new FoodData("Vegetable pizza", "pizza2", "olice oil, Vegetable oil, pitted kalamata, cherry", 8.7));

        adapterPopular = new PopularAdapter(foodList);
        recyclerViewPopularList.setAdapter(adapterPopular);
    }
}