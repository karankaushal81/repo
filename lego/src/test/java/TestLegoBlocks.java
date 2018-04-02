

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestLegoBlocks {
	
	
	@Test
	public void testContinousArrangement()
	{
		LegoBlocks.h=4;
		LegoBlocks.w=4;
		int[] arr = {1,2,3,4};
		LegoBlocks.blocks = arr;
		
		List<String> arrangement = new ArrayList<String>();
		
		arrangement.add(",1,1,1,1");
		arrangement.add(",2,2");
		arrangement.add(",2,2");
		arrangement.add(",3,1");
		
		assertTrue(LegoBlocks.isContinous(arrangement));
	}
	
	@Test
	public void testContinousArrangement2()
	{
		LegoBlocks.h=4;
		LegoBlocks.w=4;
		int[] arr = {1,2,3,4};
		LegoBlocks.blocks = arr;
		
		List<String> arrangement = new ArrayList<String>();
		
		arrangement.add(",1,1,1,1");
		arrangement.add(",2,2");
		arrangement.add(",2,2");
		arrangement.add(",1,1,1,1");
		
		assertFalse(LegoBlocks.isContinous(arrangement));
	}
	
	
	@Test
	public void testLegoBlocks1()
	{
		LegoBlocks.count =0;
		LegoBlocks.continousWallCount =0;
		LegoBlocks.h=4;
		LegoBlocks.w=4;
		int[] arr = {1,2,3,4};
		LegoBlocks.blocks = arr;
		
		LegoBlocks.forTest();
		
		assertEquals(LegoBlocks.count, 8*8*8*8);
		assertEquals(LegoBlocks.continousWallCount, 3375);
	}

	
	@Test
	public void testLegoBlocks2()
	{
		LegoBlocks.count =0;
		LegoBlocks.continousWallCount =0;
		LegoBlocks.h=3;
		LegoBlocks.w=4;
		int[] arr = {1,2,3,4};
		LegoBlocks.blocks = arr;
		
		LegoBlocks.forTest();
		
		assertEquals(LegoBlocks.count, 8*8*8);
		assertEquals(LegoBlocks.continousWallCount, 343);
	}

	
	@Test
	public void testLegoBlocks3()
	{
		LegoBlocks.count =0;
		LegoBlocks.continousWallCount =0;
		LegoBlocks.h=1;
		LegoBlocks.w=5;
		int[] arr = {1,2,3,4};
		LegoBlocks.blocks = arr;
		
		LegoBlocks.forTest();
		
		assertEquals(LegoBlocks.count, 15);
		assertEquals(LegoBlocks.continousWallCount, 0);
	}
	
	
	@Test
	public void testLegoBlocks4()
	{
		LegoBlocks.count =0;
		LegoBlocks.continousWallCount =0;
		LegoBlocks.h=4;
		LegoBlocks.w=5;
		int[] arr = {1,2,3,4};
		LegoBlocks.blocks = arr;
		
		LegoBlocks.forTest();
		
		assertEquals(LegoBlocks.count, 15*15*15*15);
		assertEquals(LegoBlocks.continousWallCount, 35714);
	}
	
	
	
	@Test
	public void testLegoBlocks5()
	{
		LegoBlocks.count =0;
		LegoBlocks.continousWallCount =0;
		LegoBlocks.h=1;
		LegoBlocks.w=6;
		int[] arr = {2,3,4, 5};
		LegoBlocks.blocks = arr;
		
		LegoBlocks.forTest();
		
		assertEquals(LegoBlocks.count, 4);
		assertEquals(LegoBlocks.continousWallCount, 0);
	}
	
	@Test
	public void testLegoBlocks6()
	{
		LegoBlocks.count =0;
		LegoBlocks.continousWallCount =0;
		LegoBlocks.h=4;
		LegoBlocks.w=6;
		int[] arr = {2,3,4,5};
		LegoBlocks.blocks = arr;
		
		LegoBlocks.forTest();
		
		assertEquals(LegoBlocks.count, 4*4*4*4);
		assertEquals(LegoBlocks.continousWallCount, 224);
	}
	
	@Test
	public void testLegoBlocks7()
	{
		LegoBlocks.count =0;
		LegoBlocks.continousWallCount =0;
		LegoBlocks.h=1;
		LegoBlocks.w=6;
		int[] arr = {1,2,3,4};
		LegoBlocks.blocks = arr;
		
		LegoBlocks.forTest();
		
		assertEquals(LegoBlocks.count, 29);
		assertEquals(LegoBlocks.continousWallCount, 0);
	}
	
	@Test
	public void testLegoBlocks8()
	{
		LegoBlocks.count =0;
		LegoBlocks.continousWallCount =0;
		LegoBlocks.h=3;
		LegoBlocks.w=6;
		int[] arr = {1,2,3,4};
		LegoBlocks.blocks = arr;
		
		LegoBlocks.forTest();
		
		assertEquals(LegoBlocks.count, 29*29*29);
		assertEquals(LegoBlocks.continousWallCount, 9870);
	}

}
