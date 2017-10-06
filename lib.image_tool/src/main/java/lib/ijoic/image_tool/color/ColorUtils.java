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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lib.ijoic.image_tool.annotation.NonNull;
import lib.ijoic.image_tool.annotation.Nullable;

/**
 * Color utils.
 *
 * @author VerstSiu verstsiu@126.com
 * @date 2017/10/6 14:30
 * @version 1.0
 */
class ColorUtils {

  private static final int MIN_CONFIG_PARAM_SIZE = 2;

  private static final int INDEX_SUFFIX = 0;
  private static final int INDEX_COLOR = 1;

  /**
   * Returns color configs.
   *
   * @param file config file.
   */
  @NonNull
  static List<ColorConfig> readColorConfigs(@NonNull String file) {
    List<ColorConfig> configs = new ArrayList<>();
    InputStream is = null;

    try {
      is = new FileInputStream(file);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    // read configs.
    if (is != null) {
      Scanner sc =  new Scanner(is);
      String configLine;
      String[] configParts;

      while (sc.hasNext()) {
        configLine = sc.nextLine();
        configParts = configLine.split(" ");

        if (configParts.length >= MIN_CONFIG_PARAM_SIZE) {
          ColorConfig config = new ColorConfig();

          config.setSuffix(configParts[INDEX_SUFFIX]);
          config.setColor(readColor(configParts[INDEX_COLOR], 0));

          configs.add(config);
        }
      }

      sc.close();
    }

    return configs;
  }

  private static int readColor(@Nullable String text, int defValue) {
    if (text != null && !text.isEmpty()) {
      try {
        return Integer.parseInt(text, 16);
      } catch (NumberFormatException e) {
        e.printStackTrace();
      }
    }
    return defValue;
  }

  private ColorUtils() {}
}
