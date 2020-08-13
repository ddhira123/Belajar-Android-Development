package com.example.githubuserwithapi.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.githubuserwithapi.R;
import com.example.githubuserwithapi.User;
import com.example.githubuserwithapi.UserAdapter;
import com.example.githubuserwithapi.UserDetails;

import java.util.ArrayList;

import static androidx.recyclerview.widget.RecyclerView.HORIZONTAL;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private UserAdapter adapter;
    private ProgressBar progressBar;
    private PageViewModel pageViewModel;
    private String username;
    private String section;
    private TextView tv_no_data;

    public PlaceholderFragment(int index) {
        // 0 for Following, 1 for Followers
        section = index == 0 ? "Following(s)" : "Follower(s)";
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_user_details, container, false);
        UserDetails activity = (UserDetails) getActivity();
        assert activity != null;
        username = activity.username;
        progressBar = rootView.findViewById(R.id.progress_bar_fol);
        showLoading(true);
        pageViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(PageViewModel.class);
        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.foll_list);
        tv_no_data = rootView.findViewById(R.id.tv_no_data);
        DividerItemDecoration itemDecor = new DividerItemDecoration(rootView.getContext(), HORIZONTAL);
        rv.addItemDecoration(itemDecor);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);
        adapter = new UserAdapter();
        adapter.notifyDataSetChanged();
        rv.setAdapter(adapter);
        return rootView;
    }

    private void showLoading(Boolean state) {
        if (state) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pageViewModel.setListFolUsers(username, section);

        pageViewModel.getListFolUsers().observe(getViewLifecycleOwner(), new Observer<ArrayList<User>>() {
            @Override
            public void onChanged(ArrayList<User> users) {
                adapter.setData(users);
                if (users.isEmpty()) {
                    tv_no_data.setVisibility(View.VISIBLE);
                }
                showLoading(false);
            }
        });

        adapter.setOnItemClickCallback(new UserAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(User data) {
            }
        });
    }
}