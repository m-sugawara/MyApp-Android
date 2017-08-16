package com.example.m_sugawara.myapplication.adapters

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.m_sugawara.myapplication.adapters.commons.AdapterConstants
import com.example.m_sugawara.myapplication.adapters.commons.ViewType
import com.example.m_sugawara.myapplication.adapters.commons.ViewTypeDelegateAdapter
import com.example.m_sugawara.myapplication.models.RedditNewsItem

/**
 * Created by m_sugawara on 2017/08/15.
 */
class NewsAdapter(listener: NewsDelegateAdapter.onViewSelectedListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: ArrayList<ViewType>
    private var delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()
    private val loadingItem = object : ViewType {
        override fun getViewType(): Int = AdapterConstants.LOADING
    }

    init {
        delegateAdapters.put(AdapterConstants.LOADING, LoadingDelegateAdapter())
        delegateAdapters.put(AdapterConstants.NEWS, NewsDelegateAdapter(listener))
        items = ArrayList()

        items.add(loadingItem)
    }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = delegateAdapters.get(viewType).onCreateViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegateAdapters.get(getItemViewType(position)).onBindViewHolder(holder, items[position])
    }

    override fun getItemViewType(position: Int): Int = items[position].getViewType()

    fun getNews(): List<RedditNewsItem> =
            items
                    .filter { it.getViewType() == AdapterConstants.NEWS }
                    .map { it as RedditNewsItem }

    private fun getLastPosition() = if (items.lastIndex == -1) 0 else items.lastIndex
}