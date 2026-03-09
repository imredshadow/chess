package com.example;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

//you will need to implement two functions in this file.
public class Piece {
    private final boolean color;
    private BufferedImage img;
    
    public Piece(boolean isWhite, String img_file) {
        this.color = isWhite;
         
        try {
            if (this.img == null) {
                this.img = ImageIO.read(new File(System.getProperty("user.dir")+img_file));
            }
          } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
          }
    }
    
    

    
    public boolean getColor() {
        return color;
    }
    
    public Image getImage() {
        return img;
    }
    
    public void draw(Graphics g, Square currentSquare) {
        int x = currentSquare.getX();
        int y = currentSquare.getY();
        
        g.drawImage(this.img, x, y, null);
    }
    
    
    // TO BE IMPLEMENTED!
    //return a list of every square that is "controlled" by this piece. A square is controlled
    //if the piece capture into it legally.
    public ArrayList<Square> getControlledSquares(Square[][] board, Square start) {
        return null;
    }
    

    //TO BE IMPLEMENTED!
    //implement the move function here
    //it's up to you how the piece moves, but at the very least the rules should be logical and it should never move off the board!
    //returns an arraylist of squares which are legal to move to
    //please note that your piece must have some sort of logic. Just being able to move to every square on the board is not
    //going to score any points.
    public ArrayList<Square> getLegalMoves(Board b, Square start){
        // b.getSquareArray() //gives the 2d board we made earlier
        // you are at coordinate start.getRow() start.getCol()
        // so check to see if your square is on the board and is not occupied by another piece. 
        ArrayList<Square> moves = new ArrayList<>();

        //loop for each direction we want to go in
        //right
        for(int col = start.getCol()+1; col<=7; col++){
            Square right = b.getSquareArray()[start.getRow()][col];
            if(!right.isOccupied() || right.getOccupyingPiece().getColor()!= color){
                
                moves.add(right);
                if(right.isOccupied()){
                    break;
                }
            }
            else{
                break;
            }
        }
        
        //left
        for(int col = start.getCol()-1; col>=0; col--){
            Square left = b.getSquareArray()[start.getRow()][col];
            if(!left.isOccupied() || left.getOccupyingPiece().getColor()!= color){
                moves.add(left);
                if(left.isOccupied()){
                    break;
                }
            }
            else{
                break;
            }
        }

        //top
        for(int row = start.getRow()+1; row<=7; row++){
            Square up = b.getSquareArray()[row][start.getCol()];
            if(!up.isOccupied() || up.getOccupyingPiece().getColor()!= color){
                moves.add(up);
                if(up.isOccupied()){
                    break;
                }
            }
            else{
                break;
            }
        }

        for(int row = start.getRow()-1; row>=0; row--){
            Square down = b.getSquareArray()[row][start.getCol()];
            if(!down.isOccupied() || down.getOccupyingPiece().getColor()!= color){
                moves.add(down);
                if(down.isOccupied()){
                    break;
                }
            }
            else{
                break;
            }
        }

    	return moves;
    }
}