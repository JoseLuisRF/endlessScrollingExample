package com.arusoft.joseluisrf.taiwanexampleapp.presentation.fragments

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arusoft.joseluisrf.taiwanexampleapp.R
import com.arusoft.joseluisrf.taiwanexampleapp.databinding.FragmentCityGuideBinding
import com.arusoft.joseluisrf.taiwanexampleapp.di.ComponentsFactory
import com.arusoft.joseluisrf.taiwanexampleapp.domain.model.FeedModel
import com.arusoft.joseluisrf.taiwanexampleapp.presentation.adapter.CityGuideAdapter
import com.arusoft.joseluisrf.taiwanexampleapp.presentation.fragments.base.BaseFragment
import com.arusoft.joseluisrf.taiwanexampleapp.presentation.listener.EndlessScrollListener
import com.arusoft.joseluisrf.taiwanexampleapp.presentation.presenter.CityGuidePresenter
import com.arusoft.joseluisrf.taiwanexampleapp.presentation.view.CityGuideView
import javax.inject.Inject


class CityGuideFragment : BaseFragment(), CityGuideView {

    private lateinit var binding: FragmentCityGuideBinding
    private val PAGE_SIZE = 5

    @Inject
    lateinit var presenter: CityGuidePresenter

    private var adapter = CityGuideAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<FragmentCityGuideBinding>(inflater, R.layout.fragment_city_guide, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        ComponentsFactory.createUserComponent(getApplicationComponent()).inject(this)
        presenter.view = this
        val linearLayoutManager = LinearLayoutManager(context)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.rvFeeds.layoutManager = linearLayoutManager
        binding.rvFeeds.adapter = adapter
        binding.swipeRefresh.setOnRefreshListener {
            object : SwipeRefreshLayout.OnRefreshListener {
                override fun onRefresh() {
                    //TODO: Refresh Data displayed on the screen based on current Page
                    //presenter.refreshData(page)
                }
            }
        }

        binding.rvFeeds.addOnScrollListener(object : EndlessScrollListener() {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView) {
                presenter.loadFeed(page)
            }
        })
        presenter.loadFeed(1)
    }

    override fun onLoadFeedError() {
        //TODO: show error description
    }


    override fun onLoadFeedSuccess(models: MutableList<FeedModel>) {
        adapter.removeLoading()
        if (!models.isEmpty()) {
            models.forEach { m -> adapter.add(m) }
            if (adapter.itemCount >= PAGE_SIZE) {
                adapter.addLoading()
            }
        }
    }
}