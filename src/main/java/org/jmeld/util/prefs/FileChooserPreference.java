/*
   JMeld is a visual diff and merge tool.
   Copyright (C) 2007  Kees Kuip
   This library is free software; you can redistribute it and/or
   modify it under the terms of the GNU Lesser General Public
   License as published by the Free Software Foundation; either
   version 2.1 of the License, or (at your option) any later version.
   This library is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
   Lesser General Public License for more details.
   You should have received a copy of the GNU Lesser General Public
   License along with this library; if not, write to the Free Software
   Foundation, Inc., 51 Franklin Street, Fifth Floor,
   Boston, MA  02110-1301  USA
 */
package org.jmeld.util.prefs;

import javax.swing.*;

import java.io.*;

public class FileChooserPreference
    extends Preference
{
  // Class variables:
  private static String FILE = "FILE";

  // Instance variables:
  private JFileChooser target;

  public FileChooserPreference(String preferenceName, JFileChooser target)
  {
    super("FileChooser-" + preferenceName);

    this.target = target;

    init();
  }

  private void init()
  {
    String fileName;

    fileName = getString(FILE, null);
    if (fileName != null)
    {
      target.setCurrentDirectory(new File(fileName));
    }
  }

  public void save()
  {
    String fileName;
    File file;

    file = target.getSelectedFile();
    if (file != null)
    {
      try
      {
        fileName = file.getCanonicalPath();
        putString(FILE, fileName);
      }
      catch (IOException ex)
      {
        ex.printStackTrace();
      }
    }
  }
}
