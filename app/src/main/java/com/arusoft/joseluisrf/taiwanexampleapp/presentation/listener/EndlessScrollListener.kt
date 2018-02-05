package com.arusoft.joseluisrf.taiwanexampleapp.presentation.listener

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView


abstract class EndlessScrollListener constructor() : RecyclerView.OnScrollListener() {
    // The minimum number of items to have below your current scroll position
    // before loading more.
    private var visibleThreshold = 5
    // The current offset index of data you have loaded
    private var currentPage = 0
    // The total number of items in the dataset after the last load
    private var previousTotalItemCount = 0
    // True if we are still waiting for the last set of data to load.
    private var loading = true
    // Sets the starting page index
    private var startingPageIndex = 0
    private var mLayoutManager: LinearLayoutManager? = null


    constructor(linearLayoutManager: LinearLayoutManager) : this() {
        this.mLayoutManager = linearLayoutManager
    }


    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        if( mLayoutManager != null) {

            var totalItemCount = mLayoutManager!!.itemCount
            var lastVisibleItemPosition = (mLayoutManager as LinearLayoutManager).findLastVisibleItemPosition()

            // If it’s still loading, we check to see if the dataset count has
            // changed, if so we conclude it has finished loading and update the current page
            // number and total item count.
            if (loading && totalItemCount > previousTotalItemCount) {
                loading = false
                previousTotalItemCount = totalItemCount
            }

            // If it isn’t currently loading, we check to see if we have breached
            // the visibleThreshold and need to reload more data.
            // If we do need to reload some more data, we execute onLoadMore to fetch the data.
            // threshold should reflect how many total columns there are too
            if (!loading && lastVisibleItemPosition + visibleThreshold > totalItemCount) {
                currentPage++
                onLoadMore(currentPage, totalItemCount, recyclerView)
                loading = true
            }
        }  else {
           //TODO: Throw an exception
        }
    }

    // Call whenever performing new searches
    fun resetState() {
        this.currentPage = this.startingPageIndex
        this.previousTotalItemCount = 0
        this.loading = true
    }

    // Defines the process for actually loading more data based on page
    abstract fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView)
}