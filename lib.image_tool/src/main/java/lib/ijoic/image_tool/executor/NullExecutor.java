package lib.ijoic.image_tool.executor;

import lib.ijoic.image_tool.annotation.NonNull;

/**
 * Null executor.
 *
 * @author VerstSiu verstsiu@126.com
 * @date 2017/10/6 9:36
 * @version 1.0
 */
class NullExecutor implements Executor {

  @NonNull
  static NullExecutor getInstance() {
    return SingletonHolder.instance;
  }

  private interface SingletonHolder {
    NullExecutor instance = new NullExecutor();
  }

  @Override
  public void runCommandLineExecute(String... args) {
    // do nothing.
  }

  private NullExecutor() {}
}
