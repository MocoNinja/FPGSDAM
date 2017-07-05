import java.awt.*;
import java.applet.*;

public class Casilla extends Rectangle{
	public static final int TAM = 17;
	private Image mina;
	Image reverso;
	private boolean tapada;
	private int alrededor;
    public Casilla(int posx, int posy, Image rev) {
		super(posx, posy, TAM, TAM);
    	mina = null;
    	reverso = rev;
    	tapada = true;
    	alrededor = 0;
    }

	public Image getMina(){
		return mina;
	}
	
	public void setMina(Image nueva){
		mina = nueva;
	}
	
	public boolean getTapada(){
		return tapada;
	}

	public void destapar(){
		tapada = false;
	}

	public int getAlrededor(){
		return alrededor;
	}

	public void setAlrededor(int num){
		alrededor = num;
	}
    public void dibujar(Graphics g, Applet a){
		g.drawRect(x, y, width, height);
		if(tapada)
			g.drawImage(reverso, x, y, a);
		else if(mina != null)
				g.drawImage(mina, x, y, a);
			 else
			 	g.drawString((alrededor==0)?"":"" + alrededor, x+4, y+13);
    }
    
}