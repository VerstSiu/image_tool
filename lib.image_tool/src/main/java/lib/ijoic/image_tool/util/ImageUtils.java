package lib.ijoic.image_tool.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
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

  private ImageUtils() {}
}
