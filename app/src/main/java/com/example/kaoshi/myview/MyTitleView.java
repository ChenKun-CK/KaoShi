package com.example.kaoshi.myview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.kaoshi.R;

/**
 * author:Created by WangZhiQiang on 2018/4/16.
 */
public class MyTitleView extends RelativeLayout{

    private EditText editText;
    private ImageView imageView;
    private Button button;

    public MyTitleView(Context context) {
        this(context,null);
    }

    public MyTitleView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyTitleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context,attrs);
    }

    private void initView(final Context context, AttributeSet attrs) {
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.MyTitleView);
        int color = attributes.getColor(R.styleable.MyTitleView_textColor, 000);
        //搜索栏
        LayoutParams params1 = new LayoutParams(800, LayoutParams.MATCH_PARENT);
        params1.leftMargin=120;
        editText = new EditText(context);
        editText.setTextColor(color);
        editText.setHint("请输入搜索内容");
        addView(editText,params1);
        //箭头
        LayoutParams params2 = new LayoutParams(100, 100);
        params2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        params2.rightMargin=80;
        imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.you);
        addView(imageView,params2);
    }

    public EditText getEditText(){
        return editText;
    }

    public ImageView getImageView(){
        return imageView;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }
}
