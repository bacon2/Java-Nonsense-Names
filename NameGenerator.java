//https://www3.nd.edu/~busiforc/handouts/cryptography/Letter%20Frequencies.html
public class NameGenerator {
	private static final char[] vowels = {'a','e','i','o','u'};
	private static final double[] vowelChance = {.08167,.12702,.06966,.07507,.02758};
	private static final char[] consonants = {'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','y','z'};
	private static final double[] consonantChance = {.01492,.02782,.04253, 0.02228, 0.02015, 0.06094, 0.00153, 0.00772, 0.04025, 0.02406, 0.06749, 0.01929, 0.00095, 0.05987,0.06327,0.09056,0.00978,0.02360,0.00150,0.01974,0.00074};
	private static final double[] wordLengthChance = {0.1,0.6,2.6,5.2,8.5,12.2,14,14,12.6,10.1,7.5,5.2,3.2,2,1,0.6,0.3,0.2,0.1,0.1};
	public static String name()
	{
		int length = getLength();
		StringBuilder name = new StringBuilder();
		boolean lastWasVowel = false;
		
		//vowel 0 vs consonant _
		for (int i = 0; i < length; i++)
		{
			if (lastWasVowel)
			{
				if(Math.random() < 0.15)
				{
					name.append(getVowel());
					lastWasVowel = true;
				} else {
					name.append(getConsonant());
					lastWasVowel = false;
				}
			} else {
				if(Math.random() < 0.3)
				{
					name.append(getConsonant());
					lastWasVowel = false;
				} else {
					name.append(getVowel());
					lastWasVowel = true;
				}
			}
		}
		String done = name.toString();
		return done.length()>1?done.substring(0,1).toUpperCase() + done.substring(1):done.toUpperCase();
	}
	private static int getLength()
	{
		int length = 0;
		do {
			length = (int) ((Math.random() * wordLengthChance.length));
		}
		while (Math.random() * 100 > wordLengthChance[length]);
		return length;
	}
	private static char getVowel()
	{
		char vowel = ' ';
		int i = 0;
		do {
			i = (int)(Math.random() * vowels.length);
			vowel = vowels[i];
		}
		while (Math.random() * 0.381 > vowelChance[i]);
		return vowel;
	}
	private static char getConsonant()
	{
		char consonant = ' ';
		int i = 0;
		do {
			i = (int)(Math.random() * consonants.length);
			consonant = consonants[i];
		}
		while (Math.random() * 0.619 > consonantChance[i]);
		return consonant;
	}
}
