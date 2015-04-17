package com.cacard.androiddemo.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.cacard.androiddemo.MyApplication;

/**
 * 静态注册的广播在进程被杀死后接收到广播，会启动一个新进程，并接收、处理广播。
 */
public class PackageAddRemoveReceiver extends BroadcastReceiver {
    public PackageAddRemoveReceiver() {
        super();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        MyApplication.log("->接收到广播");
    }
}