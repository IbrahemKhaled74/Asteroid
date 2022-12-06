package com.example.egfwd_secound_project.ui.fragment.main

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
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
        setHasOptionsMenu(true)

        adapter.onClickListener = object : AsteroidAdapter.OnClickListener {
            override fun onItemClicked(item: Asteroid?, position: Int) {
                findNavController().navigate(MainDirections.actionMainToDetails(item))

            }
        }
        return binding.root

    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.asteroid_filter, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.show_today_menu -> mainViewModel.asteroidDaily.observe(viewLifecycleOwner) {
                adapter.setNewData(it)
            }
            R.id.show_week_menu -> mainViewModel.asteroidWeek.observe(viewLifecycleOwner) {
                adapter.setNewData(it)
            }
            R.id.show_all_menu -> mainViewModel.asteroid.observe(viewLifecycleOwner) {
                adapter.setNewData(it)
            }
        }
        return super.onOptionsItemSelected(item)
    }


}

