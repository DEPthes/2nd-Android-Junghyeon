package com.example.myapplication

import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("myBatteryState")
fun myBatterySetting(view: ImageView, batteryState: BatteryState) {
    when(batteryState){
        BatteryState.FULL->{view.setImageResource(R.drawable.baseline_battery_full_24)}
        BatteryState.HIGH->{view.setImageResource(R.drawable.baseline_battery_6_bar_24)}
        BatteryState.LOW->{view.setImageResource(R.drawable.baseline_battery_2_bar_24)}
        BatteryState.CRITICAL->{view.setImageResource(R.drawable.baseline_battery_0_bar_24)}
    }
}
