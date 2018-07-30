package category.start;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	private static boolean running=true;
	
	public static void main(String[] args){
		final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {
                "classpath:spring-context.xml"
        });
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                context.stop();
                System.out.println("dubbo service has stop");
                synchronized (Main.class) {
                    running = false;
                    Main.class.notify();
                }
            }
        });
        context.start();
        System.out.println("dubbo service has start");
        synchronized (Main.class) {
            while (running) {
                try {
                    Main.class.wait();
                } catch (Throwable e) {
                	context.close();
                }
            }
        }
	}
	
}
