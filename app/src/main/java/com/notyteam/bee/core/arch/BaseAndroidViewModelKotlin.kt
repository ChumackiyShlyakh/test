//package com.notyteam.bee.core.arch
//
//import android.app.Application
//import androidx.annotation.ColorRes
//import androidx.annotation.DimenRes
//import androidx.annotation.PluralsRes
//import androidx.annotation.StringRes
//import androidx.core.content.ContextCompat
//import androidx.databinding.Observable
//import androidx.databinding.PropertyChangeRegistry
//import androidx.lifecycle.AndroidViewModel
//import androidx.lifecycle.Observer
//
//open class BaseAndroidViewModelKotlin(application: Application) : AndroidViewModel(application), Observable {
//
//    @Transient
//    private var mCallbacks: PropertyChangeRegistry? = null
//
//    protected override fun onCleared() {
//        super.onCleared()
//    }
//
//    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback) {
//        synchronized(this) {
//            if (mCallbacks == null) {
//                mCallbacks = PropertyChangeRegistry()
//            }
//        }
//        mCallbacks!!.add(callback)
//    }
//
//    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback) {
//        synchronized(this) {
//            if (mCallbacks == null) {
//                return
//            }
//        }
//        mCallbacks!!.remove(callback)
//    }
//
//    /**
//     * Notifies listeners that all properties of this instance have changed.
//     */
//    fun notifyChange() {
//        synchronized(this) {
//            if (mCallbacks == null) {
//                return
//            }
//        }
//        mCallbacks!!.notifyCallbacks(this, 0, null)
//    }
//
//    /**
//     * Notifies listeners that a specific property has changed. The getter for the property
//     * that changes should be marked with [Bindable] to generate a field in
//     * `BR` to be used as `fieldId`.
//     *
//     * @param fieldId The generated BR id for the Bindable field.
//     */
//    fun notifyPropertyChanged(fieldId: Int) {
//        synchronized(this) {
//            if (mCallbacks == null) {
//                return
//            }
//        }
//        mCallbacks!!.notifyCallbacks(this, fieldId, null)
//    }
//
//    protected fun getString(@StringRes resourceID: Int): String {
//        return getApplication().getString(resourceID)
//    }
//
//    protected fun getString(@StringRes resId: Int, vararg formatArgs: Any): String {
//        return getApplication().getString(resId, formatArgs)
//    }
//
//    protected fun getColor(@ColorRes resourceID: Int): Int {
//        return ContextCompat.getColor(getApplication(), resourceID)
//    }
//
//    protected fun getDimen(@DimenRes resId: Int): Float {
//        return getApplication().getResources().getDimension(resId)
//    }
//
//    protected fun getQuantityString(
//        @PluralsRes id: Int, quantity: Int,
//        vararg formatArgs: Any
//    ): String {
//        return getApplication().getResources().getQuantityString(id, quantity, formatArgs)
//    }
//}