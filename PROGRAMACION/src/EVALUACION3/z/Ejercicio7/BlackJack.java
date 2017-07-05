import java.awt.*;
import java.applet.*;
import java.net.*;

public class BlackJack extends Applet{
	public static final int NUM_CARTAS = 52;
	public static final int CPP = 13;
	String nombres[] = {"_of_clubs.png", "_of_diamonds.png", "_of_hearts.png", "_of_spades.png"};
	Image imagenes[];
	Baraja baraja;
	Button boton1, boton2;
	Mano manoJugador;
	Mano manoCrouppier;
	TextField apuesta;
	
    public void init() {
    	Panel panel = new Panel();
    	boton1 = new Button("Carta !");
    	boton2 = new Button("Me planto !");
    	panel.add(boton1);
    	panel.add(boton2);
    	this.setLayout(new BorderLayout());
    	this.add("South", panel);

		Panel panel2 = new Panel();
		Label etiqueta = new Label("Introduce tu apuesta : ", Label.RIGHT);
		apuesta = new TextField("", 10);
		panel2.add(etiqueta);
		panel2.add(apuesta);
		this.add("North", panel2);

		imagenes = new Image[NUM_CARTAS];
		for(int i=0; i<4; i++)
			for(int j=0; j<CPP; j++)
				imagenes[(i*CPP)+j] = getImage(getCodeBase(), "Cartas/" + (j+1) + nombres[i]);
		baraja = new Baraja(imagenes);
		baraja.barajar();
		manoJugador = new Mano();
		manoCrouppier = new Mano();
	}
    
    public void paint(Graphics g){
			manoJugador.mostrar_lista(g, this, 450);
			manoCrouppier.mostrar_lista(g, this, 50);
			//g.drawString("" + manoJugador.puntuacion(), 300, 500);
    }

	public boolean action(Event ev, Object obj){
		if(ev.target instanceof TextField){
			apuesta.setEditable(false);
			manoJugador.anadirALista(baraja.sacar());
			manoJugador.anadirALista(baraja.sacar());
			manoCrouppier.anadirALista(baraja.sacar());
			repaint();
			return true;
		}else if(ev.target instanceof Button){
				if(ev.arg.equals("Carta !")){
					manoJugador.anadirALista(baraja.sacar());
					repaint();
					if(manoJugador.seHaPasado())
						juegaElCrouppier();
					return true;
				}else if(ev.arg.equals("Me planto !")){
					juegaElCrouppier();
					return true;
				}
			}
		return false;
	}
	
	public void juegaElCrouppier(){
		while(manoCrouppier.menor17())
			manoCrouppier.anadirALista(baraja.sacar());
		repaint();
	}
	
}