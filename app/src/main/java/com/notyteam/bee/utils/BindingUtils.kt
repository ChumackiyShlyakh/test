package com.notyteam.bee.utils

import android.view.View
import android.widget.EditText
import androidx.databinding.BindingAdapter
import com.google.android.material.navigation.NavigationView
import com.google.android.material.textfield.TextInputLayout

object BindingUtils {

    @JvmStatic
    @BindingAdapter("app:errorText")
    fun errorMessage(view: TextInputLayout, errorMessage: String?) {
        view.error = errorMessage
    }

    @JvmStatic
    @BindingAdapter("onFocus")
    fun bindFocusChange(editText: EditText, onFocusChangeListener: View.OnFocusChangeListener?) {
        if (editText.onFocusChangeListener == null) {
            editText.onFocusChangeListener = onFocusChangeListener
        }
    }

    @JvmStatic
    @BindingAdapter("onNavigationItemSelected")
    fun setOnNavigationItemSelectedListener(
        view: NavigationView, listener: NavigationView.OnNavigationItemSelectedListener
    ) {
        view.setNavigationItemSelectedListener(listener)
    }
}