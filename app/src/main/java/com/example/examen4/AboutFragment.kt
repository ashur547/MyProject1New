package com.example.examen4

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class AboutFragment : Fragment() {

    lateinit var developerRecyclerView: RecyclerView
    lateinit var showWebSiteButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_about, container, false)

        val developersNames: List<String> = listOf("Sofee")

        showWebSiteButton=view.findViewById(R.id.show_web_site_buttom)
        developerRecyclerView = view.findViewById(R.id.developer_recycler_view)
        developerRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        developerRecyclerView.adapter=DeveloperAdapter(developersNames)

        showWebSiteButton.setOnClickListener {
            val link = Uri.parse("https://youtu.be/76mbfupZn0c/")
            val intent = Intent(Intent.ACTION_VIEW, link)
            context?.startActivity(intent)
        }
        return view
    }

}