package com.example.foodie;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {super(fragmentActivity);}

    @NonNull
    @Override
    // creates a fragment for the viewpager to use
    public Fragment createFragment(int position) {
        switch(position) {
            case 0:
                return new page_1();
            case 1:
                return new page_2();
            default:
                return new page_3();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
