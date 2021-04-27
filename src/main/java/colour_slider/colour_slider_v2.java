/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colour_slider;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author pengboxue
 */
public class colour_slider_v2 extends JFrame{
    JPanel topPanel, colourPanel, sliderPanel, textPanel;
    JPanel redPanel, greenPanel, bluePanel;
    JSlider redSlider, greenSlider, blueSlider;
    JLabel redLabel, greenLabel, blueLabel;
    int redValue, greenValue, blueValue;
    
    public static void main(String[] args)
    {
        ColourSlider app = new ColourSlider();
        app.setTitle("RGB Colour Code");
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(550, 450);
        app.setVisible(true);      
    }
    
    public colour_slider_v2()
    {
        // divide the main area into 2 equal parts
        
        // 2 rows, 1 column
        setLayout(new GridLayout(2,1,5,5));
        topPanel = new JPanel();
        sliderPanel = new JPanel();
        add(topPanel);
        add(sliderPanel);
        
        // colour area
        topPanel.setLayout(new BorderLayout(10,10));
        topPanel.setBorder(BorderFactory.createEmptyBorder(5,15,5,15));
        textPanel = new JPanel();
        textPanel.add(new JLabel("Move sliders to change the colour"));
        colourPanel = new JPanel();
        colourPanel.setBackground(new Color(100,0,191));
        topPanel.add(textPanel, BorderLayout.NORTH);
        topPanel.add(colourPanel, BorderLayout.CENTER);
        
        // slider area
        sliderPanel.setLayout(new GridLayout(3,1,5,5));
        sliderPanel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        redPanel = new JPanel();
        bluePanel = new JPanel();
        greenPanel = new JPanel();
        sliderPanel.add(redPanel);
        sliderPanel.add(greenPanel);
        sliderPanel.add(bluePanel);
        
        // red panel
        redPanel.setLayout(new BorderLayout());
        redPanel.setBackground(Color.WHITE);
        redPanel.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        redSlider = new JSlider(0,255,128); // min, max, initial
        redSlider.setMajorTickSpacing(50);
        redSlider.setMinorTickSpacing(10);
        redSlider.setPaintTicks(true);
        redLabel = new JLabel("128");
        redPanel.add(new JLabel("Red"),BorderLayout.WEST);
        redPanel.add(redSlider , BorderLayout.CENTER);
        redPanel.add(redLabel, BorderLayout.EAST);
        
         // green panel
        greenPanel.setLayout(new BorderLayout());
        greenPanel.setBackground(Color.WHITE);
        greenPanel.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        greenSlider = new JSlider(0,255,128); // min, max, initial
        greenSlider.setMajorTickSpacing(50);
        greenSlider.setMinorTickSpacing(10);
        greenSlider.setPaintTicks(true);
        greenLabel = new JLabel("128");
        greenPanel.add(new JLabel("green"),BorderLayout.WEST);
        greenPanel.add(greenSlider , BorderLayout.CENTER);
        greenPanel.add(greenLabel, BorderLayout.EAST);
        
        
        // blue panel
        bluePanel.setLayout(new BorderLayout());
        bluePanel.setBackground(Color.WHITE);
        bluePanel.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        blueSlider = new JSlider(0,255,128); // min, max, initial
        blueSlider.setMajorTickSpacing(50);
        blueSlider.setMinorTickSpacing(10);
        blueSlider.setPaintTicks(true);
        blueLabel = new JLabel("128");
        bluePanel.add(new JLabel("blue"),BorderLayout.WEST);
        bluePanel.add(blueSlider , BorderLayout.CENTER);
        bluePanel.add(blueLabel, BorderLayout.EAST);
        
        redSlider.addChangeListener(new SliderChanged());
        greenSlider.addChangeListener(new SliderChanged());
        blueSlider.addChangeListener(new SliderChanged());
        
        
    }
    
    //inner class  
    
    class SliderChanged implements ChangeListener{
        int r, g, b;
        
        public SliderChanged (){}
        
        public void stateChanged (ChangeEvent e){


            r = redSlider.getValue();
            redLabel.setText(r + "");
            g = greenSlider.getValue();
            greenLabel.setText(g + "");
            b = blueSlider.getValue();
            blueLabel.setText(b + "");

            colourPanel.setBackground(new Color(r, g, b));
        }
    }
}
