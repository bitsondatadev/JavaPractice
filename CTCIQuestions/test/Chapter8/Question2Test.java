package Chapter8;

import java.util.Arrays;
import java.util.List;

import org.junit.*;

import static org.junit.Assert.*;

public class Question2Test{
	
	Question2 q2;
	boolean[][] grid;

	@Before
	public void setUp(){
		q2 = new Question2();
	}

	@After
	public void tearDown(){

	}

	@Test
	public void testGetPath(){
		int r = 3;
		int c = 5;
		grid = new boolean[r][c];
		grid[0][0] = true;
		grid[0][1] = true;
		grid[0][2] = true;
		grid[1][2] = true;
		grid[2][2] = true;
		grid[2][3] = true;
		
		/** grid
		 * 1 1 1 0 0
		 * 0 0 1 0 0
		 * 0 0 1 1 0
		 */
		assertNull(q2.getPath(grid));
		
		grid[2][4] = true;
		
		/** grid
		 * 1 1 1 0 0
		 * 0 0 1 0 0
		 * 0 0 1 1 1
		 */
		List<Point> memo = q2.getPath(grid);
		assertEquals(r + c - 1, memo.size());
		//Question2.printPath(memo);
		
		grid[2][2] = false;
		
		/** grid
		 * 1 1 1 0 0
		 * 0 0 1 0 0
		 * 0 0 0 1 1
		 */
		assertNull(q2.getPath(grid));
		
		grid[1][3] = true;
		
		/** grid
		 * 1 1 1 0 0
		 * 0 0 1 1 0
		 * 0 0 0 1 1
		 */
		memo = q2.getPath(grid);
		assertEquals(r + c - 1, memo.size());
		//Question2.printPath(memo);
		
		grid[0][1] = false;
		grid[1][3] = false;
		grid[2][3] = false;
		grid[1][0] = true;
		grid[2][0] = true;
		grid[2][1] = true;
		grid[2][2] = true;
		grid[0][3] = true;
		grid[0][4] = true;
		grid[1][4] = true;
		
		/** grid
		 * 1 0 1 1 1
		 * 1 0 1 0 1
		 * 1 1 1 0 1
		 */
		assertNull(q2.getPath(grid));
		
		grid[0][1] = true;
		
		/** grid
		 * 1 1 1 1 1
		 * 1 0 1 0 1
		 * 1 1 1 0 1
		 */
		memo = q2.getPath(grid);
		assertEquals(r + c - 1, memo.size());
		//Question2.printPath(memo);
		

		
	}
	
	@Test
	public void testAlmostFullGridGetPath(){
		int r = 12;
		int c = 12;
		grid = new boolean[r][c];
		for(int i = 0; i < r; i++){
			Arrays.fill(grid[i], true);
		}
		
		grid[0][0] = false;
		assertNull(q2.getPath(grid));
		
	}
}
