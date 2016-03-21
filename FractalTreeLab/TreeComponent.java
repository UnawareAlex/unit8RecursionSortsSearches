//********************************************************************
//  KochPanel.java       Author: Lewis/Loftus/Cocking
//
//  Represents a drawing surface on which to paint a Koch Snowflake.
//********************************************************************

import java.awt.*;
import javax.swing.JPanel;
import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Double;
import java.awt.geom.Point2D;
import java.util.Scanner;


public class TreeComponent extends JPanel
{
   private final int PANEL_WIDTH = 800;
   private final int PANEL_HEIGHT = 800;

   private int current; //current order
   
   private double scalingFactor = .618; //how much smaller each consecutive branch will be
   
   private Point2D.Double startPoint; //starting position of branch
   
   private double branchAngle;

   //-----------------------------------------------------------------
   //  Sets the initial fractal order to the value specified.
   //-----------------------------------------------------------------
   public TreeComponent (int currentOrder)
   {
      current = currentOrder;
      startPoint = new Point2D.Double(400, 600);
      setBackground (Color.black);
      setPreferredSize (new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
      Scanner s = new Scanner(System.in);
      System.out.println("Would you like to choose a branching angle or use a random value? (choose/random) ");
      if (s.next().equals("choose"))
      {
          System.out.println("Please enter a value from 0-90");
          branchAngle = s.nextDouble();
      }
      else if (s.next().equals("random"))
      {
          branchAngle = Math.random() * 90 + 1;
          System.out.println("The random angle is " + branchAngle);
      }
      else
      {
          System.out.println("Default angle set to 42");
          branchAngle = 42;
      }
   }

   //-----------------------------------------------------------------
   //  Draws the fractal recursively. Base case is an order of 1 for
   //  which a simple straight line is drawn. Otherwise three
   //  intermediate points are computed, and each line segment is
   //  drawn as a fractal.
   //-----------------------------------------------------------------
   public void drawFractal (Graphics2D g2, Point2D.Double oldPoint, double length, double angle, int order)
   {
       Point2D.Double newPoint;
       //double branchAngle = 7; //specify branching angle
       //double branchAngle = Math.random() * 90 + 1; //set random angle
       if (order >= 13)
       {
           return; //end the recursive loop
       }
       else
       {
           //solve for new point
           newPoint = new Point2D.Double(oldPoint.getX()-(length*Math.sin(angle)), oldPoint.getY()-(length*Math.cos(angle)));
           //draw line between old and new point
           Line2D.Double newLine = new Line2D.Double(newPoint, oldPoint);
           g2.draw(newLine);
           //call method on new points
           drawFractal(g2, newPoint, length*scalingFactor, angle + branchAngle, order+1);
           drawFractal(g2, newPoint, length*scalingFactor, angle - branchAngle, order+1);
       }
   }

   //-----------------------------------------------------------------
   //  Performs the initial calls to the drawFractal method.
   //-----------------------------------------------------------------
   public void paintComponent (Graphics page)
   {
      Graphics2D g2 = (Graphics2D)page;
      super.paintComponent (g2);
      page.setColor(Color.green);
      drawFractal(g2, startPoint, 180, 0, 0);
   }

   //-----------------------------------------------------------------
   //  Sets the fractal order to the value specified.
   //-----------------------------------------------------------------
   public void setOrder (int order)
   {
      current = order;
   }

   //-----------------------------------------------------------------
   //  Returns the current order.
   //-----------------------------------------------------------------
   public int getOrder ()
   {
      return current;
   }
}
