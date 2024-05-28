package com.miempresa.semana12

import android.app.Application
import com.miempresa.semana12.database.MyDatabase

class MyApplication: Application() {
    lateinit var database: MyDatabase
    override fun onCreate() {
        super.onCreate()
        database = MyDatabase.buildDatabase(this)
    }
}