import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimplifyPath {
    public static void main(String[] args) {
        SimplifyPath obj = new SimplifyPath();
        // String path = "/a/./b/../../c/";
        // String path = "/../";
        String path = "/home//foo/";
        String simplifyPath = obj.simplifyPath(path);
        System.out.println("----simplifyPath-----" + simplifyPath);

    }

    public String simplifyPath(String path) {

        String[] pathArray = path.split("/");
        List<String> pathList = new ArrayList<String>();
        Collections.addAll(pathList, pathArray);
        String pathListString = "";
        while (pathList.contains(".")) {
            pathList.remove(".");
        }
        while (pathList.contains("")) {
            pathList.remove("");
        }
        while (pathList.contains("..")) {
            int n = pathList.indexOf("..");
            pathList.remove("..");
            if (n > 0) {
                pathList.remove(n - 1);
            }
        }
        if (pathList.size() == 0) {
            return "/";
        }
        for (String s : pathList) {
            pathListString += "/" + s;
        }
        return pathListString;
    }

}