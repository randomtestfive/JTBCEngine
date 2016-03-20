package jtbcngine;

import java.awt.Point;

/**
 * Describes an object that can be used in a Playspace
 * @see Playspace
 */
public class PhysicsObject 
{	
	int blockSize;
	public int xPos = 0;
	public int yPos = 0;
	float realXPos = 0;
	float realYPos = 0;
	float xVel = 0;
	float yVel = 0;
	int xSize = 0;
	int ySize = 0;
	Level level;

	public PhysicsObject(Playspace p, int StartXpos, int StartYpos, int StartXvel, int StartyVel, int xsize, int ysize)
	{
		this.blockSize = p.blockSize;
		this.realXPos = StartXpos;
		this.realYPos = StartYpos;
		this.xPos = StartXpos;
		this.yPos = StartYpos;
		this.xVel = StartXvel;
		this.yVel = StartyVel;
		this.xSize = xsize;
		this.ySize = ysize;
		this.level = p.l;
	}
	
	public int getXPos()
	{
		return (int) realXPos;
	}
	
	public int getYPos()
	{
		return (int) realYPos;
	}
	
	public int getXVel()
	{
		return (int) xVel;
	}
	
	public int getYVel()
	{
		return (int) yVel;
	}
	
	public void setPos(Point p)
	{
		realXPos = p.x;
		realYPos = p.y;
	}
	
	public void setVel(Point p)
	{
		xVel = p.x;
		yVel = p.y;
	}

	public void setLevel(Level l)
	{
		level = l;
	}

