package com.notyteam.bee.registration.smscode.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.mukesh.OnOtpCompletionListener
import com.mukesh.OtpView
import kotlinx.android.synthetic.main.fragment_smscode.*
import android.widget.Toast
import `in`.aabhasjindal.otptextview.OTPListener
import `in`.aabhasjindal.otptextview.OtpTextView
import com.notyteam.bee.R
import com.notyteam.bee.core.ui.MainActivity
import com.notyteam.bee.registration.login.fragment.LoginFragment
import com.notyteam.bee.utils.OnBackPressed


class SMSCodeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_smscode, container, false)

        val btn_sms_in = view.findViewById<Button>(R.id.btn_sms_code_fragment)
//        val viewModel = ViewModelProviders.of(this)[SMSCodeViewModel::class.java]
//        val binding: FragmentSmscodeBinding =
//            FragmentSmscodeBinding.inflate(inflater, container, false)
//
//        binding.viewmodel

        btn_sms_in?.setOnClickListener{
            val intent = Intent (getActivity(), MainActivity::class.java)
            getActivity()?.startActivity(intent)
            getActivity()?.finish()
        }

        val otpTextView: OtpTextView
        otpTextView = view.findViewById(R.id.otp_view)
        otpTextView.otpListener = object : OTPListener {
            override fun onInteractionListener() {
                // fired when user types something in the Otpbox
            }

            override fun onOTPComplete(otp: String) {
                // fired when user has entered the OTP fully.
//                Toast.makeText(this, "The OTP is $otp", Toast.LENGTH_SHORT).show()
            }
        }

//        return binding.root
        return view
    }
}