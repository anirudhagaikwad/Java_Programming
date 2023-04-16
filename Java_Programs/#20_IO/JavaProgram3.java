package PPT20;
/*
How to Scan All Mp3 Files In the Given Directory using Java?
*/

import java.io.File;
import java.io.FileFilter;

public class JavaProgram3 {

    public static final String C_DIRECTORY = "C:\\";

    public static void main(String[] args)
    {
        scanAllFile(C_DIRECTORY);
    }

    // recursive function for scan all files in directory
    public static void scanAllFile(String path)
    {
        File file = new File(path);

        File[] files = file.listFiles();
        if (files == null)
            return;

        for (File f : files) {

            if (f.isDirectory() && f.exists()) {
                try {
                    scanAllFile(f.getPath());
                }
                catch (Exception e) {
                    e.printStackTrace();
                    continue;
                }
            }
            else if (!f.isDirectory() && f.exists()) {
                // using file filter
                if (filter.accept(f)) {
                    System.out.println(f.getName());
                }
            }
        }
    }

    // file filter for sort mp3 files
    static FileFilter filter = new FileFilter() {
        @Override
        public boolean accept(File file)
        {
            if (file.getName().endsWith(".mp3")
                    || file.getName().endsWith(".mp3")) {
                return true;
            }
            return false;
        }
    };
}

