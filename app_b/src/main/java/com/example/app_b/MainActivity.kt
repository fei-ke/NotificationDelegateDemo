package com.example.app_b

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val notificationManager = getSystemService(NotificationManager::class.java)
        val channel = NotificationChannel("test_channel", "test", NotificationManager.IMPORTANCE_HIGH)
        notificationManager.createNotificationChannel(channel)

        findViewById<Button>(R.id.button).setOnClickListener {
            //当前应用 B，将发送通知权限代理给应用 A
            notificationManager.notificationDelegate = "com.example.app_a"
            if (notificationManager.notificationDelegate == "com.example.app_a") {
                Toast.makeText(this, "设置成功", Toast.LENGTH_SHORT).show()
            }
        }
    }
}