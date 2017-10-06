package lib.ijoic.image_tool.color;

import java.io.File;
import java.util.List;

import lib.ijoic.image_tool.annotation.NonNull;
import lib.ijoic.image_tool.annotation.Nullable;
import lib.ijoic.image_tool.executor.Executor;
import lib.ijoic.image_tool.util.ImageUtils;

/**
 * Color executor.
 *
 * @author VerstSiu verstsiu@126.com
 * @date 2017/10/6 14:25
 * @version 1.0
 */
public class ColorExecutor implements Executor {

  private static final int MIN_ARGS_SIZE = 4;

  private static final int INDEX_SRC = 1;
  private static final int INDEX_ROOT = 2;
  private static final int INDEX_CONFIG = 3;

  @Override
  public void runCommandLineExecute(String... args) {
    // color src root config
    if (args.length < MIN_ARGS_SIZE) {
      return;
    }
    String src = args[INDEX_SRC];
    String root = args[INDEX_ROOT];
    String configPath = args[INDEX_CONFIG];
    File srcFile;

    if (src == null || root == null || configPath == null
        || !(srcFile = new File(src)).exists()) {
      return;
    }

    if (!srcFile.isDirectory()) {
      fillSingleFile(src, root, configPath);
    } else {
      String[] files = srcFile.list();

      if (files != null) {
        for (String file : files) {
          if (file == null || file.isEmpty()) {
            continue;
          }
          fillSingleFile(src + File.separator + file, root, configPath);
        }
      }
    }
  }

  private void fillSingleFile(@NonNull String srcFile, @NonNull String root, @NonNull String configPath) {
    String srcFileName;
    List<ColorConfig> configs;

    if (!checkAndMakeRootDir(root)
        || (srcFileName = readFileName(srcFile)) == null
        || srcFileName.isEmpty()
        || (configs = ColorUtils.readColorConfigs(configPath)).isEmpty()) {
      return;
    }
    String filePath;
    String suffix;
    int color;

    for (ColorConfig config : configs) {
      color = config.getColor();

      if (color == 0) {
        continue;
      }
      suffix = config.getSuffix();
      filePath = root + File.separator + srcFileName;

      if (suffix != null && !suffix.isEmpty()) {
        filePath += "_" + suffix;
      }
      filePath += ".png";

      ImageUtils.fillColor(srcFile, filePath, color);
    }
  }

  @Nullable
  static String readFileName(@NonNull String text) {
    if (text.contains("/")) {
      text = text.substring(text.lastIndexOf("/") + 1);
    }
    if (text.contains("\\")) {
      text = text.substring(text.lastIndexOf("\\") + 1);
    }
    if (text.contains(".")) {
      text = text.substring(0, text.lastIndexOf("."));
    }
    return text;
  }

  private static boolean checkAndMakeRootDir(@NonNull String file) {
    File rootFile = new File(file);

    if (rootFile.exists()) {
      return rootFile.isDirectory();
    }
    return rootFile.mkdirs();
  }
}
