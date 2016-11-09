
public class Player extends Splite{

	private boolean up = false;
	private boolean down = false;
	private boolean left = false;
	private boolean right = false;

	public Player(double x, double y, double size){
		super(x,y,size);
	}

	public void pressKey(String key){
		switch(key){
		case "up": up = true; break;
		case "down": down = true; break;
		case "left": left = true; break;
		case "right": right = true; break;
		}
	}
	public void releaseKey(String key){
		switch(key){
		case "up": up = false; break;
		case "down": down = false; break;
		case "left": left = false; break;
		case "right": right = false; break;
		}
	}

	public void move(int width, int height){
		if(up){
			if(down){
				if(left){
					if(!right){
						//1,1,1,0
						if(X > 0){
							X -= MOVE_DISTANCE;
						}
					}
				}else{
					if(right){
						//1,1,0,1
						if(X < width-size){
							X += MOVE_DISTANCE;
						}
					}
				}
			}else{
				if(left){
					if(right){
						//1,0,1,1
						if(Y > 0){
							Y -= MOVE_DISTANCE;
						}
					}else{
						//1,0,1,0
						if(X > 0){
							X -= MOVE_DISTANCE*Math.cos(Math.PI/4);
						}
						if(Y > 0){
							Y -= MOVE_DISTANCE*Math.sin(Math.PI/4);
						}
					}
				}else{
					if(right){
						//1,0,0,1
						if(X < width-size){
							X += MOVE_DISTANCE*Math.cos(Math.PI/4);
						}
						if(Y > 0){
							Y -= MOVE_DISTANCE*Math.sin(Math.PI/4);
						}
					}else{
						//1,0,0,0
						if(Y > 0){
							Y -= MOVE_DISTANCE;
						}
					}
				}
			}
		}else{
			if(down){
				if(left){
					if(right){
						//0,1,1,1
						if(Y < height-size){
							Y += MOVE_DISTANCE;
						}
					}else{
						//0,1,1,0
						if(X > 0){
							X -= MOVE_DISTANCE*Math.cos(Math.PI/4);
						}
						if(Y < height-size){
							Y += MOVE_DISTANCE*Math.sin(Math.PI/4);
						}
					}
				}else{
					if(right){
						//0,1,0,1
						if(X < width-size){
							X += MOVE_DISTANCE*Math.cos(Math.PI/4);
						}
						if(Y < height-size){
							Y += MOVE_DISTANCE*Math.sin(Math.PI/4);
						}
					}else{
						//0,1,0,0
						if(Y < height-size){
							Y += MOVE_DISTANCE;
						}
					}
				}
			}else{
				if(left){
					if(!right){
						//0,0,1,0
						if(X > 0){
							X -= MOVE_DISTANCE;
						}
					}
				}else{
					if(right){
						//0,0,0,1
						if(X < width-size){
							X += MOVE_DISTANCE;
						}
					}
				}
			}
		}
	}

}
