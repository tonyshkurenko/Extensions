package io.github.tonyshkurenko.decoratortest.decorators;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import io.github.tonyshkurenko.extensions.activities.AppCompatActivityExtension;
import io.github.tonyshkurenko.extensions.activities.OnPauseExtension;
import io.github.tonyshkurenko.extensions.activities.OnResumeExtension;

/**
 * Created by: Anton Shkurenko (anthonyshkurenko)
 * Project: Extensions
 * Date: 8/17/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public class SimpleBroadcastReceiverExtension extends AppCompatActivityExtension
    implements OnResumeExtension, OnPauseExtension {

  private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
    @Override public void onReceive(Context context, Intent intent) {
      Toast.makeText(mAppCompatActivity,
          "onReceive() in " + mAppCompatActivity.getClass().getSimpleName(), Toast.LENGTH_SHORT)
          .show();
    }
  };

  public SimpleBroadcastReceiverExtension(AppCompatActivity appCompatActivity) {
    super(appCompatActivity);
  }

  @Override public void onResume() {
    LocalBroadcastManager.getInstance(mAppCompatActivity)
        .registerReceiver(mMessageReceiver, new IntentFilter("event"));
  }

  @Override public void onPause() {
    LocalBroadcastManager.getInstance(mAppCompatActivity).unregisterReceiver(mMessageReceiver);
  }
}
