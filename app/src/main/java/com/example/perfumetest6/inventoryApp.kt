package com.example.perfumetest6

import android.app.Application

class InventoryApp: Application(){
    override fun onCreate(){
        super.onCreate()
        Graph.provide(this)
    }
}