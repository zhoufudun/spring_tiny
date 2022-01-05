package com.spring_101_200.test_191_200.test_199_jvm;


import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;

//可以用"*"支持所有的Annotations
@SupportedAnnotationTypes("*")
//只支持JDK 6的Java代码
@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class NameCheckProcessor extends AbstractProcessor {

    private com.spring_101_200.test_191_200.test_199_jvm.NameChecker nameChecker;

    /**
     * 初始化名称检查插件
     */
    public void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        nameChecker = new com.spring_101_200.test_191_200.test_199_jvm.NameChecker(processingEnv);
    }

    /**
     * 对输入的语法树的各个节点进行名称检查
     */
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (!roundEnv.processingOver()) {
            for (Element element : roundEnv.getRootElements())
                nameChecker.checkNames(element);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("");
    }
}
