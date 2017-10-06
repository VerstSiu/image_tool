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
