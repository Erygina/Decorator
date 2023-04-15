package com.example.decorator.ui.behavior.decoratorBehavior

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.decorator.R
import com.example.decorator.ui.behavior.BehaviorFragment

class PushNotificationDecorator(
    code: Code,
    private val fragment: BehaviorFragment
) : CodeDecorator(code) {

    override fun GetCode(): Int {
        val code = super.GetCode()
        PushNotification(code)
        return code
    }

    private fun PushNotification(code: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = R.string.channel_name
            val descriptionText = R.string.channel_description
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("CHANNEL_ID", name.toString(), importance).apply {
                description = descriptionText.toString()
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                fragment.activity?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
        val builder =
            NotificationCompat.Builder(fragment.requireActivity().application, "CHANNEL_ID")
                .setSmallIcon(R.drawable.cat)
                .setContentTitle("Индентификация")
                .setContentText("Ваш код $code")
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        val notificationManager =
            NotificationManagerCompat.from(fragment.requireActivity().application)
        notificationManager.notify(101, builder.build())
    }

}
