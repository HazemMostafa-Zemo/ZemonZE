
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;

/**
 *
 * @author dell
 */
class SimpleGLEventListener implements GLEventListener {

    /**
     * Take care of initialization here.
     */
    @Override
    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();

        gl.glClearColor(ToRGB(135), ToRGB(206), ToRGB(234), 1.0f);

        gl.glViewport(0, 0, 600, 300);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(0.0, 600.0, 0.0, 300.0, -1.0, 1.0);
    }



    /**
     * Take care of drawing here.
     */
    @Override
    public void display(GLAutoDrawable drawable) {

        GL gl = drawable.getGL();

        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
//
//		gl.glPointSize(73.0f);
//
//		gl.glColor3f(1.0f, 0.0f, 0.0f);
//
//		gl.glBegin(GL.GL_POINTS);
//		gl.glVertex2i ( 300,150);
//		gl.glEnd();
//
//                gl.glPointSize(33.0f);
//
//		gl.glColor3f(0.0f, 1.0f, 0.0f);
//
//		gl.glBegin(GL.GL_POINTS);
//		gl.glVertex2i ( 200,150);
//		gl.glEnd();
//
//		gl.glColor3f(0.0f, 0.0f, 1.0f);
//
//		gl.glBegin(GL.GL_POINTS);
//		gl.glVertex2i ( 400,150);
//		gl.glEnd();

//                 gl.glBegin(GL.GL_POLYGON);
//                    gl.glColor3f(1.0f,1.0f,1.0f);
//                    gl.glVertex2i(0,150);
//                    gl.glVertex2i(600,150);
//                    gl.glVertex2i(600,230);
//                    gl.glVertex2i(0,230);
//                    gl.glEnd();
//                    //-----
//         gl.glBegin(GL.GL_POLYGON);
//        gl.glColor3f(0.2980f,0.6784f,0.1843f);
//        gl.glVertex2i(0,75);
//        gl.glVertex2i(600,75);
//        gl.glVertex2i(600,150);
//        gl.glVertex2i(0,150);
//        gl.glEnd();
//        //=------
//        gl.glBegin(GL.GL_TRIANGLES);
//        gl.glColor3f(1.0f,0.0f,0.0f);
//        gl.glVertex2i(0,300);
//        gl.glVertex2i(150,200);
//        gl.glVertex2i(0,75);
//        gl.glEnd();


//
//        /////
//        gl.glBegin(GL.GL_TRIANGLES);
//        gl.glColor3f((180f/255f),(191f/255f),(37f/255f));
//        gl.glVertex2i(350,0);
//        gl.glVertex2i(580,0);
//        gl.glVertex2i(465,150);
//        gl.glEnd();
//        ////-----
//        gl.glBegin(GL.GL_TRIANGLES);
//        gl.glColor3f((190f/255f),(200f/255f),(38f/255f));
//        gl.glVertex2i(250,0);
//        gl.glVertex2i(500,0);
//        gl.glVertex2i(368,200);
//        gl.glEnd();
//        //-----
//        gl.glBegin(GL.GL_TRIANGLES);
//        gl.glColor3f((204f/255f),(212f/255f),(42f/255f));
//        gl.glVertex2i(80,0);
//        gl.glVertex2i(400,0);
//        gl.glVertex2i(240,250);
//        gl.glEnd();
//


//        gl.glColor3f(1.0f, 1.0f, 0.0f);
//        double radius=42;
//        double ONE_DEGREE=(Math.PI/180);
//        double THREE_SIXTY=2*Math.PI;
//        gl.glBegin(GL.GL_POLYGON);
//        for (double a=0;a<THREE_SIXTY;a+=ONE_DEGREE){
//            int x=(int)(radius*Math.cos(a))+550;
//            int y=(int)(radius*Math.sin(a))+241;
//            gl.glVertex2d(x,y);
//        }
//        gl.glEnd();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);


        //Water
        gl.glColor3f(ToRGB(1), ToRGB(100), ToRGB(202));
        gl.glBegin(GL.GL_POLYGON);
        int x = 0, y = 0;
        gl.glVertex2i(x, y);
        gl.glVertex2i(x + 600, y);
        gl.glVertex2i(x + 600, y + 150);
        gl.glVertex2i(x, y + 150);
        gl.glEnd();

        //---------------------

        //Waves {
            //Wave 1
        gl.glColor3f(1f, 1f, 1f);
        gl.glBegin(GL.GL_POINTS);
        for (x = 0; x < 600; x += 1)
            gl.glVertex2d(x, (Math.sin(x / 18.0) * 8.4) + 125);

        gl.glEnd();


        //Wave 2
        gl.glColor3f(1f, 1f, 1f);
        gl.glBegin(GL.GL_POINTS);
        for (x = 0; x < 600; x += 1)
            gl.glVertex2d(x, (Math.sin(x / 18.0) * 8.4) + 95);

        gl.glEnd();


        //Wave 3
        gl.glColor3f(1f, 1f, 1f);
        gl.glBegin(GL.GL_POINTS);
        for (x = 0; x < 600; x += 1)
            gl.glVertex2d(x, (Math.sin(x / 18.0) * 8.4) + 66);

        gl.glEnd();


        //Wave 4
        gl.glColor3f(1f, 1f, 1f);
        gl.glBegin(GL.GL_POINTS);
        for (x = 0; x < 600; x += 1)
            gl.glVertex2d(x, (Math.sin(x / 18.0) * 8.4) + 32);

        gl.glEnd();


        //Wave 5
        gl.glColor3f(1f, 1f, 1f);
        gl.glBegin(GL.GL_POINTS);
        for (x = 0; x < 600; x += 1)
            gl.glVertex2d(x, (Math.sin(x / 18.0) * 8.4)+9);

        gl.glEnd();
            // }

        //Boat
        gl.glColor3f(ToRGB(153),ToRGB(75),ToRGB(26));
        gl.glBegin(GL.GL_POLYGON);
        int i=184;
        int j=124;
        gl.glVertex2i(i,j);
        gl.glVertex2i(i+225,j);
        gl.glVertex2i(i+250,j+26);
        gl.glVertex2i(i-25,j+26);
        gl.glEnd();



        //Boat Pillar
        gl.glColor3f(ToRGB(102),ToRGB(50),ToRGB(0));
        gl.glBegin(GL.GL_POLYGON);
        int w=280;
        int h=150;
        gl.glVertex2i(w,h);
        gl.glVertex2i(w+40,h);
        gl.glVertex2i(w+40,h+100);
        gl.glVertex2i(w,h+100);
        gl.glEnd();


        //Boat's Sail
        gl.glColor3f(1f,1f,1f);
        gl.glBegin(GL.GL_TRIANGLES);
        i=288;
        j=150;
        gl.glVertex2i(i,j);
        gl.glVertex2i(420,j);
        gl.glVertex2i(i,j+100);
        gl.glEnd();

        // Wood
        gl.glColor3f(ToRGB(204),ToRGB(126),ToRGB(51));
        gl.glBegin(GL.GL_POLYGON);
        i=167;
        j=150;
        gl.glVertex2i(i,j);
        gl.glVertex2i(425,j);
        gl.glVertex2i(425,j+10);
        gl.glVertex2i(i,j+10);
        gl.glEnd();
    }


    /**
     * Called when the GLDrawable (GLCanvas
     * or GLJPanel) has changed in size. We
     * won't need this, but you may eventually
     * need it -- just not yet.
     */
    @Override
    public void reshape(
            GLAutoDrawable drawable,
            int x,
            int y,
            int width,
            int height
    ) {}

    /**
     * If the display depth is changed while the
     * program is running this method is called.
     * Nowadays this doesn't happen much, unless
     * a programmer has his program do it.
     */
    @Override
    public void displayChanged(
            GLAutoDrawable drawable,
            boolean modeChanged,
            boolean deviceChanged
    ) {}


    public void dispose(GLAutoDrawable arg0) {
        // TODO Auto-generated method stub

    }
    public float ToRGB(float x){
        return (x/255f);
    }

}
