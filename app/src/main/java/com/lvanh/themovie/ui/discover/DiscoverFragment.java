package com.lvanh.themovie.ui.discover;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.lvanh.themovie.R;
import java.util.ArrayList;
import java.util.List;

public class DiscoverFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_discover, container, false);
        ViewPager2 viewPager2 = root.findViewById(R.id.vpi_hot_movie);
        List<String> itemHotMovies = new ArrayList<>();
        itemHotMovies.add("https://image.tmdb.org/t/p/original/fYtHxTxlhzD4QWfEbrC1rypysSD.jpg");
        itemHotMovies.add("https://image.tmdb.org/t/p/original/pci1ArYW7oJ2eyTo2NMYEKHHiCP.jpg");
        itemHotMovies.add("https://image.tmdb.org/t/p/original/2CAL2433ZeIihfX1Hb2139CX0pW.jpg");
        itemHotMovies.add("https://image.tmdb.org/t/p/original/q6y0Go1tsGEsmtFryDOJo3dEmqu.jpg");
        itemHotMovies.add("https://image.tmdb.org/t/p/original/3bhkrj58Vtu7enYsRolD1fZdja1.jpg");
        viewPager2.setAdapter(new ItemHotMovieAdapter(itemHotMovies,viewPager2));
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        return root;
    }
}