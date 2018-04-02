You have n types of lego blocks, 
of sizes given as (1 x 1 x 1), (1 x 1 x 2), (1 x 1 x 3), (1 x 1 x 4)........(1 x 1 x n).

n is the width of the block, the height and the depth is the same, 1 unit.

Using these blocks, you want to make a wall of height h and width w. The wall should not have any holes in it. The wall you build should be one solid structure. A solid structure can be interpreted in one of the following ways: 
(1)It should not be possible to separate the wall along any vertical line without cutting any lego block used to build the wall. 
(2)You cannot make a vertical cut from top to bottom without cutting one or more lego blocks.

The blocks can only be placed horizontally. In how many ways can the wall be built?


Input : int[] blocks, defining the width of the blocks. It can be any number of blocks and any combination of widths
e.g {1, 2, 3, 4} or {2, 4, 6, 8} or {2, 5, 8, 9, 6, 5, 4} or {1} or {6}

int h = 6, w = 4; (height and width of the wall). Those can be any numbers, under 5000.


Output : 
1) Print all the combinations of the blocks which are continous walls, depict that visually
2) Print the count of all possible combinations
3) Print the count of all valid combinations
4) write test with different inputs (h, w, blocks) to assert that this is a generic solution and this solution works for different height, width and block width arrays



Classes : LegoBlocks.java, TestLegoBlocks.java
