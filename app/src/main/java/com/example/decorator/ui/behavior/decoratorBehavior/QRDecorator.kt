package com.example.decorator.ui.behavior.decoratorBehavior

import android.graphics.Point
import android.view.Display
import androidmads.library.qrgenearator.QRGContents
import androidmads.library.qrgenearator.QRGEncoder
import androidx.fragment.app.FragmentActivity
import com.example.decorator.databinding.FragmentBehaviorBinding

class QRDecorator(
    code: Code,
    private val context: FragmentBehaviorBinding,
    private val activity: FragmentActivity?
) : CodeDecorator(code) {
    override fun GetCode(): Int {
        val code = super.GetCode()
        QrCode(code)
        return code
    }

    private fun QrCode(code: Int) {
        //var qrgEncoder: QRGEncoder
        val display: Display? = activity?.windowManager?.defaultDisplay
        val point = Point()
        display?.getSize(point)

        val width: Int = point.x
        val height: Int = point.y

        var dimen = if (width < height) width else height
        dimen = dimen * 3 / 4

        val qrEncoder = QRGEncoder(code.toString(), null, QRGContents.Type.TEXT, dimen)

        try {
            val bitmap = qrEncoder.bitmap
            context.emailImageView.setImageBitmap(bitmap)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}