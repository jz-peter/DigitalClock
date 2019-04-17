package io.turntotech.android.digitalclock;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;

import static java.security.AccessController.getContext;

public class CustomDotsView extends ConstraintLayout {

    View viewTopDot;
    View viewBottomDot;

    public CustomDotsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);


        inflate(getContext(), R.layout.custom_twodots_view, this);

        viewTopDot = findViewById(R.id.viewTopDot);
        viewBottomDot = findViewById(R.id.viewBottomDot);
    }

     public void setDots () {

         if (viewTopDot.getVisibility()== VISIBLE) {
             viewTopDot.setVisibility(INVISIBLE);
             viewBottomDot.setVisibility(INVISIBLE);
         }
         else  {
            viewTopDot.setVisibility(VISIBLE);
            viewBottomDot.setVisibility(VISIBLE);
        }

     }

}


