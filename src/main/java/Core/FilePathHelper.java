package Core;

import java.io.File;

public class FilePathHelper {
    public static final String dir = System.getProperty("user.dir");
    static File f = new File(dir);
    static String filepath = f.getParent();
    public static final String FilePathInCore= filepath+"\\Manotosh\\Java\\Automation\\API\\src\\main\\java\\repository\\localRepo\\post.json";

    public static final String postApiPath = FilePathInCore+"post.json";


}

