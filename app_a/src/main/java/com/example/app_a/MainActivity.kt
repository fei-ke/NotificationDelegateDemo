package com.example.app_a

import android.app.Notification
import android.app.NotificationManager
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener {

            val notification = Notification.Builder(applicationContext, "test_channel")
                .setContentText("Notification From App B")
                .setContentTitle("Notification From App B")
                .setSmallIcon(R.drawable.ic_notification)
                .build()

            val notificationManager = getSystemService(NotificationManager::class.java)

            //当前应用 A，以应用 B 的身份发送通知
            val target = "com.example.app_b"
            if (notificationManager.canNotifyAsPackage(target)) {
                notificationManager.notifyAsPackage(target, null, System.currentTimeMillis().toInt(), notification)
            } else {
                Toast.makeText(applicationContext, "无法以应用 B 身份发送通知，请先前往应用 B 设置", Toast.LENGTH_SHORT).show()
            }
        }
    }
}