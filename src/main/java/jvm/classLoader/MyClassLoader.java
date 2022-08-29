package jvm.classLoader;

import java.io.*;

public class MyClassLoader extends ClassLoader {
    private File classPathFile;

    private ClassLoader jdkClassLoader;

    public MyClassLoader(ClassLoader parent) {
        super(null);
        String path = MyClassLoader.class.getResource("").getPath();
        this.classPathFile = new File(path);
    }

    //重写loadClass打破双亲委派模型
//    @Override
//    public Class<?> loadClass(String name) throws ClassNotFoundException {
//        Class result = null;
//        try {
//            //这里先使用jdkClassLoader来加载jdk自带的类
//            result = jdkClassLoader.loadClass(name);
//        } catch (Exception e) {
//            //忽略
//        }
//        if (result != null) {
//            return result;
//        }
//        // jdkClassLoader找不到类时，就自行加载
//        String className = MyClassLoader.class.getPackage().getName() + "." + name;
//        File classFile = new File(classPathFile, name.replace(".", "\\") + ".class");
////        String classPath = classPathMap.get(name);
////        File file = new File(classPath);
//        if (!classFile.exists()) {
//            throw new ClassNotFoundException();
//        }
//
//        byte[] classBytes = getClassData(classFile);
//        if (classBytes == null || classBytes.length == 0) {
//            throw new ClassNotFoundException();
//        }
//        return defineClass(classBytes, 0, classBytes.length);
//
//    }

    /**
     * 重写findClass不会打破双亲委派模型
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        String className = MyClassLoader.class.getPackage().getName() + "." + name;
        if (classPathFile != null) {
            //这里出现错误，classloader只能加载.class文件
            File classFile = new File(classPathFile, name.replace(".", "\\") + ".class");
            if (classFile.exists()) {
                try (FileInputStream in = new FileInputStream(classFile);
                     ByteArrayOutputStream out = new ByteArrayOutputStream()) {
                    byte[] bytes = new byte[1024];
                    int len;
                    while ((len = in.read(bytes)) != -1) {
                        out.write(bytes, 0, len);
                    }
                    return defineClass(className, out.toByteArray(), 0, out.size());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return super.findClass(name);
    }

    private byte[] getClassData(File file) {
        try (InputStream ins = new FileInputStream(file); ByteArrayOutputStream baos = new
                ByteArrayOutputStream()) {
            byte[] buffer = new byte[4096];
            int bytesNumRead = 0;
            while ((bytesNumRead = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesNumRead);
            }
            return baos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[]{};
    }

}
