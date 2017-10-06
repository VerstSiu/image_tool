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
