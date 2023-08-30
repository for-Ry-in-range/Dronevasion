import javafx.scene.SnapshotParameters;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.TextAlignment;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import kong.unirest.*;
import kong.unirest.json.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import javafx.scene.layout.GridPane;
import javafx.scene.canvas.Canvas;
import javafx.scene.Group;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture; 
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.canvas.GraphicsContext;
import javafx.animation.AnimationTimer;
import java.util.Random;
import javafx.animation.KeyFrame; 
import javafx.animation.Timeline; 
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 
import javafx.util.Duration; 
import javafx.scene.paint.Color;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import java.awt.MouseInfo;
import javafx.scene.shape.*;

/**
 * @author: Ryan Wong
 * @version 1.0
 */

public class Play extends Application {

    String signedIn = "none";
    int userDollars = -1;
    int droneNum = 0;
    boolean[] dronesOwned = new boolean[]{true, false, false, false};

    public void changeUser(String newUser) {
        signedIn = newUser;
    }
    public void setDollars(int dollars) {
        userDollars = dollars;
    }
    public int getDollars() {
        return userDollars;
    }
    public String getUser() {
        return signedIn;
    }
    public void setDrone(int drone) {
        droneNum = drone;
    }
    public int getDroneNum() {
        return droneNum;
    }

    public void main(Stage primaryStage) {
        start(primaryStage);
    }

    public void actualGame(Stage primaryStage) {
        Random rand = new Random();
        Group root = new Group();
        Canvas canvas = new Canvas(1000, 700);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Variables:
        MyBoolean notFirstMap = new MyBoolean();
        MyBoolean alreadyMoved = new MyBoolean();
        Integ rocketDistToGoal = new Integ();
        Integ rocketDistToGoal2 = new Integ();
        Integ mouseX = new Integ();
        Integ mouseY = new Integ();
        Integ mouseX2 = new Integ();
        Integ mouseY2 = new Integ();
        Integ releasedX = new Integ();
        Integ releasedY = new Integ();
        Integ releasedX2 = new Integ();
        Integ releasedY2 = new Integ();
        MyBoolean wDown = new MyBoolean();
        MyBoolean aDown = new MyBoolean();
        MyBoolean sDown = new MyBoolean();
        MyBoolean dDown = new MyBoolean();
        Integ netDistance = new Integ();
        Integ max = new Integ();
        Integ distanceFromMax = new Integ();
        Character character = new Character();
        Integ map1_val = new Integ();
        map1_val.setValue(-700);
        Integ map2_val = new Integ();
        map2_val.setValue(-2100);
        Integ map3_val = new Integ();
        map3_val.setValue(-3500);
        Bullet missile = new Bullet();
        Bullet missile2 = new Bullet();
        Doub score = new Doub();
        Integ difficulty = new Integ();
        ObjWithCoords coin = new ObjWithCoords(0,1400);
        Integ speed = new Integ();
        speed.setValue(10);
        Integ coins = new Integ();
        Integ speedCountdown = new Integ();
        MyBoolean moreDist = new MyBoolean();
        Integ spread = new Integ();
        Integ timeSinceMouseShot = new Integ();
        Doub storm = new Doub();
        storm.setValue(700);
        Integ survivors = new Integ();
        survivors.setValue(0);
        Integ stormChange = new Integ();
        Integ getDarker = new Integ();
        Doub blackOpac = new Doub();
        blackOpac.setValue(0.0);
        Integ topBar = new Integ();
        topBar.setValue(-1000);
        Integ bottomBar = new Integ();
        bottomBar.setValue(1000);
        Doub acc = new Doub();
        Integ lastDark = new Integ();
        MyBoolean blackDone = new MyBoolean();
        Integ endMisF = new Integ();
        Integ lastEnd = new Integ();
        MyBoolean stopText = new MyBoolean();
        Doub fade = new Doub();
        fade.setValue(1);
        Integ lostC = new Integ();
        lostC.setValue(-1);
        Integ redness = new Integ();
        Doub redOpac = new Doub();
        Integ tCoins = new Integ();
        MyBoolean lostCgoing = new MyBoolean();
        MyBoolean moreSee = new MyBoolean();
        moreSee.setBoolean(true);
        Doub continOpac = new Doub();
        MyBoolean survivorsDone = new MyBoolean();
        Integ kills = new Integ();
        Doub meters = new Doub();
        Integ fin_distance = new Integ();
        Integ fin_coin = new Integ();
        MyBoolean twoAmmo = new MyBoolean();
        Doub smokeRate1 = new Doub();
        smokeRate1.setValue(-1);
        Doub prev_smokeRate1 = new Doub();
        Doub smokeRate2 = new Doub();
        smokeRate2.setValue(-1);
        Doub prev_smokeRate2 = new Doub();
        Integ bomb = new Integ();
        bomb.setValue(0);
        Doub bombOpac = new Doub();
        Doub inAndOut = new Doub();
        MyBoolean goingUp = new MyBoolean();
        Integ yel_smk_size = new Integ();
        Doub smokeSize = new Doub();
        Doub sizeDecrease = new Doub();
        Integ bombX = new Integ();
        Doub bombY = new Doub();
        Doub dropVel = new Doub();
        Doub bSha = new Doub();
        String id = "61db2b65f701f4600003ee88";
        Integ currentX = new Integ(-1);
        Integ currentY = new Integ(-1);
        Integ mDownX = new Integ(-1);
        Integ mDownY = new Integ(-1);
        Integ offsetX = new Integ(-1);
        Integ offsetY = new Integ(-1);
        MyBoolean showLine = new MyBoolean(false);
        Integ lineLength = new Integ(300);


        // Create all of the enemies:
        Enemy e1 = new Enemy(1);
        Enemy e2 = new Enemy(2);
        Enemy e3 = new Enemy(3);
        Enemy e4 = new Enemy(4);
        Enemy[] enemies = new Enemy[]{e1, e2, e3, e4};
        
        ObjWithCoords b1 = new ObjWithCoords();
        ObjWithCoords b2 = new ObjWithCoords();
        ObjWithCoords b3 = new ObjWithCoords();
        ObjWithCoords b4 = new ObjWithCoords();
        ObjWithCoords[] rightBullets = new ObjWithCoords[]{b1, b2, b3, b4};
        for (ObjWithCoords b : rightBullets) {
            b.setY(365);;
        }
        ObjWithCoords bb1 = new ObjWithCoords();
        ObjWithCoords bb2 = new ObjWithCoords();
        ObjWithCoords bb3 = new ObjWithCoords();
        ObjWithCoords bb4 = new ObjWithCoords();
        ObjWithCoords[] leftBullets = new ObjWithCoords[]{bb1, bb2, bb3, bb4};
        for (ObjWithCoords b : leftBullets) {
            b.setY(365);
        }


        // Images:
        Image map1 = new Image("file:D:/Programming/DroneAttack/images/map1.jpg");
        Image map2 = new Image("file:D:/Programming/DroneAttack/images/Map2.jpg");
        Image map3 = new Image("file:D:/Programming/DroneAttack/images/map3.jpg");
        Image rocket = new Image("file:D:/Programming/DroneAttack/images/missile_RECTANGLE.png");
        Image blackBlueDrone = new Image("file:D:/Programming/DroneAttack/images/drone3.png");
        Image speedDrone = new Image("file:D:/Programming/DroneAttack/images/SpeedDrone_2.png");
        Image t_shadow = new Image("file:D:/Programming/DroneAttack/images/EnemyShadow.png");
        Image Enemy = new Image("file:D:/Programming/DroneAttack/images/enemy1.png");
        Image Enemy_2 = new Image("file:D:/Programming/DroneAttack/images/enemy2.png");
        Image Enemy_3 = new Image("file:D:/Programming/DroneAttack/images/enemy3.png");
        Image Enemy_4 = new Image("file:D:/Programming/DroneAttack/images/enemy4.png");
        Image coinImg = new Image("file:D:/Programming/DroneAttack/images/coin.png");
        Image droneShadow = new Image("file:D:/Programming/DroneAttack/images/drone_shadow.png");
        Image ui_1 = new Image("file:D:/Programming/DroneAttack/images/hud.png");
        Image speedIcon = new Image("file:D:/Programming/DroneAttack/images/speedIcon.png");
        Image speedIconUsed = new Image("file:D:/Programming/DroneAttack/images/speedIconUsed.png");
        Image speedIcon_C_A = new Image("file:D:/Programming/DroneAttack/images/speedIcon_cantAfford.png");
        Image extraDistIcon = new Image("file:D:/Programming/DroneAttack/images/extraDistIcon.png");
        Image extraDistIconUsed = new Image("file:D:/Programming/DroneAttack/images/extraDistIconUsed.png");
        Image extraDistIcon_C_A = new Image("file:D:/Programming/DroneAttack/images/extraDistIcon_cantAfford.png");
        Image bullet = new Image("file:D:/Programming/DroneAttack/images/bullet.png");
        Image bullet2 = new Image("file:D:/Programming/DroneAttack/images/bullet2.png");
        Image spreadIcon = new Image("file:D:/Programming/DroneAttack/images/SpreadBulletsIcon_small.png");
        Image spreadIconUsed = new Image("file:D:/Programming/DroneAttack/images/SpreadBulletsIcon_used.png");
        Image spreadIcon_C_A = new Image("file:D:/Programming/DroneAttack/images/SpreadBulletsIcon_C_A.png");
        Image bar = new Image("file:D:/Programming/DroneAttack/images/bar.png");
        Image bar_behind = new Image("file:D:/Programming/DroneAttack/images/bar_behind.png");
        Image coinTransP = new Image("file:D:/Programming/DroneAttack/images/Coin_Transparent.png");
        Image coinIcon = new Image("file:D:/Programming/DroneAttack/images/Coin_2.png");
        Image coinIconTop = new Image("file:D:/Programming/DroneAttack/images/Coin_top.png");
        Image ads = new Image("file:D:/Programming/DroneAttack/images/Deelectricity.png");
        Image survBox = new Image("file:D:/Programming/DroneAttack/images/survivors.png");
        Image black = new Image("file:D:/Programming/DroneAttack/images/black.jpg");
        Image tBar = new Image("file:D:/Programming/DroneAttack/images/topBar.jpg");
        Image bBar = new Image("file:D:/Programming/DroneAttack/images/bottomBar.jpg");
        Image imgMissionF = new Image("file:D:/Programming/DroneAttack/images/missionFailed.png");
        Image staticScr = new Image("file:D:/Programming/DroneAttack/images/lostConnection.jpg");
        Image redEdges = new Image("file:D:/Programming/DroneAttack/images/redEdges.png");
        Image twoAmmoIcon = new Image("file:D:/Programming/DroneAttack/images/twoAmmo_Icon.png");
        Image twoAmmoIcon_used = new Image("file:D:/Programming/DroneAttack/images/twoAmmo_Used.png");
        Image twoAmmoIcon_C_A = new Image("file:D:/Programming/DroneAttack/images/twoAmmo_C_A.png");
        Image smoke = new Image("file:D:/Programming/DroneAttack/images/smoke.png");
        Image lightning = new Image("file:D:/Programming/DroneAttack/images/explosion_lightning.png");
        Image bubbles = new Image("file:D:/Programming/DroneAttack/images/explosion_smallSmoke.png");
        Image orange = new Image("file:D:/Programming/DroneAttack/images/orange.png");
        Image red = new Image("file:D:/Programming/DroneAttack/images/red.png");
        Image smokeRed = new Image("file:D:/Programming/DroneAttack/images/back_smoke.png");
        Image smokeYellow = new Image("file:D:/Programming/DroneAttack/images/yellow_smoke.png");
        Image flash = new Image("file:D:/Programming/DroneAttack/images/flash.jpg");
        Image bombImg = new Image("file:D:/Programming/DroneAttack/images/bomb.png");
        Image bombSha = new Image("file:D:/Programming/DroneAttack/images/bomb_shadow.png");
        Image bombIconUsed = new Image("file:D:/Programming/DroneAttack/images/bomb_icon_used.png");
        Image bombIcon = new Image("file:D:/Programming/DroneAttack/images/bomb_icon.png");
        Image bombIcon_C_A = new Image("file:D:/Programming/DroneAttack/images/bomb_icon_C_A.png");
        Image grayRedDrone = new Image("file:D:/Programming/DroneAttack/images/grayRedDrone.png");
        Image whiteOrDrone = new Image("file:D:/Programming/DroneAttack/images/whiteOrange.png");
        Image blackOrDrone = new Image("file:D:/Programming/DroneAttack/images/blackOrange.png");


        
        // Create all of the imageViews to alter the image
        
        Image[] droneImages = new Image[]{blackBlueDrone, blackOrDrone, grayRedDrone, whiteOrDrone};
        ImageView iv = new ImageView(droneImages[getDroneNum()]);

        ImageView ivSD = new ImageView(speedDrone);
        ImageView ivSha = new ImageView(droneShadow);
        ImageView ivRo = new ImageView(rocket);
        ImageView ivRo2 = new ImageView(rocket);
        ImageView im = new ImageView(black);
        ImageView ivRed = new ImageView(redEdges);
        ImageView ivSmoke1 = new ImageView(smoke);
        ImageView ivSmoke2 = new ImageView(smoke);
        ImageView ivOrange = new ImageView(orange);
        ImageView ivBubbles = new ImageView(bubbles);
        ImageView ivYSmk = new ImageView(smokeYellow);
        ImageView ivRedBlob = new ImageView(red);
        ImageView ivRedSmk = new ImageView(smokeRed);
        ImageView ivBombSha = new ImageView(bombSha);

        EventHandler<ActionEvent> eventHandler = e -> {             
            
            if (lostCgoing.getValue()== false && survivorsDone.getValue()==false) {
                score.changeValue(0.03125);
            }
            Text scoreText = new Text();
            if (score.getValue()%60 < 10) {
                scoreText = new Text(476, 45, Integer.toString((int)((int)score.getValue()/60)) + ":0" + Integer.toString((int)score.getValue()%60));
            }
            else {
                scoreText = new Text(476, 45, Integer.toString((int)((int)score.getValue()/60)) + ":" + Integer.toString((int)score.getValue()%60));
            }
            scoreText.setFont(Font.font("Agency FB", 39));
            scoreText.setTextAlignment(TextAlignment.CENTER);
            scoreText.setFill(Color.WHITE);
            scoreText.setOpacity(fade.getValue());
            
            Text coinsText = new Text();
            coinsText = new Text(243, 661, Integer.toString(coins.getValue()));
            coinsText.setFont(Font.font("Agency FB", 21));
            coinsText.setFill(Color.WHITE);
            coinsText.setOpacity(fade.getValue());
            
            Text spreadText = new Text();
            spreadText = new Text(348, 678, "700");
            spreadText.setFont(Font.font("Agency FB", 16));
            spreadText.setFill(Color.WHITE);
            spreadText.setOpacity(0.37 * fade.getValue());

            Text bombText = new Text();
            bombText = new Text(427, 678, "700");
            bombText.setFont(Font.font("Agency FB", 16));
            bombText.setFill(Color.WHITE);
            bombText.setOpacity(0.37 * fade.getValue());

            Text inUseText = new Text();
            inUseText = new Text(420, 678, "IN USE");
            inUseText.setFont(Font.font("Agency FB", 16));
            inUseText.setFill(Color.rgb(153,214,240));
            inUseText.setOpacity(0.37 * fade.getValue());
            
            Text speedText = new Text();
            speedText = new Text(504, 678, "500");
            speedText.setFont(Font.font("Agency FB", 16));
            speedText.setFill(Color.WHITE);
            speedText.setOpacity(.37);
            speedText.setOpacity(0.37 * fade.getValue());
            
            Text distanceText = new Text();
            distanceText = new Text(648, 678, "300");
            distanceText.setFont(Font.font("Agency FB", 16));
            distanceText.setFill(Color.WHITE);
            distanceText.setOpacity(.37);
            distanceText.setOpacity(0.37 * fade.getValue());

            Text twoAmmoText = new Text(582, 677, "400");
            twoAmmoText.setFont(Font.font("Agency FB", 16));
            twoAmmoText.setFill(Color.WHITE);
            twoAmmoText.setOpacity(.37);
            twoAmmoText.setOpacity(.37*fade.getValue());

            Text equipped = new Text();
            equipped = new Text(629, 677, "EQUIPPED");
            equipped.setFont(Font.font("Agency FB", 14));
            equipped.setFill(Color.rgb(153,214,240));
            equipped.setOpacity(fade.getValue());

            Text equipped_twoAmmo = new Text(562, 677, "EQUIPPED");
            equipped_twoAmmo.setFont(Font.font("Agency FB", 14));
            equipped_twoAmmo.setFill(Color.rgb(153,214,240));
            equipped_twoAmmo.setOpacity(fade.getValue());

            Text survCount = new Text(367, 33, survivors.getValue()+" of 8");
            survCount.setFont(Font.font("Arial", FontWeight.BOLD, 16));
            survCount.setFill(Color.WHITE);
            survCount.setOpacity(fade.getValue());
            
            Text survivorsWord = new Text(364, 43, "SURVIVORS");
            survivorsWord.setFont(Font.font(9));
            survivorsWord.setFill(Color.WHITE);
            survivorsWord.setOpacity(fade.getValue());
            
            Text contin = new Text(406, 462, "[Click to continue]");
            contin.setFont(Font.font("Agency FB", 29));
            contin.setFill(Color.WHITE);
            contin.setOpacity(continOpac.getValue());

            Text ddzDist = new Text(592, 27, "DDZ Dist:");
            ddzDist.setFont(Font.font(10));
            ddzDist.setFill(Color.WHITE);
            ddzDist.setOpacity(fade.getValue());

            Text stormDist = new Text(594,43,Integer.toString((int)((storm.getValue()-375)/17))+" m");
            if ((storm.getValue()-375)/17 < 0) {
                stormDist = new Text(594,43,"0 m");
            }
            stormDist.setFont(Font.font("Arial", FontWeight.BOLD, 16));
            stormDist.setFill(Color.WHITE);
            stormDist.setOpacity(fade.getValue());
            
            if (score.getValue() < 8) {
                difficulty.setValue(1);
            }
            else if (score.getValue() < 20) {
                difficulty.setValue(2);
            }
            else if (score.getValue() < 35) {
                difficulty.setValue(3);
            }
            else if (score.getValue() < 55) {
                difficulty.setValue(4);
            }
            else if (score.getValue() < 80) {
                difficulty.setValue(5);
            }
            else if (score.getValue() < 120) {
                difficulty.setValue(6);
            }
            else if (score.getValue() < 175) {
                difficulty.setValue(7);
            }

            
            
            
            

            root.setOnMousePressed(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent me) {
                    if (rocketDistToGoal.getValue() <= 0) { // If 1st missile ISNT being used
                        mouseX.setValue((int)me.getX());
                        mouseY.setValue((int)me.getY());
                    }
                    else if (rocketDistToGoal2.getValue()<=0 && twoAmmo.getValue()==true){ // If 2nd missile ISNT being used
                        mouseX2.setValue((int)me.getX());
                        mouseY2.setValue((int)me.getY());
                    }
                    timeSinceMouseShot.setValue(0);
                    mDownX.setValue(MouseInfo.getPointerInfo().getLocation().x);
                    mDownY.setValue(MouseInfo.getPointerInfo().getLocation().y);
                    showLine.setBoolean(true);
                }
            });
            timeSinceMouseShot.changeValue(1);
            currentX.setValue(MouseInfo.getPointerInfo().getLocation().x);
            currentY.setValue(MouseInfo.getPointerInfo().getLocation().y);

