//package javaTest.annotationTest;
//
//import javax.annotation.processing.AbstractProcessor;
//import javax.annotation.processing.RoundEnvironment;
//import javax.annotation.processing.SupportedAnnotationTypes;
//import javax.lang.model.element.Element;
//import javax.lang.model.element.TypeElement;
//import javax.tools.JavaFileObject;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.lang.annotation.Annotation;
//import java.util.Set;
//
//@SupportedAnnotationTypes("javaTest.annotationTest.annotation1")
//public class Annotation1Handle extends AbstractProcessor {
//    /**
//     * {@inheritDoc}
//     *
//     * @param annotations
//     * @param roundEnv
//     */
//    @Override
//    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
//        try {
//            JavaFileObject sourceFile = processingEnv.getFiler().createSourceFile("javaTest.annotationTest.handle");
//            try (PrintWriter out = new PrintWriter(sourceFile.openWriter())){
//                for (Element e:roundEnv.getElementsAnnotatedWith((Class<? extends Annotation>) handleClass.class)){
//                    if(e instanceof  TypeElement){
//                        TypeElement te = (TypeElement) e;
//                        Annotation1Handle.method();
//                    }
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return true;
//    }
//
//    static void method() {
//
//    }
//}
