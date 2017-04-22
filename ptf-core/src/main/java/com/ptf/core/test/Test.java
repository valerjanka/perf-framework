package com.ptf.core.test;

import com.ptf.core.test.thread.ThreadContext;

/**
 * @author valerjanka
 */
public interface Test {
    void init(ThreadContext threadContext);
    void beforeTest();
    void test();
    void afterTest();
}
