package com.erthru.multiselectrecyclerview

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_main.view.*

class RecyclerViewAdapter(val data:ArrayList<Student>?, val context:MainActivity) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_main,parent,false))
    }

    override fun getItemCount(): Int = data?.size ?:0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val student = data?.get(position)
        holder.v.tvNameLM.text = student?.name

        holder.v.setOnLongClickListener(object : View.OnLongClickListener{

            override fun onLongClick(p0: View?): Boolean {

                if(!MainActivity.KEY_IS_SELECTED)
                    onSelected(holder.v,student)

                return true
            }

        })

        holder.v.setOnClickListener {

            if(MainActivity.KEY_IS_SELECTED)
                selection(holder.v,student)

        }

    }

    private fun onSelected(v:View,student:Student?){

        MainActivity.KEY_IS_SELECTED = true
        MainActivity.KEY_ITEM_SELECTED.add(student!!)
        v.setBackgroundColor(context.resources.getColor(R.color.colorPrimaryDark))
        v.tvNameLM.setTextColor(context.resources.getColor(R.color.colorWhite))
        context.supportActionBar?.hide()
        context.frameSelectedMain.visibility = View.VISIBLE
        context.tvCountSelectedMain.text = MainActivity.KEY_ITEM_SELECTED.size.toString()+" Selected"
        showSelectedItem()

    }

    private fun selection(v:View,student:Student?){

        if(!MainActivity.KEY_ITEM_SELECTED.contains(student)){
            MainActivity.KEY_ITEM_SELECTED.add(student!!)
            v.setBackgroundColor(context.resources.getColor(R.color.colorPrimaryDark))
            v.tvNameLM.setTextColor(context.resources.getColor(R.color.colorWhite))
            context.tvCountSelectedMain.text = MainActivity.KEY_ITEM_SELECTED.size.toString()+" Selected"
            showSelectedItem()
        }else{
            MainActivity.KEY_ITEM_SELECTED.remove(student!!)
            v.setBackgroundColor(Color.parseColor("#FAFAFA"))
            v.tvNameLM.setTextColor(Color.parseColor("#757575"))
            context.tvCountSelectedMain.text = MainActivity.KEY_ITEM_SELECTED.size.toString()+" Selected"
            showSelectedItem()
        }

    }

    private fun showSelectedItem(){

        Log.d("SELECTED_ITEM",MainActivity.KEY_ITEM_SELECTED.toString())

    }

    class ViewHolder(val v:View) : RecyclerView.ViewHolder(v)

}