package br.com.mafra.niveldebolha;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Leandro on 05/01/2016.
 */
public class Deitado {

    public void Desenha(Canvas c, Paint p) {

        p.setColor(new Color().rgb(242,242,170));
        c.drawPaint(p);

        p.setColor(new Color().rgb(100, 255, 51));
        c.drawCircle(384, 640, 300, p);

    }
}
