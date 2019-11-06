package com.notyteam.bee.utils

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import com.notyteam.bee.R
import kotlinx.android.synthetic.main.dialog_myplaces_bottom.*

class DialogAdapter {

    private fun showDialog(activity: Fragment) {

        val dialog = Dialog(activity.activity)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.dialog_myplaces_bottom)
        dialog.show()

        val window = dialog.getWindow()
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        window?.setLayout(
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.MATCH_PARENT
        )

        var ll_dialog_myplaces_bottom_edit =
            dialog.ll_dialog_myplaces_bottom_edit.findViewById<LinearLayout>(R.id.ll_dialog_myplaces_bottom_edit)
        var ll_dialog_myplaces_bottom_archive =
            dialog.ll_dialog_myplaces_bottom_archive.findViewById<LinearLayout>(R.id.ll_dialog_myplaces_bottom_archive)
        var ll_dialog_myplaces_bottom_delete =
            dialog.ll_dialog_myplaces_bottom_delete.findViewById<LinearLayout>(R.id.ll_dialog_myplaces_bottom_delete)

        ll_dialog_myplaces_bottom_edit.setOnClickListener {
            dialog.dismiss()
        }
        ll_dialog_myplaces_bottom_archive.setOnClickListener {

            //            fragmentManager?.beginTransaction()?.replace(
//                R.id.fragment_container_main_activity,
//                GoogleMapNewObjectFragment()
//            )?.commit()

            dialog.dismiss()
        }
        ll_dialog_myplaces_bottom_delete.setOnClickListener {

            dialog.dismiss()
        }
    }
}

//public class ViewDialog {
//
//    public void showDialog(Activity activity, String msg){
//        final Dialog dialog = new Dialog(activity);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setCanceledOnTouchOutside(true);
//
//        dialog.setContentView(R.layout.dialog);
//
//        TextView text = (TextView) dialog.findViewById(R.id.text_dialog);
//        text.setText(msg);
//
//        Button dialogButton = (Button) dialog.findViewById(R.id.btn_dialog);
//        dialogButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//
//        dialog.show();
//
//    }
//}