
public class LengthTester
{
    public static void main(String[] args)
    {
        Length length1 = new Length(0,0,0,12);
        Length length2 = new Length(0,0,0,36);
        Length length3 = new Length(0,0,0,48);
        
        Length tempLength = length1.plus(length2);
        System.out.println(tempLength);
        
        System.out.println(length3.minus(length2));
        System.out.println(length3.representAsMiles());

        System.out.println(length3.representAsYards());
        
    }
}
