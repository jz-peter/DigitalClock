package io.turntotech.android.digitalclock;

import android.content.Context;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;

public class CustomDigitView extends ConstraintLayout {

    View viewTop;
    View viewMiddle;
    View viewBottom;
    View viewTopLeft;
    View viewBottomLeft;
    View viewTopRight;
    View viewBottomRight;


    public CustomDigitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);


        inflate(getContext(), R.layout.custom_digit_view, this);

        viewTop = findViewById(R.id.viewTop);
        viewMiddle = findViewById(R.id.viewMiddle);
        viewBottom = findViewById(R.id.viewBottom);
        viewTopLeft = findViewById(R.id.viewTopLeft);
        viewBottomLeft = findViewById(R.id.viewBottomLeft);
        viewTopRight = findViewById(R.id.viewTopRight);
        viewBottomRight = findViewById(R.id.viewBottomRight);
    }

    public void setDigit(char value) {


        if (value == '0') {
            viewTop.setVisibility(VISIBLE);
            viewMiddle.setVisibility(INVISIBLE);
            viewBottom.setVisibility(VISIBLE);
            viewTopLeft.setVisibility(VISIBLE);
            viewBottomLeft.setVisibility(VISIBLE);
            viewTopRight.setVisibility(VISIBLE);
            viewBottomRight.setVisibility(VISIBLE);
        } else if (value == '1') {
            viewTop.setVisibility(INVISIBLE);
            viewMiddle.setVisibility(INVISIBLE);
            viewBottom.setVisibility(INVISIBLE);
            viewTopLeft.setVisibility(INVISIBLE);
            viewBottomLeft.setVisibility(INVISIBLE);
            viewTopRight.setVisibility(VISIBLE);
            viewBottomRight.setVisibility(VISIBLE);
        } else if (value == '2') {
            viewTop.setVisibility(VISIBLE);
            viewMiddle.setVisibility(VISIBLE);
            viewBottom.setVisibility(VISIBLE);
            viewTopLeft.setVisibility(INVISIBLE);
            viewBottomLeft.setVisibility(VISIBLE);
            viewTopRight.setVisibility(VISIBLE);
            viewBottomRight.setVisibility(INVISIBLE);
        } else if (value == '3') {
            viewTop.setVisibility(VISIBLE);
            viewMiddle.setVisibility(VISIBLE);
            viewBottom.setVisibility(VISIBLE);
            viewTopLeft.setVisibility(INVISIBLE);
            viewBottomLeft.setVisibility(INVISIBLE);
            viewTopRight.setVisibility(VISIBLE);
            viewBottomRight.setVisibility(VISIBLE);
        } else if (value == '4') {
            viewTop.setVisibility(INVISIBLE);
            viewMiddle.setVisibility(VISIBLE);
            viewBottom.setVisibility(INVISIBLE);
            viewTopLeft.setVisibility(VISIBLE);
            viewBottomLeft.setVisibility(INVISIBLE);
            viewTopRight.setVisibility(VISIBLE);
            viewBottomRight.setVisibility(VISIBLE);
        } else if (value == '5') {
            viewTop.setVisibility(VISIBLE);
            viewMiddle.setVisibility(VISIBLE);
            viewBottom.setVisibility(VISIBLE);
            viewTopLeft.setVisibility(VISIBLE);
            viewBottomLeft.setVisibility(INVISIBLE);
            viewTopRight.setVisibility(INVISIBLE);
            viewBottomRight.setVisibility(VISIBLE);
        } else if (value == '6') {
            viewTop.setVisibility(VISIBLE);
            viewMiddle.setVisibility(VISIBLE);
            viewBottom.setVisibility(VISIBLE);
            viewTopLeft.setVisibility(VISIBLE);
            viewBottomLeft.setVisibility(VISIBLE);
            viewTopRight.setVisibility(INVISIBLE);
            viewBottomRight.setVisibility(VISIBLE);
        } else if (value == '7') {
            viewTop.setVisibility(VISIBLE);
            viewMiddle.setVisibility(INVISIBLE);
            viewBottom.setVisibility(INVISIBLE);
            viewTopLeft.setVisibility(INVISIBLE);
            viewBottomLeft.setVisibility(INVISIBLE);
            viewTopRight.setVisibility(VISIBLE);
            viewBottomRight.setVisibility(VISIBLE);
        } else if (value == '8') {
            viewTop.setVisibility(VISIBLE);
            viewMiddle.setVisibility(VISIBLE);
            viewBottom.setVisibility(VISIBLE);
            viewTopLeft.setVisibility(VISIBLE);
            viewBottomLeft.setVisibility(VISIBLE);
            viewTopRight.setVisibility(VISIBLE);
            viewBottomRight.setVisibility(VISIBLE);
        } else if (value == '9') {
            viewTop.setVisibility(VISIBLE);
            viewMiddle.setVisibility(VISIBLE);
            viewBottom.setVisibility(VISIBLE);
            viewTopLeft.setVisibility(VISIBLE);
            viewBottomLeft.setVisibility(INVISIBLE);
            viewTopRight.setVisibility(VISIBLE);
            viewBottomRight.setVisibility(VISIBLE);
        }
    }
        public void setDigitColor ( int colorResourceId){

            viewTop.setBackgroundResource(colorResourceId);
            viewMiddle.setBackgroundResource(colorResourceId);
            viewBottom.setBackgroundResource(colorResourceId);
            viewTopLeft.setBackgroundResource(colorResourceId);
            viewBottomLeft.setBackgroundResource(colorResourceId);
            viewTopRight.setBackgroundResource(colorResourceId);
            viewBottomRight.setBackgroundResource(colorResourceId);

        }

}