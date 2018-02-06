package com.arusoft.joseluisrf.taiwanexampleapp.presentation.view

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.PagedList
import android.util.Log
import com.arusoft.joseluisrf.taiwanexampleapp.data.database.entity.FeedEntity
import com.arusoft.joseluisrf.taiwanexampleapp.domain.interactor.UseCaseGetCityGuide
import io.reactivex.subscribers.DisposableSubscriber
import javax.inject.Inject


class CityGuideViewModel @Inject constructor(private val useCaseGetCityGuide: UseCaseGetCityGuide) : ViewModel() {

    companion object {
        /**
         * A good page size is a value that fills at least a screen worth of content on a large
         * device so the User is unlikely to see a null item.
         * You can play with this constant to observe the paging behavior.
         * <p>
         * It's possible to vary this with list device size, but often unnecessary, unless a user
         * scrolling on a large device is expected to scroll through items more quickly than a small
         * device, such as when the large device uses a grid layout of items.
         */
        private const val PAGE_SIZE = 20

        /**
         * If placeholders are enabled, PagedList will report the full size but some items might
         * be null in onBind method (PagedListAdapter triggers a rebind when data is loaded).
         * <p>
         * If placeholders are disabled, onBind will never receive null but as more pages are
         * loaded, the scrollbars will jitter as new pages are loaded. You should probably disable
         * scrollbars if you disable placeholders.
         */
        private const val ENABLE_PLACEHOLDERS = true
    }

    var allFeedItems : LiveData<PagedList<FeedEntity>>? = null

    init {
        loadUsers()
    }


    private fun loadUsers() {
        useCaseGetCityGuide.execute(object : DisposableSubscriber<LiveData<PagedList<FeedEntity>>>() {
            override fun onError(t: Throwable?) {
                t?.printStackTrace()
                Log.d("JLRF", t.toString())
            }

            override fun onComplete() {

            }

            override fun onNext(liveData: LiveData<PagedList<FeedEntity>>) {
                allFeedItems = liveData

            }

        }, 10)
    }
}