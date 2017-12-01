package com.scy.rock.energyview_master;

import android.app.Dialog;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.scy.rock.energyview_master.R;
/**
 * Created by Administrator on 2017/9/29 0029.
 */

public class EnergyView extends RelativeLayout  {
    public static final String TAG = EnergyView.class.getSimpleName();
    private ImageView img;


    private View empty;

    public EnergyView(Context context) {
        this(context,null);
    }

    public EnergyView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }
    public EnergyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater in = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        in.inflate(R.layout.energy_view, this, true);
        img = (ImageView) findViewById(R.id.img);
        empty = findViewById(R.id.img_empty);

    }
    private float currentProgress = 0;
    public void setProgress(int progress) {
        if(currentProgress<maxProgress) {
            currentProgress = progress;
            int height = img.getHeight();
            float j = (float) Math.abs((currentProgress - maxProgress)) / (float) maxProgress;
            float k = height *j;
            float l = height-k;
            img.setScrollY((int) l);
        }

    }
    private int maxProgress = 100;
    public void setMaxProgress(int maxProgress) {
        this.maxProgress = maxProgress;
    }
    public int getCurrentProgress() {
        return (int) currentProgress;
    }
    public void clearProgress() {
        currentProgress = 0;
        img.setScrollY(0);
    }
    public void setEmptyVisibility(int visibility) {
        empty.setVisibility(visibility);
    }


}
