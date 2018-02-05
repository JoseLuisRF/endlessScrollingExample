package com.arusoft.joseluisrf.taiwanexampleapp.presentation.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arusoft.joseluisrf.taiwanexampleapp.R
import com.arusoft.joseluisrf.taiwanexampleapp.databinding.FragmentCityGuideBinding
import com.arusoft.joseluisrf.taiwanexampleapp.di.ComponentsFactory
import com.arusoft.joseluisrf.taiwanexampleapp.presentation.adapter.CityGuideAdapter
import com.arusoft.joseluisrf.taiwanexampleapp.presentation.fragments.base.BaseFragment
import com.arusoft.joseluisrf.taiwanexampleapp.presentation.view.CityGuideViewModel
import com.arusoft.joseluisrf.taiwanexampleapp.presentation.view.CustomViewModelFactory
import javax.inject.Inject


class CityGuideFragment : BaseFragment() {

    private lateinit var binding: FragmentCityGuideBinding

    @Inject lateinit var viewModelFactory: CustomViewModelFactory

    private lateinit var viewModel: CityGuideViewModel

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<FragmentCityGuideBinding>(inflater, R.layout.fragment_city_guide, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        ComponentsFactory.createUserComponent(getApplicationComponent()).inject(this)

        viewModel = viewModelFactory.create(CityGuideViewModel::class.java)

        val adapter = CityGuideAdapter()
        binding.rvFeeds.adapter = adapter

        viewModel.allFeedItems?.observe(this, Observer(adapter::setList))
        viewModel.getFeedGuide()
    }
}