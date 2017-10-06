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
  static List<ScaleConfig> readClipConfigs(@NonNull String file) {
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
