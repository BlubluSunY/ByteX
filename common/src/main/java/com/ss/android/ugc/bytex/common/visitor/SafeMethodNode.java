package com.ss.android.ugc.bytex.common.visitor;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.MethodNode;

/**
 * Created by tanlehua on 2019/4/24.
 */
public class SafeMethodNode extends MethodNode {
    SafeMethodNode(int access, String name, String desc, String signature, String[] exceptions) {
        super(Opcodes.ASM5, access, name, desc, signature, exceptions);
    }

    @Override
    public synchronized void accept(MethodVisitor methodVisitor) {
        super.accept(methodVisitor);
    }
}
