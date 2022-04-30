package com.bear.boot.code.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-04-29 09:32
 **/
@Component
@Slf4j
public class MathCodeUtil {
    private final Random random = new Random();

    private int value = -1;

    private String randCode() {
        int one = random.nextInt(100);
        int two = random.nextInt(100) + 1;
        String str = "+-*/";
        char op = str.charAt(random.nextInt(str.length()));
        switch (op) {
            case '+' -> value = one + two;
            case '-' -> value = one - two;
            case '*' -> value = one * two;
            case '/' -> value = one / two;
            default -> value = 0;
        }
        return "" + one + op + two + " = ?";
    }

    private Color randColor() {
        int r = random.nextInt(256);
        int b = random.nextInt(256);
        int g = random.nextInt(256);
        return new Color(r, g, b);
    }

    public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int height = 30;
        int width = 140;
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics2D pen = img.createGraphics();

        String code = randCode();
        request.getSession().setAttribute("mathCode",value);
        log.info(String.valueOf(value));

        pen.fillRect(0,0,width,height);

        int fontSize = 18;
        pen.setFont(new Font("微雅软黑",Font.BOLD,fontSize + random.nextInt(5)));

        for (int i = 0; i < code.length(); i++) {
            pen.setColor(randColor());

            pen.drawString(code.charAt(i) + "", 5 + i * fontSize, (fontSize + height) / 2 + random.nextInt(5));
        }

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(img, "png", out);
        out.flush();
        out.close();
    }
}
