package br.com.mafra.niveldebolha;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.NonNull;

import java.text.DecimalFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Leandro on 05/01/2016.
 */
public class Empe {
    private float temp1=0, temp2=0, temp3=0, temp4=0;

    public void DesenhaA(Canvas c, Paint p, float telalargura, float telaaltura, Tela tela, float positiY) {

        temp1 = telalargura*0.065104166666667f;
        temp2 = telalargura- (temp1*2);
        float bolha = (temp2/180);

        p.setColor(new Color().rgb(242, 242, 170));
        c.drawPaint(p);

        p.setColor(new Color().rgb(100, 255, 51));
        temp1 = telalargura*0.03906257f;
        temp2 = telalargura-temp1;
        temp3 = telaaltura*0.520833333333f;
        temp4 = telaaltura*0.714145833333f;
        c.drawRect(temp1, temp3, temp2, temp4, p);// 50, 400, 1230, 550

        /******** bolha **************/
        /*********** borda de baixo ************/
        p.setColor(new Color().rgb(0, 230, 0));
        temp1 = ((telalargura/2)+(bolha*positiY))-((telalargura*0.1015625f)/2);
        temp2 = temp1 + (telalargura*0.1015625f);
        temp3 = (telaaltura*0.520833333333f) - ((telaaltura*0.18229166666667f)/2);
        temp4 = (telaaltura*0.520833333333f) + ((telaaltura*0.18229166666667f)/2);
        RectF rec1 = new RectF(temp1,temp3,temp2,temp4);// 530,380,650,520
        c.drawArc(rec1, 0, 180, true, p);
        /************ meio da bolha ***********/
        temp3 = (telaaltura*0.520833333333f) - ((telaaltura*0.15625f)/2);
        temp4 = (telaaltura*0.520833333333f) + ((telaaltura*0.15625f)/2);
        RectF rec = new RectF(temp1,temp3,temp2,temp4);//530,390,650,510
        p.setColor(new Color().rgb(242, 242, 170));
        c.drawArc(rec, 0, 180, true, p);
        /*********** linhas **************/
        p.setColor(new Color().rgb(0, 0, 0));
        temp1 = (telalargura/2)-((telalargura*0.1015625f)/2) - 5;
        temp2 = (telalargura/2)-((telalargura*0.1015625f)/2) - 5;
        temp3 = telaaltura*0.520833333333f;;
        temp4 = telaaltura*0.714145833333f;
        c.drawLine(temp1, temp3, temp2, temp4, p);//520, 450, 520, 600,
        temp1 = (telalargura/2)+((telalargura*0.1015625f)/2) + 5;
        temp2 = (telalargura/2)+((telalargura*0.1015625f)/2) + 5;
        c.drawLine(temp1, temp3, temp2, temp4, p);//660, 450, 660, 600,

        /************ area do texto ***********/

        p.setColor(Color.WHITE);
        temp1 = (telalargura/2) - ((telalargura*0.390625f)/2);
        temp2 = (telalargura/2) + ((telalargura*0.390625f)/2);
        temp3 = telaaltura*0.0651041666666667f;
        temp4 = telaaltura*0.390625f;
        c.drawRect(temp1, temp3, temp2, temp4, p);//340, 50, 840, 300,

        p.setColor(Color.BLACK);
        temp1 = temp1 + (10*(telalargura/1280));
        temp2 = temp2 - (10*(telalargura/1280));
        temp3 = temp3 + (10*(telaaltura/768));
        temp4 = temp4 - (10*(telaaltura/768));
        c.drawRect(temp1, temp3, temp2, temp4, p);

        DecimalFormat df = new DecimalFormat("#####");

        p.setColor(Color.WHITE);
        p.setTypeface(Typeface.SANS_SERIF);
        temp1 = telalargura*0.3125f;
        temp2 = telaaltura*0.325520833333333f;
        p.setTextSize(200 * telalargura/1280);
        c.drawText(df.format(positiY), temp1, temp2, p);//400, 250,

        /******************* botao *****************/
        Bitmap imageFromRes = BitmapFactory.decodeResource(tela.getResources(), R.drawable.circulo);
        temp1 = (telalargura/2) - ((telalargura*0.15625f)/2);
        temp2 = (telalargura/2) + ((telalargura*0.15625f)/2);
        temp4 = telaaltura;
        temp3 = telaaltura - (telaaltura*0.26041666666667f);
        c.drawBitmap(imageFromRes, null, new RectF(temp1, temp3, temp2, temp4), null);

        float[] posi = new float[]{temp1, temp2, temp3, temp4};

        tela.PosiEmpB(posi);
    }

