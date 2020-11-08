package com.example.madlevel3task2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_portal.view.*


//declare the data set that is going to be displayed in the list
// so its going to  be an arraylist with items (THIS IS THE LIST)
//what type of viewholder is going to be recycled in my list

class PortalAdapter(private var items: List<Portal>):
RecyclerView.Adapter<PortalAdapter.PortalViewHolder>() {

    // everytime you have a reclycerview, you need to build a custom view holder class that
    //describes what the views are going to be looking like in your recyclerview
    inner class PortalViewHolder constructor(
            //inside the constructor you want to take a single parameter
            //so its going to be a view object
            itemView: View
            //this is the recyler view holder that is passed in the adapter
            // So that a view holder class is created
            //So its passing the view as input to the constructor of the view holder
    ) : RecyclerView.ViewHolder(itemView) {


        //create a bind method
        // this is going to be responsible for taking each individual item_name object
        // binding the item_name objects to the views in the layout

        fun databind(portal: Portal) {
            itemView.tvPortaltitle.text = portal.PortalTitle
            itemView.tvPortaltext.text = portal.PortalsText
        }
    }


    //this will tell the recyler view or its for creating different view holders in the list
    //this is resposible for creating each individual view holder
    //needs to return a new view holder object
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortalViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_portal, parent, false)
        return PortalViewHolder(v)
    }

    override fun onBindViewHolder(holder: PortalViewHolder, position: Int) {
        //in most cases you have different view holders, but in this case we have on viewholder
        //when view holder is the type of quiz view holder then that means this is what i wanna display, the items

        holder.databind(items[position])
    }

    override fun getItemCount(): Int {
        //this will tell the recyler view how many items are inside of your list
        return items.size
    }
}