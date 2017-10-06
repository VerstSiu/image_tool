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
