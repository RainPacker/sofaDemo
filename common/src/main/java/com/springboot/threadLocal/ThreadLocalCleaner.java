package com.springboot.threadLocal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ThreadLocalCleaner {
    private static List<ThreadLocalCleaner.CleanCallback> callbacks = new ArrayList();

    public ThreadLocalCleaner() {
    }

    public static void clear() {
        Iterator i$ = callbacks.iterator();

        while(i$.hasNext()) {
            ThreadLocalCleaner.CleanCallback callback = (ThreadLocalCleaner.CleanCallback)i$.next();
            callback.clear();
        }

    }

    public static void register(final ThreadLocal<?> tl) {
        callbacks.add(new ThreadLocalCleaner.CleanCallback() {
            public void clear() {
                tl.remove();
            }
        });
    }

    public static void register(ThreadLocalCleaner.CleanCallback cleanCallback) {
        callbacks.add(cleanCallback);
    }

    public interface CleanCallback {
        void clear();
    }
}