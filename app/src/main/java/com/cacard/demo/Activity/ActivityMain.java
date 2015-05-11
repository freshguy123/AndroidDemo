package com.cacard.demo.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.cacard.demo.Animator.ActivityScrollerDemo;
import com.cacard.demo.Animator.ActivityValueAnimator;
import com.cacard.demo.Canvas.CanvasDemoActivity;
import com.cacard.demo.Canvas.CanvasLayerActivity;
import com.cacard.demo.Canvas.CanvasOperationActivity;
import com.cacard.demo.Canvas.CycleProgressViewActivity;
import com.cacard.demo.Canvas.MusicWaveAnimationActivity;
import com.cacard.demo.Canvas.Paint.ColorFilter.ColorMatrixColorFilterDemoActivity;
import com.cacard.demo.Canvas.Paint.MaskFilter.MaskFilterDemoActivity;
import com.cacard.demo.Canvas.Paint.PathEffect.PathEffectActivity;
import com.cacard.demo.Canvas.Paint.Shader.ShaderActivity;
import com.cacard.demo.Canvas.PathActivity;
import com.cacard.demo.Drawable.ClipDrawableActivity;
import com.cacard.demo.Drawable.DrawingCacheCaptureActivity;
import com.cacard.demo.Drawable.ShapeDrawableActivity;
import com.cacard.demo.Drawable.TransitionDrawableActivity;
import com.cacard.demo.FloatWindow.ActivityFloatWindow;
import com.cacard.demo.GestureDetectorDemo.GestureDetectorDemoActivity;
import com.cacard.demo.IO.ActivityDirInfo;
import com.cacard.demo.Media.ActivityAudioPlayer;
import com.cacard.demo.Media.ActivityAudioPlayerUsingService;
import com.cacard.demo.ViewDragHelperDemo.VDHActivity;
import com.cacard.demo.launchmode.SingleInstance.Activity0;

public class ActivityMain extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setTitle("Main Activity");

        generateMenu();

    }

    // 各个子Demo入口
    private void generateMenu() {
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);

        addButton(root, "ScreenInfomation", ActivityScreenSize.class);
        addButton(root, "DirInfo", ActivityDirInfo.class);

        addButton(root, "ShapeDrawable", ShapeDrawableActivity.class);
        addButton(root, "ClipDrawable", ClipDrawableActivity.class);
        addButton(root, "TransitionDrawable", TransitionDrawableActivity.class);

        addButton(root, "Using Drawing Cache to Caputre", DrawingCacheCaptureActivity.class);

        addButton(root, "ValueAnimator", ActivityValueAnimator.class);
        addButton(root, "Scroller", ActivityScrollerDemo.class);

        addButton(root, "ViewDragHelper", VDHActivity.class);
        addButton(root, "GestureDetectory", GestureDetectorDemoActivity.class);

        addButton(root, "LaunchMode-SingleInstance", Activity0.class);

        addButton(root, "Canvas/", CanvasDemoActivity.class);
        addButton(root, "Canvas/CycleProgress", CycleProgressViewActivity.class);
        addButton(root, "Canvas/MusicWave", MusicWaveAnimationActivity.class);
        addButton(root, "Canvas/Layer", CanvasLayerActivity.class);
        addButton(root, "Canvas/Operation/Translate...", CanvasOperationActivity.class);
        addButton(root, "Canvas/Paint/ColorMatrixColorFilter", ColorMatrixColorFilterDemoActivity.class);
        addButton(root, "Canvas/Paint/MaskFilter", MaskFilterDemoActivity.class);
        addButton(root, "Canvas/Paint/PathEffect", PathEffectActivity.class);
        addButton(root, "Canvas/Paint/Shader", ShaderActivity.class);
        addButton(root, "Canvas/DrawPath", PathActivity.class);

        addButton(root, "SpSpeed", ActivitySpIODemo.class);
        addButton(root, "SpSpeed2", ActivitySpIODemo2.class);

        addButton(root, "AudioPlayer", ActivityAudioPlayer.class);
        addButton(root, "AudioPlayerUsingService", ActivityAudioPlayerUsingService.class);

        addButton(root, "FloatWindow", ActivityFloatWindow.class);

        ScrollView sv = new ScrollView(this);
        sv.addView(root);

        setContentView(sv);
    }

    private void addButton(ViewGroup root, String text, final Class<?> clazz) {
        Button btn = new Button(this);
        btn.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        btn.setText(text);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityMain.this.startActivity(new Intent(ActivityMain.this, clazz));
            }
        });
        root.addView(btn);
    }


    private void log(String msg) {
        Log.i("lcq", msg);
    }

    /**
     * 监视ViewThree
     */
    private void addViewThreeObServer(View v) {
        if (v == null) {
            return;
        }

        ViewTreeObserver ob = v.getViewTreeObserver();
        if (ob == null) {
            return;
        }

        if (ob.isAlive()) {
            ob.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    log("->ob.addOnGlobalLayoutListener");
                }
            });
        }
    }

    private void getRootView() {
        ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0);
        getWindow().getDecorView().findViewById(android.R.id.content);
    }
}
