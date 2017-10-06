package lib.ijoic.image_tool;

import lib.ijoic.image_tool.executor.ExecutorFactory;

/**
 * Image tool.
 *
 * @author VerstSiu verstsiu@126.com
 * @date 2017/09/21 09:39
 * @version 1.0
 */
public class ImageTool {

  public static void main(String... args) {
    ExecutorFactory.getExecutor(args).runCommandLineExecute(args);
  }

}
