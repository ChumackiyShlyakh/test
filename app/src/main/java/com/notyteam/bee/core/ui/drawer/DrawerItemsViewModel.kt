package com.notyteam.bee.core.ui.drawer

import android.app.Application
import android.view.MenuItem
import androidx.annotation.NonNull
import androidx.lifecycle.AndroidViewModel
import com.notyteam.bee.core.arch.SingleLiveEvent

class DrawerItemsViewModel(application: Application) : AndroidViewModel(application) {

    private val mutableLiveData = SingleLiveEvent<Int>()

    fun onNavigationClick(@NonNull item: MenuItem): Boolean {
        mutableLiveData.setValue(item.itemId)
        return true
    }

    fun getDrawerItemId(): SingleLiveEvent<Int> {
        return mutableLiveData
    }
}