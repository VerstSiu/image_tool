package lib.ijoic.image_tool.color;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Color executor test.
 *
 * @author VerstSiu verstsiu@126.com
 * @date 2017/10/6 14:51
 * @version 1.0
 */
public class ColorExecutorTest {

  @Test
  public void testReadFileName() {
    testReadFileName("/image.jpg", "image");
    testReadFileName("\\image.jpg", "image");
    testReadFileName("image.jpg", "image");
    testReadFileName("image.", "image");
    testReadFileName("image", "image");
    testReadFileName("/", "");
    testReadFileName("\\", "");
    testReadFileName(".", "");
    testReadFileName("/.", "");
    testReadFileName("\\.", "");
    testReadFileName("./", "");
    testReadFileName(".\\", "");
    testReadFileName("image.a.b.c", "image.a.b");
  }

  private void testReadFileName(String input, String output) {
    assertEquals(ColorExecutor.readFileName(input), output);
  }

}
