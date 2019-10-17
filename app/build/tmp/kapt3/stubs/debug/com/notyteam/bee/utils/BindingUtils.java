package com.notyteam.bee.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\fH\u0007J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/notyteam/bee/utils/BindingUtils;", "", "()V", "bindFocusChange", "", "editText", "Landroid/widget/EditText;", "onFocusChangeListener", "Landroid/view/View$OnFocusChangeListener;", "errorMessage", "view", "Lcom/google/android/material/textfield/TextInputLayout;", "", "setOnNavigationItemSelectedListener", "Lcom/google/android/material/navigation/NavigationView;", "listener", "Lcom/google/android/material/navigation/NavigationView$OnNavigationItemSelectedListener;", "app_debug"})
public final class BindingUtils {
    public static final com.notyteam.bee.utils.BindingUtils INSTANCE = null;
    
    @androidx.databinding.BindingAdapter(value = {"app:errorText"})
    public static final void errorMessage(@org.jetbrains.annotations.NotNull()
    com.google.android.material.textfield.TextInputLayout view, @org.jetbrains.annotations.Nullable()
    java.lang.String errorMessage) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"onFocus"})
    public static final void bindFocusChange(@org.jetbrains.annotations.NotNull()
    android.widget.EditText editText, @org.jetbrains.annotations.Nullable()
    android.view.View.OnFocusChangeListener onFocusChangeListener) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"onNavigationItemSelected"})
    public static final void setOnNavigationItemSelectedListener(@org.jetbrains.annotations.NotNull()
    com.google.android.material.navigation.NavigationView view, @org.jetbrains.annotations.NotNull()
    com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener listener) {
    }
    
    private BindingUtils() {
        super();
    }
}