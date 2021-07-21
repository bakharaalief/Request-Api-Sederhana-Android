package com.bakharaalief.requetapisederhana.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bakharaalief.requetapisederhana.R
import com.bakharaalief.requetapisederhana.ui.main.adapter.ListAdapter
import com.bakharaalief.requetapisederhana.ui.main.viewmodel.MainVM

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //setview
        val loadingItem = findViewById<ProgressBar>(R.id.loading)
        val myRV = findViewById<RecyclerView>(R.id.my_rv)

        loadingItem.visibility = View.VISIBLE
        myRV.visibility = View.GONE

        //set viewModel
        val viewModel = ViewModelProvider(this).get(MainVM::class.java)
        viewModel.getData()

        //handle loading
        viewModel.isLoading.observe(this, Observer {
            //still loading
            if(it){
                loadingItem.visibility = View.VISIBLE
                myRV.visibility = View.GONE
            }
            else{
                loadingItem.visibility = View.GONE
                myRV.visibility = View.VISIBLE
            }
        })

        //set recyclerview
        val rvAdapter = ListAdapter()
        viewModel.listPost.observe(this, Observer {
            rvAdapter.listPost = it
        })
        myRV.adapter = rvAdapter
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        myRV.layoutManager = layoutManager
    }
}