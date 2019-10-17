package com.notyteam.bee.registration.login.viewmodel


import android.text.TextUtils
import androidx.lifecycle.MutableLiveData
import android.text.Editable
import android.app.Application
import android.view.View
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import com.notyteam.bee.R
import com.notyteam.bee.core.model.request.LoginModelRequest
import com.notyteam.bee.core.arch.BaseAndroidViewModel
import java.util.regex.Pattern

class LoginViewModel(application: Application) : BaseAndroidViewModel(application) {

    val errorEmailMessage = ObservableField<String>()
    val errorPasswordMessage = ObservableField<String>()
    val isEnabled = ObservableBoolean(false)
    private var onPropertyChangedCallback: Observable.OnPropertyChangedCallback

    private val PASSWORD_MIN_LENGTH = 6
    private val loginModelRequest = LoginModelRequest()
    private val mutableLiveData = MutableLiveData<LoginModelRequest>()

    @Bindable
    private var email: String? = null
    @Bindable
    private var password: String? = null

    init {
        onPropertyChangedCallback = object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable, propertyId: Int) {
                if (propertyId == BR.email || propertyId == BR.password) {
                    if (isEmailValid() && isPasswordValid()) {
                        isEnabled.set(true)
                    }
                    if (!isEmailValid() || !isPasswordValid()) {
                        isEnabled.set(false)
                    }
                }
            }
        }
        addOnPropertyChangedCallback(onPropertyChangedCallback)
    }

    fun onEmailChanged(e: Editable) {
        setEmailIsValid()
        notifyPropertyChanged(BR.email)
    }

    fun onPasswordChanged(e: Editable) {
        setPasswordIsValid()
        notifyPropertyChanged(BR.password)
    }

    fun getEmail(): String? {
        return email
    }

    fun getPassword(): String? {
        return password
    }

    fun setEmail(email: String) {
        this.email = email
    }

    fun setPassword(password: String) {
        this.password = password
    }

    fun getEmailOnFocusChangeListener(): View.OnFocusChangeListener {
        return View.OnFocusChangeListener { view, focused ->
            if (!focused) {
                setEmailIsValid()
            }
        }
    }

    fun getPasswordOnFocusChangeListener(): View.OnFocusChangeListener {
        return View.OnFocusChangeListener { view, focused ->
            if (!focused) {
                setPasswordIsValid()
            }
        }
    }

    fun onButtonFragmentLoginClick() {
        mutableLiveData.setValue(loginModelRequest)
    }

    fun getLoginModelRequest(): MutableLiveData<LoginModelRequest> {
        return mutableLiveData
    }

    private fun setPasswordIsValid() {
        if (isPasswordValid()) {
            errorPasswordMessage.set("")
//            userModelRequest.setPassword(password1!!.trim { it <= ' ' })
        } else {
            if (TextUtils.isEmpty(password)) {
                errorPasswordMessage.set(getString(R.string.empty_password))
            } else if (password!!.length < PASSWORD_MIN_LENGTH) {
                errorPasswordMessage.set(getString(R.string.password_length_error))
            }
        }
        notifyPropertyChanged(BR.password)
    }


    private fun setEmailIsValid() {
        if (isEmailValid()) {
            errorEmailMessage.set("")
//            userModelRequest.setEmail(email1!!.trim { it <= ' ' })
        } else {
            errorEmailMessage.set(
                if (!TextUtils.isEmpty(email))
                    getString(R.string.email_error)
                else
                    getString(R.string.empty_email)
            )
        }
        notifyPropertyChanged(BR.email)
    }

    private fun isPasswordValid(): Boolean {
        return !TextUtils.isEmpty(password) && password!!.length >= PASSWORD_MIN_LENGTH
    }

    private fun isEmailValid(): Boolean {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    protected object Patterns {
        val EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
        val EMAIL_ADDRESS = Pattern.compile(EMAIL_PATTERN)
    }
}
