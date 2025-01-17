package com.example.background_tasks_flutter_playground.battery

import android.content.Context
import android.os.BatteryManager
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel


class BatteryController(val result: MethodChannel.Result) {
    fun route(appContext: Context, activityContext:Context){
        val batteryLevel = BatteryService.getBatteryLevel(appContext,activityContext);
        if (batteryLevel != -1) {
            result.success(batteryLevel)
        } else {
            result.error("UNAVAILABLE", "Battery level not available.", null)
        }
    }
}