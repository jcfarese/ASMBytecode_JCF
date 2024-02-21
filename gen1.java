import static utils.Utilities.writeFile;

import org.objectweb.asm.*;

/**
 * Gen 1 to create a Program 1.class that multiplies numbers together
 */

public class gen1 {

    /**
     * Main Method
     */

    public static void main(String[] args) {

        //Creates a classwriter
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC,"program1", null, "java/lang/Object",null);
        
        //Empty constructor 
        {
			
		}

        {
            MethodVisitor mv=cw.visitMethod(Opcodes.ACC_PUBLIC+Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
            mv.visitCode();

            //Creates steps to multiply integers and print the results
            mv.visitLdcInsn((Integer)15);
            mv.visitVarInsn(Opcodes.ISTORE,1);
            mv.visitLdcInsn((Integer)20);
            mv.visitVarInsn(Opcodes.ISTORE,2);
            mv.visitVarInsn(Opcodes.ILOAD,1);
            mv.visitVarInsn(Opcodes.ILOAD,2);
            mv.visitInsn(Opcodes.IMUL);
            mv.visitVarInsn(Opcodes.ISTORE,3);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ILOAD, 3);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
            
            //
            //Creates steps to multiply floats and print the results
            mv.visitLdcInsn((Float)21.127f);
            mv.visitVarInsn(Opcodes.FSTORE,4);
            mv.visitLdcInsn((Float)20.456f);
            mv.visitVarInsn(Opcodes.FSTORE,5);
            mv.visitVarInsn(Opcodes.FLOAD,4);
            mv.visitVarInsn(Opcodes.FLOAD,5);
            mv.visitInsn(Opcodes.FMUL);
            mv.visitVarInsn(Opcodes.FSTORE,6);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.FLOAD, 6);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(F)V", false);


            //Creates steps to multiply doubles and print the results
            mv.visitLdcInsn((Double)173.43);
            mv.visitVarInsn(Opcodes.DSTORE,7);
            mv.visitLdcInsn((Double)45.56);
            mv.visitVarInsn(Opcodes.DSTORE,9);
            mv.visitVarInsn(Opcodes.DLOAD,7);
            mv.visitVarInsn(Opcodes.DLOAD,9);
            mv.visitInsn(Opcodes.DMUL);
            mv.visitVarInsn(Opcodes.DSTORE,11);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.DLOAD, 11);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(D)V", false);


            //Creates steps to multiply longs and print the results
            mv.visitLdcInsn((Long)123456789000l);
            mv.visitVarInsn(Opcodes.LSTORE,13);
            mv.visitLdcInsn((Long)1139453935858433l);
            mv.visitVarInsn(Opcodes.LSTORE,15);
            mv.visitVarInsn(Opcodes.LLOAD,13);
            mv.visitVarInsn(Opcodes.LLOAD,15);
            mv.visitInsn(Opcodes.LMUL);
            mv.visitVarInsn(Opcodes.LSTORE,17);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.LLOAD, 17);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V", false);
            
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0,0);
            mv.visitEnd();
        }

        //Ends
        cw.visitEnd();
        //Converts to an array
        byte[] b = cw.toByteArray();
        //Writes a class file
        writeFile(b, "program1.class");
        
        System.out.println("Done!");
        
    }
    
}
