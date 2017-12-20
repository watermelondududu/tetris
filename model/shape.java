package model;

import java.util.Random;

public class shape {
	public enum Shapes{NoShape,Z,S,I,T,O,L,J};
	private Shapes pieceShape;
	private int[][] coords;//coords中存放的是一個piece中四個小方塊的坐標
	private int[][][] coordsTable;//table中存放了8種shape的原始坐標表
	
	public shape(){
		coords = new int[4][2];
		coordsTable = new int[][][]{//8;4;2;
			{{0, 0}, {0, 0}, {0, 0}, {0, 0}},//noshape
			{{0, -1}, {0, 0}, {-1, 0}, {-1, 1}},//z
            {{0, -1}, {0, 0}, {1, 0}, {1, 1}},//s
            {{0, -1}, {0, 0}, {0, 1}, {0, 2}},//i
            {{-1, 0}, {0, 0}, {1, 0}, {0, 1}},//t
            {{0, 0}, {1, 0}, {0, 1}, {1, 1}},//o
            {{-1, -1}, {0, -1}, {0, 0}, {0, 1}},//l
            {{1, -1}, {0, -1}, {0, 0}, {0, 1}}//j
		};
		setPieceShape(Shapes.NoShape);
	}
	
	public void setPieceShape(Shapes pieceShape){//把坐標表中響應shape的坐標複製進了當前的coords數組中，並
		for(int i=0;i<4;i++){
			System.arraycopy(coordsTable[pieceShape.ordinal()][i], 0, coords[i], 0, 2);
		}
		this.pieceShape=pieceShape;
	}
	
	public void setX(int index,int x){
		coords[index][0]=x;
	}
	
	public void setY(int index,int y){
		coords[index][1]=y;
	}
	
	public int getX(int index){
		return coords[index][0]; 
	}
	
	public int getY(int index){
		return coords[index][1];
	}
	
	public Shapes getPieceShape(){
		return pieceShape;
	}
	
	public void setRandomShape(){
		Random r=new Random();
		int x = r.nextInt(7)+1;//產生一個【0，7）之間的隨機數，+1是為了跳過noshape
		Shapes[] shape= Shapes.values();//通過values（）函數把枚舉類型shapes變成可以用下標表示的數組，此時 shape={Z,S,I,T,O,L,J}
		setPieceShape(shape[x]);
	}
	
	public int minX(){
		int m=coords[0][0];
		for(int i=0;i<4;i++){
			m=Math.min(m, coords[i][0]);
		}
		return m;
	}
	
	public int minY(){
		int m=coords[0][1];
		for(int i=0;i<4;i++){
			m=Math.min(m, coords[i][1]);
		}
		return m;
	}
	
	public shape getLeftRotatedPiece(){
		if(pieceShape==Shapes.O){//正方形就不用旋轉了
			return this;
		}
		
		shape result = new shape();
		result.pieceShape=pieceShape;
		
		for(int i=0;i<4;i++){
			result.setX(i, getY(i));//x'=-y
			result.setY(i, -getX(i));//y'=x
		}
		
		return result;
	}
	
	public shape getRightRotatedPiece(){
		if(pieceShape==Shapes.O){//正方形就不用旋轉了
			return this;
		}
		
		shape result = new shape();
		result.pieceShape=pieceShape;
		
		for(int i=0;i<4;i++){
			result.setX(i, -getY(i));//x'=-y
			result.setY(i, getX(i));//y'=x
		}
		
		return result;
	}
}
