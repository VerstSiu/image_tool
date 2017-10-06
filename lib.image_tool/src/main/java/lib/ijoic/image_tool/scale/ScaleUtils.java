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
package lib.ijoic.image_tool.scale;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lib.ijoic.image_tool.annotation.NonNull;
import lib.ijoic.image_tool.annotation.Nullable;

/**
 * Scale utils.
 *
 * @author VerstSiu verstsiu@126.com
 * @date 2017/10/6 10:27
 * @version 1.0
 */
class ScaleUtils {

  private static final int MIN_CONFIG_PARAM_SIZE = 3;

  private static final int INDEX_FOLDER = 0;
  private static final int INDEX_FILE_NAME = 1;
  private static final int INDEX_IMAGE_SIZE = 2;

  /**
   * Returns scale configs.
   *
   * @param file config file.
   */
  @NonNull
  static List<ScaleConfig> readScaleConfigs(@NonNull String file) {
    List<ScaleConfig> configs = new ArrayList<>();
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
          ScaleConfig config = new ScaleConfig();

          config.setFolder(configParts[INDEX_FOLDER]);
          config.setFileName(configParts[INDEX_FILE_NAME]);
          config.setSize(readInt(configParts[INDEX_IMAGE_SIZE], 0));

          configs.add(config);
        }
      }

      sc.close();
    }

    return configs;
  }

  private static int readInt(@Nullable String text, int defValue) {
    if (text != null && !text.isEmpty()) {
      try {
        return Integer.parseInt(text, 10);
      } catch (NumberFormatException e) {
        e.printStackTrace();
      }
    }
    return defValue;
  }

  private ScaleUtils() {}
}
