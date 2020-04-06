package com.ibeetl.admin.core.file;

import com.ibeetl.admin.core.util.PlatformException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/**
 * 本地文件系统
 *
 * @author xiandafu
 */
public class LocalFileItem extends PersistFileItem {
  String root;

  public LocalFileItem(String root) {
    this.root = root;
  }

  public OutputStream openOutpuStream() {
    File file = new File(root + File.separator + path);
    try {
      if (!file.exists()) {
        file.createNewFile();
      }
      FileOutputStream fos = new FileOutputStream(file);
      return fos;
    } catch (IOException e) {
      throw new PlatformException("Open file [" + path + "] output stream error ");
    }
  }

  @Override
  public void copy(OutputStream os) {
    File file = new File(root + File.separator + path);
    FileInputStream input = null;
    try {
      input = new FileInputStream(file);
      byte[] buf = new byte[1024];
      int bytesRead;
      while ((bytesRead = input.read(buf)) > 0) {
        os.write(buf, 0, bytesRead);
      }

    } catch (Exception ex) {
      throw new PlatformException("下载/复制文件失败" + ex);
    } finally {
      try {
        input.close();
        os.close();
        if (isTemp) {
          this.delete();
        }
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

  @Override
  public boolean delete() {
    File file = new File(root + File.separator + path);
    return file.delete();
  }
}
