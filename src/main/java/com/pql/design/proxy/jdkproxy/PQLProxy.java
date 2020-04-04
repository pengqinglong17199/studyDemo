package com.pql.design.proxy.jdkproxy;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 生产源代码的工具类
 * */
public class PQLProxy {

    public static final String ln = "\r\n";

    public static Object newProxyInstance(PQLClassLoader classLoader, Class<?>[] interfaces, PQLInvocationHandler h){
        try{
            // 动态生成源代码 .java文件
            String src = generateSrc(interfaces);

            // java文件输出磁盘
            String filePath = PQLProxy.class.getResource("").getPath();
            File file = new File(filePath + "$Proxy0.java");
            FileWriter fw = new FileWriter(file);
            fw.write(src);
            fw.flush();
            fw.close();

            // 把生成的.java文件编译成.class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable<? extends JavaFileObject> iterable = manager.getJavaFileObjects(file);
            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
            task.call();
            manager.close();

            // 把编译的class文件加载到jvm中
            Class proxyClass = classLoader.findClass("$Proxy0");
            Constructor constructor = proxyClass.getConstructor(PQLInvocationHandler.class);
            file.delete();
            return constructor.newInstance(h);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private static String generateSrc(Class<?>[] interfaces){
        StringBuffer sb = new StringBuffer();
        sb.append("package ").append(PQLProxy.class.getPackage().getName() + ";" +ln);
        for (Class<?> clazz : interfaces){
            sb.append("import ")
              .append(clazz.getPackage().getName())
              .append(".")
              .append(clazz.getSimpleName()  + ";" + ln);
        }
        sb.append("import java.lang.reflect.*;" + ln);
        sb.append("public class $Proxy0 implements ");
        for (int i = 0; i < interfaces.length; i++) {
            sb.append(interfaces[i].getSimpleName());
            if(i > 0 && (i+1) < interfaces.length){
                sb.append(",");
            }else{
                sb.append("{").append(ln);
            }
        }
        sb.append("PQLInvocationHandler h;");
        sb.append("public $Proxy0 (PQLInvocationHandler h) {"+ln);
        sb.append("this.h = h;");
        sb.append("}" + ln);

        for (Class<?> interfaceClass : interfaces){
            for (Method method : interfaceClass.getMethods()) {
                Class<?>[] params = method.getParameterTypes();

                StringBuffer paramNames = new StringBuffer();
                StringBuffer paramValues = new StringBuffer();
                StringBuffer paramClasses = new StringBuffer();

                for (int i = 0; i < params.length; i++) {
                    Class<?> paramClass = params[i];
                    String type = paramClass.getName();
                    String paramName = toLowerFirstCase(paramClass.getSimpleName());
                    paramNames.append(type + " " + paramName);
                    paramValues.append(paramName);
                    paramClasses.append(paramClass.getName() + ".class");
                    if(i > 0 && i < params.length - 1){
                        paramNames.append(",");
                        paramValues.append(",");
                        paramClasses.append(",");
                    }
                }
                // 方法声明 public returnType methodName (Params params){
                sb.append("public ")
                  .append(method.getReturnType().getName())
                  .append(" ")
                  .append(method.getName())
                  .append(" (")
                  .append(paramNames.toString())
                  .append(") {")
                  .append(ln);
                // 方法第一句 try{
                sb.append("try{").append(ln);
                // Method m = interface.class.getName(method.getName(), new Class[]{paramClasses.toString()});
                sb.append("Method m = ")
                  .append(interfaceClass.getName())
                  .append(".class.getMethod(\"")
                  .append(method.getName())
                  .append("\", new Class[]{")
                  .append(paramClasses.toString())
                  .append("});")
                  .append(ln);
                // return this.h.invoke(this, m, new Object[]{}, returnType);
                sb.append((hasReturnValue(method.getReturnType())) ? "return " : "")
                  .append(getCaseCode("this.h.invoke(this, m, new Object[]{" + paramValues.toString() + "})", method.getReturnType()))
                  .append(";").append(ln);
                // }catch(Error e){
                // }catch(Throwable e){
                sb.append("}catch(Error e){}")
                  .append("catch(Throwable e){")
                  .append(ln);
                sb.append("throw new UndeclaredThrowableException(e);")
                  .append(ln);
                sb.append("}");
                sb.append(getReturnEmptyCode(method.getReturnType()));
                sb.append("}");
            }
        }
        sb.append("}").append(ln);
        return sb.toString();
    }

    private static Map<Class, Class> mappings = new HashMap<>();
    static {
        mappings.put(int.class, Integer.class);
    }

    private static String getReturnEmptyCode(Class<?> returnClass){
        if(mappings.containsKey(returnClass)){
            return "return 0;";
        }else if(returnClass == void.class){
            return "";
        }else{
            return "return null;";
        }
    }

    private static String getCaseCode(String code, Class<?> returnClass){
        if(mappings.containsKey(returnClass)){
            // ((Integer) this.h.invoke(this, m, new Object[]{})).intValue()
            return "((" + mappings.get(returnClass).getName() + ")" + code + ")." + returnClass.getSimpleName() + "Value()";
        }
        return code;
    }
    private static boolean hasReturnValue(Class<?> clazz){
        return clazz != void.class;
    }

    private static String toLowerFirstCase(String simpleName) {
        char[] chars = simpleName.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }
}
