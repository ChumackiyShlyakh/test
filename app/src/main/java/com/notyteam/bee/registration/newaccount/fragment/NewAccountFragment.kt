package com.notyteam.bee.registration.newaccount.fragment

import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.notyteam.bee.R
import com.notyteam.bee.registration.smscode.fragment.SMSCodeFragment
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.*
import com.notyteam.bee.core.arch.DialogCustomListView
import com.notyteam.bee.core.arch.DialogDataAdapter
import android.widget.RelativeLayout
import com.notyteam.bee.registration.RegistrationFragment
import com.notyteam.bee.utils.OnBackPressed
import kotlinx.android.synthetic.main.dialog_custom_layout.*
import kotlinx.android.synthetic.main.item_bees.*


class NewAccountFragment : Fragment(), DialogDataAdapter.RecyclerViewItemClickListener {

    lateinit var btn_newaccount_meaning: Button
    lateinit var btn_newaccount_language: Button
    internal var customDialog: DialogCustomListView? = null
    private var language: String = "language"
    private var meaning: String = "meaning"

    private var textItems = arrayOf("Beekeeper", "Agrarian", "Beekeeper + Agrarian")
    private var imagesItems = intArrayOf(
        R.drawable.beekeeper,
        R.drawable.agrarian,
        R.drawable.beekeeper_agrarian
    )

    private var itemsLanguage = arrayOf("Ukraine", "Russian", "English")
    private var imagesFlags = intArrayOf(
        R.drawable.ukraine,
        R.drawable.russia,
        R.drawable.great_britain
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_newaccount, container, false)

        val btn_newaccount = view.findViewById<Button>(R.id.btn_fragment_new_account_create_account)
        btn_newaccount_meaning = view.findViewById(R.id.btn_fragment_newaccount_meaning)
        btn_newaccount_language = view.findViewById(R.id.btn_newaccount_language)

        btn_newaccount.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(
                com.notyteam.bee.R.id.fragment_container_registration,
                SMSCodeFragment()
            )?.commit()
        }

        btn_newaccount_meaning.setOnClickListener(View.OnClickListener {
            if (btn_newaccount_meaning.text.equals("Choose meaning")){
            tv_dialogcustom?.setText(R.string.choose_meaning)
            } else {
//                radiobtn_item_bees
//                btn_newaccount_meaning.text
            }
            showItems(this)
        })

        btn_newaccount_language.setOnClickListener{
            tv_dialogcustom?.setText(R.string.choose_language)
            showItemsLanguage(this)
        }
        return view
    }

    fun showItemsLanguage(view: NewAccountFragment) {
        val dataAdapter = DialogDataAdapter(language, itemsLanguage, imagesFlags, this)
        customDialog = activity?.let { DialogCustomListView(it, dataAdapter) }
        customDialog?.show()
        val window = customDialog?.getWindow()
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        window?.setLayout(
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.MATCH_PARENT
        )
        customDialog?.setCanceledOnTouchOutside(false)
    }

    fun showItems(view: NewAccountFragment) {
        val dataAdapter = DialogDataAdapter(meaning, textItems, imagesItems, this) //
        customDialog = activity?.let { DialogCustomListView(it, dataAdapter) }
        customDialog?.show()
        val window = customDialog?.getWindow()
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        window?.setLayout(
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.MATCH_PARENT
        )
        customDialog?.setCanceledOnTouchOutside(false)
    }

    override fun clickOnItem(data: String) {
        btn_newaccount_meaning.text = data
        if (customDialog != null) {
            customDialog?.dismiss()
        }
    }

    override fun clickOnItemLanguage(data: String) {
        btn_newaccount_language.text = data
        if (customDialog != null) {
            customDialog?.dismiss()
        }
    }

}

