package com.example.m_sugawara.myapplication.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.m_sugawara.myapplication.R
import com.example.m_sugawara.myapplication.adapters.commons.ViewType
import com.example.m_sugawara.myapplication.adapters.commons.ViewTypeDelegateAdapter
import com.example.m_sugawara.myapplication.commons.getFriendlyTime
import com.example.m_sugawara.myapplication.commons.inflate
import com.example.m_sugawara.myapplication.commons.loadImg
import com.example.m_sugawara.myapplication.models.RedditNewsItem
import kotlinx.android.synthetic.main.news_item.view.*

/**
 * Created by m_sugawara on 2017/08/15.
 */
class NewsDelegateAdapter(val viewActions: onViewSelectedListener): ViewTypeDelegateAdapter {

    interface onViewSelectedListener {
        fun onItemSelected(url: String?)
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return TurnsViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as TurnsViewHolder
        holder.bind(item as RedditNewsItem)
    }

    inner class TurnsViewHolder(parent: ViewGroup): RecyclerView.ViewHolder (
            parent.inflate(R.layout.news_item)
    ) {
        fun bind(item: RedditNewsItem) = with(itemView) {
            img_thumbnail.loadImg(item.thumbnail)
            description.text = item.title
            author.text = item.author
            comments.text = "${item.numComments} comments"
            time.text = item.created.getFriendlyTime()

            super.itemView.setOnClickListener { viewActions.onItemSelected(item.url) }
        }
    }

}