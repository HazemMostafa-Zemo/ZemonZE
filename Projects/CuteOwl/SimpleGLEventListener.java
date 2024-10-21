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

        gl.glClearColor(255f, 0.0f, 255f, 1.0f);

        gl.glViewport(0, 0, 600, 300);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(-600, 600.0, -300, 300.0, -1.0, 1.0);
    }


    double V_RedBall=0;
    double V_eye1=0;
    double V_eye2=0;
    public void display(GLAutoDrawable drawable) {

        GL gl = drawable.getGL();

        Background(gl);
        drawOwl(gl);


        Eyes(gl);



        /////////////
        gl.glPushMatrix();
        gl.glTranslated(V_RedBall+=5.2,0,0);
        RedBall(gl);
        gl.glPopMatrix();

        if(V_RedBall>1200){
            V_RedBall=0;
            V_eye1=0;
            V_eye2=0;
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

    public void Circle(float red, float green, float blue, double r, int i, int j, GL gl) {

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

    public void Background(GL gl){
        gl.glColor3f(1f,0,1f);
        gl.glBegin(GL.GL_POLYGON);

        gl.glVertex2i(-600,-300);
        gl.glVertex2i(600,-300);
        gl.glVertex2i(600,300);
        gl.glVertex2i(-600,300);

        gl.glEnd();
    }

    public void drawOwl(GL gl) {

        gl.glColor3f(1,1,0);
        gl.glBegin(GL.GL_TRIANGLES);

        gl.glVertex2i(-40+10,60-10);
        gl.glVertex2i(40+10,60-10);
        gl.glVertex2i(10,-20-10);

        gl.glEnd();

        Circle(255f,255f,255f,100,-50,100,gl);
        Circle(255f,255f,255f,100,-50+120,100,gl);
    }
    public void Eyes(GL gl){
        gl.glPushMatrix();



        gl.glTranslated(-50,100,0);
        gl.glRotated(V_eye1+=0.6,0,0,1);
        Circle(0,0,0,30,-70+30,0,gl);
        gl.glPopMatrix();


        gl.glPushMatrix();

        gl.glTranslated(-50+120,100,0);
        gl.glRotated(V_eye2+=0.65,0,0,1);
        Circle(0,0,50,30,-70+30,0,gl);

        gl.glPopMatrix();

    }
    public void RedBall(GL gl){
        Circle(255,0,0,15,-600+15,-300+15,gl);
    }
}