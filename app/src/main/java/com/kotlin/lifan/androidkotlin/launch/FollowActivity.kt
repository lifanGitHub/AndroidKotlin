package com.kotlin.lifan.androidkotlin.launch

import android.os.Bundle
import android.os.PersistableBundle
import com.kotlin.lifan.androidkotlin.base.BaseActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * @author: LiFan
 * @date: 2021/11/17
 */
class FollowActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        
    }

    suspend fun x(){
        withContext(Dispatchers.IO){

        }
    }
}