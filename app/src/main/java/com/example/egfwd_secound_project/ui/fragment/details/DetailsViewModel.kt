package com.example.egfwd_secound_project.ui.fragment.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailsViewModel :ViewModel(){
    private val _displayDialog = MutableLiveData<Boolean>()
    val displayDialog: LiveData<Boolean>
        get() = _displayDialog

    fun showDialog(){
        _displayDialog.value=true
    }
    fun hideDialog(){
        _displayDialog.value=false
    }

}