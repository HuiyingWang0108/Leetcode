import java.util.Stack;

public class SimplifyPath2 {
    public static void main(String[] args) {
        SimplifyPath2 obj = new SimplifyPath2();
        // String path = "/a/./b/../../c/";
        // String path = "/../";
        String path = "/home//foo/";
        String simplifyPath = obj.simplifyPath(path);
        System.out.println("----simplifyPath-----" + simplifyPath);

    }

    public String simplifyPath(String path) {

        String[] pathArray = path.split("/");
        StringBuilder stringBuilder = new StringBuilder();
        Stack<String> pathStack = new Stack<String>();
        for (int i = 0; i < pathArray.length; i++) {
            if (pathArray[i].equals("..")) {
                if (!pathStack.empty()) {
                    pathStack.pop();
                }
            } else if (!pathArray[i].equals(".") && !pathArray[i].equals("")) {
                pathStack.push(pathArray[i]);
            }
        }
        // pathStack.stream().forEach(S -> System.out.println(S));
        if (pathStack.empty()) {
            return "/";
        }
        do {
            stringBuilder.insert(0, "/" + pathStack.pop());// append vs insert（逆序）
        } while (pathStack.size() > 0);

        return stringBuilder.toString();
    }

}