	public void Update(int dTime)
	{
		float dxVel = this.xVel * dTime; 
		float dyVel = this.yVel * dTime;
		
		if (/*dyVel == 0 &&*/ dxVel > 0)
		{
			//system.out.println("pos non" + " (" + this.realXPos + " " + this.realYPos + ") (" + dxVel + " " + dyVel + ")");
			//this.realYPos = this.realYPos + (int)dyVel;
			int tempx = (int)this.realXPos + xSize + (int)dxVel;
			//int tempy = this.realYPos;
			if(this.level.level.length * this.blockSize > tempx)
			{
				if(this.realYPos%this.blockSize == 0 || (this.realYPos+ySize)%this.blockSize == 0)
				{
					if(this.level.level[tempx / this.blockSize][(int)this.realYPos / this.blockSize] == 1)
					{
						//system.out.println("yesx");
						this.realXPos = ((this.realXPos / this.blockSize) + 1) * this.blockSize - xSize;
						dxVel = 0;
					}
					else
					{
						this.realXPos = this.realXPos + (int)dxVel;
					}
				}
				else
				{
					if(this.level.level[(tempx / this.blockSize)][((int)this.realYPos / this.blockSize)] == 1 || this.level.level[(tempx / this.blockSize)][(((int)this.realYPos + ySize) / this.blockSize)] == 1)
					{
						//system.out.println("hitx");
						this.realXPos = ((this.realXPos / this.blockSize) + 1) * this.blockSize - (xSize);
					}
					else
					{
						this.realXPos = this.realXPos + (int)dxVel;
					}
				}
			}
			else
			{
				this.realXPos = (this.level.level.length * this.blockSize) - xSize;
				dxVel = 0;
			}
		}
		else if (/*dyVel == 0 &&0*/ dxVel < 0)
		{
			//system.out.println("neg non" + " " + dxVel + " " + dyVel);
			//this.realYPos = this.realYPos + (int)dyVel;
			int tempx = (int)this.realXPos + (int)dxVel;
			//int tempy = this.realYPos;
			if(0 < tempx)
			{
				if(this.realYPos%this.blockSize == 0 || (this.realYPos+ySize)%this.blockSize == 0)
				{
					if(this.level.level[tempx / this.blockSize][(int)this.realYPos / this.blockSize] == 1)
					{
						//system.out.println("yesx");
						this.realXPos = ((this.realXPos / this.blockSize)) * this.blockSize;
						dxVel = 0;
					}
					else
					{
						this.realXPos = this.realXPos + (int)dxVel;
					}
				}
				else
				{
					if(this.level.level[(tempx / this.blockSize)][((int)this.realYPos / this.blockSize)] == 1 || this.level.level[(tempx / this.blockSize)][((int)this.realYPos + ySize) / this.blockSize] == 1)
					{
						//system.out.println("hitx");
						this.realXPos = ((this.realXPos / this.blockSize)) * this.blockSize;
						dxVel = 0;
					}
					else
					{
						this.realXPos = this.realXPos + (int)dxVel;
					}
				}
			}
			else
			{
				this.realXPos = 0;
			}
		}

		if (dyVel > 0 /*&& dxVel == 0*/)
		{
			//system.out.println("non pos" + " " + dxVel + " " + dyVel);
			//this.realYPos = this.realYPos + (int)dyVel;
			//int tempx = this.realXPos;
			int tempy = (int)this.realYPos + (int)dyVel;
			if(this.level.level[0].length * this.blockSize > tempy)
			{
				//system.out.println("left");
				if(this.realXPos%this.blockSize == 0)
				{
					if(this.level.level[(int)this.realXPos / this.blockSize][((tempy + ySize) / this.blockSize)] == 1)
					{
						//system.out.println("yes");
						this.realYPos = (((this.realYPos) / this.blockSize) + 1) * this.blockSize;
						dyVel = 0;
					}
					else
					{
						this.realYPos = this.realYPos + (int)dyVel;
					}
				}
				else if((this.realXPos+xSize)%this.blockSize == 0)
				{
					//system.out.println("right");
					if(this.level.level[(int)this.realXPos / this.blockSize][((tempy + ySize) / this.blockSize)] == 1)
					{
						//system.out.println("yes2");
						this.realYPos = (((this.realYPos) / this.blockSize) + 1) * this.blockSize;
						dyVel = 0;
					}
					else
					{
						this.realYPos = this.realYPos + (int)dyVel;
					}
				}
				else
				{
					//system.out.println("norm");
					if(this.realXPos + xSize < this.level.level.length * this.blockSize)
					{
						if(this.level.level[(int)this.realXPos / this.blockSize][((tempy + ySize) / this.blockSize)] == 1 || this.level.level[(((int)this.realXPos) + xSize) / this.blockSize][((tempy + ySize) / this.blockSize)] == 1)
						{	
							//system.out.println("hit+ " + this.realXPos + " " + tempy);
							this.realYPos = (((this.realYPos) / this.blockSize) + 1) * this.blockSize;
							//system.out.println(this.realXPos + " " + (this.realYPos));
						}
						else
						{
							this.realYPos = this.realYPos + (int)dyVel;
						}
					}
				}
			}
			else
			{
				this.realYPos = (this.level.level[0].length * this.blockSize);
			}
		}
		else if (dyVel < 0 /*&& dxVel == 0*/)
		{
			//system.out.println("non neg" + " " + dxVel + " " + dyVel);
			//this.realYPos = this.realYPos + (int)dyVel;
			//int tempx = this.realXPos;
			int tempy = (int)this.realYPos + (int)dyVel;
			if(0 < tempy)
			{
				if(this.realXPos%this.blockSize == 0 || (this.realXPos+xSize)%this.blockSize == 0)
				{
					if(this.level.level[((int)this.realXPos / this.blockSize)][tempy / this.blockSize] == 1)
					{
						//system.out.println("yes");
						this.realYPos = ((this.realYPos / this.blockSize)) * this.blockSize;
						dyVel = 0;
					}
					else
					{
						this.realYPos = this.realYPos + (int)dyVel;
					}
				}
				else
				{
					if(this.realXPos + xSize < this.level.level.length * this.blockSize)
					{
						if(this.level.level[((int)this.realXPos / this.blockSize)][(tempy / this.blockSize)] == 1 || 
								this.level.level[(((int)this.realXPos + xSize) / this.blockSize)][(tempy / this.blockSize)] == 1)
						{
							//system.out.println("hi-t");
							this.realYPos = ((this.realYPos / this.blockSize)) * this.blockSize;
							dyVel = 0;
						}
						else
						{
							this.realYPos = this.realYPos + (int)dyVel;
						}
					}
				}
			}
			else
			{
				this.realYPos = 0;
				dyVel = 0;
			}
		}
		this.xPos = (int) this.realXPos;
		this.yPos = (int) this.realYPos;
		if(dyVel == 0)
		{
			this.yVel = 0;
		}
		if(dxVel == 0)
		{
			this.xVel = 0;
		}
	}
}

