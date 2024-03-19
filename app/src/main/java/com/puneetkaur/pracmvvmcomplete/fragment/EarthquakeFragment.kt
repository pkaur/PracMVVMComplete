package com.puneetkaur.pracmvvmcomplete.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.puneetkaur.pracmvvmcomplete.adapter.EarthquakeAdapter
import com.puneetkaur.pracmvvmcomplete.databinding.FragmentEarthquakeBinding
import com.puneetkaur.pracmvvmcomplete.repository.EarthquakeRepository
import com.puneetkaur.pracmvvmcomplete.viewmodel.EarthquakeViewModel
import com.puneetkaur.pracmvvmcomplete.viewmodel.ViewModelFactory

class EarthquakeFragment : Fragment() {
    lateinit var binding: FragmentEarthquakeBinding
    lateinit var viewModel: EarthquakeViewModel
    lateinit var adapter: EarthquakeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEarthquakeBinding.inflate(inflater, container, false)

        val repository = EarthquakeRepository()
        viewModel = ViewModelProvider(this, ViewModelFactory(repository)).get(EarthquakeViewModel::class.java)

        viewModel.earthquakes.observe(this, Observer { response ->
            adapter = response.data?.let { EarthquakeAdapter(it.earthquakes) }!!
            binding.recycleView.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = adapter
            }
        })
        return binding.root
    }
}