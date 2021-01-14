package com.sagar.softuser_clone.ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sagar.softuser_clone.R

class RegisterFragment : Fragment() {

    private lateinit var registerViewModel: RegisterViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        registerViewModel =
                ViewModelProvider(this).get(RegisterViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_register, container, false)
//        val textView: TextView = root.findViewById(R.id.text_dashboard)
        registerViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
        })
        return root
    }
}