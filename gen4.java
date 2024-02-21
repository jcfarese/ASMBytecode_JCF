import static utils.Utilities.writeFile;

import org.objectweb.asm.*;

/**
 * Gen 4 to create a Program 4.class that takes numbers and compares them and returns the larger number
 */
public class gen4 {

    /**
     * Main Method
     */
    public static void main(String[] args) {

        //Create a classwriter
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC,"program4", null, "java/lang/Object",null);
        
        //Empty Constructor
        {

        }

        {

            MethodVisitor mv=cw.visitMethod(Opcodes.ACC_PUBLIC+Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
            mv.visitCode();

            //Creates labels for the comparitors
            Label greaterThanInt = new Label();
            Label greaterThanShort = new Label();
            Label greaterThanLong = new Label();
            Label endInt = new Label();
            Label endShort = new Label();
            Label endLong = new Label();

            //Creates steps to compares integers and print the larger number
            mv.visitLdcInsn((Integer)20);
            mv.visitVarInsn(Opcodes.ISTORE,1);
            mv.visitLdcInsn((Integer)60);
            mv.visitVarInsn(Opcodes.ISTORE,2);
            mv.visitVarInsn(Opcodes.ILOAD,1);
            mv.visitVarInsn(Opcodes.ILOAD,2);
            mv.visitJumpInsn(Opcodes.IF_ICMPGT, greaterThanInt);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ILOAD, 2);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
            mv.visitJumpInsn(Opcodes.GOTO, endInt);

            mv.visitLabel(greaterThanInt);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ILOAD, 1);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
            mv.visitJumpInsn(Opcodes.GOTO, endInt);

            //jump instruction label to end the int comparison
            mv.visitLabel(endInt);   


            //Creates steps to compares shorts and print the larger number
            mv.visitLdcInsn((short)1111);
            mv.visitVarInsn(Opcodes.ISTORE,3);
            mv.visitLdcInsn((short)2222);
            mv.visitVarInsn(Opcodes.ISTORE,4);
            mv.visitVarInsn(Opcodes.ILOAD,3);
            mv.visitVarInsn(Opcodes.ILOAD,4);
            mv.visitJumpInsn(Opcodes.IF_ICMPGT, greaterThanShort);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ILOAD, 4);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
            mv.visitJumpInsn(Opcodes.GOTO, endShort);

            mv.visitLabel(greaterThanShort);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ILOAD, 3);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
            mv.visitJumpInsn(Opcodes.GOTO, endShort);

            //jump instruction label to end the short comparison
            mv.visitLabel(endShort);

            //Creates steps to compares long and print the larger number
            mv.visitLdcInsn((Long)1234567890000000000l);
            mv.visitVarInsn(Opcodes.LSTORE,5);
            mv.visitLdcInsn((Long)1139453935858433l);
            mv.visitVarInsn(Opcodes.LSTORE,7);
            mv.visitVarInsn(Opcodes.LLOAD,5);
            mv.visitVarInsn(Opcodes.LLOAD,7);
            mv.visitInsn(Opcodes.LCMP);
            mv.visitJumpInsn(Opcodes.IFGT, greaterThanLong);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.LLOAD, 7);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V", false);
            mv.visitJumpInsn(Opcodes.GOTO, endLong);

            mv.visitLabel(greaterThanLong);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.LLOAD, 5);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V", false);
            mv.visitJumpInsn(Opcodes.GOTO, endLong);

            //jump instruction label to end the long comparison
            mv.visitLabel(endLong);


            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0,0);
            mv.visitEnd();

        }
        //Ends
        cw.visitEnd();
        //Converts to an array
        byte[] b = cw.toByteArray();
        //Writes a class file
        writeFile(b, "program4.class");
        
        System.out.println("Done!");

    }



}
    
