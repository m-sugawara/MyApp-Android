package com.example.m_sugawara.myapplication.adapters.commons

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Created by m_sugawara on 2017/08/15.
 */

interface ViewTypeDelegateAdapter {
    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder

    fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType)
}