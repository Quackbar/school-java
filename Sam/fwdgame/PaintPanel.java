import java.awt.*;
import javax.swing.*;

public class PaintPanel extends JPanel implements path
{
	static int counter;
	ColorSettings currentGame;
	boolean go;
	static Image image;
	int p1 = 90, p2 = 0, p3 = 90, p4 = 140, rand1 = (int)(Math.random() * 1209), rand2 = (int)(Math.random() * 1100), rand3 = (int)(Math.random() * 1999), rand4 = (int)(Math.random() * 1599), p5 = 160, p6 = 160, p7 = 160, p8 = 160, p9 = 160, p10 = 160, p11, p12, p13;

	public PaintPanel(ColorSettings game, int guessCounter)
	{
		currentGame = game;
		setBackground(currentGame.getDrawPanelColor());
		counter = guessCounter;
	}

	public void paintComponent(Graphics p)
	{
		image = Toolkit.getDefaultToolkit().getImage("powerplant.png");
		if(g.getPopulation()>=23)
		{

			//x
			p1 = rand1;
			p3 = rand1;
			p5 = rand2;
			p6 = rand2;
			p7 = rand3;
			p8 = rand3;
			p9 = rand4;
			p10 = rand4;
			//y
			p2++;
			p4++;

			super.paintComponent(p);
			p.setColor(currentGame.setRandomLazer());
			p.drawLine(p1,p2,p3,p4);
			p.drawLine(p6,p2,p5,p4);
			p.drawLine(p8,p2,p7,p4);
			p.drawLine(p10,p2,p9,p4);

			p.setColor(currentGame.setRandomStar());
			p.fillRect(300,50,2,6);
			p.fillRect(298,52,6,2);
			p.fillRect(400,20,2,6);
			p.fillRect(398,22,6,2);
			p.fillRect(500,80,2,6);
			p.fillRect(498,82,6,2);
			p.fillRect(390,600,2,6);
			p.fillRect(388,602,6,2);
			p.fillRect(450,300,2,6);
			p.fillRect(448,302,6,2);
			p.fillRect(600,0,2,6);
			p.fillRect(598,2,6,2);
			p.fillRect(625,500,2,6);
			p.fillRect(623,502,6,2);
			p.fillRect(460,430,2,6);
			p.fillRect(458,432,6,2);
			p.fillRect(390,200,2,6);
			p.fillRect(388,202,6,2);
			p.fillRect(590,220,2,6);
			p.fillRect(588,222,6,2);
			p.fillRect(550,360,2,6);
			p.fillRect(548,362,6,2);
			p.fillRect(300,390,2,6);
			p.fillRect(298,392,6,2);
			p.fillRect(540,580,2,6);
			p.fillRect(538,582,6,2);
			p.fillRect(370,800,2,6);
			p.fillRect(368,802,6,2);
			p.fillRect(650,850,2,6);
			p.fillRect(648,852,6,2);
			p.fillRect(530,900,2,6);
			p.fillRect(528,902,6,2);
			p.fillRect(300+500,50,2,6);
			p.fillRect(298+500,52,6,2);
			p.fillRect(400+500,20,2,6);
			p.fillRect(398+500,22,6,2);
			p.fillRect(500+500,80,2,6);
			p.fillRect(498+500,82,6,2);
			p.fillRect(390+500,600,2,6);
			p.fillRect(388+500,602,6,2);
			p.fillRect(450+500,300,2,6);
			p.fillRect(448+500,302,6,2);
			p.fillRect(600+500,0,2,6);
			p.fillRect(598+500,2,6,2);
			p.fillRect(625+500,500,2,6);
			p.fillRect(623+500,502,6,2);
			p.fillRect(460+500,430,2,6);
			p.fillRect(458+500,432,6,2);
			p.fillRect(390+500,200,2,6);
			p.fillRect(388+500,202,6,2);
			p.fillRect(590+500,220,2,6);
			p.fillRect(588+500,222,6,2);
			p.fillRect(550+500,360,2,6);
			p.fillRect(548+500,362,6,2);
			p.fillRect(300+500,390,2,6);
			p.fillRect(298+500,392,6,2);
			p.fillRect(540+500,580,2,6);
			p.fillRect(538+500,582,6,2);
			p.fillRect(370+500,800,2,6);
			p.fillRect(368+500,802,6,2);
			p.fillRect(650+500,850,2,6);
			p.fillRect(648+500,852,6,2);
			p.fillRect(530+500,900,2,6);
			p.fillRect(528+500,902,6,2);
			p.fillRect(300+1000,50,2,6);
			p.fillRect(298+1000,52,6,2);
			p.fillRect(400+1000,20,2,6);
			p.fillRect(398+1000,22,6,2);
			p.fillRect(500+1000,80,2,6);
			p.fillRect(498+1000,82,6,2);
			p.fillRect(390+1000,600,2,6);
			p.fillRect(388+1000,602,6,2);
			p.fillRect(450+1000,300,2,6);
			p.fillRect(448+1000,302,6,2);
			p.fillRect(600+1000,0,2,6);
			p.fillRect(598+1000,2,6,2);
			p.fillRect(625+1000,500,2,6);
			p.fillRect(623+1000,502,6,2);
			p.fillRect(460+1000,430,2,6);
			p.fillRect(458+1000,432,6,2);
			p.fillRect(390+1000,200,2,6);
			p.fillRect(388+1000,202,6,2);
			p.fillRect(590+1000,220,2,6);
			p.fillRect(588+1000,222,6,2);
			p.fillRect(550+1000,360,2,6);
			p.fillRect(548+1000,362,6,2);
			p.fillRect(300+1000,390,2,6);
			p.fillRect(298+1000,392,6,2);
			p.fillRect(540+1000,580,2,6);
			p.fillRect(538+1000,582,6,2);
			p.fillRect(370+1000,800,2,6);
			p.fillRect(368+1000,802,6,2);
			p.fillRect(650+1000,850,2,6);
			p.fillRect(648+1000,852,6,2);
			p.fillRect(530+1000,900,2,6);
			p.fillRect(528+1000,902,6,2);
			p.fillRect(300-500,50,2,6);
			p.fillRect(298-500,52,6,2);
			p.fillRect(400-500,20,2,6);
			p.fillRect(398-500,22,6,2);
			p.fillRect(500-500,80,2,6);
			p.fillRect(498-500,82,6,2);
			p.fillRect(390-500,600,2,6);
			p.fillRect(388-500,602,6,2);
			p.fillRect(450-500,300,2,6);
			p.fillRect(448-500,302,6,2);
			p.fillRect(600-500,0,2,6);
			p.fillRect(598-500,2,6,2);
			p.fillRect(625-500,500,2,6);
			p.fillRect(623-500,502,6,2);
			p.fillRect(460-500,430,2,6);
			p.fillRect(458-500,432,6,2);
			p.fillRect(390-500,200,2,6);
			p.fillRect(388-500,202,6,2);
			p.fillRect(590-500,220,2,6);
			p.fillRect(588-500,222,6,2);
			p.fillRect(550-500,360,2,6);
			p.fillRect(548-500,362,6,2);
			p.fillRect(300-500,390,2,6);
			p.fillRect(298-500,392,6,2);
			p.fillRect(540-500,580,2,6);
			p.fillRect(538-500,582,6,2);
			p.fillRect(370-500,800,2,6);
			p.fillRect(368-500,802,6,2);
			p.fillRect(650-500,850,2,6);
			p.fillRect(648-500,852,6,2);
			p.fillRect(530-500,900,2,6);
			p.fillRect(528-500,902,6,2);



			p.setColor(currentGame.setRandomBuilding());
			p.fillRect(650,865,20,90);
			p.fillRect(480,865,10,90);
			p.fillRect(380,875,10,90);
			p.fillRect(410,885,10,100);
			p.fillRect(450,855,10,120);
			p.fillRect(520,875,10,90);
			p.fillRect(340,875,20,90);
			p.fillRect(550,875,20,90);
			p.fillRect(600,875,20,90);
			p.fillRect(320,875,10,90);
			p.fillRect(750,875,10,90);
			p.fillRect(620,875,10,90);
			p.fillRect(720,875,20,90);
			p.fillRect(820,875,10,90);
			p.fillRect(900,875,10,90);
			p.fillRect(870,875,10,90);
			p.fillRect(1100,875,10,90);
			p.fillRect(340,875,10,90);
			p.fillRect(240,875,20,90);
			p.fillRect(270,875,10,90);
		//	p.fillRect(100,875,10,90);
			p.fillRect(370,875,10,90);
			p.fillRect(200,875,30,90);
			p.fillRect(170,875,10,90);


			p.setColor(currentGame.setRandomBuilding());
			p.fillRect(1400,865,50,90);
			p.fillRect(1230,865,10,90);
			p.fillRect(1130,875,10,90);
			p.fillRect(1160,885,10,100);
			p.fillRect(1200,855,10,120);
			p.fillRect(1270,875,10,90);
			p.fillRect(1090,875,20,90);
			p.fillRect(1300,875,20,90);
			p.fillRect(1350,875,20,90);
			p.fillRect(1070,875,10,90);
			p.fillRect(1500,875,10,90);
			p.fillRect(1370,875,10,90);
			p.fillRect(1470,875,10,90);
			p.drawString("Energy: " + g.getEnergy(),5,20);
			p.drawString("Population: " + g.getPopulation(),5,30);
			p.drawString("Population Surplus: " + g.getPopulationSurplus(),5,40);
			g.setEnergy(1);
			if(g.getBuildC() == true)
			{
				p.setColor(currentGame.setRandomBuildingD());
				p.fillRect(650+g.getPpLocal(),865-g.getPpLocal2(),20+g.getPpLocal(),90+g.getPpLocal());
				p.fillRect(480+g.getPpLocal(),865-g.getPpLocal2(),10+g.getPpLocal(),90+g.getPpLocal());
				p.fillRect(380+g.getPpLocal(),875-g.getPpLocal2(),10+g.getPpLocal(),90+g.getPpLocal());
				p.fillRect(410+g.getPpLocal(),885-g.getPpLocal2(),10+g.getPpLocal(),100+g.getPpLocal());
				p.fillRect(450+g.getPpLocal(),855-g.getPpLocal2(),10+g.getPpLocal(),120+g.getPpLocal());
				p.fillRect(520+g.getPpLocal(),875-g.getPpLocal2(),10+g.getPpLocal(),90+g.getPpLocal());
				p.fillRect(340+g.getPpLocal(),875-g.getPpLocal2(),20+g.getPpLocal(),90+g.getPpLocal());
				p.fillRect(550+g.getPpLocal(),875-g.getPpLocal2(),20+g.getPpLocal(),90+g.getPpLocal());
				p.fillRect(600+g.getPpLocal(),875-g.getPpLocal2(),20+g.getPpLocal(),90+g.getPpLocal());
				p.fillRect(320+g.getPpLocal(),875-g.getPpLocal2(),10+g.getPpLocal(),90+g.getPpLocal());
				p.fillRect(750+g.getPpLocal(),875-g.getPpLocal2(),10+g.getPpLocal(),90+g.getPpLocal());
				p.fillRect(620+g.getPpLocal(),875-g.getPpLocal2(),10+g.getPpLocal(),90+g.getPpLocal());
				p.fillRect(720+g.getPpLocal(),875-g.getPpLocal2(),20+g.getPpLocal(),90+g.getPpLocal());
				p.fillRect(820+g.getPpLocal(),875-g.getPpLocal2(),10+g.getPpLocal(),90+g.getPpLocal());
				p.fillRect(900+g.getPpLocal(),875-g.getPpLocal2(),10+g.getPpLocal(),90+g.getPpLocal());
				p.fillRect(870+g.getPpLocal(),875-g.getPpLocal2(),10+g.getPpLocal(),90+g.getPpLocal());
				p.fillRect(1100+g.getPpLocal(),875-g.getPpLocal2(),10+g.getPpLocal(),90+g.getPpLocal());
				p.fillRect(340+g.getPpLocal(),875-g.getPpLocal2(),10+g.getPpLocal(),90+g.getPpLocal());
				p.fillRect(240+g.getPpLocal(),875-g.getPpLocal2(),20+g.getPpLocal(),90+g.getPpLocal());
				p.fillRect(270+g.getPpLocal(),875-g.getPpLocal2(),10+g.getPpLocal(),90+g.getPpLocal());
				p.fillRect(370+g.getPpLocal(),875-g.getPpLocal2(),10+g.getPpLocal(),90+g.getPpLocal());
				p.fillRect(200+g.getPpLocal(),875-g.getPpLocal2(),30+g.getPpLocal(),90+g.getPpLocal());
				p.fillRect(170+g.getPpLocal(),875-g.getPpLocal2(),10+g.getPpLocal(),90+g.getPpLocal());



				p.fillRect(1400-g.getPpLocal(),865-g.getPpLocal2(),50+g.getPpLocal(),90+g.getPpLocal());
				p.fillRect(1230-g.getPpLocal(),865-g.getPpLocal2(),10+g.getPpLocal(),90+g.getPpLocal());
				p.fillRect(1130-g.getPpLocal(),875-g.getPpLocal2(),10+g.getPpLocal(),90+g.getPpLocal());
				p.fillRect(1160-g.getPpLocal(),885-g.getPpLocal2(),10+g.getPpLocal(),100+g.getPpLocal());
				p.fillRect(1200-g.getPpLocal(),855-g.getPpLocal2(),10+g.getPpLocal(),120+g.getPpLocal());
				p.fillRect(1270-g.getPpLocal(),875-g.getPpLocal2(),10+g.getPpLocal(),90+g.getPpLocal());
				p.fillRect(1090-g.getPpLocal(),875-g.getPpLocal2(),20+g.getPpLocal(),90+g.getPpLocal());
				p.fillRect(1300-g.getPpLocal(),875-g.getPpLocal2(),20+g.getPpLocal(),90+g.getPpLocal());
				p.fillRect(1350-g.getPpLocal(),875-g.getPpLocal2(),20+g.getPpLocal(),90+g.getPpLocal());
				p.fillRect(1070-g.getPpLocal(),875-g.getPpLocal2(),10+g.getPpLocal(),90+g.getPpLocal());
				p.fillRect(1500-g.getPpLocal(),875-g.getPpLocal2(),10+g.getPpLocal(),90+g.getPpLocal());
				p.fillRect(1370-g.getPpLocal(),875-g.getPpLocal2(),10+g.getPpLocal(),90+g.getPpLocal());
				p.fillRect(1470-g.getPpLocal(),875-g.getPpLocal2(),10+g.getPpLocal(),90+g.getPpLocal());
				g.setBuildC(true);
				g.setPopulationSurplus(10);
			}
			if(g.getEnergy() >= 0&&g.getPopulation()>=0)
			{


				switch(counter)
				{

					case 1:
					g.setEnergy(-10);
					if(g.getPopulation() <100000)
						g.setPopulation(2);
					else if(g.getPopulation() >= 100000)
						g.setPopulationSurplus(2);
					p.setColor(currentGame.setRandomPen());
					p.drawOval(-180,700,1950,800);
					if(p1 > 100 && p1 < 2000 &&p4 >= 700||p6 > 100 && p6 < 2000 &&p4 >= 700||p8 > 100 && p8 < 2000 &&p4 >= 700||p10 > 100 && p10 < 2000 &&p4 >= 700)
					{
						p1 = rand1 /= .5;
						p3 = rand1/= .5;
						p5 = rand2/= .5;
						p6 = rand2/= .5;
						p7 = rand3/= .5;
						p8 = rand3/= .5;
						p9 = rand4/= .5;
						p10 = rand4/= .5;
						p2-= 1070;
						p4-= 1070;
					}
				}
			}
			if(p1 > 0 && p1 < 1800 &&p4 >= 850||p6 > 0 && p6 < 1800 &&p4 >= 850||p8 > 0 && p8 < 1800 &&p4 >= 850||p10 > 0 && p10 < 1800 &&p4 >= 850)
			{
				g.setPopulation(-100);
				if(g.getPopulationSurplus() > 100)
					g.setPopulationSurplus(-800);

					p.setColor(currentGame.setRandomBomb());
					p.fillRect(905+15,700-100,100,300);
					p.fillOval(700+15,600-100,500,200);
					p.drawOval(850+15,800-100,200,20);

			}

			p.setColor(currentGame.setRandomNuke());
			p.fillRect(920,869,100,200);
			if(g.getBuild() == true)
			{
				g.setEnergy(11);
				p.drawImage(image, 975,860, 30, 40, this);
				g.setBuild(true);
			}



			repaint();



			if(p4 > 1070)
			{
				p1 = rand1 /= .5;
				p3 = rand1/= .5;
				p5 = rand2/= .5;
				p6 = rand2/= .5;
				p7 = rand3/= .5;
				p8 = rand3/= .5;
				p9 = rand4/= .5;
				p10 = rand4/= .5;
				p2-= 1070;
				p4-= 1070;

				if(p3>2000)
				{
					p3 = (rand1*= .3);
					p1 = (rand1*= .3);

				}
				else if(p5>2000)
				{
					p5 = (rand2*= .1);
					p5 = (rand2*= .1);

				}

				else if(p7>2000)
				{
					p8 = (rand3*= .15);
					p7 = (rand3*= .15);

				}

				else if(p9>2000)
				{
					p10 = (rand4*= .05);
					p9 = (rand4*= .05);

				}
			}
   			p.drawImage(image, 925,860, 30, 40, this);
   			if(g.getGTG() == true)
   			{
				p13++;
				p.setColor(currentGame.setRandomSpaceShip());
				p.drawLine(110,700-p13,120,750-p13);
				p.drawLine(100,750-p13,110,700-p13);
				p.drawLine(100,840-p13,110,860-p13);
				p.drawLine(120,840-p13,110,860-p13);
				p.drawLine(110,860-p13,100,900-p13);
				p.drawLine(110,860-p13,120,900-p13);
	//			p.drawLine(100,800+10,80,850+10);
	//			p.drawLine(120,800+10,140,850+10);
				p.fillRect(100,750-p13,20,90);
	/*			p.fillRect(60,850+10,20,90);
				p.fillRect(140,850+10,20,90);
				p.drawLine(60,850+10,70,830+10);
				p.drawLine(70,830+10,80,850+10);
				p.drawLine(140,850+10,150,830+10);
				p.drawLine(150,830+10,160,850+10);*/
				p.drawLine(100,900-p13,120,900-p13);
				p.setColor(currentGame.setRandomLazer());
				p.drawLine(100,900-p13,110,990-p13);
				p.drawLine(110,990-p13,120,900-p13);
			}

			else
			{
				p.setColor(currentGame.setRandomSpaceShip());
				p.drawLine(110,700+130,120,750+130);
				p.drawLine(100,750+130,110,700+130);
				p.drawLine(100,840+130,110,860+130);
				p.drawLine(120,840+130,110,860+130);
				p.drawLine(110,860+130,100,900+130);
				p.drawLine(110,860+130,120,900+130);
	//			p.drawLine(100,800+10,80,850+10);
	//			p.drawLine(120,800+10,140,850+10);
				p.fillRect(100,750+130,20,90);
	/*			p.fillRect(60,850+10,20,90);
				p.fillRect(140,850+10,20,90);
				p.drawLine(60,850+10,70,830+10);
				p.drawLine(70,830+10,80,850+10);
				p.drawLine(140,850+10,150,830+10);
				p.drawLine(150,830+10,160,850+10);*/
				p.drawLine(100,900+130,120,900+130);
			}
		}
		else
		{
			p.setColor(Color.red);
			p.drawString("You Lose", 600,400);
		}

	}
}