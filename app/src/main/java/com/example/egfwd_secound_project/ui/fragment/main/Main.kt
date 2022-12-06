package com.example.egfwd_secound_project.ui.fragment.main

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.egfwd_secound_project.*
import com.example.egfwd_secound_project.databinding.FragmentMainBinding
import com.example.egfwd_secound_project.ui.api.WebServices
import com.example.egfwd_secound_project.ui.model.Asteroid
import com.example.egfwd_secound_project.ui.rv.AsteroidAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import javax.inject.Inject

@AndroidEntryPoint
class Main : Fragment() {
    lateinit var binding: FragmentMainBinding
    lateinit var recyclerView: RecyclerView
    val mainViewModel: MainViewModel by viewModels()
    @Inject
    lateinit var adapter: AsteroidAdapter

    //
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_main, container,
            false,
        )
        recyclerView = binding.asteroidRV
        recyclerView.adapter = adapter
        binding.lifecycleOwner = this
        binding.viewModel = mainViewModel
        adapter.onClickListener = object : AsteroidAdapter.OnClickListener {
            override fun onItemClicked(item: Asteroid?, position: Int) {
                findNavController().navigate(MainDirections.actionMainToDetails(item))

            }
        }
        return binding.root

    }


}

