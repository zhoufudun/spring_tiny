package com.spring_101_200.test_111_120.test_117_excution.pointtest;



import java.util.Iterator;

public  class MyResolvedType {


    public static void main(String[] args) {
        MyResolvedType myResolvedType = new MyResolvedType();
        myResolvedType.findPointcut("aaaaaaa");
    }


    private final static MyResolvedType.MyPointcutGetter PointcutGetterInstance = new MyResolvedType.MyPointcutGetter();

    private static class MyPointcutGetter implements MyIterators.MyGetter<MyResolvedType, MyResolvedMember> {
        public Iterator<MyResolvedMember> get(MyResolvedType o) {
            return MyIterators.array(o.getDeclaredPointcuts());
        }
    }

    public Iterator<MyResolvedMember> getPointcuts() {
        final MyIterators.MyFilter<MyResolvedType> dupFilter = MyIterators.dupFilter();
        // same order as fields
        MyIterators.MyGetter<MyResolvedType, MyResolvedType> typeGetter = new MyIterators.MyGetter<MyResolvedType, MyResolvedType>() {
            public Iterator<MyResolvedType> get(MyResolvedType o) {
                return dupFilter.filter(o.getDirectSupertypes());
            }
        };
        return MyIterators.mapOver(MyIterators.recur(this, typeGetter), PointcutGetterInstance);
    }

    public void findPointcut(String name) {
        for (Iterator<MyResolvedMember> i = getPointcuts(); i.hasNext(); ) {
             i.next();
        }
    }



    public final Iterator<MyResolvedType> getDirectSupertypes() {
        Iterator<MyResolvedType> interfacesIterator = MyIterators.array(getDeclaredInterfaces());
        MyResolvedType superclass = getSuperclass();
        if (superclass == null) {
            return interfacesIterator;
        } else {
            return MyIterators.snoc(interfacesIterator, superclass);
        }
    }

    public MyResolvedType getSuperclass(){
        System.out.println("-getSuperclass---");
        return null;
    }

    public  MyResolvedType[] getDeclaredInterfaces(){
        System.out.println("-getDeclaredInterfaces---");
        return null;
    }

    public  MyResolvedMember[] getDeclaredPointcuts(){
        System.out.println("-getDeclaredPointcuts---");
        return null;
    }


}