            // If in quadrant I
            if(mDownX.getValue() < currentX.getValue() && mDownY.getValue() > currentY.getValue()) {
                double opposite = mDownY.getValue()-currentY.getValue();
                double adjacent = currentX.getValue()-mDownX.getValue();
                double tan = Math.atan(opposite / adjacent);
                int degrees = (int)(57.2958 * (tan));
                offsetX.setValue((int)(Math.cos(Math.toRadians(degrees))*lineLength.getValue()));
                offsetY.setValue((int)(Math.sin(Math.toRadians(degrees))*-1*lineLength.getValue()));
            }

            // If in quadrant II
            if(mDownX.getValue() > currentX.getValue() && mDownY.getValue() > currentY.getValue()) {
                double opposite = mDownY.getValue()-currentY.getValue();
                double adjacent = mDownX.getValue()-currentX.getValue();
                double tan = Math.atan(opposite / adjacent);
                int degrees = (int)(57.2958 * (tan));
                offsetX.setValue((int)(Math.cos(Math.toRadians(degrees))*-1*lineLength.getValue()));
                offsetY.setValue((int)(Math.sin(Math.toRadians(degrees))*-1*lineLength.getValue()));
            }
            
            // If in quadrant III
            if(mDownX.getValue() > currentX.getValue() && mDownY.getValue() < currentY.getValue()) {
                double opposite = currentY.getValue()-mDownY.getValue();
                double adjacent = mDownX.getValue()-currentX.getValue();
                double tan = Math.atan(opposite / adjacent);
                int degrees = (int)(57.2958 * (tan));
                offsetX.setValue((int)(Math.cos(Math.toRadians(degrees))*-1*lineLength.getValue()));
                offsetY.setValue((int)(Math.sin(Math.toRadians(degrees))*lineLength.getValue()));
            }

            // If in quadrant IV
            if(mDownX.getValue() < currentX.getValue() && mDownY.getValue() < currentY.getValue()) {
                double opposite = currentY.getValue()-mDownY.getValue();
                double adjacent = currentX.getValue()-mDownX.getValue();
                double tan = Math.atan(opposite / adjacent);
                int degrees = (int)(57.2958 * (tan));
                offsetX.setValue((int)(Math.cos(Math.toRadians(degrees))*lineLength.getValue()));
                offsetY.setValue((int)(Math.sin(Math.toRadians(degrees))*lineLength.getValue()));
            }

            
            
