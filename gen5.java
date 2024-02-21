import static utils.Utilities.writeFile;

import org.objectweb.asm.*;

/**
 * Gen 5 to create a Program 5.class that prints a string
 */
public class gen5 {

    /**
     * Main Method
     */
    public static void main(String[] args) {
        
        //Create a classwriter
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC,"program5", null, "java/lang/Object",null);

        //Empty constructor
        {

        }

        {

            MethodVisitor mv=cw.visitMethod(Opcodes.ACC_PUBLIC+Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
            mv.visitCode();

            //Writes string
            mv.visitLdcInsn((String)"Welcome to Compilers!");
            //Stores the string
            mv.visitVarInsn(Opcodes.ASTORE, 1);
            //Loads the string and then prints it
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ALOAD, 1);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false); 

            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0,0);
            mv.visitEnd();

        }

        //Ends
        cw.visitEnd();
        //Converts to an array 
        byte[] b = cw.toByteArray();
        //Writes a class file 
        writeFile(b, "program5.class");
        
        System.out.println("Done!");

    }
    
}
