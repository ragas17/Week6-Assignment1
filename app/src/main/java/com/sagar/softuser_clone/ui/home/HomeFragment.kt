package com.sagar.softuser_clone.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sagar.softuser_clone.R
import com.sagar.softuser_clone.adapter.StudentAdapter
import com.sagar.softuser_clone.model.Database

class HomeFragment : Fragment() {

    private lateinit var studentRecycler: RecyclerView
//    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)
        studentRecycler = view.findViewById(R.id.rvStudentRecycler)

        val studentData = Database.instance?.studentData

        val studentAdapter = StudentAdapter(studentData, this)
        studentRecycler.layoutManager = LinearLayoutManager(activity)
        studentRecycler.adapter = studentAdapter

        return view

//        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
//        val root = inflater.inflate(R.layout.fragment_home, container, false)
//        studentRecycler = root.findViewById(R.id.rvStudentRecycler)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
//        return root
    }
}