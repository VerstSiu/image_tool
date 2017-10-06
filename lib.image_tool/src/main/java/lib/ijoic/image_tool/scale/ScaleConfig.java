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

/**
 * Scale config.
 *
 * @author VerstSiu verstsiu@126.com
 * @date 2017/10/6 10:11
 * @version 1.0
 */
class ScaleConfig {

  private String folder;
  private int size;
  private String fileName;

  /**
   * Returns folder.
   */
  public String getFolder() {
    return this.folder;
  }

  /**
   * Set folder.
   *
   * @param folder folder.
   */
  public void setFolder(String folder) {
    this.folder = folder;
  }

  /**
   * Returns size.
   */
  public int getSize() {
    return this.size;
  }

  /**
   * Set size.
   *
   * @param size size.
   */
  public void setSize(int size) {
    this.size = size;
  }

  /**
   * Returns file name.
   */
  public String getFileName() {
    return this.fileName;
  }

  /**
   * Set file name.
   *
   * @param fileName file name.
   */
  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

}
