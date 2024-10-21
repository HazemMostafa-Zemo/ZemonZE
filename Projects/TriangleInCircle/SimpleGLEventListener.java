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

        gl.glClearColor(0, 0, 0, 1.0f);

        gl.glViewport(0, 0, 600, 300);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(-600, 600.0, -300, 300.0, -1.0, 1.0);
    }

    double x=0;
    double y=0;
    double Vx=3;

    double Vy=2;

    double rotate=0;

    public void display(GLAutoDrawable drawable) {

        GL gl = drawable.getGL();
    drawGraph(gl);
//Animate
    gl.glPushMatrix();

    gl.glTranslated(x+=Vx,y+=Vy,0);
        gl.glRotated(rotate++,0,0,1);
    TriangleCircle(gl);
    gl.glPopMatrix();

    if(x-90 <= -600 || x+90 >= 600){
        Vx=-1*Vx;
    }
    if(y-90 <= -300 || y+90 >= 300){
        Vy=-1*Vy;
    }







    }

    @Override
    public void reshape(
            GLAutoDrawable drawable,
            int x,
            int y,
            int width,
            int height
    ) {
    }

    @Override
    public void displayChanged(
            GLAutoDrawable drawable,
            boolean modeChanged,
            boolean deviceChanged
    ) {
    }

    public void dispose(GLAutoDrawable arg0) {
        // TODO Auto-generated method stub

    }

    public float ToRGB(float x) {
        return (x / 255f);
    }

    public void Circle(float red, float green, float blue, double r, int i, int j, GLAutoDrawable drawable) {
        GL gl = drawable.getGL();

        gl.glColor3f(ToRGB(red), ToRGB(green), ToRGB(blue));
        final double ONE_DEGREE = (Math.PI / 180);
        final double THREE_SIXTY = 2 * Math.PI;
        double x, y;
        double radius = r;
        gl.glBegin(GL.GL_POLYGON);
        for (double a = 0; a < THREE_SIXTY; a += ONE_DEGREE) {
            x = radius * (Math.cos(a)) + i;
            y = radius * (Math.sin(a)) + j;
            gl.glVertex2d(x, y);
        }
        gl.glEnd();
    }

    public void drawGraph(GL gl) {
        float red;
        float green;
        float blue;
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        ////////////////////
        //drawing the grid
        red = 0.2f;
        green = 0.2f;
        blue = 0.2f;
        gl.glColor3f(red, green, blue);
        //You may notice I'm using GL_LINES here.
        //Details of glBegin() will be discussed latter.
        gl.glBegin(GL.GL_LINES);
        //draw the vertical lines
        for (int x = -600; x <= 600; x += 10) {
            gl.glVertex2d(x, -300);
            gl.glVertex2d(x, 300);
        }
        //draw the horizontal lines
        for (int y = -300; y <= 300; y += 10) {
            gl.glVertex2d(-600, y);
            gl.glVertex2d(600, y);
        }
        gl.glEnd();
        //////////////////////////////
// draw the x-axis and y-axis
        red = 0.0f;
        green = 0.2f;
        blue = 0.4f;
        gl.glColor3f(red, green, blue);
        gl.glBegin(GL.GL_LINES);
//line for y-axis
        gl.glVertex2d(0, 140*2);
        gl.glVertex2d(0, -140*2);
//line for x-axis
        gl.glVertex2d(240*(2.4), 0);
        gl.glVertex2d(-240*(2.4), 0);
        gl.glEnd();
/////////////////////
// draw arrow heads
        gl.glBegin(GL.GL_TRIANGLES);
        gl.glVertex2d( 0, 150*2);
        gl.glVertex2d(-5*(2.4), 140*2);
        gl.glVertex2d( 5*(2.4), 140*2);
        gl.glVertex2d( 0, -150*2);
        gl.glVertex2d(-5*(2.4), -140*2);
        gl.glVertex2d( 5*(2.4), -140*2);
        gl.glVertex2d(250*(2.4), 0);
        gl.glVertex2d(240*(2.4),-5*2);
        gl.glVertex2d(240*(2.4), 5*2);
        gl.glVertex2d(-250*(2.4), 0);
        gl.glVertex2d(-240*(2.4),-5*2);
        gl.glVertex2d(-240*(2.4), 5*2);
        gl.glEnd();
    }


    public void TriangleCircle(GL gl){
        //Circle
        final double ONE_DEGREE = (Math.PI / 180);
        final double THREE_SIXTY = 2 * Math.PI;
        double x, y;
        double radius = 90;
        gl.glBegin(GL.GL_LINE_STRIP);
        gl.glColor3f(1,1,0);
        // angle is
        // x = radius * (cosine of angle)
        // y = radius * (sine of angle)
        for (double a=0; a<THREE_SIXTY; a+=ONE_DEGREE) {
            x = radius * (Math.cos(a));
            y = radius * (Math.sin(a));
            gl.glVertex2d(x, y);
        }
        gl.glEnd();


        //Triangle
        gl.glBegin(GL.GL_TRIANGLES);

        gl.glVertex2i(80,-40);
        gl.glVertex2i(-80,-40);
        gl.glVertex2i(0,90);

        gl.glEnd();

    }
}