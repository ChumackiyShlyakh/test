package com.notyteam.bee.registration.login.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.notyteam.bee.R
import com.notyteam.bee.core.model.response.LoginResponse
import com.notyteam.bee.databinding.FragmentLoginBinding
import com.notyteam.bee.registration.RegistrationFragment
import com.notyteam.bee.registration.login.viewmodel.LoginViewModel
import com.notyteam.bee.registration.smscode.fragment.SMSCodeFragment
import com.notyteam.bee.utils.OnBackPressed
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginFragment : Fragment(), Callback<LoginResponse> {

    private var userCallback: Callback<LoginResponse>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        val view = inflater.inflate(R.layout.fragment_registration, container, false)
        val viewModel = ViewModelProviders.of(this)[LoginViewModel::class.java]
        val binding: FragmentLoginBinding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.model

        userCallback = this

        val btn_in = binding.btnFragmentLoginIn
//        val btn_in = view?.findViewById<Button>(R.id.btn_fragment_login_in)

        btn_in.setOnClickListener{
//                        activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragment_container_login,
//                SMSCodeFragment())?.commit()
            fragmentManager?.beginTransaction()?.replace(R.id.fragment_container_registration,
                SMSCodeFragment())?.addToBackStack(null)?.commit()
        }

        viewModel.getLoginModelRequest().observe(this, Observer { it?.let {
//            activity!!.supportFragmentManager.beginTransaction().replace(R.id.fragment_container_login,
//                SMSCodeFragment()).commit()

            fragmentManager!!.beginTransaction().replace(R.id.fragment_container_registration,
                SMSCodeFragment()).addToBackStack(null).commit()
//            if (Utils.isNetworkConnected(getContext())) run {
//
//            }
        }
        })

         return binding.root
    }


    override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
//        activity!!.supportFragmentManager.beginTransaction().replace(R.id.fragment_container_login,
//            SMSCodeFragment()).commit()
        fragmentManager!!.beginTransaction().replace(R.id.fragment_container_registration,
            SMSCodeFragment()).addToBackStack(null).commit()
    }

    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {

        fragmentManager!!.beginTransaction().replace(R.id.fragment_container_registration,
            SMSCodeFragment()).addToBackStack(null).commit()
    }
}