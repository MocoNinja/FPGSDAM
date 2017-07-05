import static org.junit.Assert.*;

import org.junit.Test;

public class CountCharsTest
{
	String[] palabras = {"Uno", "Mozambique", "Alcachofa", "Alcanfor", "Pie", "Frigo", "FrigoPie", "CS 1.6", "I n33d scissors 61!!", "MGS:2"};
	int[][] respuestas = {{2, 1}, {5, 5}, {4, 5}, {3, 5}, {2, 1}, {2, 3}, {4, 4}, {0, 2}, {3,8}, {0, 3}};
	CountChars test = new CountChars();
	@Test
	public void Test()
	{
		for (int i = 0; i < palabras.length; i++)
		{
			assertArrayEquals(respuestas[i], test.countChars(palabras[i]));
		}
	}
}
