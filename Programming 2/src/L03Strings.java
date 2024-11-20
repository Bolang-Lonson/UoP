public class L03Strings {
    public static void main(String[] args) {
        {   /** String basics */
            // String name = new String("Bolang");
            String name = "Bolang";

            System.out.println("Hello "+name);
            System.out.println(name.charAt(1));
            System.out.println(name.concat("-Lonson"));
        }
        {   /** Demonstration of heap, similar strings point to the same object*/
            String name = "Bolang";
            name += "-Lonson";

            System.out.println(name);

            String s1 = "Saadiq", s2 = "Saadiq";

            System.out.println(s1 == s2);   // true
        }
        {   /** Mutable vs immutable strings, string buffers */
            StringBuffer sb = new StringBuffer("Lonson");

            System.out.println(sb.capacity());
            System.out.println(sb.length());

            sb.append(" Nfi");
            System.out.println(sb);

            // converting from StringBuffer to String
            String str = sb.toString();
            // deleting character at index
            sb.deleteCharAt(2);
            System.out.println(sb);

            // inserting str or char at index
            sb.insert(2, "n");
            System.out.println(sb);

            // manipulating length and capacity by inserting empty characters
            sb.setLength(30);
            sb.ensureCapacity(100);
        }
    }
}