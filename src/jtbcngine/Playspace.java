package jtbcngine;

import java.util.ArrayList;

/**
 * Contains PhysicsObjects and allows them to collide with a Level
 * @see Level
 * @see PhysicsObject
 */
public class Playspace 
{
	ArrayList<PhysicsObject> objects = new ArrayList<PhysicsObject>();
	int blockSize;
	Level l;
	
	public void Update(int deltaTime)
	{
		for (PhysicsObject object : this.objects)
		{
			object.Update(deltaTime);
		}
	}
	
	public void Update()
	{
		for (PhysicsObject object : this.objects)
		{
			object.Update(1);
		}
	}
	
	public void AddObject(PhysicsObject o)
	{
		this.objects.add(o);
		o.setLevel(l);
	}
	
	public void RemoveObject(int index)
	{
		this.objects.remove(index);
	}
	
	public PhysicsObject GetObject(int index)
	{
		return this.objects.get(index);
	}
	
	public Playspace(Level level)
	{
		this.blockSize = level.blockSize;
		this.l = level;
	}

	public int getLevelWidth()
	{
		return l.level.length;
	}

	public int getLevelHeight()
	{
		return l.level[0].length;
	}
}
