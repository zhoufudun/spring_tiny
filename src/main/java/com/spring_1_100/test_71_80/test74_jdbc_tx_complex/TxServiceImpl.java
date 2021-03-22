package com.spring_1_100.test_71_80.test74_jdbc_tx_complex;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class TxServiceImpl implements TxService {

    private UserService userService;


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUser() {


        User user1 = userService.selectById(456l);
        user1.setUsername("123");
        userService.updateById(user1);
        int i = 0 ;
        int j = 0;
        int c = i / j ;

        User user2 = userService.selectById(457l);
        user2.setUsername("456");
        userService.updateById(user2);
    }




    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateUserRequiresNewTest1(){
        User user1 = userService.selectById(456l);
        user1.setUsername("123");
        userService.updateById(user1);
        userService.updateUserRequiresNew1();
    }






    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateUserRequiresNewTest2(){
        User user1 = userService.selectById(456l);
        user1.setUsername("123");
        userService.updateById(user1);
        userService.updateUserRequiresNew2();
        int i = 0 ;
        int j = 0;
        int c = i / j ;
    }


    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUserRequiresTest1(){
        User user1 = userService.selectById(456l);
        user1.setUsername("123");
        userService.updateById(user1);
        userService.updateUserRequires1();
    }


    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUserRequiresTest2(){
        User user1 = userService.selectById(456l);
        user1.setUsername("123");
        userService.updateById(user1);
        userService.updateUserRequires2();
        int i = 0 ;
        int j = 0;
        int c = i / j ;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateUserRequiresNewTest22() {
        User user1 = userService.selectById(456l);
        user1.setUsername("123");
        userService.updateById(user1);
        userService.updateUserRequiresNew2();
        int i = 0 ;
        int j = 0;
        int c = i / j ;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateUserRequiresNewTest222() {
        User user1 = userService.selectById(458l);
        user1.setUsername("789");
        userService.updateById(user1);

        userService.updateUserRequiresNew33();
        userService.updateUserRequiresNew1();

    }


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateUserRequiresNewTest3(){
        User user1 = userService.selectById(456l);
        user1.setUsername("123");
        userService.updateById(user1);
        userService.updateUserRequires();
        int i = 0 ;
        int j = 0;
        int c = i / j ;
    }


    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUserRequiresNewTest4(){
        User user1 = userService.selectById(456l);
        user1.setUsername("123");
        userService.updateById(user1);
        userService.updateUserRequiresNew1();
    }


    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUserRequiresNewTest5(){
        User user1 = userService.selectById(456l);
        user1.setUsername("123");
        userService.updateById(user1);
        userService.updateUserSupports();
        int i = 0 ;
        int j = 0;
        int c = i / j ;
    }



    public void updateUserRequiresNewTest6(){
        User user1 = userService.selectById(456l);
        user1.setUsername("123");
        userService.updateById(user1);
        userService.updateUserSupports();
        int i = 0 ;
        int j = 0;
        int c = i / j ;
    }


    public void updateUserRequiresNewTest7(){
        User user1 = userService.selectById(456l);
        user1.setUsername("123");
        userService.updateById(user1);
        userService.updateUserSupportsException();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUserRequiresNewTest8(){
        User user1 = userService.selectById(456l);
        user1.setUsername("123");
        userService.updateById(user1);
        userService.updateUserSupportsException();
    }


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateUserRequiresNewTest9(){
        User user1 = userService.selectById(456l);
        user1.setUsername("123");
        userService.updateById(user1);
        userService.updateUserSupportsException();
    }



    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUserRequiresNewTest10(){
        User user1 = userService.selectById(456l);
        user1.setUsername("123");
        userService.updateById(user1);
        userService.updateUserSupportsException();
    }


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateUserRequiresNewTest11(){
        User user1 = userService.selectById(456l);
        user1.setUsername("123");
        userService.updateById(user1);
        userService.updateUserMandatory();
    }


    public void updateUserRequiresNewTest12(){
        User user1 = userService.selectById(456l);
        user1.setUsername("123");
        userService.updateById(user1);
        userService.updateUserMandatory();
    }

    public void updateUserRequiresNewTest13(){
        userService.updateUserRequire123();
        userService.updateUserMandatory();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateUserRequiresNewTest14() {
        User user1 = userService.selectById(456l);
        user1.setUsername("123");
        userService.updateById(user1);
        userService.updateUserNotSupportException();
    }

    @Override
    public void updateUserRequiresNewTest15() {
        User user1 = userService.selectById(456l);
        user1.setUsername("123");
        userService.updateById(user1);
        userService.updateUserNotSupportException();
    }



    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateUserRequiresNewTest144() {
        User user1 = userService.selectById(456l);
        user1.setUsername("123huikaiming");
        userService.updateById(user1);
        userService.updateUserNotSupportException123();
    }


    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateUserRequiresNewTest16() {
        User user1 = userService.selectById(456l);
        user1.setUsername("123");
        userService.updateById(user1);

        userService.updateUserNever();
    }



    @Transactional(propagation = Propagation.NEVER)
    @Override
    public void updateUserRequiresNewTest17() {
        User user1 = userService.selectById(456l);
        user1.setUsername("123");
        userService.updateById(user1);
        userService.updateUserRequires2();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateUserRequiresNewTest18()  {
        User user1 = userService.selectById(456l);
        user1.setUsername("123");
        userService.updateById(user1);
        try {
            userService.updateUserNested2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateUserRequiresNewTest19() {
        try {
            User user1 = userService.selectById(456l);
            user1.setUsername("123");
            userService.updateById(user1);
            System.out.println("====================================");
            User user2 = userService.selectById(457l);
            user2.setUsername("456");
            userService.updateById(user2);

            int i = 0;
            int j = 0;
            int c = i / j;


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateUserRequiresNewTest20() {
        try {
            User user1 = userService.selectById(456l);
            user1.setUsername("123");
            userService.updateById(user1);
            System.out.println("====================================");
            userService.updateUserRequireThrowException3();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateUserRequiresNewTest21() {
        try {
            User user1 = userService.selectById(456l);
            user1.setUsername("123");
            userService.updateById(user1);
            System.out.println("====================================");
            userService.updateUserRequireThrowException2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateUserRequiresNewTest2222() {
        try {
            User user1 = userService.selectById(456l);
            user1.setUsername("123");
            userService.updateById(user1);
            System.out.println("====================================");
            userService.updateUserRequireThrowException4();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void requiredTest() {
        User user1 = userService.selectById(456l);
        user1.setUsername("123");
        userService.updateById(user1);

        userService.updateUserRequired();
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
