package base.javassist;

import javassist.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.HashMap;

public class ModifyStringClass extends ClassLoader {
    private final String classToOverride;
    private final String customClassLocation;

    public ModifyStringClass(String classToOverride, String customClassLocation) {
        this.classToOverride = classToOverride;
        this.customClassLocation = customClassLocation;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        if (name.equals(classToOverride)) {
            try {
                byte[] classBytes = loadClassBytes(name);
                return defineClass(name, classBytes, 0, classBytes.length);
            } catch (Exception e) {
                e.printStackTrace();
                throw new ClassNotFoundException(name);
            }
        }
        return super.findClass(name);
    }

    private byte[] loadClassBytes(String name) throws Exception {
        File file = new File(customClassLocation, name.replace('.', '/') + ".class");
        try (FileInputStream fis = new FileInputStream(file);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, length);
            }
            return baos.toByteArray();
        }
    }

    public static void main(String[] args) throws Exception {
        ModifyStringClass classLoader = new ModifyStringClass("java.lang.String", "path/to/custom/classes");
        Class<?> clazz = classLoader.findClass("java.lang.String");
        Object stringInstance = clazz.newInstance();
        Method method = clazz.getDeclaredMethod("toString");
        method.setAccessible(true);
        Object result = method.invoke(stringInstance);
        System.out.println(result);
    }
}
