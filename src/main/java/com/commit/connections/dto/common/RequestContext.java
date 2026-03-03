package com.commit.connections.dto.common;

import com.commit.connections.entity.User;

public class RequestContext {
    private static final ThreadLocal<CurrentUser> CTX = new ThreadLocal<>();

    public static void set(CurrentUser user) {
        CTX.set(user);
    }
    public static CurrentUser get() {
        return CTX.get();
    }
    public static void clear() {
        CTX.remove();
    }
}
