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

import java.io.File;
import java.util.List;

import lib.ijoic.image_tool.annotation.NonNull;
import lib.ijoic.image_tool.executor.Executor;
import lib.ijoic.image_tool.util.ImageUtils;

/**
 * Scale executor.
 *
 * @author VerstSiu verstsiu@126.com
 * @date 2017/10/6 9:32
 * @version 1.0
 */
public class ScaleExecutor implements Executor {

  private static final int MIN_ARGS_SIZE = 4;

  private static final int INDEX_SRC = 1;
  private static final int INDEX_ROOT = 2;
  private static final int INDEX_CONFIG = 3;

  @Override
  public void runCommandLineExecute(String... args) {
    // scale src root config
    if (args.length < MIN_ARGS_SIZE) {
      return;
    }
    String src = args[INDEX_SRC];
    String root = args[INDEX_ROOT];
    String configPath = args[INDEX_CONFIG];
    List<ScaleConfig> configs;

    if (root == null || !checkAndMakeRootDir(root) || configPath == null
        || (configs = ScaleUtils.readScaleConfigs(configPath)).isEmpty()) {
      return;
    }
    String folder;
    String filePath;
    int clipSize;

    for (ScaleConfig config : configs) {
      folder = config.getFolder();
      filePath = config.getFileName();
      clipSize = config.getSize();

      if (folder == null || folder.isEmpty() || filePath == null || filePath.isEmpty()
          || clipSize <= 0) {
        continue;
      }
      folder = root + File.separator + folder;
      filePath = folder + File.separator + filePath;

      if (checkAndMakeRootDir(folder)) {
        ImageUtils.scale(src, filePath, clipSize, clipSize, false);
      }
    }
  }

  private static boolean checkAndMakeRootDir(@NonNull String file) {
    File rootFile = new File(file);

    if (rootFile.exists()) {
      return rootFile.isDirectory();
    }
    return rootFile.mkdirs();
  }

}
