Demonstrate `android.app.NotificationManager#notifyAsPackage`

App B:
```kotlin
 //当前应用 B，将发送通知权限代理给应用 A
 notificationManager.notificationDelegate = "com.example.app_a"
```

App A:
```kotlin
//当前应用 A，以应用 B 的身份发送通知
val target = "com.example.app_b"
if (notificationManager.canNotifyAsPackage(target)) {
    notificationManager.notifyAsPackage(target, null, System.currentTimeMillis().toInt(), notification)
}
```