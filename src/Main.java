public class Main
{
    public static void main(String args[])
    {
        HashTable h = new HashTable();
        h.put("Aa", 25);
        h.put("BB", 23);
        h.put("cc", 2);
        System.out.println(h);
        h.remove("Aa");
        System.out.println(h);
    }
}
