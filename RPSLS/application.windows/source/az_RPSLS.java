import processing.core.*; 
import processing.xml.*; 

import java.applet.*; 
import java.awt.Dimension; 
import java.awt.Frame; 
import java.awt.event.MouseEvent; 
import java.awt.event.KeyEvent; 
import java.awt.event.FocusEvent; 
import java.awt.Image; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class az_RPSLS extends PApplet {

PImage rk, pp, sz, lz, sp, CURR_IMG, uwin, swin;
PImage bazinga, sheldon, tied, winwin, head;
PFont pf, pf1, pf2;
String CURR_OPT, action, winner;
String[] opt;
PImage[] img;
int random_index;
Map<String, String>  actions;
Map<String, String>  winners;

public void setup() {
  size(600, 600);
  head = 
  rk = loadImage("rk.jpg");
  pp = loadImage("pp.jpg");
  sz = loadImage("sz.jpg");
  lz = loadImage("lz.jpg");
  sp = loadImage("sp.jpg");
  uwin = loadImage("uwin.jpg");
  swin = loadImage("swin.jpg");
  bazinga = loadImage("bazinga.jpg");
  sheldon = loadImage("sheldon.jpg");
  tied = loadImage("tied.jpg");
  winwin = loadImage("winwin.jpg");
  head = loadImage("head.jpg");
  pf=loadFont("rpsls.vlw");
  pf1=loadFont("out.vlw");
  pf2=loadFont("normal.vlw");
  opt = new String[] {
    "rock", "paper", "scissor", "lizard", "spock"
  };
  img = new PImage[] { 
    rk, pp, sz, lz, sp
  };
  actions = new HashMap<String, String> ();
  winners = new HashMap<String, String> ();
  initActions();
  background(172);
  smooth();
}

public void draw() {
  textFont(pf);
  textSize(21);
  textAlign(LEFT);
  fill(0);
  text("Your Choice:", 15, 55);
  strokeWeight(10);
  line(15, 80, 150, 80);
  textFont(pf2);
  textSize(14);
  textAlign(CENTER);
  image(rk, 60, 100, 80, 80);
  text("ROCK", 30, 150);
  image(pp, 60, 200, 80, 80);
  text("PAPER", 30, 250);
  image(sz, 60, 300, 80, 80);
  text("SCISSOR", 30, 350);
  image(lz, 60, 400, 80, 80);
  text("LIZARD", 30, 450);
  image(sp, 60, 500, 80, 80);
  text("SPOCK", 30, 550);
  
  image(head,180,10,400,100);
  textFont(pf);
  textAlign(CENTER);
  textSize(50);
  text("R * P * S * L * S",380,160);
  strokeWeight(15);
  line(180, 180, 580, 180);
  getClickResult();
  if (mousePressed==true && !CURR_OPT.equals("OOF")) {
    textFont(pf);
    textSize(24);
    text("Your call..", 235, 230);
    image(CURR_IMG, 180, 250, 121, 121);
    random_index = (int)random(5);
    text("Sheldon says..", 490, 230);
    image(img[random_index], 430, 250, 121, 121);
    if (CURR_OPT.equals(opt[random_index])) {
      action = "!! Ghost minD !!";
      winner = "Evrybody Win";
    }
    else {
      action = actions.get(CURR_OPT+"-"+opt[random_index]);
      winner = winners.get(CURR_OPT+"-"+opt[random_index]);
    }

    fill(172);
    noStroke();
    rect(150, 420, 450, 180);
    textFont(pf1);
    textSize(31);
    fill(0);
    text(action, 365, 450);
    if (winner.equals("B A Z i N G A")) {
      image(uwin, 310, 265, 110, 80);
      image(bazinga, 200, 470, 380, 100);
    }
    else if (winner.equals("SHELDON wins ('_')")) {      
      image(swin, 310, 265, 110, 80);
      image(sheldon, 200, 470, 380, 100);
    }
    else {
      fill(0, 255, 255);
      image(tied, 310, 265, 110, 80);
      image(winwin, 200, 470, 380, 100);
    }
    //    text(winner, 365, 520);
  }
}


public void getClickResult() {
  if (mouseX>60 && mouseX<140 && mouseY>100 && mouseY<180) {
    CURR_IMG=rk;
    CURR_OPT="rock";
  }
  else if (mouseX>60 && mouseX<140 && mouseY>200 && mouseY<280) {
    CURR_IMG=pp;
    CURR_OPT="paper";
  }
  else if (mouseX>60 && mouseX<140 && mouseY>300 && mouseY<380) {
    CURR_IMG=sz;
    CURR_OPT="scissor";
  }
  else if (mouseX>60 && mouseX<140 && mouseY>400 && mouseY<480) {
    CURR_IMG=lz;
    CURR_OPT="lizard";
  }
  else if (mouseX>60 && mouseX<140 && mouseY>500 && mouseY<580) {
    CURR_IMG=sp;
    CURR_OPT="spock";
  }
  else {
    CURR_OPT="OOF";
  }
}

public String getAction(String s1, String s2) {
  println(actions.get(s1+"-"+s2));
  println(winners.get(s1+"-"+s2));
  return "";
}

public void initActions() {
  actions.put("rock"+"-"+"paper", "Paper covers Rock");
  actions.put("rock"+"-"+"scissor", "Rock crushes Scissors");
  actions.put("rock"+"-"+"lizard", "Rock crushes Lizard");
  actions.put("rock"+"-"+"spock", "Spock vaporizes Rock");
  actions.put("paper"+"-"+"rock", "Paper covers Rock");
  actions.put("paper"+"-"+"scissor", "Scissor cuts Paper");
  actions.put("paper"+"-"+"lizard", "Lizard eats Paper");
  actions.put("paper"+"-"+"spock", "Paper disproves Spock");
  actions.put("scissor"+"-"+"rock", "Rock crushes Scissors");
  actions.put("scissor"+"-"+"paper", "Scissor cuts Paper");
  actions.put("scissor"+"-"+"lizard", "Scissor decapitates Lizard");
  actions.put("scissor"+"-"+"spock", "Spock smashes Scissor");
  actions.put("lizard"+"-"+"rock", "Rock crushes Lizard");
  actions.put("lizard"+"-"+"paper", "Lizard eats Paper");
  actions.put("lizard"+"-"+"scissor", "Scissor decapitates Lizard");
  actions.put("lizard"+"-"+"spock", "Lizard poisons Spock");
  actions.put("spock"+"-"+"rock", "Spock vaporizes Rock");
  actions.put("spock"+"-"+"paper", "Paper disproves Spock");
  actions.put("spock"+"-"+"scissor", "Spock smashes Scissor");
  actions.put("spock"+"-"+"lizard", "Lizard poisons Spock");  

  winners.put("rock"+"-"+"paper", "SHELDON wins ('_')");
  winners.put("rock"+"-"+"scissor", "B A Z i N G A");
  winners.put("rock"+"-"+"lizard", "B A Z i N G A");
  winners.put("rock"+"-"+"spock", "SHELDON wins ('_')");
  winners.put("paper"+"-"+"rock", "B A Z i N G A");
  winners.put("paper"+"-"+"scissor", "SHELDON wins ('_')");
  winners.put("paper"+"-"+"lizard", "SHELDON wins ('_')");
  winners.put("paper"+"-"+"spock", "B A Z i N G A");
  winners.put("scissor"+"-"+"rock", "SHELDON wins ('_')");
  winners.put("scissor"+"-"+"paper", "B A Z i N G A");
  winners.put("scissor"+"-"+"lizard", "B A Z i N G A");
  winners.put("scissor"+"-"+"spock", "SHELDON wins ('_')");
  winners.put("lizard"+"-"+"rock", "SHELDON wins ('_')");
  winners.put("lizard"+"-"+"paper", "B A Z i N G A");
  winners.put("lizard"+"-"+"scissor", "SHELDON wins ('_')");
  winners.put("lizard"+"-"+"spock", "B A Z i N G A");
  winners.put("spock"+"-"+"rock", "B A Z i N G A");
  winners.put("spock"+"-"+"paper", "SHELDON wins ('_')");
  winners.put("spock"+"-"+"scissor", "B A Z i N G A");
  winners.put("spock"+"-"+"lizard", "SHELDON wins ('_')");
}

  static public void main(String args[]) {
    PApplet.main(new String[] { "--present", "--bgcolor=#666666", "--stop-color=#cccccc", "az_RPSLS" });
  }
}
