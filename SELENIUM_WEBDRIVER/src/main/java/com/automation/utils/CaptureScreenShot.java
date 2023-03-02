package com.automation.utils;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class CaptureScreenShot {
    private static String imgPath = "/Screenshots";
    public static void takePictureFailTc(String imgName) {
        try {
            File f = new File(imgPath);
            if (!f.exists()) {
                f.mkdir();
            }

            BufferedImage img = (new Robot()).createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));

            imgPath = "Screenshots/" + imgName + ".jpg";
            File iName = new File(imgPath);
            ImageIO.write(img, "jpg", iName);
        } catch (Exception var6) {
            System.out.println("Capture error");
        }
    }

    public static void attachScreenShot(){
        try{
            System.setProperty("org.uncommons.reportng.escape-output", "false");

            File f = new File(imgPath);
            Reporter.log("<br> <a title = \"Screen Shot\" href = \"" + f.getAbsolutePath() +
                    "\">");
            Reporter.log("<img alt ='" + f.getName() +"' src = '" + f.getAbsolutePath() +
                    "' height ='240 width ='418' /><br>");
        }catch (Exception e){
            System.out.println("Can't make a report");
        }
    }
}
