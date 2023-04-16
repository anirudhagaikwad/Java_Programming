package PPT21;
/* java program for ilustrating multiple threads
can execute the same method but in
synchronized way.
 */

class Line_
{
    // if multiple threads(trains) trying to access
    // this synchronized method on the same Object
    // but only one thread will be able
    // to execute it at a time.
    synchronized public void getLine()
    {
        for (int i = 0; i < 3; i++)
        {
            System.out.println(i);
            try
            {
                Thread.sleep(400);
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
    }
}

class Train_ extends Thread
{
    // Reference variable of type Line.
    Line_ line;

    Train_(Line_ line)
    {
        this.line = line;
    }

    @Override
    public void run()
    {
        line.getLine();
    }
}

class JavaProgram13
{
    public static void main(String[] args)
    {
        Line_ obj = new Line_();

        // we are creating two threads which share
        // same Object.
        Train_ train1 = new Train_(obj);
        Train_ train2 = new Train_(obj);

        // both threads start executing .
        train1.start();
        train2.start();
    }
}

