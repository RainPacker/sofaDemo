package com.springboot.threadLocal;

import com.springboot.threadLocal.ThreadLocalCleaner.CleanCallback;

public class AutoCleanThreadLocal<T> extends ThreadLocal<T> {
    public AutoCleanThreadLocal() {
        ThreadLocalCleaner.register(new CleanCallback() {
            public void clear() {
                AutoCleanThreadLocal.this.clean();
                AutoCleanThreadLocal.this.remove();
            }
        });
    }

    protected void clean() {
    }
}
