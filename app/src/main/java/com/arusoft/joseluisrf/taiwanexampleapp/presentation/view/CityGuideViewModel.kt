package com.arusoft.joseluisrf.taiwanexampleapp.presentation.view

import android.arch.lifecycle.ViewModel
import com.arusoft.joseluisrf.taiwanexampleapp.domain.model.FeedModel
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.LiveData
import android.arch.paging.DataSource
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
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
        private const val PAGE_SIZE = 30

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


    private var feedGuide: MutableLiveData<List<FeedModel>>? = null

    fun getFeedGuide(): LiveData<List<FeedModel>> {
        if (feedGuide == null) {
            feedGuide = MutableLiveData<List<FeedModel>>()
            loadUsers()
        }
        return feedGuide as MutableLiveData<List<FeedModel>>
    }

    private fun loadUsers() {
        useCaseGetCityGuide.execute(object: DisposableSubscriber<DataSource.Factory<Integer, FeedEntity>>(){
            override fun onError(t: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onComplete() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onNext(models: DataSource.Factory<Integer, FeedEntity>) {
                allFeedItems = LivePagedListBuilder(models, PagedList.Config.Builder()
                        .setPageSize(PAGE_SIZE)
                        .setEnablePlaceholders(ENABLE_PLACEHOLDERS)
                        .build()).build()
            }

        }, 10)
    }
}