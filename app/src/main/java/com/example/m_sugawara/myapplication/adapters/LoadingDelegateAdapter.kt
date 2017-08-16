package com.example.m_sugawara.myapplication.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.m_sugawara.myapplication.R
import com.example.m_sugawara.myapplication.adapters.commons.ViewType
import com.example.m_sugawara.myapplication.adapters.commons.ViewTypeDelegateAdapter
import com.example.m_sugawara.myapplication.commons.inflate

/**
 * Created by m_sugawara on 2017/08/15.
 */
class LoadingDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup) = LoadingViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }

    class LoadingViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.news_item_loading)
    )
}