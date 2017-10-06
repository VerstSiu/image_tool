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
package lib.ijoic.image_tool.color;

/**
 * Color config.
 *
 * @author VerstSiu verstsiu@126.com
 * @date 2017/10/6 14:27
 * @version 1.0
 */
class ColorConfig {

  private String suffix;
  private int color;

  /**
   * Returns suffix.
   */
  public String getSuffix() {
    return this.suffix;
  }

  /**
   * Set suffix.
   *
   * @param suffix suffix.
   */
  public void setSuffix(String suffix) {
    this.suffix = suffix;
  }

  /**
   * Returns color.
   */
  public int getColor() {
    return this.color;
  }

  /**
   * Set color.
   *
   * @param color color.
   */
  public void setColor(int color) {
    this.color = color;
  }

}
