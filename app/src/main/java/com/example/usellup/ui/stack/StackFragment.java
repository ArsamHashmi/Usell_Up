package com.example.usellup.ui.stack;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.usellup.databinding.FragmentStackBinding;

public class StackFragment extends Fragment {

    private FragmentStackBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        StackViewModel stackViewModel = new ViewModelProvider(this).get(StackViewModel.class);

        binding = FragmentStackBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textStack;
        stackViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}