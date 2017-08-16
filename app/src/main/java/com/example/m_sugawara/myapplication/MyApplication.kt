package com.example.m_sugawara.myapplication

import android.app.Application

/**
 * Created by m_sugawara on 2017/08/15.
 */
class MyApplication: Application() {

    private var sApplication: MyApplication

    init {
        sApplication = this
    }

    override fun onCreate() {
        super.onCreate()
    }

    fun getApplication(): MyApplication {
        return sApplication
    }
}