package ro.itschool.project.utils.multithreading;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLifecycle extends Thread{

    @Override
    public void run() {
        log.info("The thread is running and going to sleep for 2 seconds");
        try {
            Thread.sleep(2000);
            log.info("The thread is not sleeping anymore");
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }

    public static void main(String[] args) {
        ThreadLifecycle thread = new ThreadLifecycle();
        log.info("Thread state after creation: "+ thread.getState());

        thread.start();
        log.info("Thread state after it was created: "+thread.getState());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("Thread state is on sleep: "+thread.getState());
    }
}
