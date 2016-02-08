package com.pkg.draganddropdeno;

import android.app.Activity;
import android.content.ClipData;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

    /** Called when the activity is first created. */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drag_layout);
        findViewById(R.id.myimage1).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.myimage2).setOnTouchListener(new MyTouchListener());
       // findViewById(R.id.myimage3).setOnTouchListener(new MyTouchListener());
        //findViewById(R.id.myimage4).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.topleft).setOnDragListener(new MyDragListener());
        findViewById(R.id.topright).setOnDragListener(new MyDragListener());
        //findViewById(R.id.bottomleft).setOnDragListener(new MyDragListener());
        //findViewById(R.id.bottomright).setOnDragListener(new MyDragListener());

    }

    private final class MyTouchListener implements View.OnTouchListener {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                view.setVisibility(View.INVISIBLE);
                return true;
            } else {
                return false;
            }
        }
    }

    class MyDragListener implements View.OnDragListener {
        Drawable enterShape = getResources().getDrawable(R.drawable.shape_droptarget);
        Drawable normalShape = getResources().getDrawable(R.drawable.shape);

        @Override
        public boolean onDrag(View v, DragEvent event) {
/*            int action = event.getAction();
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    // do nothing
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    v.setBackgroundDrawable(enterShape);
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    v.setBackgroundDrawable(normalShape);
                    break;
                case DragEvent.ACTION_DROP:
                    // Dropped, reassign View to ViewGroup
                    View view = (View) event.getLocalState();

                    ViewGroup owner = (ViewGroup) view.getParent();
                    owner.removeView(view);
                                       break;
                case DragEvent.ACTION_DRAG_ENDED:

                    v.setBackgroundDrawable(normalShape);

                    View view1 = (View) event.getLocalState();
                    float x = event.getX();
                    float y  = event.getY();

                    LinearLayout container = (LinearLayout) v;
                    view1.setX(x);
                    view1.setY(y);
                    container.addView(view1);
                    view1.setVisibility(View.VISIBLE);

                default:
                    break;
            }
            return true;*/

                int action = event.getAction();
                switch (event.getAction()) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        // do nothing
                        break;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        v.setBackgroundDrawable(enterShape);
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        v.setBackgroundDrawable(normalShape);
                        break;
                    case DragEvent.ACTION_DROP:
                        // Dropped, reassign View to ViewGroup
                        View view = (View) event.getLocalState();
                        ViewGroup owner = (ViewGroup) view.getParent();
                        owner.removeView(view);
                        LinearLayout container = (LinearLayout) v;
                        container.addView(view);
                        view.setVisibility(View.VISIBLE);
                        break;
                    case DragEvent.ACTION_DRAG_ENDED:
                        v.setBackgroundDrawable(normalShape);
                    default:
                        break;
                }
                return true;
        }
    }
}