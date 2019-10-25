package com.notyteam.bee.core.arch

import android.app.Activity
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.notyteam.bee.R
import com.notyteam.bee.registration.newaccount.fragment.NewAccountFragment

class DialogDataAdapter(
    private val chooseDialog: String,
    private val arrayStringDataDialogItems: Array<String>,
    private val arrayImagesDataDialogItems: IntArray,
    internal var recyclerViewItemClickListener: RecyclerViewItemClickListener
) : RecyclerView.Adapter<DialogDataAdapter.GrandExpertViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): GrandExpertViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_bees, parent, false)
        return GrandExpertViewHolder(v)
    }

    override fun onBindViewHolder(beesViewHolder: GrandExpertViewHolder, i: Int) {
        beesViewHolder.tv_dialog_layout.text = arrayStringDataDialogItems[i]
        beesViewHolder.image.setBackgroundResource(arrayImagesDataDialogItems[i])
    }

    override fun getItemCount(): Int {
        return arrayStringDataDialogItems.size
    }

    inner class GrandExpertViewHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {

        var tv_dialog_layout: TextView
        var image: View
        var radioButton: RadioButton

        init {
            tv_dialog_layout = v.findViewById(R.id.tv_item_bees)
            image = v.findViewById(R.id.iv_item_bees)
            radioButton = v.findViewById(R.id.radiobtn_item_bees)
            radioButton.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            if (chooseDialog == "meaning"){
            recyclerViewItemClickListener.clickOnItem(arrayStringDataDialogItems[this.adapterPosition])
            } else if (chooseDialog == "language") {
            recyclerViewItemClickListener.clickOnItemLanguage(arrayStringDataDialogItems[this.adapterPosition])
            }
        }
    }

    interface RecyclerViewItemClickListener {
        fun clickOnItem(data: String)
        fun clickOnItemLanguage(data: String)
    }
}