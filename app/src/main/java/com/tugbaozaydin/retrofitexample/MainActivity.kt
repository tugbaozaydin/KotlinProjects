package com.tugbaozaydin.retrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val retrofitService = ApiClient.getClient().create(ApiInterface::class.java)
     var userList: MutableList<User> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getData()
        initView()


    }

    private fun initView() {
        val userListAdapter = UserItemAdapter(userList)
        val recyclerView: RecyclerView = findViewById(R.id.user_list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = userListAdapter
    }

    private fun getData() {
        retrofitService.getUserData().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                response.body()?.let { userList.addAll(it) }
                if (response.isSuccessful) {
                    userList = (response.body() as MutableList<User>?)!!
                    initView()
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
            }

        })
    }
}