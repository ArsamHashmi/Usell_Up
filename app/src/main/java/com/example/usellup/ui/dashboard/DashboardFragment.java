package com.example.usellup.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.usellup.R;
import com.example.usellup.adapters.ProductsRecyclerAdapter;
import com.example.usellup.adapters.SliderAdapter;
import com.example.usellup.adapters.UsersRecyclerAdapter;
import com.example.usellup.databinding.FragmentDashboardBinding;
import com.example.usellup.models.product_model;
import com.example.usellup.models.slider_model;
import com.example.usellup.models.user_model;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private SliderView sliderView;
    private RecyclerView recyclerView_MainCategory, recyclerView_SubCategory, recyclerView_users;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        sliderView = binding.slider;
        recyclerView_MainCategory = binding.recyclerViewMainCategory;
        recyclerView_SubCategory = binding.recyclerViewSubCategory;
        recyclerView_users = binding.recyclerViewUsers;

        ArrayList<slider_model> sliderDataArrayList = new ArrayList<>();
        sliderDataArrayList.add(new slider_model(R.drawable.slider_img1, 1000, 500,50));
        sliderDataArrayList.add(new slider_model(R.drawable.slider_img2, 500,400,20));

        setupImageSlider(sliderDataArrayList);
        setupRecyclerViewUsers();
        setupProductsRecyclerView();

        return root;
    }

    private void setupImageSlider(ArrayList<slider_model> list){

        SliderAdapter adapter = new SliderAdapter(list);
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
        sliderView.setSliderAdapter(adapter);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();
    }

    private void setupRecyclerViewUsers(){
        user_model item1 = new user_model("Girl",R.drawable.profile_one);
        user_model item2 = new user_model("Boy",R.drawable.profile_two);
        user_model item3 = new user_model("Courage 1",R.drawable.profile_three);
        user_model item4 = new user_model("Tom1",R.drawable.profile_four);
        user_model item5 = new user_model("Tom2",R.drawable.profile_five);
        user_model item6 = new user_model("Courage2",R.drawable.profile_six);

        ArrayList<user_model> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);

        UsersRecyclerAdapter adapter = new UsersRecyclerAdapter(items,getActivity());
        recyclerView_users.setHasFixedSize(true);
        recyclerView_users.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView_users.setAdapter(adapter);
    }

    private void setupRecyclerViewSubcategory(ArrayList<product_model> items){
        ProductsRecyclerAdapter adapter = new ProductsRecyclerAdapter(items,getActivity());
        recyclerView_MainCategory.setHasFixedSize(true);
        recyclerView_MainCategory.setLayoutManager(new GridLayoutManager(getContext(), 3, GridLayoutManager.VERTICAL, false));
        recyclerView_MainCategory.setAdapter(adapter);
    }

    private void setupRecyclerViewMainCategory(ArrayList<product_model> items){
        ProductsRecyclerAdapter adapter = new ProductsRecyclerAdapter(items,getActivity());
        recyclerView_SubCategory.setHasFixedSize(true);
        recyclerView_SubCategory.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView_SubCategory.setAdapter(adapter);
    }

    private void setupProductsRecyclerView(){
        product_model item1 = new product_model(R.drawable.product_red_shirt, 3.5f, 50, 500,1000,50.0,"Red Shirt");
        product_model item2 = new product_model(R.drawable.product_yellow_shirt, 5.0f, 30, 700,1000,3.0,"Yellow Shirt");
        product_model item3 = new product_model(R.drawable.product_shirts, 1.0f, 10, 900,1000,10.0,"Shirts");
        product_model item4 = new product_model(R.drawable.product_yellow_shirt, 4.0f, 60, 400,1000,3.0,"Yellow Shirt2");
        product_model item5 = new product_model(R.drawable.product_red_shirt, 2.5f, 40, 600,1000,30.0,"Red Shirt2");
        product_model item6 = new product_model(R.drawable.product_shirts, 1.5f, 10, 450,500,11.0,"Many Shirts");
        product_model item7 = new product_model(R.drawable.product_red_shirt, 2.0f, 50, 500,1000,50.0,"Red Shirt3");
        product_model item8 = new product_model(R.drawable.product_shirts, 4.7f, 10, 900,1000,10.0,"IDK shirts");
        product_model item9 = new product_model(R.drawable.product_yellow_shirt, 5.0f, 30, 700,1000,32.0,"Yellow Shirt3");

        ArrayList<product_model> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);
        items.add(item7);
        items.add(item8);
        items.add(item9);

        setupRecyclerViewMainCategory(items);
        setupRecyclerViewSubcategory(items);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
