package lib.ijoic.image_tool.executor;

/**
 * Command line executor
 *
 * @author VerstSiu verstsiu@126.com
 * @date 2017/10/6 9:25
 * @version 1.0
 */
public interface Executor {
  /**
   * Run command line execute.
   *
   * @param args command line arguments.
   */
  void runCommandLineExecute(String... args);
}
