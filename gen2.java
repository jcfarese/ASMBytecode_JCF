import static utils.Utilities.writeFile;

import org.objectweb.asm.*;

/**
 * Gen 2 to create a Program 2.class that subtracts numbers
 */
public class gen2 {

    /**
     * Main Method
     */
    public static void main(String[] args) {

        //Create a classwriter
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC,"program2", null, "java/lang/Object",null);
        
        //Empty contructor
        {
			
		}

        {
            MethodVisitor mv=cw.visitMethod(Opcodes.ACC_PUBLIC+Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
            mv.visitCode();

            //Creates steps to subtract integers and print the results
            mv.visitLdcInsn((Integer)15);
            mv.visitVarInsn(Opcodes.ISTORE,1);
            mv.visitLdcInsn((Integer)20);
            mv.visitVarInsn(Opcodes.ISTORE,2);
            mv.visitVarInsn(Opcodes.ILOAD,1);
            mv.visitVarInsn(Opcodes.ILOAD,2);
            mv.visitInsn(Opcodes.ISUB);
            mv.visitVarInsn(Opcodes.ISTORE,3);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ILOAD, 3);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
            
             //Creates steps to subtract floats and print the results
            mv.visitLdcInsn((Float)21.127f);
            mv.visitVarInsn(Opcodes.FSTORE,4);
            mv.visitLdcInsn((Float)20.456f);
            mv.visitVarInsn(Opcodes.FSTORE,5);
            mv.visitVarInsn(Opcodes.FLOAD,4);
            mv.visitVarInsn(Opcodes.FLOAD,5);
            mv.visitInsn(Opcodes.FSUB);
            mv.visitVarInsn(Opcodes.FSTORE,6);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.FLOAD, 6);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(F)V", false);

             //Creates steps to subtract dobule and print the results
            mv.visitLdcInsn((Double)173.43);
            mv.visitVarInsn(Opcodes.DSTORE,7);
            mv.visitLdcInsn((Double)45.56);
            mv.visitVarInsn(Opcodes.DSTORE,9);
            mv.visitVarInsn(Opcodes.DLOAD,7);
            mv.visitVarInsn(Opcodes.DLOAD,9);
            mv.visitInsn(Opcodes.DSUB);
            mv.visitVarInsn(Opcodes.DSTORE,11);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.DLOAD, 11);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(D)V", false);

             //Creates steps to subtract longs and print the results
            mv.visitLdcInsn((Long)123456789000l);
            mv.visitVarInsn(Opcodes.LSTORE,13);
            mv.visitLdcInsn((Long)1139453935858433l);
            mv.visitVarInsn(Opcodes.LSTORE,15);
            mv.visitVarInsn(Opcodes.LLOAD,13);
            mv.visitVarInsn(Opcodes.LLOAD,15);
            mv.visitInsn(Opcodes.LSUB);
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
        writeFile(b, "program2.class");
        
        System.out.println("Done!");
        
    }
    
}
