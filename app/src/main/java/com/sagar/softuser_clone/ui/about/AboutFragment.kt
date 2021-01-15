package com.sagar.softuser_clone.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sagar.softuser_clone.R

class AboutFragment : Fragment() {

    private lateinit var loadWebPage: WebView

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_about, container, false)
        loadWebPage = root.findViewById(R.id.webView)
        loadWebPage.loadUrl("https://softwarica.edu.np/about-softwarica/")
        return root
    }
}