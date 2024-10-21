import com.sun.opengl.util.FPSAnimator;
import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;
import javax.media.opengl.*;


/**
 * This is a basic JOGL app. Feel free to
 * reuse this code or modify it.
 */
public class CuteOwl extends JFrame {


    /**
     *
     */

    FPSAnimator animator=null;

    public static void main(String[] args) {
        CuteOwl app = new CuteOwl();
        app.animator.start();

        // show what we've done
/*    SwingUtilities.invokeLater (
      new Runnable() {
        public void run() {
          app.setVisible(true);
        }
      }
    );*/
    }


    public CuteOwl() {
        //set the JFrame title
        super("Cute Owl");


        //kill the process when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //only three JOGL lines of code ... and here they are
        GLCanvas glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(new SimpleGLEventListener());
        animator=new FPSAnimator(glcanvas,60);
        // add the GLCanvas just like we would	 any Component
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        setSize(600, 300);


        //center the JFrame on the screen
        centerWindow();
        setVisible(true);
    }


    public void centerWindow() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize  = this.getSize();


        if (frameSize.width  > screenSize.width ) frameSize.width  = screenSize.width;
        if (frameSize.height > screenSize.height) frameSize.height = screenSize.height;


        this.setLocation (
                (screenSize.width  - frameSize.width ) >> 1,
                (screenSize.height - frameSize.height) >> 1
        );
    }
}


/**
 * For our purposes only two of the
 * GLEventListeners matter. Those would
 * be init() and display().
 */

