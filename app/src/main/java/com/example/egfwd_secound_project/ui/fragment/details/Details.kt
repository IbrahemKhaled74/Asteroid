package com.example.egfwd_secound_project.ui.fragment.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.egfwd_secound_project.R
import com.example.egfwd_secound_project.databinding.FragmentDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Details : Fragment() {
    lateinit var binding: FragmentDetailsBinding
     val viewModel: DetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(layoutInflater,R.layout.fragment_details,container,false)

        val asteroid=DetailsArgs.fromBundle(requireArguments()).asteroid
        binding.lifecycleOwner = this
        binding.asteroid=asteroid
        binding.viewModel=viewModel
        viewModel.displayDialog.observe(viewLifecycleOwner){
            if (it){
                displayExplanationDialog()
                viewModel.hideDialog()

            }
        }

        return binding.root



    }

    private fun displayExplanationDialog() {
        val builder = AlertDialog.Builder(requireActivity())
            .setMessage(getString(R.string.astronomica_unit_explanation))
            .setPositiveButton(android.R.string.ok, null)

        builder.create().show()
    }

}