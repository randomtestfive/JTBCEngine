###Java-Tile-Based-Collision Engine

Example:
```
int[][] l = {
	{0,0,0,0,0,0,0,0,0,0,0,0,0,1},
	{0,0,0,0,0,0,0,0,0,0,0,0,0,1},
	{0,0,0,0,0,0,0,0,0,0,0,1,0,1},
	{0,0,0,0,0,0,0,0,0,0,0,0,0,1},
	{0,0,0,0,0,0,0,0,0,0,0,0,0,1},
	{0,0,0,0,0,0,0,0,0,0,0,0,0,1}};
	
Level level = new Level(50, l);
	
Playspace p = new Playspace(level);
	
p.AddObject(new PhysicsObject(p, 0, 0, 0, 2));
while (true)
{
	p.Update();
}
```