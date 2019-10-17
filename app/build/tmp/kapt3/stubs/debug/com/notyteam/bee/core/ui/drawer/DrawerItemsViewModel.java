package com.notyteam.bee.core.ui.drawer;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0010\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\fR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/notyteam/bee/core/ui/drawer/DrawerItemsViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "mutableLiveData", "Lcom/notyteam/bee/core/arch/SingleLiveEvent;", "", "getDrawerItemId", "onNavigationClick", "", "item", "Landroid/view/MenuItem;", "app_debug"})
public final class DrawerItemsViewModel extends androidx.lifecycle.AndroidViewModel {
    private final com.notyteam.bee.core.arch.SingleLiveEvent<java.lang.Integer> mutableLiveData = null;
    
    public final boolean onNavigationClick(@org.jetbrains.annotations.NotNull()
    @androidx.annotation.NonNull()
    android.view.MenuItem item) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.notyteam.bee.core.arch.SingleLiveEvent<java.lang.Integer> getDrawerItemId() {
        return null;
    }
    
    public DrawerItemsViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
}