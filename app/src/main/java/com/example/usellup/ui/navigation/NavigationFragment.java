package com.example.usellup.ui.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.usellup.databinding.FragmentStackBinding;
import com.example.usellup.ui.favourites.FavouritesViewModel;

public class NavigationFragment extends Fragment {

    private FragmentStackBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NavigationViewModel navigationViewModel = new ViewModelProvider(this).get(NavigationViewModel.class);

        binding = FragmentStackBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textStack;
        navigationViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}