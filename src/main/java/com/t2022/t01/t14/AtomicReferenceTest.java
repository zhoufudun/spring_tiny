package com.t2022.t01.t14;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {

    public static AtomicReference<User> atomicReference = new AtomicReference<>();

    public static void main(String[] args) {
        User user = new User("conan", 15);
        atomicReference.set(user);
        User updateUser = new User("hinichi", 17);

        atomicReference.compareAndSet(user, updateUser);
        System.out.println("原来用户名：" + user.getName() + " 更新后用户名 ：" + atomicReference.get().getName());
    }

    static class User {
        private String name;
        private int old;

        private User(String name, int old) {
            this.name = name;
            this.old = old;
        }

        public String getName() {
            return name;
        }

        public int getOld() {
            return old;
        }
    }
}