    public void DesenhaB(Canvas c, Paint p, float telalargura, float telaaltura, Tela tela, float positiZ){

        temp1 = telalargura*0.065104166666667f;
        temp2 = telalargura- (temp1*2);
        float bolha = (temp2/180);


        p.setColor(new Color().rgb(242, 242, 170));
        c.drawPaint(p);

        p.setColor(new Color().rgb(100, 255, 51));
        temp1 = telalargura*0.0651041666666666667f;
        temp2 = telalargura-temp1;
        temp3 = (telaaltura/2) - ((telaaltura*0.1171875f)/2);
        temp4 = (telaaltura/2) + ((telaaltura*0.1171875f)/2);
        c.drawRect(temp1, temp3, temp2, temp4, p);

        /******** bolha **************/
        /*********** borda de baixo ************/
        p.setColor(new Color().rgb(0, 230, 0));
        temp1 = ((telalargura/2)+(bolha*positiZ))-((telalargura*0.10416666666666667f)/2);
        temp2 = temp1 + (telalargura*0.10416666666666667f);
        temp3 = (telaaltura/2) - ((telaaltura*0.1171875f)/2) - ((telaaltura*0.078125f)/2) +3;
        temp4 = (telaaltura/2) - ((telaaltura*0.1171875f)/2) + ((telaaltura*0.078125f)/2);
        RectF rec1 = new RectF(temp1,temp3,temp2,temp4);//324,550,404,650
        c.drawArc(rec1, 0, 180, true, p);
        /************ meio da bolha ***********/
        temp1 = ((telalargura/2)+(bolha*positiZ))-((telalargura*0.10416666666666667f)/2);
        temp2 = temp1 + (telalargura*0.10416666666666667f);
        temp3 = (telaaltura/2) - ((telaaltura*0.1171875f)/2) - ((telaaltura*0.0625f)/2);
        temp4 = (telaaltura/2) - ((telaaltura*0.1171875f)/2) + ((telaaltura*0.0625f)/2);
        RectF rec = new RectF(temp1,temp3,temp2,temp4);
        p.setColor(new Color().rgb(242, 242, 170));
        c.drawArc(rec, 0, 180, true, p);
        /*********** linhas **************/
        p.setColor(new Color().rgb(0, 0, 0));
        temp1 = (telalargura / 2) - ((telalargura * 0.10416666666666667f)/2) -6;
        temp2 = (telalargura / 2) - ((telalargura * 0.10416666666666667f)/2) -6;
        temp3 = (telaaltura/2) - ((telaaltura*0.1171875f)/2);
        temp4 = (telaaltura/2) + ((telaaltura*0.1171875f)/2);
        c.drawLine(temp1, temp3, temp2, temp4, p);
        temp1 = (telalargura / 2) + ((telalargura * 0.10416666666666667f)/2) +6;
        temp2 = (telalargura / 2) + ((telalargura * 0.10416666666666667f)/2) +6;
        c.drawLine(temp1, temp3, temp2, temp4, p);

        /************ area do texto ***********/

        p.setColor(Color.WHITE);
        temp1 = telalargura*0.0651041666666666667f;
        temp2 = telalargura-temp1;
        temp3 = telaaltura*0.0390625f;
        temp4 = temp3 + (telaaltura*0.234375f);
        c.drawRect(temp1, temp3, temp2, temp4, p);

        p.setColor(Color.BLACK);
        temp1 = temp1 + (10*(telalargura/768));
        temp2 = temp2 - (10*(telalargura/768));
        temp3 = temp3 + (10*(telaaltura/1280));
        temp4 = temp4 - (10*(telaaltura/1280));
        c.drawRect(temp1, temp3, temp2, temp4, p);

        DecimalFormat df = new DecimalFormat("#####");

        temp1 = telalargura / 768f;
        temp2 = telalargura*0.1953125f;
        temp3 = telaaltura*0.2109375f;
        p.setColor(Color.WHITE);
        p.setTypeface(Typeface.SANS_SERIF);
        p.setTextSize(200 * temp1);
        c.drawText(df.format(positiZ), temp2, temp3, p);// 150  260

        /*********************** botão ***************************/

        Bitmap imageFromRes = BitmapFactory.decodeResource(tela.getResources(), R.drawable.circulo);
        temp1 = telalargura/2 - ((telalargura*0.2604166666666667f)/2);
        temp2 = temp1 + (telalargura*0.2604166666666667f);
        temp3 = telaaltura*0.625f;
        temp4 = telaaltura*0.78125f;
        c.drawBitmap(imageFromRes, null, new RectF(temp1, temp3, temp2, temp4), null);

        float[] posi = new float[]{temp1, temp2, temp3, temp4};

        tela.PosiEmpB(posi);
    }
}
