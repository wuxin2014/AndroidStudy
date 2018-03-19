package com.zmy.study.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zmy.study.MainActivity;
import com.zmy.study.R;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        /**
         * PendingIntent的获取方式
         * 1、getActivity(Context context, int requestCode, Intent intent, int flags)
         * 2、getService(Context context, int requestCode, Intent intent, int flags)
         * 3、getBroadcast(Context context, int requestCode, Intent intent, int flags)
         */

        // 普通意图
        Intent notificationIntent = new Intent(this, MainActivity.class);
        // 加强意图
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

        /**
         * Notification的标志位
         * Notification.FLAG_SHOW_LIGHTS              //三色灯提醒，在使用三色灯提醒时候必须加该标志符
         * Notification.FLAG_ONGOING_EVENT          //发起正在运行事件（活动中）
         * Notification.FLAG_INSISTENT   //让声音、振动无限循环，直到用户响应 （取消或者打开）
         * Notification.FLAG_ONLY_ALERT_ONCE  //发起Notification后，铃声和震动均只执行一次
         * Notification.FLAG_AUTO_CANCEL      //用户单击通知后自动消失
         * Notification.FLAG_NO_CLEAR         //只有全部清除时，Notification才会清除 ，不清楚该通知(QQ的通知无法清除，就是用的这个)
         * Notification.FLAG_FOREGROUND_SERVICE    //表示正在运行的服务
         */
        // 通知的创建
        Notification notification = new Notification.Builder(this)
                .setContentTitle("有通知到来")
                .setContentText("这是通知的内容")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setWhen(System.currentTimeMillis())
                .setContentIntent(pendingIntent)
                .build(); // level 16才支持的
        notification.flags = Notification.FLAG_AUTO_CANCEL;
    }
}
