package com.example.m_sugawara.myapplication.models

import com.example.m_sugawara.myapplication.adapters.commons.AdapterConstants
import com.example.m_sugawara.myapplication.adapters.commons.ViewType

/**
 * Created by m_sugawara on 2017/08/15.
 */
data class RedditNewsItem (
        val author: String,
        val title: String,
        val numComments: Int,
        val created: Long,
        val thumbnail: String,
        val url: String
) : ViewType {
    override fun getViewType(): Int = AdapterConstants.NEWS
}