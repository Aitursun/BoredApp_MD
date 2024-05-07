package com.example.boredapp_md.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.example.boredapp_md.Prefs;
import com.example.boredapp_md.R;
import com.example.boredapp_md.databinding.FragmentBoardBinding;

public class BoardFragment extends Fragment {

    private FragmentBoardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentBoardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        new Prefs(requireContext()).saveBoardState();

        binding.viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                changeColor();
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
                changeColor();
            }
        });


        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        BoardAdapter adapter = new BoardAdapter();
        binding.viewPager2.setAdapter(adapter);

//---------------------------ВЫХОД-------------------------
        requireActivity().getOnBackPressedDispatcher()
                .addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
                    @Override
                    public void handleOnBackPressed() {
                        requireActivity().finish();
                    }
                });
//---------------------------------------------------------
    }

    private void changeColor() {
        if(binding.viewPager2.getCurrentItem() == 0){
            binding.iv1.setImageResource(R.drawable.color_active_bg);
            binding.iv2.setImageResource(R.drawable.grey_bg);
            binding.iv3.setImageResource(R.drawable.grey_bg);
        } else {
            if(binding.viewPager2.getCurrentItem() == 1){
                binding.iv1.setImageResource(R.drawable.grey_bg);
                binding.iv2.setImageResource(R.drawable.color_active_bg);
                binding.iv3.setImageResource(R.drawable.grey_bg);
            }else {

                binding.iv1.setImageResource(R.drawable.grey_bg);
                binding.iv2.setImageResource(R.drawable.grey_bg);
                binding.iv3.setImageResource(R.drawable.color_active_bg);
            }
        }
    };


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}