public class Quine {
    public static void main(String[] args) {
        System.out.println(sourceCodeString.substring(0, sourceCodeString.length() - 1) + '"');
        System.out.println(sourceCodeString.substring(0, sourceCodeString.length() - 1));
        System.out.println("" + '"' + '"' + '"' + ';');
        System.out.println('}');
    }

    private static String sourceCodeString = """
public class Quine {
    public static void main(String[] args) {
        System.out.println(sourceCodeString.substring(sourceCodeString.length() - 1) + '"');
        System.out.println(sourceCodeString.substring(sourceCodeString.length() - 1));
        System.out.println("" + '"' + '"' + '"' + ';');
        System.out.println('}');
    }
    \s
    private static String sourceCodeString = ""
    """;
}