            root.setOnMouseReleased(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent me) {
                    showLine.setBoolean(false);
                    if (rocketDistToGoal.getValue() <= 0) { // If 1st missile ISNT being used
                        releasedX.setValue((int)me.getX());
                        releasedY.setValue((int)me.getY());
                        if (moreDist.getValue() == true) {
                            rocketDistToGoal.setValue(500);
                        }
                        else{
                            rocketDistToGoal.setValue(300);
                        }
                        missile.setX(character.getX());
                        missile.setY(character.getY());
                    }
                    else if (rocketDistToGoal2.getValue()<=0 && twoAmmo.getValue()==true){ // If 2nd missile ISNT being used
                        releasedX2.setValue((int)me.getX());
                        releasedY2.setValue((int)me.getY());
                        if (moreDist.getValue() == true) {
                            rocketDistToGoal2.setValue(500);
                        }
                        else{
                            rocketDistToGoal2.setValue(300);
                        }
                        missile2.setX(character.getX());
                        missile2.setY(character.getY());
                    }
                }
            });
            if (mouseX.getValue() == releasedX.getValue() && mouseY.getValue() == releasedY.getValue()) { //If the mouse was not moved
                rocketDistToGoal.setValue(-1);
            }
            if (mouseX2.getValue() == releasedX2.getValue() && mouseY2.getValue() == releasedY2.getValue()) { //If the mouse was not moved
                rocketDistToGoal2.setValue(-1);
            }
            if (mouseX.getValue() > 280 && mouseX.getValue() < 717 && mouseY.getValue() > 605 && mouseY.getValue() < 690) { // If in the purchase box
                rocketDistToGoal.setValue(-1);
            }
            if (mouseX2.getValue() > 280 && mouseX2.getValue() < 717 && mouseY2.getValue() > 605 && mouseY2.getValue() < 690) { // If in the purchase box
                rocketDistToGoal.setValue(-1);
            }
            if (rocketDistToGoal.getValue() <= 0) { // Have rocket dissapear when it's not being used
                missile.setX(0);
                missile.setY(-100);
            }
            if (rocketDistToGoal2.getValue() <= 0) { // Have rocket dissapear when it's not being used
                missile2.setX(0);
                missile2.setY(-100);
            }

            // If in quadrant II
            if(mouseX.getValue() > releasedX.getValue() && mouseY.getValue() > releasedY.getValue()) {
                double opposite = mouseY.getValue()-releasedY.getValue();
                double adjacent = mouseX.getValue()-releasedX.getValue();
                double tan = Math.atan(opposite / adjacent);
                int degrees = (int)(57.2958 * (tan));                
                missile.changeY(-1 * (Math.sin(degrees*0.0174533)*17));
                missile.changeX(-1 * (Math.cos(degrees*0.0174533)*17));
                rocketDistToGoal.changeValue(-17);
                ivRo.setRotate(-1*(90-degrees));
                double xDist = Math.cos((90-degrees)*0.0174533)*50/2;
                double yDist = Math.cos(degrees*0.0174533)*50/2;
                for (Enemy t : enemies) { // For each Enemy, check if they got shot
                    if (smokeRate1.getValue()==-1 && t.getX()!=1000 && missile.getX()+xDist>=t.getX() && missile.getX()+xDist<t.getX()+56 && missile.getY()+yDist>t.getY() && missile.getY()+yDist<t.getY()+65) {
                        t.setX(1000);
                        kills.changeValue(1);
                        coins.changeValue(30);
                        tCoins.changeValue(30);
                    }
                }
            }
            if(mouseX2.getValue() > releasedX2.getValue() && mouseY2.getValue() > releasedY2.getValue()) {
                double opposite = mouseY2.getValue()-releasedY2.getValue();
                double adjacent = mouseX2.getValue()-releasedX2.getValue();
                double tan = Math.atan(opposite / adjacent);
                int degrees = (int)(57.2958 * (tan));                
                missile2.changeY(-1 * (Math.sin(degrees*0.0174533)*17));
                missile2.changeX(-1 * (Math.cos(degrees*0.0174533)*17));
                rocketDistToGoal2.changeValue(-17);
                ivRo2.setRotate(-1*(90-degrees));
                double xDist = Math.cos((90-degrees)*0.0174533)*50/2;
                double yDist = Math.cos(degrees*0.0174533)*50/2;
                for (Enemy t : enemies) {
                    if (smokeRate2.getValue()==-1 && t.getX()!=1000 && missile2.getX()+xDist>=t.getX() && missile2.getX()+xDist<t.getX()+56 && missile2.getY()+yDist>t.getY() && missile2.getY()+yDist<t.getY()+65) {
                        t.setX(1000);
                        kills.changeValue(1);
                        coins.changeValue(30);
                        tCoins.changeValue(30);
                    }
                }
            }

            // If in quadrant I
            if(mouseX.getValue() < releasedX.getValue() && mouseY.getValue() > releasedY.getValue()) {
                double opposite = mouseY.getValue()-releasedY.getValue();
                double adjacent = releasedX.getValue() - mouseX.getValue();
                double tan = Math.atan(opposite / adjacent);
                int degrees = (int)(57.2958 * (tan));
                missile.changeY(-1 * (Math.sin(degrees*0.0174533)*17));
                missile.changeX((Math.cos(degrees*0.0174533)*17));
                rocketDistToGoal.changeValue(-17);
                ivRo.setRotate((90-degrees));
                double xDist = (Math.cos(degrees*0.0174533)*50/2) + (Math.cos((90-degrees)*0.0174533)*25);
                double yDist = (Math.cos((90-degrees)*0.0174533)*50/2) + (Math.cos(degrees*0.0174533)*25);
                for (Enemy t : enemies) {
                    if (smokeRate1.getValue()==-1 && t.getX()!=1000 && missile.getX()+xDist>=t.getX() && missile.getX()+xDist<t.getX()+56 && missile.getY()+yDist>t.getY() && missile.getY()+yDist<t.getY()+65) {
                        t.setX(1000);
                        kills.changeValue(1);
                        coins.changeValue(30);
                        tCoins.changeValue(30);
                    }
                }
            }
            if(mouseX2.getValue() < releasedX2.getValue() && mouseY2.getValue() > releasedY2.getValue()) {
                double opposite = mouseY2.getValue()-releasedY2.getValue();
                double adjacent = releasedX2.getValue() - mouseX2.getValue();
                double tan = Math.atan(opposite / adjacent);
                int degrees = (int)(57.2958 * (tan));
                missile2.changeY(-1 * (Math.sin(degrees*0.0174533)*17));
                missile2.changeX((Math.cos(degrees*0.0174533)*17));
                rocketDistToGoal2.changeValue(-17);
                ivRo2.setRotate((90-degrees));
                double xDist = (Math.cos(degrees*0.0174533)*50/2) + (Math.cos((90-degrees)*0.0174533)*25);
                double yDist = (Math.cos((90-degrees)*0.0174533)*50/2) + (Math.cos(degrees*0.0174533)*25);
                for (Enemy t : enemies) {
                    if (smokeRate2.getValue()==-1 && t.getX()!=1000 && missile2.getX()+xDist>=t.getX() && missile2.getX()+xDist<t.getX()+56 && missile2.getY()+yDist>t.getY() && missile2.getY()+yDist<t.getY()+65) {
                        t.setX(1000);
                        kills.changeValue(1);
                        coins.changeValue(30);
                        tCoins.changeValue(30);
                    }
                }
            }

            // If in quadrant III
            if(mouseX.getValue() > releasedX.getValue() && mouseY.getValue() < releasedY.getValue()) {
                double opposite = releasedY.getValue() - mouseY.getValue();
                double adjacent = mouseX.getValue()-releasedX.getValue();
                double tan = Math.atan(opposite / adjacent);
                int degrees = (int)(57.2958 * (tan));
                missile.changeY((Math.sin(degrees*0.0174533)*17));
                missile.changeX(-1 * (Math.cos(degrees*0.0174533)*17));
                rocketDistToGoal.changeValue(-17);
                ivRo.setRotate(-1*(90+degrees));
                double xDist = (Math.cos((90-degrees)*0.0174533)*25);
                double yDist = (Math.cos((90-degrees)*0.0174533)*50) + (Math.cos(degrees*0.0174533)*25);
                for (Enemy t : enemies) {
                    if (smokeRate1.getValue()==-1 && t.getX()!=1000 && missile.getX()+xDist>=t.getX() && missile.getX()+xDist<t.getX()+56 && missile.getY()+yDist>t.getY() && missile.getY()+yDist<t.getY()+65) {
                        t.setX(1000);
                        kills.changeValue(1);
                        coins.changeValue(30);
                        tCoins.changeValue(30);
                    }
                }
            }
            if(mouseX2.getValue() > releasedX2.getValue() && mouseY2.getValue() < releasedY2.getValue()) {
                double opposite = releasedY2.getValue() - mouseY2.getValue();
                double adjacent = mouseX2.getValue()-releasedX2.getValue();
                double tan = Math.atan(opposite / adjacent);
                int degrees = (int)(57.2958 * (tan));
                missile2.changeY((Math.sin(degrees*0.0174533)*17));
                missile2.changeX(-1 * (Math.cos(degrees*0.0174533)*17));
                rocketDistToGoal2.changeValue(-17);
                ivRo2.setRotate(-1*(90+degrees));
                double xDist = (Math.cos((90-degrees)*0.0174533)*25);
                double yDist = (Math.cos((90-degrees)*0.0174533)*50) + (Math.cos(degrees*0.0174533)*25);
                for (Enemy t : enemies) {
                    if (smokeRate2.getValue()==-1 && t.getX()!=1000 && missile2.getX()+xDist>=t.getX() && missile2.getX()+xDist<t.getX()+56 && missile2.getY()+yDist>t.getY() && missile2.getY()+yDist<t.getY()+65) {
                        t.setX(1000);
                        kills.changeValue(1);
                        coins.changeValue(30);
                        tCoins.changeValue(30);
                    }
                }
            }
            
            // If in quadrant IV
            if(mouseX.getValue() < releasedX.getValue() && mouseY.getValue() < releasedY.getValue()) {
                double opposite = releasedY.getValue() - mouseY.getValue();
                double adjacent = releasedX.getValue() - mouseX.getValue();
                double tan = Math.atan(opposite / adjacent);
                int degrees = (int)(57.2958 * (tan));
                missile.changeY((Math.sin(degrees*0.0174533)*17));
                missile.changeX((Math.cos(degrees*0.0174533)*17));
                rocketDistToGoal.changeValue(-17);
                ivRo.setRotate((90+degrees));
                double xDist = (Math.cos(degrees*0.0174533)*50) + (Math.cos((90-degrees)*0.0174533)*25);
                double yDist = (Math.cos(degrees*0.0174533)*25) + (Math.cos((90-degrees)*0.0174533)*50);
                for (Enemy t : enemies) {
                    if (smokeRate1.getValue()==-1 && t.getX()!=1000 && missile.getX()+xDist>=t.getX() && missile.getX()+xDist<t.getX()+56 && missile.getY()+yDist>t.getY() && missile.getY()+yDist<t.getY()+65) {
                        t.setX(1000);
                        kills.changeValue(1);
                        coins.changeValue(30);
                        tCoins.changeValue(30);
                    }
                }
            }
            if(mouseX2.getValue() < releasedX2.getValue() && mouseY2.getValue() < releasedY2.getValue()) {
                double opposite = releasedY2.getValue() - mouseY2.getValue();
                double adjacent = releasedX2.getValue() - mouseX2.getValue();
                double tan = Math.atan(opposite / adjacent);
                int degrees = (int)(57.2958 * (tan));
                missile2.changeY((Math.sin(degrees*0.0174533)*17));
                missile2.changeX((Math.cos(degrees*0.0174533)*17));
                rocketDistToGoal2.changeValue(-17);
                ivRo2.setRotate((90+degrees));
                double xDist = (Math.cos(degrees*0.0174533)*50) + (Math.cos((90-degrees)*0.0174533)*25);
                double yDist = (Math.cos(degrees*0.0174533)*25) + (Math.cos((90-degrees)*0.0174533)*50);
                for (Enemy t : enemies) {
                    if (smokeRate2.getValue()==-1 && t.getX()!=1000 && missile2.getX()+xDist>=t.getX() && missile2.getX()+xDist<t.getX()+56 && missile2.getY()+yDist>t.getY() && missile2.getY()+yDist<t.getY()+65) {
                        t.setX(1000);
                        kills.changeValue(1);
                        coins.changeValue(30);
                        tCoins.changeValue(30);
                    }
                }
            }
            
            //If they shoot straight at one of the 90 degree angles

            if(mouseX.getValue() > releasedX.getValue() && mouseY.getValue() == releasedY.getValue()) { //  <--
                missile.changeX(-17);
                rocketDistToGoal.changeValue(-17);
                ivRo.setRotate((-90));
                for (Enemy t : enemies) {
                    if (smokeRate1.getValue()==-1 && (t.getX()!=1000 && missile.getX()>=t.getX() && missile.getX()<t.getX()+56) && (missile.getY()+30>=t.getY() && missile.getY()+20<t.getY()+56)) {
                        t.setX(1000);
                        coins.changeValue(30);
                        tCoins.changeValue(30);
                    }
                }
            }
            if(mouseX2.getValue() > releasedX2.getValue() && mouseY2.getValue() == releasedY2.getValue()) { //  <--
                missile2.changeX(-17);
                rocketDistToGoal2.changeValue(-17);
                ivRo2.setRotate((-90));
                for (Enemy t : enemies) {
                    if (smokeRate2.getValue()==-1 && (t.getX()!=1000 && missile2.getX()>=t.getX() && missile2.getX()<t.getX()+56) && (missile2.getY()+30>=t.getY() && missile2.getY()+20<t.getY()+56)) {
                        t.setX(1000);
                        coins.changeValue(30);
                        tCoins.changeValue(30);
                    }
                }
            }

            if(mouseX.getValue() == releasedX.getValue() && mouseY.getValue() > releasedY.getValue()) { //   ^
                missile.changeY(-17);
                rocketDistToGoal.changeValue(-17);
                ivRo.setRotate((0));
                for (Enemy t : enemies) {
                    if (smokeRate1.getValue()==-1 && (t.getX()!=1000 && missile.getX()+20>=t.getX() && missile.getX()+30<t.getX()+56) && (missile.getY()>=t.getY() && missile.getY()<t.getY()+56)) {
                        t.setX(1000);
                        kills.changeValue(1);
                        coins.changeValue(30);
                        tCoins.changeValue(30);
                    }
                }
            }
            if(mouseX2.getValue() == releasedX2.getValue() && mouseY2.getValue() > releasedY2.getValue()) { //   ^
                missile2.changeY(-17);
                rocketDistToGoal2.changeValue(-17);
                ivRo2.setRotate((0));
                for (Enemy t : enemies) {
                    if (smokeRate2.getValue()==-1 && (t.getX()!=1000 && missile2.getX()+20>=t.getX() && missile2.getX()+30<t.getX()+56) && (missile2.getY()>=t.getY() && missile2.getY()<t.getY()+56)) {
                        t.setX(1000);
                        kills.changeValue(1);
                        coins.changeValue(30);
                        tCoins.changeValue(30);
                    }
                }
            }

            if(mouseX.getValue() == releasedX.getValue() && mouseY.getValue() < releasedY.getValue()) { //   v
                missile.changeY(17);
                rocketDistToGoal.changeValue(-17);
                ivRo.setRotate((180));
                for (Enemy t : enemies) {
                    if (smokeRate1.getValue()==-1 && (t.getX()!=1000 && missile.getX()+20>=t.getX() && missile.getX()+30<t.getX()+56) && (missile.getY()+47>=t.getY() && missile.getY()+47<t.getY()+56)) {
                        t.setX(1000);
                        kills.changeValue(1);
                        coins.changeValue(30);
                        tCoins.changeValue(30);
                    }
                }
            }
            if(mouseX2.getValue() == releasedX2.getValue() && mouseY2.getValue() < releasedY2.getValue()) { //   v
                missile2.changeY(17);
                rocketDistToGoal2.changeValue(-17);
                ivRo2.setRotate((180));
                for (Enemy t : enemies) {
                    if (smokeRate2.getValue()==-1 && (t.getX()!=1000 && missile2.getX()+20>=t.getX() && missile2.getX()+30<t.getX()+56) && (missile2.getY()+47>=t.getY() && missile2.getY()+47<t.getY()+56)) {
                        t.setX(1000);
                        kills.changeValue(1);
                        coins.changeValue(30);
                        tCoins.changeValue(30);
                    }
                }
            }

            if(mouseX.getValue() < releasedX.getValue() && mouseY.getValue() == releasedY.getValue()) { //  -->
                missile.changeX(17);
                rocketDistToGoal.changeValue(-17);
                ivRo.setRotate((90));
                for (Enemy t : enemies) {
                    if (smokeRate1.getValue()==-1 && (t.getX()!=1000 && missile.getX()+47>=t.getX() && missile.getX()+47<t.getX()+56) && (missile.getY()+30>=t.getY() && missile.getY()+20<t.getY()+56)) {
                        t.setX(1000);
                        kills.changeValue(1);
                        coins.changeValue(30);
                        tCoins.changeValue(30);
                    }
                }
            }
            if(mouseX2.getValue() < releasedX2.getValue() && mouseY2.getValue() == releasedY2.getValue()) { //  -->
                missile2.changeX(17);
                rocketDistToGoal2.changeValue(-17);
                ivRo2.setRotate((90));
                for (Enemy t : enemies) {
                    if (smokeRate2.getValue()==-1 && (t.getX()!=1000 && missile2.getX()+47>=t.getX() && missile2.getX()+47<t.getX()+56) && (missile2.getY()+30>=t.getY() && missile2.getY()+20<t.getY()+56)) {
                        t.setX(1000);
                        kills.changeValue(1);
                        coins.changeValue(30);
                        tCoins.changeValue(30);
                    }
                }
            }
            
            if (map1_val.getValue() >= 700) {
                notFirstMap.setBoolean(true);
            }

            root.setOnKeyPressed(ev -> {
                if (ev.getCode() == KeyCode.W) {
                    wDown.setBoolean(true);
                }
                if (ev.getCode() == KeyCode.A) {
                    aDown.setBoolean(true);
                }
                if (ev.getCode() == KeyCode.S) {
                    sDown.setBoolean(true);
                }
                if (ev.getCode() == KeyCode.D) {
                    dDown.setBoolean(true);
                }
            });
            
            root.setOnKeyReleased(ev -> {
                if (ev.getCode() == KeyCode.W) {
                    wDown.setBoolean(false);
                }
                else if (ev.getCode() == KeyCode.A) {
                    aDown.setBoolean(false);
                }
                else if (ev.getCode() == KeyCode.S) {
                    sDown.setBoolean(false);
                }
                else if (ev.getCode() == KeyCode.D) {
                    dDown.setBoolean(false);
                }
                if (ev.getCode() == KeyCode.C && coins.getValue()>=500 && speed.getValue()!=16) { // Extra speed
                    coins.changeValue(-500);
                    speed.setValue(16);
                    speedCountdown.setValue(320);
                }
                if (ev.getCode() == KeyCode.V && coins.getValue()>=400 && twoAmmo.getValue()==false) { // Two ammo
                    coins.changeValue(-300);
                    twoAmmo.setBoolean(true);
                }
                if (ev.getCode() == KeyCode.B && coins.getValue()>=300 && moreDist.getValue()==false) { // Extra distance
                    coins.changeValue(-300);
                    moreDist.setBoolean(true);
                    lineLength.setValue(500);
                }
                if (ev.getCode() == KeyCode.Z && coins.getValue()>=700 && spread.getValue()<=0) { // Spreading bullets
                    coins.changeValue(-700);
                    spread.setValue(400);
                    b1.setX(character.getX());
                    b2.setX(character.getX()-100);
                    b3.setX(character.getX()-200);
                    b4.setX(character.getX()-300);
                    bb1.setX(character.getX()+50);
                    bb2.setX(character.getX()+150);
                    bb3.setX(character.getX()+250);
                    bb4.setX(character.getX()+350);
                }
                if (ev.getCode() == KeyCode.X && coins.getValue()>=700 && bomb.getValue()<=0) {
                    bomb.setValue(55);
                    bombX.setValue((int)character.getX());
                    bombY.setValue(340);
                    coins.changeValue(-700);
                    dropVel.setValue(1.9);
                    bSha.setValue(456);
                }
            });
            
            if(timeSinceMouseShot.getValue()<=10) {
                // More Distance manual click button
                if (mouseX.getValue()>628 && mouseY.getValue()>615 && mouseX.getValue()<670 && mouseY.getValue()<682 && releasedX.getValue()>628 && releasedY.getValue()>615 && releasedX.getValue()<670 && releasedY.getValue()<682 && coins.getValue()>=300 && moreDist.getValue()==false) {
                    coins.changeValue(-300);
                    moreDist.setBoolean(true);
                    lineLength.setValue(500);
                }
            }
            
            if(timeSinceMouseShot.getValue()<=10) {
                // Extra Speed manual click button
                if (mouseX.getValue()>475 && mouseY.getValue()>612 && mouseX.getValue()<529 && mouseY.getValue()<682 && releasedX.getValue()>475 && releasedY.getValue()>612 && releasedX.getValue()<529 && releasedY.getValue()<682 && coins.getValue()>=500 && speed.getValue()!=16) {
                    coins.changeValue(-500);
                    speed.setValue(16);
                    speedCountdown.setValue(320);
                }
            }

            // Two bullets manual click button
            if(coins.getValue() >= 400 && mouseX.getValue()>555 && mouseX.getValue()<610 && mouseY.getValue()>612 && mouseY.getValue()<682 && releasedX.getValue()>555 && releasedY.getValue()>612 && releasedX.getValue()<610 && releasedY.getValue()<682 && twoAmmo.getValue()==false) {
                twoAmmo.setBoolean(true);
            }
            
            if(timeSinceMouseShot.getValue()<=10) {
                // Spread manual click button
                if (mouseX.getValue()>308 && mouseY.getValue()>612 && mouseX.getValue()<358 && mouseY.getValue()<682 && releasedX.getValue()>308 && releasedY.getValue()>612 && releasedX.getValue()<358 && releasedY.getValue()<682 && coins.getValue()>=700 && spread.getValue()<=0) {
                    coins.changeValue(-700);
                    spread.setValue(400);
                    b1.setX(character.getX());
                    b2.setX(character.getX()-100);
                    b3.setX(character.getX()-200);
                    b4.setX(character.getX()-300);
                    bb1.setX(character.getX()+50);
                    bb2.setX(character.getX()+150);
                    bb3.setX(character.getX()+250);
                    bb4.setX(character.getX()+350);
                }
            }

            if(bomb.getValue()<=0) {
                // Bomb manual click button
                if (mouseX.getValue()>389 && mouseY.getValue()>612 && mouseX.getValue()<439 && mouseY.getValue()<682 && releasedX.getValue()>389 && releasedY.getValue()>612 && releasedX.getValue()<439 && releasedY.getValue()<682 && coins.getValue()>=700) {
                    bomb.setValue(55);
                    bombX.setValue((int)character.getX());
                    bombY.setValue(340);
                    coins.changeValue(-700);
                    dropVel.setValue(1.9);
                    bSha.setValue(456);
                }
            }
            
            
            if (aDown.getValue() == true && wDown.getValue() == true && character.getX() > 30) {
                missile.changeY(speed.getValue() * 0.714);
                missile2.changeY(speed.getValue() * 0.714);
                character.changeX(-speed.getValue() * 0.714);
                storm.changeValue(speed.getValue() *0.714);
                map1_val.setValue(map1_val.getValue() + (int)(speed.getValue() * 0.714));
                
                map2_val.setValue(map2_val.getValue() + (int)(speed.getValue() * 0.714));
                map3_val.setValue(map3_val.getValue() + (int)(speed.getValue() * 0.714));
                netDistance.setValue(netDistance.getValue() + (int)(speed.getValue() * 0.714));
                if (netDistance.getValue() > max.getValue()) {
                    max.setValue(netDistance.getValue());
                }
                iv.setRotate(-45);
                ivSD.setRotate(-45);
                ivSha.setRotate(-45);
                for (ObjWithCoords b : leftBullets) {
                    b.changeX(-(speed.getValue()*0.714));
                }
                if (speed.getValue()==10) {
                    if(score.getValue() % 2 == 0 && e1.getY() >= 1400) { // Every 2 seconds and if e1 is not being used already
                        e1.setX(rand.nextInt(800)+100);
                        e1.setY(-100);
                    }
                    else if(score.getValue() % 2.5 == 0 && e2.getY() >= 1400) { // Every 2.5 seconds and if e2 is not being used already
                        e2.setX(rand.nextInt(800)+100);
                        e2.setY(-100);
                    }
                    else if(score.getValue() % 4 == 0 && e3.getY() >= 1400) { // Every 4 seconds and if e2 is not being used already
                        e3.setX(rand.nextInt(800)+100);
                        e3.setY(-100);
                    }
                    else if(score.getValue() % 3 == 0 && e4.getY() >= 1400) { // Every 3 seconds and if e2 is not being used already
                        e4.setX(rand.nextInt(800)+100);
                        e4.setY(-100);
                    }
                    if (coin.getY() >= 1400 && rand.nextInt(2)==1 && score.getValue()%2==0) {
                        coin.setX(rand.nextInt(600) + 200);
                        coin.setY(-40);
                    }
                    meters.changeValue(0.4284);
                }
                else if (speed.getValue()==16) {
                    if(score.getValue() % 1 == 0 && e1.getY() >= 1400) { // Every second and if e1 is not being used already
                        e1.setX(rand.nextInt(800)+100);
                        e1.setY(-100);
                    }
                    else if(score.getValue() % 1.5 == 0 && e2.getY() >= 1400) { // Every 1.5 seconds and if e2 is not being used already
                        e2.setX(rand.nextInt(800)+100);
                        e2.setY(-100);
                    }
                    else if(score.getValue() % 2.5 == 0 && e3.getY() >= 1400) { // Every 2.5 seconds and if e2 is not being used already
                        e3.setX(rand.nextInt(800)+100);
                        e3.setY(-100);
                    }
                    else if(score.getValue() % 2 == 0 && e4.getY() >= 1400) { // Every 2 seconds and if e2 is not being used already
                        e4.setX(rand.nextInt(800)+100);
                        e4.setY(-100);
                    }
                    if (coin.getY() >= 1400 && rand.nextInt(2)==1 && score.getValue()%1==0) {
                        coin.setX(rand.nextInt(600) + 200);
                        coin.setY(-40);
                    }
                    meters.changeValue(0.6854);
                }
                e3.changeY(speed.getValue() * 0.714);
                e4.changeY(speed.getValue() * 0.714);
                e1.changeY(speed.getValue() * 0.714);
                e2.changeY(speed.getValue() * 0.714);
                coin.changeY(speed.getValue() * 0.714);
                bombY.changeValue(speed.getValue() * 0.714);
                bSha.changeValue(speed.getValue() * 0.714);
                // If drone touches coin
                if ((character.getX()+49>=coin.getX() && character.getX()+49<coin.getX()+50 && character.getY()>coin.getY() && character.getY()<coin.getY()+40) || (character.getY()+49>coin.getY() && character.getY()+49<coin.getY()+40) && character.getX()>coin.getX() && character.getX()<coin.getX()+50) {
                    coin.setX(1000);
                    coins.changeValue(50);
                    tCoins.changeValue(50);
                }
                alreadyMoved.setBoolean(true);
            }
            if (dDown.getValue() == true && wDown.getValue() == true && character.getX() < 910) {
                missile.changeY(speed.getValue() * 0.714);
                missile2.changeY(speed.getValue() * 0.714);
                character.changeX(speed.getValue() * 0.714);
                storm.changeValue(speed.getValue() * 0.714);
                map1_val.setValue(map1_val.getValue() + (int)(speed.getValue() * 0.714));
                map2_val.setValue(map2_val.getValue() + (int)(speed.getValue() * 0.714));
                map3_val.setValue(map3_val.getValue() + (int)(speed.getValue() * 0.714));
                netDistance.setValue(netDistance.getValue() + (int)(speed.getValue() * 0.714));
                if (netDistance.getValue() > max.getValue()) {
                    max.setValue(netDistance.getValue());
                }
                iv.setRotate(45);
                ivSD.setRotate(45);
                ivSha.setRotate(45);
                for (ObjWithCoords b : rightBullets) {
                    b.changeX(speed.getValue()*0.714);
                }
                if(speed.getValue()==10){
                    if(score.getValue() % 2 == 0 && e1.getY() >= 1400) { // Every 2 seconds and if e1 is not being used already
                        e1.setX(rand.nextInt(800)+100);
                        e1.setY(-100);
                    }
                    else if(score.getValue() % 2.5 == 0 && e2.getY() >= 1400) { // Every 2.5 seconds and if e2 is not being used already
                        e2.setX(rand.nextInt(800)+100);
                        e2.setY(-100);
                    }
                    else if(score.getValue() % 4 == 0 && e3.getY() >= 1400) { // Every 2.5 seconds and if e2 is not being used already
                        e3.setX(rand.nextInt(800)+100);
                        e3.setY(-100);
                    }
                    else if(score.getValue() % 3 == 0 && e4.getY() >= 1400) { // Every 2.5 seconds and if e2 is not being used already
                        e4.setX(rand.nextInt(800)+100);
                        e4.setY(-100);
                    }
                    if (coin.getY() >= 1400 && rand.nextInt(2)==1 && score.getValue()%2==0) {
                        coin.setX(rand.nextInt(600) + 200);
                        coin.setY(-40);
                    }
                    meters.changeValue(0.4284);
                }
                else if (speed.getValue()==16) {
                    if(score.getValue() % 1 == 0 && e1.getY() >= 1400) { // Every 2 seconds and if e1 is not being used already
                        e1.setX(rand.nextInt(800)+100);
                        e1.setY(-100);
                    }
                    else if(score.getValue() % 1.5 == 0 && e2.getY() >= 1400) { // Every 2.5 seconds and if e2 is not being used already
                        e2.setX(rand.nextInt(800)+100);
                        e2.setY(-100);
                    }
                    else if(score.getValue() % 2.5 == 0 && e3.getY() >= 1400) { // Every 2.5 seconds and if e2 is not being used already
                        e3.setX(rand.nextInt(800)+100);
                        e3.setY(-100);
                    }
                    else if(score.getValue() % 2 == 0 && e4.getY() >= 1400) { // Every 2.5 seconds and if e2 is not being used already
                        e4.setX(rand.nextInt(800)+100);
                        e4.setY(-100);
                    }
                    if (coin.getY() >= 1400 && rand.nextInt(2)==1 && score.getValue()%1==0) {
                        coin.setX(rand.nextInt(600) + 200);
                        coin.setY(-40);
                    }
                    meters.changeValue(0.6854);
                }
                e3.changeY(speed.getValue() * 0.714);
                e4.changeY(speed.getValue() * 0.714);
                e1.changeY(speed.getValue() * 0.714);
                e2.changeY(speed.getValue() * 0.714);
                coin.changeY(speed.getValue() * 0.714);
                bombY.changeValue(speed.getValue() * 0.714);
                bSha.changeValue(speed.getValue() * 0.714);
                alreadyMoved.setBoolean(true);
            }
            if (aDown.getValue() == true && sDown.getValue() == true && character.getX() > 30) {
                if ((map1_val.getValue() > -700 && distanceFromMax.getValue() > -1400 && notFirstMap.getValue()==false) || (distanceFromMax.getValue() > -1400 && notFirstMap.getValue()==true)){
                    missile.changeY(-speed.getValue() * 0.714);
                    missile2.changeY(-speed.getValue() * 0.714);
                    character.changeX(-speed.getValue() * 0.714);
                    storm.changeValue(-speed.getValue() * 0.714);
                    map1_val.setValue(map1_val.getValue() - (int)(speed.getValue() * 0.714));
                    map2_val.setValue(map2_val.getValue() - (int)(speed.getValue() * 0.714));
                    map3_val.setValue(map3_val.getValue() - (int)(speed.getValue() * 0.714));
                    netDistance.setValue(netDistance.getValue() - (int)(speed.getValue() * 0.714));
                    iv.setRotate(45);
                    ivSD.setRotate(45);
                    ivSha.setRotate(45);
                    for (ObjWithCoords b :leftBullets) {
                        b.changeX(-(speed.getValue()*0.714));
                    }
                    if (speed.getValue()==10) {
                        if(score.getValue() % 2 == 0 && e1.getY() >= 1400) { // Every 2 seconds and if e1 is not being used already
                            e1.setX(rand.nextInt(800)+100); 
                            e1.setY(-100);
                        }
                        else if(score.getValue() % 2.5 == 0 && e2.getY() >= 1400) { // Every 2.5 seconds and if e2 is not being used already
                            e2.setX(rand.nextInt(800)+100);
                            e2.setY(-100);
                        }
                        else if(score.getValue() % 4 == 0 && e3.getY() >= 1400) { // Every 2.5 seconds and if e2 is not being used already
                            e3.setX(rand.nextInt(800)+100);
                            e3.setY(-100);
                        }
                        else if(score.getValue() % 3 == 0 && e4.getY() >= 1400) { // Every 2.5 seconds and if e2 is not being used already
                            e4.setX(rand.nextInt(800)+100);
                            e4.setY(-100);
                        }
                        
                        if (coin.getY() >= 1400 && rand.nextInt(2)==1 && score.getValue()%2==0) {
                            coin.setX(rand.nextInt(600) + 200);
                            coin.setY(-40);
                        }
                        meters.changeValue(-0.4284);
                    }
                    else if (speed.getValue()==16) {
                        if(score.getValue() % 1 == 0 && e1.getY() >= 1400) { // Every 2 seconds and if e1 is not being used already
                            e1.setX(rand.nextInt(800)+100);
                            e1.setY(-100);
                        }
                        else if(score.getValue() % 1.5 == 0 && e2.getY() >= 1400) { // Every 2.5 seconds and if e2 is not being used already
                            e2.setX(rand.nextInt(800)+100);
                            e2.setY(-100);
                        }
                        else if(score.getValue() % 2.5 == 0 && e3.getY() >= 1400) { // Every 2.5 seconds and if e2 is not being used already
                            e3.setX(rand.nextInt(800)+100);
                            e3.setY(-100);
                        }
                        else if(score.getValue() % 2 == 0 && e4.getY() >= 1400) { // Every 2.5 seconds and if e2 is not being used already
                            e4.setX(rand.nextInt(800)+100);
                            e4.setY(-100);
                        }
                        if (coin.getY() >= 1400 && rand.nextInt(2)==1 && score.getValue()%1==0) {
                            coin.setX(rand.nextInt(600) + 200);
                            coin.setY(-40);
                        }
                        meters.changeValue(-0.6854);
                    }
                    e3.changeY(-speed.getValue() * 0.714);
                    e4.changeY(-speed.getValue() * 0.714);
                    e1.changeY(-speed.getValue() * 0.714);
                    e2.changeY(-speed.getValue() * 0.714);
                    coin.changeY(-speed.getValue() * 0.714);
                    bombY.changeValue(speed.getValue() * -0.714);
                    bSha.changeValue(speed.getValue() * -0.714);
                    alreadyMoved.setBoolean(true);
                }
            }
            if (dDown.getValue() == true && sDown.getValue() == true && character.getX() < 910) {
                if ((map1_val.getValue() > -700 && distanceFromMax.getValue() > -1400 && notFirstMap.getValue()==false) || (distanceFromMax.getValue() > -1400 && notFirstMap.getValue()==true)) {
                    missile.changeY(-speed.getValue() * 0.714);
                    missile2.changeY(-speed.getValue() * 0.714);
                    character.changeX(speed.getValue() * 0.714);
                    storm.changeValue(-speed.getValue() * 0.714);
                    map1_val.setValue(map1_val.getValue() - (int)(speed.getValue() * 0.714));
                    map2_val.setValue(map2_val.getValue() - (int)(speed.getValue() * 0.714));
                    map3_val.setValue(map3_val.getValue() - (int)(speed.getValue() * 0.714));
                    netDistance.setValue(netDistance.getValue() - (int)(speed.getValue() * 0.714));
                    iv.setRotate(-45);
                    ivSD.setRotate(-45);
                    ivSha.setRotate(-45);
                    for (ObjWithCoords b : rightBullets) {
                        b.changeX(speed.getValue()*0.714);
                    }
                    if (speed.getValue()==10) {
                        if(score.getValue() % 2 == 0 && e1.getY() >= 1400) { // Every 2 seconds and if e1 is not being used already
                            e1.setX(rand.nextInt(800)+100);
                            e1.setY(-100);
                        }
                        else if(score.getValue() % 2.5 == 0 && e2.getY() >= 1400) { // Every 2.5 seconds and if e2 is not being used already
                            e2.setX(rand.nextInt(800)+100);
                            e2.setY(-100);
                        }
                        else if(score.getValue() % 4 == 0 && e3.getY() >= 1400) { // Every 2.5 seconds and if e2 is not being used already
                            e3.setX(rand.nextInt(800)+100);
                            e3.setY(-100);
                        }
                        else if(score.getValue() % 3 == 0 && e4.getY() >= 1400) { // Every 2.5 seconds and if e2 is not being used already
                            e4.setX(rand.nextInt(800)+100);
                            e4.setY(-100);
                        }
                        if (coin.getY() >= 1400 && rand.nextInt(2)==1 && score.getValue()%2==0) {
                            coin.setX(rand.nextInt(600) + 200);
                            coin.setY(-40);
                        }
                        meters.changeValue(-0.4284);
                    }
                    else if (speed.getValue()==16) {
                        if(score.getValue() % 1 == 0 && e1.getY() >= 1400) { // Every 2 seconds and if e1 is not being used already
                            e1.setX(rand.nextInt(800)+100);
                            e1.setY(-100);
                        }
                        else if(score.getValue() % 1.5 == 0 && e2.getY() >= 1400) { // Every 2.5 seconds and if e2 is not being used already
                            e2.setX(rand.nextInt(800)+100);
                            e2.setY(-100);
                        }
                        else if(score.getValue() % 2.5 == 0 && e3.getY() >= 1400) { // Every 2.5 seconds and if e2 is not being used already
                            e3.setX(rand.nextInt(800)+100);
                            e3.setY(-100);
                        }
                        else if(score.getValue() % 2 == 0 && e4.getY() >= 1400) { // Every 2.5 seconds and if e2 is not being used already
                            e4.setX(rand.nextInt(800)+100);
                            e4.setY(-100);
                        }
                        if (coin.getY() >= 1400 && rand.nextInt(2)==1 && score.getValue()%1==0) {
                            coin.setX(rand.nextInt(600) + 200);
                            coin.setY(-40);
                        }
                        meters.changeValue(-0.6854);
                    }
                    e3.changeY(-speed.getValue() * 0.714);
                    e4.changeY(-speed.getValue() * 0.714);
                    e1.changeY(-speed.getValue() * 0.714);
                    e2.changeY(-speed.getValue() * 0.714);
                    coin.changeY(-speed.getValue() * 0.714);
                    bombY.changeValue(-speed.getValue() * 0.714);
                    bSha.changeValue(-speed.getValue() * 0.714);
                    alreadyMoved.setBoolean(true);
                }
            }
            
            if (wDown.getValue() == true && alreadyMoved.getValue() == false) {
                missile.changeY(speed.getValue());
                missile2.changeY(speed.getValue());
                storm.changeValue(speed.getValue());
                map1_val.setValue(map1_val.getValue() + speed.getValue());
                map2_val.setValue(map2_val.getValue() + speed.getValue());
                map3_val.setValue(map3_val.getValue() + speed.getValue());
                netDistance.setValue(netDistance.getValue() + speed.getValue());
                if (netDistance.getValue() > max.getValue()) {
                    max.setValue(netDistance.getValue());
                }
                iv.setRotate(0);
                ivSD.setRotate(0);
                ivSha.setRotate(0);
                if (speed.getValue()==10) {
                    if(score.getValue() % 2 == 0 && e1.getY() >= 1400) { // Every 2 seconds and if e1 is not being used already
                        e1.setX(rand.nextInt(800)+100);
                        e1.setY(-100);
                    }
                    else if(score.getValue() % 2.5 == 0 && e2.getY() >= 1400) { // Every 2.5 seconds and if e2 is not being used already
                        e2.setX(rand.nextInt(800)+100);
                        e2.setY(-100);
                    }
                    else if(score.getValue() % 4 == 0 && e3.getY() >= 1400) { // Every 2.5 seconds and if e2 is not being used already
                        e3.setX(rand.nextInt(800)+100);
                        e3.setY(-100);
                    }
                    else if(score.getValue() % 3 == 0 && e4.getY() >= 1400) { // Every 2.5 seconds and if e2 is not being used already
                        e4.setX(rand.nextInt(800)+100);
                        e4.setY(-100);
                    }
                    if (coin.getY() >= 1400 && rand.nextInt(2)==1 && score.getValue()%2==0) {
                        coin.setX(rand.nextInt(600) + 200);
                        coin.setY(-40);
                    }
                    meters.changeValue(.6);
                }
                else if (speed.getValue()==16) {
                    if(score.getValue() % 1 == 0 && e1.getY() >= 1400) { // Every 2 seconds and if e1 is not being used already
                        e1.setX(rand.nextInt(800)+100);
                        e1.setY(-100);
                    }
                    else if(score.getValue() % 1.5 == 0 && e2.getY() >= 1400) { // Every 2.5 seconds and if e2 is not being used already
                        e2.setX(rand.nextInt(800)+100);
                        e2.setY(-100);
                    }
                    else if(score.getValue() % 2.5 == 0 && e3.getY() >= 1400) { // Every 2.5 seconds and if e2 is not being used already
                        e3.setX(rand.nextInt(800)+100);
                        e3.setY(-100);
                    }
                    else if(score.getValue() % 2 == 0 && e4.getY() >= 1400) { // Every 2.5 seconds and if e2 is not being used already
                        e4.setX(rand.nextInt(800)+100);
                        e4.setY(-100);
                    }
                    if (coin.getY() >= 1400 && rand.nextInt(2)==1 && score.getValue()%1==0) {
                        coin.setX(rand.nextInt(600) + 200);
                        coin.setY(-40);
                    }
                    meters.changeValue(.96);
                }
                e3.changeY(speed.getValue());
                e4.changeY(speed.getValue());
                e1.changeY(speed.getValue());
                e2.changeY(speed.getValue());
                coin.changeY(speed.getValue());
                bombY.changeValue(speed.getValue());
                bSha.changeValue(speed.getValue());
            }
            if (aDown.getValue() == true && alreadyMoved.getValue() == false && character.getX() > 30) {
                character.changeX(-speed.getValue());
                iv.setRotate(0);
                ivSD.setRotate(0);
                ivSha.setRotate(0);
                for (ObjWithCoords b : leftBullets) {
                    b.changeX(-1 * speed.getValue());
                }
            }
            
            if (sDown.getValue() == true && alreadyMoved.getValue() == false) {
                if ((map1_val.getValue() > -700 && distanceFromMax.getValue() > -1400 && notFirstMap.getValue()==false) || (distanceFromMax.getValue() > -1400 && notFirstMap.getValue()==true)) {
                    missile.changeY(-speed.getValue());
                    missile2.changeY(-speed.getValue());
                    storm.changeValue(-speed.getValue());
                    map1_val.setValue(map1_val.getValue() - speed.getValue());
                    map2_val.setValue(map2_val.getValue() - speed.getValue());
                    map3_val.setValue(map3_val.getValue() - speed.getValue());
                    netDistance.setValue(netDistance.getValue() - speed.getValue());
                    iv.setRotate(0);
                    ivSD.setRotate(0);
                    ivSha.setRotate(0);
                    if (speed.getValue()==10) {
                        if(score.getValue() % 2 == 0 && e1.getY() >= 1400) { // Every 2 seconds and if e1 is not being used already
                            e1.setX(rand.nextInt(800)+100);
                            e1.setY(-100);
                        }
                        else if(score.getValue() % 2.5 == 0 && e2.getY() >= 1400) { // Every 2.5 seconds and if e2 is not being used already
                            e2.setX(rand.nextInt(800)+100);
                            e2.setY(-100);
                        }
                        else if(score.getValue() % 4 == 0 && e3.getY() >= 1400) { // Every 2.5 seconds and if e2 is not being used already
                            e3.setX(rand.nextInt(800)+100);
                            e3.setY(-100);
                        }
                        else if(score.getValue() % 3 == 0 && e4.getY() >= 1400) { // Every 2.5 seconds and if e2 is not being used already
                            e4.setX(rand.nextInt(800)+100);
                            e4.setY(-100);
                        }
                        if (coin.getY() >= 1400 && rand.nextInt(2)==1 && score.getValue()%2==0) {
                            coin.setX(rand.nextInt(600) + 200);
                            coin.setY(-40);
                        }
                        meters.changeValue(-.6);
                    }
                    else if (speed.getValue()==16) {
                        if(score.getValue() % 1 == 0 && e1.getY() >= 1400) { // Every 2 seconds and if e1 is not being used already
                            e1.setX(rand.nextInt(800)+100);
                            e1.setY(-100);
                        }
                        else if(score.getValue() % 1.5 == 0 && e2.getY() >= 1400) { // Every 2.5 seconds and if e2 is not being used already
                            e2.setX(rand.nextInt(800)+100);
                            e2.setY(-100);
                        }
                        else if(score.getValue() % 2.5 == 0 && e3.getY() >= 1400) { // Every 2.5 seconds and if e2 is not being used already
                            e3.setX(rand.nextInt(800)+100);
                            e3.setY(-100);
                        }
                        else if(score.getValue() % 2 == 0 && e4.getY() >= 1400) { // Every 2.5 seconds and if e2 is not being used already
                            e4.setX(rand.nextInt(800)+100);
                            e4.setY(-100);
                        }
                        if (coin.getY() >= 1400 && rand.nextInt(2)==1 && score.getValue()%1==0) {
                            coin.setX(rand.nextInt(600) + 200);
                            coin.setY(-40);
                        }
                        meters.changeValue(-.96);
                    }
                    e3.changeY(-speed.getValue());
                    e4.changeY(-speed.getValue());
                    e1.changeY(-speed.getValue());
                    e2.changeY(-speed.getValue());
                    coin.changeY(-speed.getValue());
                    bombY.changeValue(-speed.getValue());
                    bSha.changeValue(-speed.getValue());
                }
            }
            else if (dDown.getValue() == true && alreadyMoved.getValue() == false && character.getX() < 910) {
                character.changeX(speed.getValue());
                iv.setRotate(0);
                ivSD.setRotate(0);
                ivSha.setRotate(0);
                for (ObjWithCoords b : rightBullets) {
                    b.changeX(speed.getValue());
                }
            }
            
            // Setting the chracter's distance from their max
            distanceFromMax.setValue(netDistance.getValue() - max.getValue());
            
            // Moving the maps
            if (map1_val.getValue() > 2100) {
                map1_val.setValue(map3_val.getValue()-1400);
            }
            else if (map2_val.getValue() > 2100) {
                map2_val.setValue(map1_val.getValue()-1400);
            }
            else if (map3_val.getValue() > 2100) {
                map3_val.setValue(map2_val.getValue()-1400);
            }
            alreadyMoved.setBoolean(false);
            
            // If the drone and coin are overlapping, give them coins and hide the coin
            if ((character.getX()>=coin.getX() && character.getX()<coin.getX()+50) && (character.getY()>=coin.getY() && character.getY()<coin.getY()+40)) {
                coin.setX(1000);
                coins.changeValue(50);
                tCoins.changeValue(50);
            }
            else if ((character.getX()<coin.getX()+50 && character.getX()+70>=coin.getX()) && (character.getY()>=coin.getY() && character.getY()<coin.getY()+40)) {
                coin.setX(1000);
                coins.changeValue(50);
                tCoins.changeValue(50);
            }
            else if ((character.getX()<coin.getX()+50 && character.getX()+70>=coin.getX()) && (character.getY()+70>=coin.getY() && character.getY()<coin.getY())) {
                coin.setX(1000);
                coins.changeValue(50);
                tCoins.changeValue(50);
            }
            else if ((character.getX()>=coin.getX() && character.getX()<coin.getX()+50) && (character.getY()+70>=coin.getY() && character.getY()<coin.getY())) {
                coin.setX(1000);
                coins.changeValue(50);
                tCoins.changeValue(50);
            }
            
            if (speedCountdown.getValue() <= 0) {
                speed.setValue(10);
            }
            else {
                speedCountdown.changeValue(-1);
            }
                        
            for(ObjWithCoords b : rightBullets) {
                if(spread.getValue() > 0) {
                    if(b.getX() > character.getX()+300) {
                        b.changeX(-400);
                    }
                    b.changeX(15);
                }
            }
            for(ObjWithCoords b : leftBullets) {
                if(spread.getValue() > 0) {
                    if(b.getX() < character.getX()-300) {
                        b.changeX(400);
                    }
                    b.changeX(-15);
                }
            }
            if (spread.getValue()>0) {
                spread.changeValue(-1);
            }
            
            if(spread.getValue() > 0 && spread.getValue() < 380) {
                for (Enemy t : enemies) {
                    if (t.getX() < 1000) {
                        // Bottom right
                        if(t.getX()+56 >= character.getX()-300 && t.getX()+56 <= character.getX()+350 && t.getY()+65 >= 365 && t.getY()+65 <= 381) {
                            t.setX(1000);
                            coins.changeValue(30);
                            tCoins.changeValue(30);
                        }
                        // 1 above the one above
                        if(t.getX()+56 >= character.getX()-300 && t.getX()+56 <= character.getX()+350 && t.getY()+49 >= 365 && t.getY()+49 <= 381) {
                            t.setX(1000);
                            coins.changeValue(30);
                            tCoins.changeValue(30);
                        }
                        // 1 above the one above
                        if(t.getX()+56 >= character.getX()-300 && t.getX()+56 <= character.getX()+350 && t.getY()+33 >= 365 && t.getY()+33 <= 381) {
                            t.setX(1000);
                            coins.changeValue(30);
                            tCoins.changeValue(30);
                        }
                        // 1 above the one above
                        if(t.getX()+56 >= character.getX()-300 && t.getX()+56 <= character.getX()+350 && t.getY()+17 >= 365 && t.getY()+17 <= 381) {
                            t.setX(1000);
                            coins.changeValue(30);
                            tCoins.changeValue(30);
                        }
                        // Top right
                        if(t.getX()+56 >= character.getX()-300 && t.getX()+56 <= character.getX()+350 && t.getY()+0 >= 365 && t.getY()+0 <= 381) {
                            t.setX(1000);
                            coins.changeValue(30);
                            tCoins.changeValue(30);
                        }
                    
                        // Bottom left
                        if(t.getX() >= character.getX()-300 && t.getX() <= character.getX()+350 && t.getY()+65 >= 365 && t.getY()+65 <= 381) {
                            t.setX(1000);
                            coins.changeValue(30);
                            tCoins.changeValue(30);
                        }
                        // 1 above the one above
                        if(t.getX() >= character.getX()-300 && t.getX() <= character.getX()+350 && t.getY()+49 >= 365 && t.getY()+49 <= 381) {
                            t.setX(1000);
                            coins.changeValue(30);
                            tCoins.changeValue(30);
                        }
                        // 1 above the one above
                        if(t.getX() >= character.getX()-300 && t.getX() <= character.getX()+350 && t.getY()+33 >= 365 && t.getY()+33 <= 381) {
                            t.setX(1000);
                            coins.changeValue(30);
                            tCoins.changeValue(30);
                        }
                        // 1 above the one above
                        if(t.getX() >= character.getX()-300 && t.getX() <= character.getX()+350 && t.getY()+17 >= 365 && t.getY()+17 <= 381) {
                            t.setX(1000);
                            coins.changeValue(30);
                            tCoins.changeValue(30);
                        }
                        // Top left
                        if(t.getX() >= character.getX()-300 && t.getX() <= character.getX()+350 && t.getY()+0 >= 365 && t.getY()+0 <= 381) {
                            t.setX(1000);
                            coins.changeValue(30);
                            tCoins.changeValue(30);
                        }
                    }
                }
            }
            
            // Drone Deactivation Zone
            if (score.getValue() <= 130) {
                stormChange.setValue((int)(-1*((score.getValue()-30.0)/20+7)));
            }
            else {
                stormChange.setValue(-12);
            }
            storm.changeValue(stormChange.getValue());

            // If an Enemy is in the storm the survivor count increases by 1
            for (int i=0; i<enemies.length;i++) {
                if (enemies[i].getY() > storm.getValue() && enemies[i].getY()+stormChange.getValue() < storm.getValue() && enemies[i].getX() != 1000 && enemies[i].getY() > -60) {
                    survivors.changeValue(1);
                }
            }
            
            // Game over due to SURVIVORS:
            
            if (survivors.getValue() >= 8 && getDarker.getValue() <= 0 && lostCgoing.getValue()==false) {
                getDarker.setValue(32);
                fin_distance.setValue((int)meters.getValue());
                fin_coin.setValue(tCoins.getValue());
            }
            
            if(getDarker.getValue() > 0) {
                lastDark.setValue(getDarker.getValue());
                blackOpac.changeValue(acc.getValue());
                im.setOpacity(blackOpac.getValue());
                getDarker.changeValue(-1);
                acc.changeValue(.002);
                fade.changeValue(-0.03125);
            }
            else {
                im.setOpacity(0);
            }
            
            if (lastDark.getValue() == 1) {
                blackDone.setBoolean(true);
                if (endMisF.getValue()==0){
                    endMisF.setValue(60);
                }
            }
            
            if (endMisF.getValue() > 0) {
                lastEnd.setValue(endMisF.getValue());
                endMisF.changeValue(-1);
            }
            

            if (lastEnd.getValue() == 1) {
                survivorsDone.setBoolean(true);
            }
            

            // Game over due to hitting the storm:
            
            if (lostCgoing.getValue()==false && character.getY() > storm.getValue()) {
                if (survivors.getValue() < 8) {
                    lostCgoing.setBoolean(true);
                    fin_distance.setValue((int)meters.getValue());
                    fin_coin.setValue(tCoins.getValue());
                    lostC.setValue(48);
                    fade.setValue(0);
                }
            }
            
            if (lostC.getValue() > 0) {
                lostC.changeValue(-1);
            }
                        
            // If drone is near storm - red edges
            
            if (character.getY() > storm.getValue() - 80 && character.getY()+stormChange.getValue() < storm.getValue()-80 && character.getX() < 1000 && character.getY()<700) {
                if (redness.getValue() == 0) {
                    redness.setValue(32);
                }
            }
            
            if (redness.getValue() > 0) {
                if (redness.getValue() > 16) { // if between 32 and 16
                    redOpac.changeValue(.03125);
                }
                else { // if between 16 and 0
                    redOpac.changeValue(-.03125);
                }
                redness.changeValue(-1);
            }

            for (Enemy t : enemies) {
                if (t.getY() >= 1400 && t.getX()<1000 && t.getY()<storm.getValue()) { // If out of screen (2 full screens away)
                    survivors.changeValue(1);
                    t.setX(1000);
                }
            }

            // The bomb:
            if (bomb.getValue() <= 16 && bomb.getValue() > 0) { // It's 8 rather than 0 because the smoke will dissapate
                for (Enemy t : enemies) {
                    if (t.getY() <= 650 && t.getY() >= -40 && t.getX()>=0 && t.getX()<=970) { // If they are in the screen, kill them
                        t.setX(1000);
                        kills.changeValue(1);
                        coins.changeValue(30);
                        tCoins.changeValue(30);
                        System.out.println("Bomb: "+bomb.getValue());
                    }
                    else {
                        System.out.println("X: " + t.getX());
                        System.out.println("Y: " + t.getY());
                    }
                }
            }
            bomb.changeValue(-1);


            // Drawing:

            gc.drawImage(map1, 0, map1_val.getValue());
            gc.drawImage(map2, 0, map2_val.getValue());
            gc.drawImage(map3, 0, map3_val.getValue());
            gc.drawImage(t_shadow, e1.getX()+9, e1.getY()+19);
            gc.drawImage(t_shadow, e2.getX()+9, e2.getY()+19);
            gc.drawImage(t_shadow, e3.getX()+9, e3.getY()+19);
            gc.drawImage(t_shadow, e4.getX()+9, e4.getY()+19);
            gc.drawImage(Enemy, e1.getX(), e1.getY());
            gc.drawImage(Enemy_2, e2.getX(), e2.getY());
            gc.drawImage(Enemy_3, e3.getX(), e3.getY());
            gc.drawImage(Enemy_4, e4.getX(), e4.getY());
            gc.drawImage(coinImg, coin.getX(), coin.getY()-20);

            for(ObjWithCoords b : rightBullets) {
                if (b.getX() > character.getX()+30 && spread.getValue()>0) {
                    gc.drawImage(bullet, b.getX(), b.getY());
                }
            }

            for(ObjWithCoords b : leftBullets) {
                if (b.getX()+30 < character.getX() && spread.getValue()>0) {
                    gc.drawImage(bullet2, b.getX(), b.getY());
                }
            }
            
            ivRed.setOpacity(redOpac.getValue());
            SnapshotParameters params = new SnapshotParameters();
            params.setFill(Color.TRANSPARENT);
            Image imgRed = ivRed.snapshot(params, null);
            gc.drawImage(imgRed, 0, 0);
            
            

            params.setFill(Color.TRANSPARENT);
            Image rotatedShadow = ivSha.snapshot(params, null);
            gc.drawImage(rotatedShadow, character.getX()+30, 365);

            double opposite = mouseY.getValue()-releasedY.getValue();
            double adjacent = mouseX.getValue()-releasedX.getValue();
            double tan = Math.atan(opposite / adjacent);
            int degrees = (int)(57.2958 * (tan));
            int pxDown = degrees/90*50; // pxDown is the y-coordinate of the bottom of the missile
            if (storm.getValue() < missile.getY()+pxDown && smokeRate1.getValue()==-1 && prev_smokeRate1.getValue()!=0) { // If missile is in the storm and smokeRate is not already 25
                smokeRate1.setValue(25);
            }
            opposite = mouseY2.getValue()-releasedY2.getValue();
            adjacent = mouseX2.getValue()-releasedX2.getValue();
            tan = Math.atan(opposite / adjacent);
            degrees = (int)(57.2958 * (tan));
            pxDown = degrees/90*50;
            if (storm.getValue() < missile2.getY()+pxDown && smokeRate2.getValue()==-1 && prev_smokeRate2.getValue()!=0) { // If missile is in the storm and smokeRate is not already 25
                smokeRate2.setValue(25);
            }

            if (smokeRate1.getValue()==-1 && rocketDistToGoal.getValue()>0 && storm.getValue() > missile.getY()+pxDown) { // If not smoke and rocket is still flying and missile is NOT in storm
                params.setFill(Color.TRANSPARENT);
                Image rotatedImageRocket = ivRo.snapshot(params, null);
                gc.drawImage(rotatedImageRocket, missile.getX(), missile.getY());
            }
            if (smokeRate2.getValue()==-1 && rocketDistToGoal2.getValue()>0 && storm.getValue() > missile2.getY()+pxDown) {
                params.setFill(Color.TRANSPARENT);
                Image rotatedImageRocket2 = ivRo2.snapshot(params, null);
                gc.drawImage(rotatedImageRocket2, missile2.getX(), missile2.getY());
            }
            
            if (smokeRate1.getValue() > 0) {
                ivSmoke1.setOpacity(smokeRate1.getValue()/25.0); // Change smoke opacity
                ivSmoke1.setFitHeight(110-smokeRate1.getValue()*2); // Make the smoke get taller
                ivSmoke1.setFitWidth(110-smokeRate1.getValue()*2); // Make the smoke get wider
                params.setFill(Color.TRANSPARENT);
                Image alteredSmoke1 = ivSmoke1.snapshot(params, null);
                gc.drawImage(alteredSmoke1, missile.getX(), missile.getY());
            }
            if (smokeRate2.getValue() > 0) {
                ivSmoke2.setOpacity(smokeRate2.getValue()/25.0);
                ivSmoke2.setFitHeight(110-smokeRate2.getValue()*2); // Make the smoke get taller
                ivSmoke2.setFitWidth(110-smokeRate2.getValue()*2); // Make the smoke get wider
                params.setFill(Color.TRANSPARENT);
                Image alteredSmoke2 = ivSmoke2.snapshot(params, null);
                gc.drawImage(alteredSmoke2, missile2.getX(), missile2.getY());
            }

            if (smokeRate1.getValue() > 0) {
                prev_smokeRate1.setValue(smokeRate1.getValue());
                smokeRate1.changeValue(-3.125);
            }
            if (smokeRate2.getValue() > 0) {
                prev_smokeRate2.setValue(smokeRate2.getValue());
                smokeRate2.changeValue(-3.125);
            }
            if (smokeRate1.getValue() == 0) {
                prev_smokeRate1.setValue(0);
                smokeRate1.setValue(-1);
            }
            if (smokeRate2.getValue() == 0) {
                prev_smokeRate2.setValue(0);
                smokeRate2.setValue(-1);
            }
            if(smokeRate1.getValue() == -1 && rocketDistToGoal.getValue()<=0) {
                prev_smokeRate1.setValue(-1);
            }
            if(smokeRate2.getValue() == -1 && rocketDistToGoal2.getValue()<=0) {
                prev_smokeRate2.setValue(-1);
            }


            // DRAWING THE BOMB

            if (bomb.getValue()>0) { // If bomb is active
                System.out.println("Bomb: " + bomb.getValue());
                if (bomb.getValue()==20) {
                    bombOpac.setValue(1.00);
                    inAndOut.setValue(0);
                    goingUp.setBoolean(true);
                    smokeSize.setValue(1);
                    sizeDecrease.setValue(1);
                }
                if (bomb.getValue()>20) { // Bomb is dropping
                    if (bomb.getValue()>40) {
                        bombY.changeValue(dropVel.getValue());
                        dropVel.setValue(dropVel.getValue()*1.15);
                    }
                    gc.drawImage(bombImg, bombX.getValue(), bombY.getValue());
                    ivBombSha.setOpacity(dropVel.getValue()/13.443);
                    params.setFill(Color.TRANSPARENT);
                    Image bombShaDone = ivBombSha.snapshot(params, null);
                    gc.drawImage(bombShaDone, bombX.getValue()+10, bSha.getValue());
                }
                else if (bomb.getValue()>=16) { // The flash
                    gc.drawImage(flash, 0, 0);
                }
                else { // After the flash
                    ivRedSmk.setOpacity(bombOpac.getValue());
                    params.setFill(Color.TRANSPARENT);
                    Image redSmkDone = ivRedSmk.snapshot(params, null);
                    gc.drawImage(redSmkDone, 0,0);

                    if (bombOpac.getValue() >= .06) {
                        bombOpac.changeValue(-.06);
                    }
                    if (smokeSize.getValue() < 3) {
                        smokeSize.changeValue(.3);
                    }
                    if (sizeDecrease.getValue() >= .5) {
                        sizeDecrease.changeValue(-.03);
                    }
                }
                if (bomb.getValue()<=18) {
                    // Control the fade in and out for the bomb pieces
                    if (inAndOut.getValue()<=.6 && goingUp.getValue() == true) {            
                        inAndOut.changeValue(.3);
                    }
                    else if (inAndOut.getValue()>=.2) {
                        goingUp.setBoolean(false);
                        inAndOut.changeValue(-.3);
                    }
                }
            }
            

            if (speed.getValue()==10) {
                params.setFill(Color.TRANSPARENT);
                Image rotatedDrone = iv.snapshot(params, null);
                gc.drawImage(rotatedDrone, character.getX(), 350);
            }
            if (speed.getValue()==16) {
                params.setFill(Color.TRANSPARENT);
                Image rotatedDrone = ivSD.snapshot(params, null);
                gc.drawImage(rotatedDrone, character.getX(), 350);
            }

            gc.drawImage(ads, 0, storm.getValue());
            gc.drawImage(ui_1, 0, 0);

            if(spread.getValue() > 0) {
                gc.drawImage(spreadIconUsed, 322, 611);
            }
            else if(coins.getValue()>=700) {
                gc.drawImage(spreadIcon, 322, 611);
                spreadText.setOpacity(fade.getValue());
            }
            else{
                gc.drawImage(spreadIcon_C_A, 322, 611);
            }

            if(bomb.getValue() > 0) {
                gc.drawImage(bombIconUsed, 403, 611);
            }
            else if(coins.getValue()>=700) {
                gc.drawImage(bombIcon, 403, 611);
                bombText.setOpacity(fade.getValue());
            }
            else {
                gc.drawImage(bombIcon_C_A, 403, 611);
            }

            if(speed.getValue()==16) {
                gc.drawImage(speedIconUsed, 479, 613);
            }
            else if(coins.getValue()>=500) {
                gc.drawImage(speedIcon, 479, 613);
                speedText.setOpacity(fade.getValue());
            }
            else{
                gc.drawImage(speedIcon_C_A, 479, 613);
            }

            if(moreDist.getValue() == true) {
                gc.drawImage(extraDistIconUsed, 625, 613);
            }
            else if (coins.getValue()>=300) {
                gc.drawImage(extraDistIcon, 625, 613);
                distanceText.setOpacity(fade.getValue());
                gc.drawImage(coinIcon, 627, 663);
            }
            else {
                gc.drawImage(extraDistIcon_C_A, 625, 613);
                gc.drawImage(coinTransP, 627, 663);
            }

            if(twoAmmo.getValue() == true) {
                gc.drawImage(twoAmmoIcon_used, 562, 612);
            }
            else if (coins.getValue()>=400) {
                gc.drawImage(twoAmmoIcon, 562, 612);
                twoAmmoText.setOpacity(fade.getValue());
                gc.drawImage(coinIcon, 560, 663);
            }
            else {
                gc.drawImage(twoAmmoIcon_C_A, 562, 612);
                gc.drawImage(coinTransP, 561, 663);
            }

            //Coin icon on the left
            gc.drawImage(coinIconTop, 220, 644);

            // The aiming line
            Line line = new Line(character.getX()+30, 380, character.getX()+30+offsetX.getValue(), 380+offsetY.getValue());
            line.setStrokeWidth(28);
            line.setOpacity(0.15);

            root.getChildren().clear();
            root.getChildren().add(canvas);
            root.getChildren().add(scoreText);
            root.getChildren().add(coinsText);
            root.getChildren().add(stormDist);
            root.getChildren().add(ddzDist);
            if (showLine.getValue() == true) {
                if (lostCgoing.getValue()==false && !(survivors.getValue()>=8)) {
                    if (!(mDownX.getValue()==currentX.getValue() && mDownY.getValue()==currentY.getValue())) {
                        root.getChildren().add(line);
                    }
               }
            }
            
            if(lostC.getValue() == 0 && topBar.getValue() < 0) {
                root.getChildren().add(contin);
                if (moreSee.getValue() == true) {
                    continOpac.changeValue(.02);
                    if (continOpac.getValue() >= 1) {
                        moreSee.setBoolean(false);
                    }
                }
                else {
                    continOpac.changeValue(-.02);
                    if (continOpac.getValue() <= 0) {
                        moreSee.setBoolean(true);
                    } 
                }
            }

            if(survivorsDone.getValue()==true) {
                contin.setFill(Color.rgb(224,224,224));
                contin.setX(432);
                root.getChildren().add(contin);
                if (moreSee.getValue() == true) {
                    continOpac.changeValue(.02);
                    if (continOpac.getValue() >= 1) {
                        moreSee.setBoolean(false);
                    }
                }
                else {
                    continOpac.changeValue(-.02);
                    if (continOpac.getValue() <= 0) {
                        moreSee.setBoolean(true);
                    } 
                }
            }

            if(spread.getValue() <= 0) { //If not currently using spread
                if (coins.getValue() >= 700) { // If can afford
                    gc.drawImage(coinIcon, 325, 662);
                }
                else {
                    gc.drawImage(coinTransP, 325, 662);
                }
                root.getChildren().add(spreadText);
            }
            else {
                gc.drawImage(bar_behind, 308, 666);
                PixelReader reader = bar.getPixelReader();
                if(spread.getValue()>0) {
                    int len = (int)(((double)(spread.getValue()))/400.0*71.0);
                    WritableImage newImage = new WritableImage(reader, 0, 0, len+1, 15);
                    gc.drawImage(newImage, 308, 667);
                }
            }

            if(bomb.getValue() <= 0) { //If bomb is not being used
                if (coins.getValue() >= 700) { // If can afford
                    gc.drawImage(coinIcon, 404, 662);
                }
                else {
                    gc.drawImage(coinTransP, 404, 662);
                }
                root.getChildren().add(bombText);
            }
            else {
                if(bomb.getValue()>0) {
                    root.getChildren().add(inUseText);
                }
            }

            if(speedCountdown.getValue() <= 0) { //If not currently using speed
                if (coins.getValue() >= 500) { // If can afford
                    gc.drawImage(coinIcon, 482, 663);
                }
                else {
                    gc.drawImage(coinTransP, 482, 663);
                }
                root.getChildren().add(speedText);
            }
            else {
                gc.drawImage(bar_behind,468,667);
                PixelReader reader = bar.getPixelReader();
                int length = (int)(((double)(speedCountdown.getValue()))/320.0*71.0);
                WritableImage newImage = new WritableImage(reader, 0, 0, length+1, 15);
                gc.drawImage(newImage, 468, 667);
            }

            if(moreDist.getValue() == false) { //If haven't bought moreDist
                root.getChildren().add(distanceText);
            }
            else {
                root.getChildren().add(equipped);
            }

            if(twoAmmo.getValue() == false) { //If haven't bought twoAmmo
                root.getChildren().add(twoAmmoText);
            }
            else {
                root.getChildren().add(equipped_twoAmmo);
            }

            // Displaying how many survivors are left
            root.getChildren().add(survCount);
            root.getChildren().add(survivorsWord);
            
            // Makes the smoke dissipate:

            params.setFill(Color.TRANSPARENT);
            Image opacityDark = im.snapshot(params, null);
            gc.drawImage(opacityDark, 0, 0);
            
            if (blackDone.getValue() == true) {
                gc.drawImage(imgMissionF, 0, 0);
            }
            
            if (lostC.getValue() >= 0) {
                gc.drawImage(staticScr, 0, 0);
            }
            
            gc.drawImage(tBar, topBar.getValue(), 0);
            gc.drawImage(bBar, bottomBar.getValue(), 350);
            
        };
        
        // Create an animation
        Timeline animation = new Timeline( 
        new KeyFrame(Duration.millis(32), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE); 
        animation.play(); // Start animation
        
        root.setOnMouseClicked(e -> { 
            if (lostCgoing.getValue()==true || survivorsDone.getValue()==true) {
                animation.stop();
                root.getChildren().clear();
                scoreScreen(primaryStage, score.getValue(), fin_distance.getValue(), fin_coin.getValue(), kills.getValue());
            }
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(root, 1000, 700);
        primaryStage.setTitle("Dronevasion"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        
        root.requestFocus();
    }
    
    




    public void scoreScreen(Stage primaryStage, double time, int distance, int coins, int killed) {
        Random rand = new Random();
        Group root = new Group();
        Canvas canvas = new Canvas(1000, 700);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Integ timeX = new Integ(380);
        final String urlTable = "https://testing-2c6e.restdb.io/rest/test";
        final String apiKey = "b5429a94ccb93bd952bbe91cb57f1e4373a0f";
        
        // Get an existing row
        HttpResponse<JsonNode> queryResponse = Unirest.get(urlTable)
            .header("x-apikey", apiKey)
            .header("cache-control", "no-cache")
            .queryString("q","{\"username\": \"" + signedIn + "\"}")
            .asJson();
        JSONArray rows = queryResponse.getBody().getArray();
        int numRows = rows.length();
        String id = null;
        if (numRows > 0) {
            JSONObject row = rows.getJSONObject(0);
            id = row.getString("_id");
        }

        // Update the player's dollars
        if (id != null)
        {
            HttpResponse addResponse = Unirest.post(urlTable)
            .header("content-type", "application/json")
            .header("x-apikey", apiKey)
            .header("cache-control", "no-cache")
            .body("{\"_id\":\"" + id + "\",\"username\":\""+getUser()+"\",\"dollars\":\"" + (getDollars()+(int)time+"").toString() + "\"}")
            .asJson();
            
            setDollars(getDollars()+(int)time);
        }

        Doub firstOpac = new Doub();
        Doub scrValFade = new Doub();
        Doub secondOpac = new Doub();
        Doub thirdOpac = new Doub();
        Doub fourthOpac = new Doub();

        //Image backGr = new Image("file:D:/Programming/DroneAttack/images/scoreBackground.jpg");
        Image hangar = new Image("file:D:/Programming/DroneAttack/images/hangar_final.jpg");
        Image goAgain = new Image("file:D:/Programming/DroneAttack/images/play_again_button.png");
        Image home = new Image("file:D:/Programming/DroneAttack/images/home_button.png");
        Image blackBG = new Image("file:D:/Programming/DroneAttack/images/score_screen_background_fade.png");
        Image separator = new Image("file:D:/Programming/DroneAttack/images/separator.png");
        
        ImageView ivGoAgain = new ImageView(goAgain);
        ImageView ivHome = new ImageView(home);

        EventHandler<ActionEvent> eventHandler = e -> {

            Text score = new Text(439, 150, "SCORE:");
            score.setFont(Font.font("Agency FB", 54));
            score.setFill(Color.WHITE);
            score.setOpacity(firstOpac.getValue());

            Text goAgainText = new Text(420, 480, "GO AGAIN!");
            goAgainText.setFont(Font.font("Agency FB", 48));
            goAgainText.setFill(Color.WHITE);
            goAgainText.setOpacity(firstOpac.getValue());

            Text homeText = new Text(464, 568, "Home");
            homeText.setFont(Font.font("Agency FB", 38));
            homeText.setFill(Color.WHITE);
            homeText.setOpacity(firstOpac.getValue());

            Text kills;
            if (killed == 1) {
                kills = new Text(539, 295, "1 enemy killed");
            }
            else {
                kills = new Text(539, 295, Integer.toString(killed)+" enemies killed");
            }
            kills.setFont(Font.font(27));
            kills.setFill(Color.WHITE);
            kills.setOpacity(thirdOpac.getValue());

            Text dollarsText = new Text();
            if (!signedIn.equals("none")) { // If they're signed in
                dollarsText = new Text(539,255,"$"+(int)time+" earned");
            }
            else {
                dollarsText = new Text(539,255,"$"+(int)time+" (login to save $)");
            }
            dollarsText.setFont(Font.font(27));
            dollarsText.setFill(Color.WHITE);
            dollarsText.setOpacity(firstOpac.getValue());
            
            Text tCoins = new Text();
            if (coins>1000) { // If coins is in the thousands, add a comma
                tCoins = new Text(539,335,Integer.toString(coins/1000)+","+(Integer.toString(coins)).substring(String.valueOf(coins).length()-3)+" total coins");
            }
            else {
                tCoins = new Text(539,335,Integer.toString(coins)+" total coins");
            }
            tCoins.setFont(Font.font(27));
            tCoins.setFill(Color.WHITE);
            tCoins.setOpacity(fourthOpac.getValue());

            Text scrVal;
            if (time%60 < 10) {
                scrVal = new Text(timeX.getValue(), 340, Integer.toString((int)((int)time/60)) + ":0" + Integer.toString((int)time%60));
            }
            else {
                scrVal = new Text(timeX.getValue(), 340, Integer.toString((int)((int)time/60)) + ":" + Integer.toString((int)time%60));
            }
            scrVal.setFont(Font.font("Agency FB", FontWeight.BOLD, 156));
            scrVal.setFill(Color.WHITE);
            scrVal.setOpacity(scrValFade.getValue());
            scrValFade.changeValue(.03);
            if (timeX.getValue() > 228) {
                timeX.changeValue(-18);
            }
            
            gc.drawImage(hangar, 0, 0);
            gc.drawImage(blackBG, 100, 70);
            gc.drawImage(separator, 0, 0);
            root.getChildren().clear();
            root.getChildren().add(canvas);
            root.getChildren().add(score);
            root.getChildren().add(scrVal);
            root.getChildren().add(dollarsText);
            root.getChildren().add(kills);
            root.getChildren().add(tCoins);
            root.getChildren().add(goAgainText);
            root.getChildren().add(homeText);

            if (firstOpac.getValue() <= 1.00) {
                firstOpac.changeValue(.04);
            }
            if (scrValFade.getValue()>.5 && secondOpac.getValue()<=1.0) {
                secondOpac.changeValue(.07);
            }
            if (secondOpac.getValue()>.5 && thirdOpac.getValue()<=1.0) {
                thirdOpac.changeValue(.07);
            }
            if (thirdOpac.getValue()>.5 && fourthOpac.getValue()<=1.0) {
                fourthOpac.changeValue(.07);
            }

            // Make the GoAgain button fade in
            ivGoAgain.setOpacity(firstOpac.getValue());
            SnapshotParameters params = new SnapshotParameters();
            params.setFill(Color.TRANSPARENT);
            Image imgGoAgain = ivGoAgain.snapshot(params, null);
            gc.drawImage(imgGoAgain, 336, 397);

            // Make the Home button fade in
            ivHome.setOpacity(secondOpac.getValue());
            params.setFill(Color.TRANSPARENT);
            Image imgHome = ivHome.snapshot(params, null);
            gc.drawImage(imgHome, 376, 515);
        };

        // Create an animation
        Timeline animation = new Timeline( 
        new KeyFrame(Duration.millis(32), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE); 
        animation.play(); // Start animation
        
        root.setOnMouseReleased(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                if (me.getX() > 342 && me.getX() < 650 && me.getY() > 415 && me.getY() < 507) {
                    animation.stop();
                    root.getChildren().clear();
                    actualGame(primaryStage);
                }
                else if (me.getX() > 382 && me.getX() < 609 && me.getY() > 520 && me.getY() < 588) {
                    animation.stop();
                    root.getChildren().clear();
                    start(primaryStage);
                }
            }
        });
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(root, 1000, 700);
        primaryStage.setTitle("Dronevasion"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        
        root.requestFocus();
    }
    
    
    /**
     * The starting screen AKA the home screen.
     * @param Stage primaryStage
     */
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {

        Group root = new Group();
        Canvas canvas = new Canvas(1000, 700);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        Image hangar = new Image("file:D:/Programming/DroneAttack/images/hangar_final.jpg");
        Image play = new Image("file:D:/Programming/DroneAttack/images/play_button.png");
        Image how_play = new Image("file:D:/Programming/DroneAttack/images/how_to_play_button.png");
        Image blackBlueDrone = new Image("file:D:/Programming/DroneAttack/images/title_screen_drone.png");
        Image blackOrDrone = new Image("file:D:/Programming/DroneAttack/images/blackOrangeDrone.png");
        Image grayRedDrone = new Image("file:D:/Programming/DroneAttack/images/grayRedDroneTitleScreen.png");
        Image whiteOrangeDrone = new Image("file:D:/Programming/DroneAttack/images/white_drone.png");
        Image lightGlare = new Image("file:D:/Programming/DroneAttack/images/white_glare.png");
        Image cornerBG = new Image("file:D:/Programming/DroneAttack/images/name_and_dollars.png");
        Image signout = new Image("file:D:/Programming/DroneAttack/images/signout.png");
        Image login = new Image("file:D:/Programming/DroneAttack/images/login_button.png");
        Image logo = new Image("file:D:/Programming/DroneAttack/images/logo.png");
        Image darkSpot = new Image("file:D:/Programming/DroneAttack/images/darkSpot.png");
        Image WONGames = new Image("file:D:/Programming/DroneAttack/images/WONGames.png");

        Text play_text = new Text(221, 309, "PLAY!");
        play_text.setFont(Font.font("Agency FB", 52));
        play_text.setFill(Color.WHITE);

        Text changeDrone = new Text(205, 413, "Change drone");
        changeDrone.setFont(Font.font("Agency FB", 32));
        changeDrone.setFill(Color.WHITE);

        Text how_text = new Text(223, 470, "How to play");
        how_text.setFont(Font.font("Arial", 20));
        how_text.setUnderline(true);
        how_text.setFill(Color.WHITE);

        // Variables:
        final String urlTable = "https://testing-2c6e.restdb.io/rest/test";
        final String apiKey = "b5429a94ccb93bd952bbe91cb57f1e4373a0f";
        String id = "61db2b65f701f4600003ee88";
        String name = "NA";
        Integ dollars = new Integ(-1);
        Doub y = new Doub();
        MyBoolean goingDown = new MyBoolean(true);

        // Get an existing row
        HttpResponse<JsonNode> queryResponse = Unirest.get(urlTable)
            .header("x-apikey", apiKey)
            .header("cache-control", "no-cache")
            .queryString("q","{\"username\": \"" + signedIn + "\"}")
            .asJson();
        JSONArray rows = queryResponse.getBody().getArray();
        int numRows = rows.length();
        if (numRows > 0) {
            JSONObject row = rows.getJSONObject(0);
            dollars.setValue(row.getInt("dollars"));
        }
        System.out.println(name);

        Text name_text = new Text(855, 38, signedIn);
        name_text.setFont(Font.font("Agency FB", 24));
        name_text.setFill(Color.WHITE);

        Text dol_text = new Text(797, 33, "$"+dollars.getValue());
        dol_text.setFont(Font.font("Arial", FontWeight.BOLD, 13));
        dol_text.setFill(Color.rgb(63, 191, 76));

        EventHandler<ActionEvent> eventHandler = e -> {
            
            // Make drone move up and down
            if (goingDown.getValue() == true) {
                y.changeValue(.16);
            }
            else if (goingDown.getValue() == false) {
                y.changeValue(-.16);
            }
            if (y.getValue() > 40) {
                goingDown.setBoolean(false);
            }
            else if (y.getValue() < -40) {
                goingDown.setBoolean(true);
            }
            
            gc.drawImage(hangar, 0, 0);
            gc.drawImage(darkSpot, 0, 0);
            gc.drawImage(play, 0, 15);
            gc.drawImage(how_play, 0, 0);
            if (!signedIn.equals("none")) { // If they are signed in
                gc.drawImage(cornerBG, 0, 0);
                gc.drawImage(signout, 0, 0);
            }
            else {
                gc.drawImage(login, 0, 0);
            }

            // Drawing the drone:
            if (getDroneNum() == 0) {
                gc.drawImage(lightGlare, 0, 0);
                gc.drawImage(blackBlueDrone, 0, y.getValue());
            }
            else if (getDroneNum() == 1) {
                gc.drawImage(blackOrDrone, 0, y.getValue());
            }
            else if (getDroneNum() == 2) {
                gc.drawImage(grayRedDrone, 0, y.getValue());
            }
            else if (getDroneNum() == 3) {
                gc.drawImage(whiteOrangeDrone, 0, y.getValue());
            }

            
            gc.drawImage(logo, 335, 33);
            gc.drawImage(WONGames, 838, 669);
            
            root.getChildren().clear();
            root.getChildren().add(canvas);
            root.getChildren().add(play_text);
            root.getChildren().add(changeDrone);
            root.getChildren().add(how_text);
            if (!signedIn.equals("none")) { // If they are signed in
                root.getChildren().add(name_text);
                root.getChildren().add(dol_text);
            }
            
        };
        
        // Create an animation
        Timeline animation = new Timeline( 
        new KeyFrame(Duration.millis(20), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play(); // Start animation
        

        root.setOnMouseReleased(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                if (me.getX()>117 && me.getX()<425 && me.getY()>240 && me.getY()<333) {
                    if (!signedIn.equals("none")) { // If they are signed in
                        animation.stop();
                        root.getChildren().clear();
                        actualGame(primaryStage);
                    }
                    else {
                        animation.stop();
                        root.getChildren().clear();
                        guest(primaryStage);
                    }
                }
                else if (me.getX()>218 && me.getX()<328 && me.getY()>455 && me.getY()<474) {
                    animation.stop();
                    root.getChildren().clear();
                    howToPlay(primaryStage);
                }
                else if (me.getX()>160 && me.getX()<387 && me.getY()>365 && me.getY()<433) {
                    animation.stop();
                    root.getChildren().clear();
                    changeDrone(primaryStage);
                }
                
                if (!signedIn.equals("none") && me.getX()>963 && me.getX()<988 && me.getY()>11 && me.getY()<43) { // If they click logout
                    changeUser("none");
                    setDollars(-1);
                    dronesOwned[1] = false;
                    dronesOwned[2] = false;
                    dronesOwned[3] = false;
                    setDrone(0);
                    animation.stop();
                    root.getChildren().clear();
                    start(primaryStage);
                }
                else if (signedIn.equals("none") && me.getX()>921 && me.getX()<986 && me.getY()>13 && me.getY()<43) {
                    animation.stop();
                    root.getChildren().clear();
                    login(primaryStage);
                }
            }
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(root, 1000, 700);
        primaryStage.setTitle("Dronevasion"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        
        root.requestFocus();
    }

    /**
     * The login page
     * @param Stage primaryStage
     */
    public void login(Stage primaryStage) {
        Group root = new Group();
        Canvas canvas = new Canvas(1000, 700);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        HBox hb = new HBox();

        // Variables:
        final String urlTable = "https://testing-2c6e.restdb.io/rest/test";
        final String apiKey = "b5429a94ccb93bd952bbe91cb57f1e4373a0f";
        MyBoolean showWrong = new MyBoolean(false);
        
        Image hangar = new Image("file:D:/Programming/DroneAttack/images/hangar_final.jpg");
        Image gray_fade = new Image("file:D:/Programming/DroneAttack/images/login_screen_background_fade.png");
        Image loginBtn = new Image("file:D:/Programming/DroneAttack/images/login.png");
        Image x = new Image("file:D:/Programming/DroneAttack/images/x.png");

        Text loginText = new Text(464, 208, "Login");
        loginText.setFont(Font.font("Agency FB", 52));
        loginText.setFill(Color.WHITE);

        Text signInText = new Text(470, 481, "SIGN IN");
        signInText.setFont(Font.font("Agency FB", 34));
        signInText.setFill(Color.WHITE);

        Text username = new Text(340, 246, "Username");
        username.setFont(Font.font("Arial", 16));
        username.setFill(Color.WHITE);

        Text password = new Text(340, 343, "Password");
        password.setFont(Font.font("Arial", 16));
        password.setFill(Color.WHITE);

        Text create = new Text(449, 530, "Create account");
        create.setFont(Font.font("Arial", 18));
        create.setUnderline(true);
        create.setFill(Color.WHITE);

        Text wrong = new Text(334, 432, "The username or password you entered is incorrect");
        wrong.setFont(Font.font(15));
        wrong.setFill(Color.rgb(214, 214, 214));

        // Text fields:

        TextField nameField = new TextField ();
        nameField.relocate(340, 252);
        nameField.setPrefWidth(330);
        nameField.setPrefHeight(26);
        nameField.setFont(Font.font("Agency FB", 32));

        PasswordField pwField = new PasswordField ();
        pwField.relocate(340, 348);
        pwField.setPrefWidth(330);
        pwField.setPrefHeight(26);
        pwField.setFont(Font.font("Agency FB", 32));
        
        EventHandler<ActionEvent> eventHandler = e -> {
            
            gc.drawImage(hangar, 0, 0);
            gc.drawImage(gray_fade, 100, 70);
            gc.drawImage(loginBtn, 405, 426);
            gc.drawImage(x, 690, 150);
            
            root.getChildren().clear();
            root.getChildren().add(canvas);
            root.getChildren().add(loginText);
            root.getChildren().add(nameField);
            root.getChildren().add(pwField);
            root.getChildren().add(signInText);
            root.getChildren().add(username);
            root.getChildren().add(password);
            root.getChildren().add(create);
            if (showWrong.getValue() == true) {
                root.getChildren().add(wrong);
            }
        };
        
        // Create an animation
        Timeline animation = new Timeline( 
        new KeyFrame(Duration.millis(20), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play(); // Start animation
        
        root.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                HttpResponse<JsonNode> queryResponse = Unirest.get(urlTable)
                .header("x-apikey", apiKey)
                .header("cache-control", "no-cache")
                .queryString("q","{\"username\":\"" + nameField.getText() + "\"}")
                .asJson();
                JSONArray rows = queryResponse.getBody().getArray();
                System.out.println(rows);
                int numRows = rows.length();
                System.out.println(numRows);
                String id = null;
                
                if (numRows > 0) {
                    JSONObject row = rows.getJSONObject(0);
                    if (row.getString("password").equals(pwField.getText())) { // If it's the right password
                        changeUser(nameField.getText());
                        setDollars(row.getInt("dollars"));
                        dronesOwned[0] = row.getBoolean("drone1");
                        dronesOwned[1] = row.getBoolean("drone2");
                        dronesOwned[2] = row.getBoolean("drone3");
                        dronesOwned[3] = row.getBoolean("drone4");
                        setDrone(row.getInt("droneNum"));
                        animation.stop();
                        root.getChildren().clear();
                        start(primaryStage);
                    }
                    else {
                        showWrong.setBoolean(true);
                    }
                }
                else { // if that's an invalid username
                    showWrong.setBoolean(true);
                }
            }
        });

        root.setOnMouseReleased(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                System.out.println("X: " + me.getX() + ", Y: " + me.getY());
                if (me.getX()>408 && me.getX()<612 && me.getY()>444 && me.getY()<503) {
                    HttpResponse<JsonNode> queryResponse = Unirest.get(urlTable)
                    .header("x-apikey", apiKey)
                    .header("cache-control", "no-cache")
                    .queryString("q","{\"username\":\"" + nameField.getText() + "\"}")
                    .asJson();
                    JSONArray rows = queryResponse.getBody().getArray();
                    System.out.println(rows);
                    int numRows = rows.length();
                    System.out.println(numRows);
                    String id = null;
                    
                    if (numRows > 0) {
                        JSONObject row = rows.getJSONObject(0);
                        if (row.getString("password").equals(pwField.getText())) { // If it's the right password
                            changeUser(nameField.getText());
                            setDollars(row.getInt("dollars"));
                            dronesOwned[0] = row.getBoolean("drone1");
                            dronesOwned[1] = row.getBoolean("drone2");
                            dronesOwned[2] = row.getBoolean("drone3");
                            dronesOwned[3] = row.getBoolean("drone4");
                            setDrone(row.getInt("droneNum"));
                            animation.stop();
                            root.getChildren().clear();
                            start(primaryStage);
                        }
                        else {
                            showWrong.setBoolean(true);
                        }
                    }
                    else { // if that's an invalid username
                        showWrong.setBoolean(true);
                    }
                }
                if (me.getX()>691 && me.getX()<727 && me.getY()>152 && me.getY()<185) {
                    animation.stop();
                    root.getChildren().clear();
                    start(primaryStage);
                }
                if (me.getX()>449 && me.getX()<571 && me.getY()>516 && me.getY()<533) { // if they click Create Account
                    animation.stop();
                    root.getChildren().clear();
                    createAcc(primaryStage);
                }
            }
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(root, 1000, 700);
        primaryStage.setTitle("Dronevasion"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        
        root.requestFocus();
    }

    public void createAcc(Stage primaryStage) {
        Group root = new Group();
        Canvas canvas = new Canvas(1000, 700);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        final String urlTable = "https://testing-2c6e.restdb.io/rest/test";
        final String apiKey = "b5429a94ccb93bd952bbe91cb57f1e4373a0f";
        MyBoolean showTooLong = new MyBoolean(false);
        MyBoolean showDontMatch = new MyBoolean(false);
        MyBoolean showTaken = new MyBoolean(false);

        Image hangar = new Image("file:D:/Programming/DroneAttack/images/hangar_final.jpg");
        Image background = new Image("file:D:/Programming/DroneAttack/images/createAccBG.png");
        Image button = new Image("file:D:/Programming/DroneAttack/images/login.png");
        Image x = new Image("file:D:/Programming/DroneAttack/images/x.png");

        Text createText = new Text(370, 170, "Create your account");
        createText.setFont(Font.font("Agency FB", 42));
        createText.setFill(Color.WHITE);

        Text buttonText = new Text(438, 552, "Create account");
        buttonText.setFont(Font.font("Agency FB", 28));
        buttonText.setFill(Color.WHITE);

        Text tooLongText = new Text(380, 500, "Please choose a shorter username");
        tooLongText.setFont(Font.font("Arial", 16));
        tooLongText.setFill(Color.WHITE);

        Text dontMatchText = new Text(407, 500, "Your passwords don't match");
        dontMatchText.setFont(Font.font("Arial", 16));
        dontMatchText.setFill(Color.WHITE);

        Text takenText = new Text(370, 500, "Sorry, that username is already taken");
        takenText.setFont(Font.font("Arial", 16));
        takenText.setFill(Color.WHITE);

        Text username = new Text(340, 216, "Username");
        username.setFont(Font.font("Arial", 16));
        username.setFill(Color.WHITE);

        Text pw = new Text(340, 312, "Password");
        pw.setFont(Font.font("Arial", 16));
        pw.setFill(Color.WHITE);

        Text reenter = new Text(340, 408, "Re-enter password");
        reenter.setFont(Font.font("Arial", 16));
        reenter.setFill(Color.WHITE);

        TextField nameField = new TextField ();
        nameField.relocate(340, 222);
        nameField.setPrefWidth(330);
        nameField.setPrefHeight(26);
        nameField.setFont(Font.font("Agency FB", 32));

        PasswordField pwField = new PasswordField ();
        pwField.relocate(340, 318);
        pwField.setPrefWidth(330);
        pwField.setPrefHeight(26);
        pwField.setFont(Font.font("Agency FB", 32));

        PasswordField reenterField = new PasswordField ();
        reenterField.relocate(340, 414);
        reenterField.setPrefWidth(330);
        reenterField.setPrefHeight(26);
        reenterField.setFont(Font.font("Agency FB", 32));

        EventHandler<ActionEvent> eventHandler = e -> {
            gc.drawImage(hangar, 0, 0);
            gc.drawImage(background, 0, 0);
            gc.drawImage(button, 400, 500);
            gc.drawImage(x, 690, 110);
            root.getChildren().clear();
            root.getChildren().add(canvas);
            root.getChildren().add(nameField);
            root.getChildren().add(pwField);
            root.getChildren().add(reenterField);
            root.getChildren().add(buttonText);
            root.getChildren().add(createText);
            root.getChildren().add(username);
            root.getChildren().add(pw);
            root.getChildren().add(reenter);
            if (showTooLong.getValue() == true) {
                root.getChildren().add(tooLongText);
            }
            else if (showDontMatch.getValue() == true) {
                root.getChildren().add(dontMatchText);
            }
            else if (showTaken.getValue() == true) {
                root.getChildren().add(takenText);
            }
        };

        // Create an animation
        Timeline animation = new Timeline( 
        new KeyFrame(Duration.millis(20), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play(); // Start animation

        root.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                showTooLong.setBoolean(false);
                showDontMatch.setBoolean(false);
                showTaken.setBoolean(false);
                if (nameField.getText().length() > 11) { // If the name is too long
                    showTooLong.setBoolean(true);
                }
                else if (!(pwField.getText().equals(reenterField.getText()))) { // If the passwords don't match
                    showDontMatch.setBoolean(true);
                }
                else if (!nameField.getText().equals("none") && !nameField.getText().equals("") && !pwField.getText().equals("") && !reenter.getText().equals("")) { // If everything is good
                    HttpResponse<JsonNode> queryResponse = Unirest.get(urlTable)
                        .header("x-apikey", apiKey)
                        .header("cache-control", "no-cache")
                        .queryString("q","{\"username\":\"" + nameField.getText() + "\"}")
                        .asJson();
                    JSONArray rows = queryResponse.getBody().getArray();
                    if (rows.length() == 0) { // If that username is not taken already
                        HttpResponse addResponse = Unirest.post(urlTable)
                            .header("content-type", "application/json")
                            .header("x-apikey", apiKey)
                            .header("cache-control", "no-cache")
                            .body("{\"username\":\"" + nameField.getText() + "\",\"dollars\":\"0\",\"password\":\""+pwField.getText()+"\",\"drone1\":\"true\",\"drone2\":\"false\",\"drone3\":\"false\",\"drone4\":\"false\",\"droneNum\":\"0\"}")
                            .asString();
                        changeUser(nameField.getText());
                        setDollars(0);
                        dronesOwned = new boolean[]{true, false, false, false};
                        setDrone(0);
                        animation.stop();
                        root.getChildren().clear();
                        start(primaryStage);
                    }
                    else {
                        showTaken.setBoolean(true);
                    }
                }
            }
        });
        root.setOnMouseReleased(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                if (me.getX()>405 && me.getX()<607 && me.getY()>512 && me.getY()<573) { // if they press Create Account
                    showTooLong.setBoolean(false);
                    showDontMatch.setBoolean(false);
                    showTaken.setBoolean(false);
                    if (nameField.getText().length() > 11) { // If the name is too long
                        showTooLong.setBoolean(true);
                    }
                    else if (!(pwField.getText().equals(reenterField.getText()))) { // If the passwords don't match
                        showDontMatch.setBoolean(true);
                    }
                    else if (!nameField.getText().equals("none") && !nameField.getText().equals("") && !pwField.getText().equals("") && !reenter.getText().equals("")) { // If everything is good
                        HttpResponse<JsonNode> queryResponse = Unirest.get(urlTable)
                            .header("x-apikey", apiKey)
                            .header("cache-control", "no-cache")
                            .queryString("q","{\"username\":\"" + nameField.getText() + "\"}")
                            .asJson();
                        JSONArray rows = queryResponse.getBody().getArray();
                        if (rows.length() == 0) { // If that username is not taken already
                            HttpResponse addResponse = Unirest.post(urlTable)
                                .header("content-type", "application/json")
                                .header("x-apikey", apiKey)
                                .header("cache-control", "no-cache")
                                .body("{\"username\":\"" + nameField.getText() + "\",\"dollars\":\"0\",\"password\":\""+pwField.getText()+"\",\"drone1\":\"true\",\"drone2\":\"false\",\"drone3\":\"false\",\"drone4\":\"false\",\"droneNum\":\"0\"}")
                                .asString();
                            changeUser(nameField.getText());
                            setDollars(0);
                            dronesOwned = new boolean[]{true, false, false, false};
                            setDrone(0);
                            animation.stop();
                            root.getChildren().clear();
                            start(primaryStage);
                        }
                        else {
                            showTaken.setBoolean(true);
                        }
                    }
                }
                else if (me.getX()>692 && me.getX()<726 && me.getY()>111 && me.getY()<146) { // If they click X
                    animation.stop();
                    root.getChildren().clear();
                    login(primaryStage);
                }
            }
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(root, 1000, 700);
        primaryStage.setTitle("Dronevasion"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        
        root.requestFocus();
    }

    public void guest(Stage primaryStage) {
        Group root = new Group();
        Canvas canvas = new Canvas(1000, 700);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Image guestWarning = new Image("file:D:/Programming/DroneAttack/images/guestWarning.jpg");

        EventHandler<ActionEvent> eventHandler = e -> {
            gc.drawImage(guestWarning, 0, 0);
            root.getChildren().clear();
            root.getChildren().add(canvas);
        };

        // Create an animation
        Timeline animation = new Timeline( 
        new KeyFrame(Duration.millis(20), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play(); // Start animation

        root.setOnMouseReleased(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                if (me.getX()>385 && me.getX()<615 && me.getY()>327 && me.getY()<396) { // if they press Sign In
                    animation.stop();
                    root.getChildren().clear();
                    login(primaryStage);
                }
                else if (me.getX()>385 && me.getX()<615 && me.getY()>411 && me.getY()<480) { // if they press Play As Guest
                    animation.stop();
                    root.getChildren().clear();
                    actualGame(primaryStage);
                }
            }
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(root, 1000, 700);
        primaryStage.setTitle("Dronevasion"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        
        root.requestFocus();
    }


    public void changeDrone(Stage primaryStage) {
        Group root = new Group();
        Canvas canvas = new Canvas(1000, 700);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        final String urlTable = "https://testing-2c6e.restdb.io/rest/test";
        final String apiKey = "b5429a94ccb93bd952bbe91cb57f1e4373a0f";
        MyBoolean showPurch = new MyBoolean(false);

        Image shop = new Image("file:D:/Programming/DroneAttack/images/shop.jpg");
        Image buy = new Image("file:D:/Programming/DroneAttack/images/buy.png");
        Image buy_CA = new Image("file:D:/Programming/DroneAttack/images/buy_CA.png");
        Image use = new Image("file:D:/Programming/DroneAttack/images/use.png");
        Image equipped = new Image("file:D:/Programming/DroneAttack/images/equipped.png");
        
        Text loginToSave = new Text(353, 541, "Login to save the $ you earn from games");
        loginToSave.setFont(Font.font("Arial", 16));
        loginToSave.setFill(Color.WHITE);

        Text purchased = new Text(453, 545, "PURCHASED!");
        purchased.setFont(Font.font("Agency FB", FontPosture.ITALIC, 24));
        purchased.setFill(Color.WHITE);

        EventHandler<ActionEvent> eventHandler = e -> {
            gc.drawImage(shop, 0, 0);

            Text dollarsText;
            if (userDollars == -1) {
                dollarsText = new Text(125, 200, "$0");
            }
            else {
                dollarsText = new Text(125, 200, "$"+userDollars);
            }
            dollarsText.setFont(Font.font("Agency FB", 20));
            dollarsText.setFill(Color.web("3FBF4C"));
            
            // Display each of the Buy buttons:

            if (getDroneNum() == 0) {
                gc.drawImage(equipped, 97, 402);
            }
            else {
                gc.drawImage(use, 97, 402);
            }

            if (getDroneNum() == 1) {
                gc.drawImage(equipped, 308, 402);
            }
            else if (dronesOwned[1] == true) {
                gc.drawImage(use, 308, 402);
            }
            else if (getDollars() >= 150) {
                gc.drawImage(buy, 308, 402);
            }
            else { 
                gc.drawImage(buy_CA, 308, 402);
            }

            if (getDroneNum() == 2) {
                gc.drawImage(equipped, 517, 402);
            }
            else if (dronesOwned[2] == true) {
                gc.drawImage(use, 517, 402);
            }
            else if (getDollars() >= 450) {
                gc.drawImage(buy, 517, 402);
            }
            else { 
                gc.drawImage(buy_CA, 517, 402);
            }

            if (getDroneNum() == 3) {
                gc.drawImage(equipped, 724, 402);
            }
            else if (dronesOwned[3] == true) {
                gc.drawImage(use, 724, 402);
            }
            else if (getDollars() >= 1500) {
                gc.drawImage(buy, 724, 402);
            }
            else { 
                gc.drawImage(buy_CA, 724, 402);
            }


            root.getChildren().clear();
            root.getChildren().add(canvas);
            if (signedIn.equals("none")) { // if they're not signed in
                root.getChildren().add(loginToSave);
            }
            root.getChildren().add(dollarsText);
            if (showPurch.getValue() == true) {
                root.getChildren().add(purchased);
            }
            
        };

        // Create an animation
        Timeline animation = new Timeline( 
        new KeyFrame(Duration.millis(20), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play(); // Start animation

        root.setOnMouseReleased(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                System.out.println("X: " + me.getX() + ", Y: " + me.getY());

                if (me.getX()>888 && me.getX()<930 && me.getY()>148 && me.getY()<187) { // if they click X
                    animation.stop();
                    root.getChildren().clear();
                    start(primaryStage);
                }

                HttpResponse<JsonNode> queryResponse = Unirest.get(urlTable)
                    .header("x-apikey", apiKey)
                    .header("cache-control", "no-cache")
                    .queryString("q","{\"username\": \"" + signedIn + "\"}")
                    .asJson();
                JSONArray rows = queryResponse.getBody().getArray();
                int numRows = rows.length();
                String id = null;
                if (numRows > 0) {
                    JSONObject row = rows.getJSONObject(0);
                    id = row.getString("_id");
                }

                if (me.getX()>120 && me.getX()<252 && me.getY()>425 && me.getY()<472) { // if they click drone 0
                    droneNum = 0;
                    if (id != null)
                    {
                        HttpResponse addResponse = Unirest.post(urlTable)
                        .header("content-type", "application/json")
                        .header("x-apikey", apiKey)
                        .header("cache-control", "no-cache")
                        .body("{\"_id\":\"" + id + "\",\"username\":\""+getUser()+"\",\"droneNum\":\"" + droneNum + "\"}")
                        .asJson();
                    }
                }

                if (me.getX()>331 && me.getX()<462 && me.getY()>425 && me.getY()<472) { // if they click Buy drone 1
                    if (dronesOwned[1] == true) {
                        droneNum = 1;
                        if (id != null)
                        {
                            HttpResponse addResponse = Unirest.post(urlTable)
                            .header("content-type", "application/json")
                            .header("x-apikey", apiKey)
                            .header("cache-control", "no-cache")
                            .body("{\"_id\":\"" + id + "\",\"username\":\""+getUser()+"\",\"droneNum\":\"" + droneNum + "\"}")
                            .asJson();
                        }
                    }
                    else if (getDollars() >= 150) {
                        userDollars -= 150;
                        dronesOwned[1] = true;
                        showPurch.setBoolean(true);
                        if (id != null)
                        {
                            HttpResponse addResponse = Unirest.post(urlTable)
                            .header("content-type", "application/json")
                            .header("x-apikey", apiKey)
                            .header("cache-control", "no-cache")
                            .body("{\"_id\":\"" + id + "\",\"username\":\""+getUser()+"\",\"dollars\":\"" + userDollars + "\",\"drone2\":\"" + true + "\"}")
                            .asJson();
                        }
                    }
                }
                if (me.getX()>540 && me.getX()<672 && me.getY()>425 && me.getY()<472) { // if they click Buy drone 2
                    if (dronesOwned[2] == true) {
                        droneNum = 2;
                        if (id != null)
                        {
                            HttpResponse addResponse = Unirest.post(urlTable)
                            .header("content-type", "application/json")
                            .header("x-apikey", apiKey)
                            .header("cache-control", "no-cache")
                            .body("{\"_id\":\"" + id + "\",\"username\":\""+getUser()+"\",\"droneNum\":\"" + droneNum + "\"}")
                            .asJson();
                        }
                    }
                    else if (getDollars() >= 450) {
                        userDollars -= 450;
                        dronesOwned[2] = true;
                        showPurch.setBoolean(true);
                        if (id != null)
                        {
                            HttpResponse addResponse = Unirest.post(urlTable)
                            .header("content-type", "application/json")
                            .header("x-apikey", apiKey)
                            .header("cache-control", "no-cache")
                            .body("{\"_id\":\"" + id + "\",\"username\":\""+getUser()+"\",\"dollars\":\"" + userDollars + "\",\"drone3\":\"" + true + "\"}")
                            .asJson();
                        }
                    }
                }
                if (me.getX()>747 && me.getX()<880 && me.getY()>425 && me.getY()<472) { // if they click Buy drone 3
                    if (dronesOwned[3] == true) {
                        droneNum = 3;
                        if (id != null)
                        {
                            HttpResponse addResponse = Unirest.post(urlTable)
                            .header("content-type", "application/json")
                            .header("x-apikey", apiKey)
                            .header("cache-control", "no-cache")
                            .body("{\"_id\":\"" + id + "\",\"username\":\""+getUser()+"\",\"droneNum\":\"" + droneNum + "\"}")
                            .asJson();
                        }
                    }
                    else if (getDollars() >= 1500) {
                        userDollars -= 1500;
                        dronesOwned[3] = true;
                        showPurch.setBoolean(true);
                        if (id != null)
                        {
                            HttpResponse addResponse = Unirest.post(urlTable)
                            .header("content-type", "application/json")
                            .header("x-apikey", apiKey)
                            .header("cache-control", "no-cache")
                            .body("{\"_id\":\"" + id + "\",\"username\":\""+getUser()+"\",\"dollars\":\"" + userDollars + "\",\"drone4\":\"" + true + "\"}")
                            .asJson();
                        }
                    }
                }
            }
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(root, 1000, 700);
        primaryStage.setTitle("Dronevasion"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        
        root.requestFocus();
    }


    public void howToPlay(Stage primaryStage) {
        Group root = new Group();
        Canvas canvas = new Canvas(1000, 700);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Image howToPlay = new Image("file:D:/Programming/DroneAttack/images/howToPlay.jpg");

        EventHandler<ActionEvent> eventHandler = e -> {
            gc.drawImage(howToPlay, 0, 0);
            root.getChildren().clear();
            root.getChildren().add(canvas);
        };

        // Create an animation
        Timeline animation = new Timeline( 
        new KeyFrame(Duration.millis(20), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play(); // Start animation

        root.setOnMouseReleased(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                if (me.getX()>848 && me.getX()<879 && me.getY()>109 && me.getY()<136) { // if they click X
                    animation.stop();
                    root.getChildren().clear();
                    start(primaryStage);
                }
            }
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(root, 1000, 700);
        primaryStage.setTitle("Dronevasion"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        
        root.requestFocus();
    }
}