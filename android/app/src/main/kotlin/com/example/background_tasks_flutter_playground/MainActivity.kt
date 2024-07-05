package com.example.background_tasks_flutter_playground
import android.content.Context
import android.os.BatteryManager
import androidx.annotation.NonNull
import com.example.background_tasks_flutter_playground.battery.BatteryController
import com.example.background_tasks_flutter_playground.request_test.RequestTestController
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity: FlutterActivity() {
    private val CHANNEL = "samples.flutter.dev/battery"

    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler {
                call, result ->
            when(call.method){
                "getBatteryLevel"->BatteryController(result).route(applicationContext,this)
                "requestTest"-> RequestTestController(result)
                else->result.notImplemented()
            }
        }
    }
}
