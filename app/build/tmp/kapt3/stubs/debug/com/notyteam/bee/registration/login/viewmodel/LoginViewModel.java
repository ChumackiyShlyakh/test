package com.notyteam.bee.registration.login.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001,B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0019\u001a\u0004\u0018\u00010\bJ\u0006\u0010\u001a\u001a\u00020\u001bJ\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015J\b\u0010\u001d\u001a\u0004\u0018\u00010\bJ\u0006\u0010\u001e\u001a\u00020\u001bJ\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020 H\u0002J\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&J\u000e\u0010\'\u001a\u00020#2\u0006\u0010%\u001a\u00020&J\u000e\u0010(\u001a\u00020#2\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010)\u001a\u00020#H\u0002J\u000e\u0010*\u001a\u00020#2\u0006\u0010\u0018\u001a\u00020\bJ\b\u0010+\u001a\u00020#H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lcom/notyteam/bee/registration/login/viewmodel/LoginViewModel;", "Lcom/notyteam/bee/core/arch/BaseAndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "PASSWORD_MIN_LENGTH", "", "email", "", "errorEmailMessage", "Landroidx/databinding/ObservableField;", "getErrorEmailMessage", "()Landroidx/databinding/ObservableField;", "errorPasswordMessage", "getErrorPasswordMessage", "isEnabled", "Landroidx/databinding/ObservableBoolean;", "()Landroidx/databinding/ObservableBoolean;", "loginModelRequest", "Lcom/notyteam/bee/core/model/request/LoginModelRequest;", "mutableLiveData", "Landroidx/lifecycle/MutableLiveData;", "onPropertyChangedCallback", "Landroidx/databinding/Observable$OnPropertyChangedCallback;", "password", "getEmail", "getEmailOnFocusChangeListener", "Landroid/view/View$OnFocusChangeListener;", "getLoginModelRequest", "getPassword", "getPasswordOnFocusChangeListener", "isEmailValid", "", "isPasswordValid", "onButtonFragmentLoginClick", "", "onEmailChanged", "e", "Landroid/text/Editable;", "onPasswordChanged", "setEmail", "setEmailIsValid", "setPassword", "setPasswordIsValid", "Patterns", "app_debug"})
public final class LoginViewModel extends com.notyteam.bee.core.arch.BaseAndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.databinding.ObservableField<java.lang.String> errorEmailMessage = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.databinding.ObservableField<java.lang.String> errorPasswordMessage = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.databinding.ObservableBoolean isEnabled = null;
    private androidx.databinding.Observable.OnPropertyChangedCallback onPropertyChangedCallback;
    private final int PASSWORD_MIN_LENGTH = 6;
    private final com.notyteam.bee.core.model.request.LoginModelRequest loginModelRequest = null;
    private final androidx.lifecycle.MutableLiveData<com.notyteam.bee.core.model.request.LoginModelRequest> mutableLiveData = null;
    @androidx.databinding.Bindable()
    private java.lang.String email;
    @androidx.databinding.Bindable()
    private java.lang.String password;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.databinding.ObservableField<java.lang.String> getErrorEmailMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.databinding.ObservableField<java.lang.String> getErrorPasswordMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.databinding.ObservableBoolean isEnabled() {
        return null;
    }
    
    public final void onEmailChanged(@org.jetbrains.annotations.NotNull()
    android.text.Editable e) {
    }
    
    public final void onPasswordChanged(@org.jetbrains.annotations.NotNull()
    android.text.Editable e) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getEmail() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPassword() {
        return null;
    }
    
    public final void setEmail(@org.jetbrains.annotations.NotNull()
    java.lang.String email) {
    }
    
    public final void setPassword(@org.jetbrains.annotations.NotNull()
    java.lang.String password) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View.OnFocusChangeListener getEmailOnFocusChangeListener() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View.OnFocusChangeListener getPasswordOnFocusChangeListener() {
        return null;
    }
    
    public final void onButtonFragmentLoginClick() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.notyteam.bee.core.model.request.LoginModelRequest> getLoginModelRequest() {
        return null;
    }
    
    private final void setPasswordIsValid() {
    }
    
    private final void setEmailIsValid() {
    }
    
    private final boolean isPasswordValid() {
        return false;
    }
    
    private final boolean isEmailValid() {
        return false;
    }
    
    public LoginViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u00c4\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/notyteam/bee/registration/login/viewmodel/LoginViewModel$Patterns;", "", "()V", "EMAIL_ADDRESS", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "getEMAIL_ADDRESS", "()Ljava/util/regex/Pattern;", "EMAIL_PATTERN", "", "getEMAIL_PATTERN", "()Ljava/lang/String;", "app_debug"})
    public static final class Patterns {
        @org.jetbrains.annotations.NotNull()
        private static final java.lang.String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        private static final java.util.regex.Pattern EMAIL_ADDRESS = null;
        public static final com.notyteam.bee.registration.login.viewmodel.LoginViewModel.Patterns INSTANCE = null;
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getEMAIL_PATTERN() {
            return null;
        }
        
        public final java.util.regex.Pattern getEMAIL_ADDRESS() {
            return null;
        }
        
        private Patterns() {
            super();
        }
    }
}