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
package lib.ijoic.image_tool.executor;

import lib.ijoic.image_tool.annotation.NonNull;
import lib.ijoic.image_tool.color.ColorExecutor;
import lib.ijoic.image_tool.scale.ScaleExecutor;

/**
 * Executor factory.
 *
 * @author VerstSiu verstsiu@126.com
 * @date 2017/10/6 9:28
 * @version 1.0
 */
public class ExecutorFactory {

  private static final String COMMAND_SCALE = "scale";
  private static final String COMMAND_COLOR = "color";

  /**
   * Returns executor.
   *
   * @param args command line arguments.
   */
  @NonNull
  public static Executor getExecutor(@NonNull String... args) {
    String command;

    if (args.length >= 1 && (command = args[0]) != null) {
      switch (command) {
        case COMMAND_SCALE:
          return new ScaleExecutor();

        case COMMAND_COLOR:
          return new ColorExecutor();

        default:
      }
    }
    return NullExecutor.getInstance();
  }

  private ExecutorFactory() {}
}
