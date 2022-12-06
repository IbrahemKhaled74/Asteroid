package com.example.egfwd_secound_project.ui.rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.egfwd_secound_project.R
import com.example.egfwd_secound_project.databinding.AsteroidItemBinding
import com.example.egfwd_secound_project.databinding.FragmentMainBinding
import com.example.egfwd_secound_project.ui.model.Asteroid

class AsteroidAdapter(var asteroidItems:List<Asteroid>?=null) :
    Adapter<AsteroidAdapter.viewHolder>() {

    fun setNewData(newAsteroidItems: List<Asteroid>?){
        val diffCallBack=DiffUtil(asteroidItems,newAsteroidItems)
        val diff=androidx.recyclerview.widget.DiffUtil.calculateDiff(diffCallBack)
        asteroidItems=newAsteroidItems
        diff.dispatchUpdatesTo(this)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view:AsteroidItemBinding=DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.asteroid_item,parent,
            false,
        )
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val item = asteroidItems?.get(position)
        holder.bind(item)
        holder.itemView.setOnClickListener {
            onClickListener.onItemClicked(item,position)
        }
    }
    lateinit var onClickListener: OnClickListener
    interface OnClickListener{
        fun onItemClicked(item: Asteroid?,position: Int)
    }

    override fun getItemCount(): Int=asteroidItems?.size?:0


    inner class viewHolder(val Asteroid: AsteroidItemBinding):ViewHolder(Asteroid.root){
        fun bind(item:Asteroid?){
            Asteroid.item=item
            Asteroid.executePendingBindings()

        }
    }

}