package com.example.hiteshbhengra.canvasexample;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.View;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class CustomDrawable extends View {

    private Paint mPaint;

    public CustomDrawable(Context context) {
        super(context);
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth((float)5.0);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Bitmap bit = CircleGeneration();
        canvas.drawBitmap(bit,0,0,null);
    }

    public Bitmap CircleGeneration() {

        Bitmap bitmap = Bitmap.createBitmap(getWidth(),getHeight(),Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(bitmap);

        int width = getWidth();
        int height = getHeight();

        int X = width/2;
        int Y = height/2;
        Y = Y - 100;
        canvas.drawColor(Color.TRANSPARENT);
        canvas.drawCircle(X-150,Y,250,mPaint);
        canvas.drawCircle(X+150,Y,250,mPaint);
        canvas.drawCircle(X,Y+260,260,mPaint);

        final Point point = new Point();
        point.x = X;
        point.y = Y - 100;

        bitmap = FloodFill(bitmap,point,Color.RED);


        return bitmap;
    }

    public Bitmap FloodFill(Bitmap bitmap,Point node,int color) {

        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int a = node.x;
        int b = node.y;

        if(bitmap.getPixel(a,b) != color) {
            Queue<Point> queue = new LinkedList<Point>();
            do {
                int x = node.x;
                int y = node.y;
                while(x > 0 && bitmap.getPixel(x - 1, y) == Color.TRANSPARENT) {
                    x--;
                }



                boolean SpanUp = false;
                boolean SpanDown = false;
                while(x < width && bitmap.getPixel(x,y) == Color.TRANSPARENT) {
                    bitmap.setPixel(x,y,color);
                    if(!SpanUp && y > 0 && bitmap.getPixel(x,y-1) == Color.TRANSPARENT) {
                        queue.add(new Point(x,y-1));
                        SpanUp = true;
                    } else if (SpanUp && y > 0 && bitmap.getPixel(x,y-1) != Color.TRANSPARENT) {
                        SpanUp = false;
                    }

                    if(!SpanDown && y < height - 1 && bitmap.getPixel(x,y+1)  == Color.TRANSPARENT) {
                        queue.add(new Point(x,y+1));
                        SpanDown = true;
                    } else if (SpanDown && y < height - 1 && bitmap.getPixel(x,y+1) != Color.TRANSPARENT) {
                        SpanDown = false;
                    }
                    x++;

                }

            } while((node = queue.poll()) != null);


        }
        return bitmap;
    }

}
