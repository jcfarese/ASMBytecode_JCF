import static utils.Utilities.writeFile;

import org.objectweb.asm.*;

/**
 * Gen 7 to create a Program 7.class that cycles through a loop 10 times and prints each cycle
 */
public class gen7 {
    
    /**
     * Main Method
     */
    public static void main(String[] args) {
        
        //Creates a classwriter
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC,"program7", null, "java/lang/Object",null);
        
        //Empty Constructor
        {

        }

        {

            MethodVisitor mv=cw.visitMethod(Opcodes.ACC_PUBLIC+Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
            mv.visitCode();

            //Creates jump labels
            Label loop = new Label();
            Label end = new Label();

            //Creates a constant and stores it at variable 1
            mv.visitInsn(Opcodes.ICONST_1); 
            mv.visitVarInsn(Opcodes.ISTORE,1);

            //Starts the loop and ends it if the variable is equal to the operand
            mv.visitLabel(loop);
            mv.visitVarInsn(Opcodes.ILOAD, 1);
            mv.visitIntInsn(Opcodes.BIPUSH, 11);
            mv.visitJumpInsn(Opcodes.IF_ICMPGE, end);

            //Prints the value of the variable which indicates the iteration the loop is at
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ILOAD, 1);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V",false);
            //Increments variable 1 by 1
            mv.visitIincInsn(1, 1);
            //Jump instruction to go to the loop label
            mv.visitJumpInsn(Opcodes.GOTO, loop);

            //Jump instruction label to end the loop
            mv.visitLabel(end);

            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0,0);
            mv.visitEnd();

        }

       //Ends
       cw.visitEnd();
       //Converts to an array 
       byte[] b = cw.toByteArray();
       //Writes a class file 
       writeFile(b, "program7.class");
       
        
        System.out.println("Done!");


    }


    
}
