package com.kelltontech.samplepercentagebasedpartitionapp;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.SeekBar;

public class CustomProgressBar extends android.support.v7.widget.AppCompatSeekBar {

	private ArrayList<ProgressItem> mProgressItemsList;

	public CustomProgressBar(Context context) {
		super(context);
		mProgressItemsList = new ArrayList<>();
	}

	public CustomProgressBar(Context context, AttributeSet attrs) {
		super(context, attrs);
        mProgressItemsList = new ArrayList<>();
    }

	public CustomProgressBar(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
        mProgressItemsList = new ArrayList<>();
    }

	public void initData(ArrayList<ProgressItem> progressItemsList) {
		this.mProgressItemsList = progressItemsList;
	}

	@Override
	protected synchronized void onMeasure(int widthMeasureSpec,
			int heightMeasureSpec) {
		// TODO Auto-generated method stub
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

	protected void onDraw(Canvas canvas) {
		if (mProgressItemsList.size() > 0) {
			int progressBarWidth = getWidth();
			int progressBarHeight = getHeight();
			int thumboffset = getThumbOffset();
			int lastProgressX = 0;
			int progressItemWidth, progressItemRight;
			for (int i = 0; i < mProgressItemsList.size(); i++) {
				ProgressItem progressItem = mProgressItemsList.get(i);
				Paint progressPaint = new Paint();
				progressPaint.setColor(getResources().getColor(
						progressItem.color));

				progressItemWidth = (int) (progressItem.progressItemPercentage
						* progressBarWidth / 100);

				progressItemRight = lastProgressX + progressItemWidth;

				// for last item give right to progress item to the width
				if (i == mProgressItemsList.size() - 1
						&& progressItemRight != progressBarWidth) {
					progressItemRight = progressBarWidth;
				}
				RectF progressRect = new RectF();
				progressRect.set(lastProgressX, thumboffset / 2,
						progressItemRight, progressBarHeight - thumboffset / 2);

                    canvas.drawRect(progressRect,progressPaint);
                lastProgressX = progressItemRight;
			}
			RectF rectF=new RectF();
			rectF.set(0,thumboffset/2,getWidth(),getHeight()-thumboffset/2);
			Paint paint=new Paint();
			paint.setColor(Color.BLACK);
			canvas.drawRoundRect(rectF,20,20,paint);
            super.onDraw(canvas);
		}

	}

}
