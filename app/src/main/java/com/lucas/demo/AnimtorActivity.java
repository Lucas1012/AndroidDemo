package com.lucas.demo;

import android.animation.*;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Author: LucasCui
 * E-mail: 18410140018@163.com
 * Date: 2019/8/12
 * Description:动画学习类
 * Version: 1.0
 */
public class AnimtorActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_anim_01;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animtor);
        tv_anim_01 = findViewById(R.id.tv_anim_01);
        tv_anim_01.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_anim_01:
//                anim01();
                mutalAnim();
                break;
            default:
                break;
        }
    }

    /**
     * 属性动画 改变透明度
     */
    private void anim01() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(tv_anim_01, "alpha", 1.0f, 0.0f)
                // 设置动画时常
                .setDuration(1000);
        // 设置重复次数
        animator.setRepeatCount(2);
        animator.start();
    }


    // 平移 X 轴
    private void doTranslateXByCode() {
        // translationX,translationY,
        ObjectAnimator animator = ObjectAnimator.ofFloat(tv_anim_01, "translationX", 0f, 200f)
                .setDuration(1000);
        animator.start();
//        ObjectAnimator animator1 = ObjectAnimator.ofFloat(tv_anim_01,"translationY",0f,500.0f);
//        animator1.setDuration(1000);
//        animator1.setStartDelay(1000);
//        animator1.start();


    }

    // 通过代码完成缩放动画
    // 缩放 X 轴
    private void doScaleXByCode() {
        //scaleX,scaleY
        ObjectAnimator animator = ObjectAnimator.ofFloat(tv_anim_01, "scaleX", 1f, 3f);
        animator.start();

    }

    // 通过代码完成旋转动画
    public void mutalAnim(){
//        ObjectAnimator animator = ObjectAnimator.ofFloat(tv_anim_01,"scaleX",1f,3f).setDuration(2000);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(tv_anim_01,"translationY",0,200);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(tv_anim_01,"translationX",0,200);
//        ObjectAnimator animator2 = ObjectAnimator.ofFloat(tv_anim_01,"alpha",0,1);
        AnimatorSet set = new AnimatorSet();
//        set.playSequentially(animator,animator1);
        set.playTogether(animator1,animator3);
        set.setInterpolator(new TimeInterpolator() {
            @Override
            public float getInterpolation(float v) {
                return v;
            }
        });
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
            }
        });
        set.start();

//        // 串行
//        set.playSequentially(animator1,animator2);
//        // 并行
//        set.playTogether(animator2,animator3);
//        set.start();

        /**
         * 这里也可以使用这样
         set.play(animator1).before(animator2);
         set.play(animator2).with(animator3);
         * 或者
         set.play(animator2).with(animator3).after(animator1);
         */

    }

    private void doRotateByCode() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(tv_anim_01, "rotation", 0f, 360f)
                .setDuration(1000);
        animator.start();
    }

}
