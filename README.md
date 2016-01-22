###Java-Tile-Based-Collision Engine

Example:
```
int[][] l = {
	{0,0,0,0,0,0,0,0,0,0,0,0,0,1},
	{0,0,0,0,0,0,0,0,0,0,0,0,0,1},
	{0,0,0,0,0,0,0,0,0,0,0,1,0,1},
	{0,0,0,0,0,0,0,0,0,0,0,0,0,1},
	{0,0,0,0,0,0,0,0,0,0,0,0,0,1}};
	
Level level = new Level(1, l);
	
Playspace p = new Playspace(level);
int xPos = 2;
int yPos = 0;
int xVel = 0;
int yVel = 1;
int xSize = 1;
int ySize = 1;
p.AddObject(new PhysicsObject(p, xPos, yPos, xVel, yVel, xSize, ySize));
while (true)
{
	p.Update();
	System.out.println(p.GetObject(0).yPos);
}
```