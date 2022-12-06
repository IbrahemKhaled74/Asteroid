package com.example.egfwd_secound_project.ui.rv

import com.example.egfwd_secound_project.ui.model.Asteroid

class DiffUtil(val oldList: List<Asteroid>? , val newList: List<Asteroid>?):androidx.recyclerview.widget.DiffUtil.Callback() {


    override fun getOldListSize(): Int =oldList?.size?:0
    override fun getNewListSize(): Int =newList?.size?:0

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList?.get(oldItemPosition)?.id == newList?.get(newItemPosition)?.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return oldList == newList

    }
}