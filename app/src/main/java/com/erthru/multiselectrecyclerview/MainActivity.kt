package com.erthru.multiselectrecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {

        var KEY_IS_SELECTED = false
        var KEY_ITEM_SELECTED = ArrayList<Student>()

    }

    val data:ArrayList<Student> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fillData()
        rvMain.layoutManager = LinearLayoutManager(this)
        rvMain.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))

        val adapter = RecyclerViewAdapter(data,this)
        adapter.notifyDataSetChanged()
        rvMain.adapter = adapter

        btnCloseSelectedMain.setOnClickListener {
            KEY_IS_SELECTED = false
            KEY_ITEM_SELECTED.clear()
            recreate()
        }

    }

    private fun fillData(){

        data.add(Student(0,"Asuka Tenjouin"))
        data.add(Student(1,"Judai Yuki"))
        data.add(Student(2,"Jun Manjoume"))
        data.add(Student(3,"Ryo Marufuji"))
        data.add(Student(4,"Sho Marufuji"))
        data.add(Student(5,"Misawa Daichi"))
        data.add(Student(6,"Hayato Maeda"))
        data.add(Student(7,"Rei Saotome"))

    }

}
