package com.example.decorator.ui.behavior.decoratorBehavior

import android.widget.Toast
import androidx.fragment.app.FragmentActivity

class CodeImpl(private val activity: FragmentActivity?): Code() {
    private val code = (100000..999999).random()
    override fun GetCode(): Int {
        Toast.makeText(activity, code.toString(), Toast.LENGTH_LONG).show()
        return code
    }
}