package com.spring_101_200.test_191_200.test_199_jvm;

/**
 * 此代码演示了两点
 * 1. 对象可以被GC时自我拯救
 * 2.这种自救只有一次机会，因为一个对象的finalize()方法最多只会被系统自动调用一次
 */
public class FinalizeEscapeGC {
    public  static  FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive(){
        System.out.println("yes ,i am still alive : ");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed !");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }


    public static void main(String[] args)  throws  Throwable{
        SAVE_HOOK = new FinalizeEscapeGC();
        //对象第一次成功的拯救自己
        SAVE_HOOK = null;
        System.gc();
        // 因为Finalizer方法优先级很低，暂停0.5秒，等待它
        Thread.sleep(500);
        if(SAVE_HOOK !=null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("no ,i am dead :(");
        }
        //下面的代码与上面的代码完全相同，但是这次自救失败了
        //对象第一次成功的拯救自己
        SAVE_HOOK = null;
        System.gc();
        // 因为Finalizer方法优先级很低，暂停0.5秒，等待它
        Thread.sleep(500);
        if(SAVE_HOOK !=null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("no ,i am dead :(");
        }

    }
}
