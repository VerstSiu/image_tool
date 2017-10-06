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
