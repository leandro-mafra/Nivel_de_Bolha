package br.com.mafra.niveldebolha;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.io.Serializable;

/**
 * Created by Leandro on 05/01/2016.
 */
public class Tela extends View implements Serializable{

    private int telawidth;
    private int telaheight;
    private int posissao;
    private float positiX;
    private float positiY;
    private float positiZ;
    private float[] posi;

    public Tela(Context context) {
        super(context);
    }
    public Tela(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Tela(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas c) {
        super.onDraw(c);
        Paint p = new Paint();

        Empe empe = new Empe();

        switch (posissao){
            case 0:
                empe.DesenhaB(c, p, telawidth, telaheight, this, positiZ);
                break;
            case 1:
                empe.DesenhaA(c, p, telawidth, telaheight, this, positiY);
                break;
        };


    }

    public void Proporssao(int posicaoTela) {
        posissao = posicaoTela;
    }

    public boolean Touth(MotionEvent e){
        if((e.getX()>posi[0] && e.getX()<posi[1]) && (e.getY()>posi[2] && e.getY()<posi[3])){
            return true;
        }else{
            return false;
        }
    }


    public void setTelawidth(int telawidth) {
        this.telawidth = telawidth;
    }

    public void setTelaheight(int telaheight) {
        this.telaheight = telaheight;
    }

    public void Sensor(float v, float v1, float v2) {
        positiX = v;
        positiY = v1;
        positiZ = v2;
    }

    public void PosiEmpB(float[] posi) {
        this.posi = posi;
    }

}
