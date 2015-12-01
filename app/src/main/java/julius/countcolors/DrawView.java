package julius.countcolors;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.Random;

/**
 * Created by AM on 10.11.2015.
 */
public class DrawView extends View {
    Paint paint = new Paint();
    Paint CirclePaint = new Paint();
    int myQty;
    int myWidth;
    int myHeight;
    Boolean myRandomColorCircles;
    Boolean myareHorizontal;
    Random rnd = new Random();
    int[] QtyCircles;

    public DrawView(Context context, int qty, int Width, int Height, Boolean RandomColorCircles, Boolean areHorizontal) {
        super(context);

        // View t = findViewById(R.id.DifferentCirclesColors);
        // returns NULL

        myQty = qty;
        myWidth = Width;
        myHeight = Height;
        myRandomColorCircles = RandomColorCircles;
        myareHorizontal = areHorizontal;

        int myColor = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        paint.setColor(myColor);
        // paint.setColor(Color.BLACK);

        myColor = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        CirclePaint.setColor(myColor);
    }

    public int getCirclesQty (int i){

        return QtyCircles[i];
    }

    @Override
    public void onDraw(Canvas canvas) {

//        DisplayMetrics metrics = getResources().getDisplayMetrics();
//        int myWidth = metrics.widthPixels;
//        int myHeight = metrics.heightPixels;
        int myRadius;
        if (myHeight > myWidth) {
            myRadius = myWidth;
        } else {
            myRadius = myHeight;
        }

        QtyCircles = new int [myQty];
        int myQtyLines = myQty-1;

        for (int i=1;i<myQtyLines+1;i++){
            if (myareHorizontal) {
                canvas.drawLine(1, myHeight / (myQtyLines + 1) * i, myWidth - 1, myHeight / (myQtyLines + 1) * i, paint);
            } else {
                canvas.drawLine(myWidth / (myQtyLines + 1) * i, 1, myWidth / (myQtyLines + 1) * i, myHeight - 1, paint);
            }

        }
        for (int i=0;i<myQtyLines+1;i++){
            int myQtyCircles = rnd.nextInt(myQtyLines + 2);
            QtyCircles[i] = myQtyCircles;

            for (int j=0;j<myQtyCircles;j++) {
                if (myRandomColorCircles) {
                    CirclePaint.setColor(Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
                }
                if (myareHorizontal) {
                    canvas.drawCircle((float) (myWidth / (myQtyLines + 1) * (j + 0.5)), (float) (myHeight / (myQtyLines + 1) * (i + 0.5)), myRadius / (myQtyLines + 1) / 8 + rnd.nextInt(myRadius / (myQtyLines + 1) / 4), CirclePaint);
                } else {
                    canvas.drawCircle((float) (myWidth / (myQtyLines + 1) * (i + 0.5)), (float) (myHeight / (myQtyLines + 1) * (j + 0.5)), myRadius / (myQtyLines + 1) / 8 + rnd.nextInt(myRadius / (myQtyLines + 1) / 4), CirclePaint);
                }
            }
        }

    }

}
