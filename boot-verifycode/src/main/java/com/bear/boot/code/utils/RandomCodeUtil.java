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
public class RandomCodeUtil {
    private final Random random = new Random();

    public String randCode(int len) {
        if (len < 4) {
            len = 4;
        }

        StringBuilder code = new StringBuilder();
        for (int i = 0; i < len; i++) {
            String str = "0123456789abcdefABCDEF";
            code.append(str.charAt(random.nextInt(str.length())));
        }
        return code.toString();
    }

    public Color randColor() {
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return new Color(r, g, b);
    }

    public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException{
        int height = 48;
        int width = 100;
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics2D pen = img.createGraphics();

        String code = randCode(4);
        log.info(code);
        request.getSession().setAttribute("randomCode",code);

        pen.fillRect(0,0,width,height);

        int fontSize = 14;
        pen.setFont(new Font("微雅软黑",Font.BOLD,fontSize + random.nextInt(5)));

        for (int i = 0; i < code.length(); i++) {
            pen.setColor(randColor());

            pen.drawString(code.charAt(i) + "", 20 + i * fontSize, (fontSize + height) / 2 + random.nextInt(5));
        }

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(img, "png", out);
        out.flush();
        out.close();
    }
}
