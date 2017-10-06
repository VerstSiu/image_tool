/*
 *
 *  Copyright(c) 2017 VerstSiu
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package lib.ijoic.image_tool.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import lib.ijoic.image_tool.annotation.NonNull;

/**
 * Image utils.
 *
 * @author VerstSiu verstsiu@126.com
 * @date 2017/10/6 10:18
 * @version 1.0
 */
public class ImageUtils {

  /**
   * Scale image.
   *
   * @param src source file.
   * @param dst dst file.
   * @param width width.
   * @param height height.
   * @param fillWhite fill white.
   */
  public static void scale(@NonNull String src, @NonNull String dst, int width, int height, boolean fillWhite) {
    try {
      double ratio; // 缩放比例
      BufferedImage bufferedImage = ImageIO.read(new File(src));
      Image imageTemp = bufferedImage.getScaledInstance(width, height, BufferedImage.SCALE_SMOOTH);

      // 计算比例
      if ((bufferedImage.getHeight() > height) || (bufferedImage.getWidth() > width)) {
        if (bufferedImage.getHeight() > bufferedImage.getWidth()) {
          ratio = (double) height / bufferedImage.getHeight();
        } else {
          ratio = (double) width / bufferedImage.getWidth();
        }
        AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(ratio, ratio), null);
        imageTemp = op.filter(bufferedImage, null);
      }

      if (fillWhite) {//补白
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();

        graphics.setColor(Color.white);
        graphics.fillRect(0, 0, width, height);

        if (width == imageTemp.getWidth(null)) {
          graphics.drawImage(
              imageTemp,
              0,
              (height - imageTemp.getHeight(null)) / 2,
              imageTemp.getWidth(null),
              imageTemp.getHeight(null),
              Color.white,
              null
          );

        } else {
          graphics.drawImage(
              imageTemp,
              (width - imageTemp.getWidth(null)) / 2,
              0,
              imageTemp.getWidth(null),
              imageTemp.getHeight(null),
              Color.white,
              null
          );
        }
        graphics.dispose();
        imageTemp = image;
      }

      if (!RenderedImage.class.isInstance(imageTemp)) {
        imageTemp = convertToBufferedImage(imageTemp);
      }
      ImageIO.write((RenderedImage) imageTemp, "PNG", new File(dst));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @NonNull
  private static BufferedImage convertToBufferedImage(@NonNull Image image) {
    BufferedImage newImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);

    Graphics2D g = newImage.createGraphics();
    g.drawImage(image, 0, 0, null);
    g.dispose();

    return newImage;
  }

  /**
   * Fill color with image.
   *
   * @param src source file.
   * @param dst dst file.
   * @param color color.
   */
  public static void fillColor(@NonNull String src, @NonNull String dst, int color) {
    try {
      BufferedImage bufferedImage = ImageIO.read(new File(src));

      fillColor(bufferedImage, color);

      ImageIO.write(bufferedImage, "PNG", new File(dst));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void fillColor(@NonNull BufferedImage image, int color) {
    int width = image.getWidth();
    int height = image.getHeight();
    WritableRaster raster = image.getRaster();

//    int a = (color >> 24) & 0xFF;
    int r = (color >> 16) & 0xFF;
    int g = (color >> 8) & 0xFF;
    int b = color & 0xFF;

    for (int x = 0; x < width; ++x) {
      for (int y = 0; y < height; ++y) {
        int[] pixel = raster.getPixel(x, y, (int[]) null);
        pixel[0] = r;
        pixel[1] = g;
        pixel[2] = b;
        raster.setPixel(x, y, pixel);
      }
    }
  }

  private ImageUtils() {}
}
