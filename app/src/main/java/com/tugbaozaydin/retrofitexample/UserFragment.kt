package com.tugbaozaydin.retrofitexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tugbaozaydin.retrofitexample.databinding.FragmentUserBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserFragment : Fragment() {

    private val retrofitService = ApiClient.getClient().create(ApiInterface::class.java)
    var userList: MutableList<User> = mutableListOf()
    private var _binding: FragmentUserBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getData()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUserBinding.inflate(inflater, container, false)
        val view = binding.root
        initView()
        return view
    }
    private fun initView() {
        val userListAdapter = UserItemAdapter(userList)
        val recyclerView: RecyclerView = binding.userList
        recyclerView.layoutManager = LinearLayoutManager(context)
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