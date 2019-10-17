package com.notyteam.bee.registration.newaccount.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.notyteam.bee.R
import com.notyteam.bee.registration.smscode.fragment.SMSCodeFragment
import android.widget.Toast
import com.notyteam.bee.core.ui.MainActivity
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog


class NewAccountFragment : Fragment(){

lateinit var btn_newaccount_meaning: Button
lateinit var alertDialog1: AlertDialog
var values = arrayOf<CharSequence>(" First Item ", " Second Item ", " Third Item ")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_newaccount, container, false)

        val btn_newaccount = view.findViewById<Button>(R.id.btn_newaccount)
    btn_newaccount_meaning = view.findViewById(R.id.btn_newaccount_meaning) as Button

    btn_newaccount_meaning.setOnClickListener(View.OnClickListener { CreateAlertDialogWithRadioButtonGroup() })

        btn_newaccount.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(R.id.fragment_container_registration,
                SMSCodeFragment())?.commit()
        }

//        return binding.root
        return view
    }
fun CreateAlertDialogWithRadioButtonGroup() {

    val builder = context?.let { AlertDialog.Builder(it) }

    builder?.setTitle("Select Your Choice")

    builder?.setSingleChoiceItems(values, -1,
        DialogInterface.OnClickListener { dialog, item ->
            when (item) {
                0 ->

                    Toast.makeText(
                        context,
                        "First Item Clicked",
                        Toast.LENGTH_LONG
                    ).show()
                1 ->

                    Toast.makeText(
                        context,
                        "Second Item Clicked",
                        Toast.LENGTH_LONG
                    ).show()
                2 ->

                    Toast.makeText(
                        context,
                        "Third Item Clicked",
                        Toast.LENGTH_LONG
                    ).show()
            }
            alertDialog1.dismiss()
        })
    alertDialog1 = builder!!.create()
    alertDialog1.show()

}
}

