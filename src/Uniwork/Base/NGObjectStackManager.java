package Uniwork.Base;

import java.util.ArrayList;

public class NGObjectStackManager extends NGObject {

    protected ArrayList<NGObjectStack> FStacks;

    public NGObjectStackManager() {
        super();
        FStacks = new ArrayList<NGObjectStack>();
    }

    public NGObjectStack getStack(String aName) {
        for (NGObjectStack stack : FStacks) {
            if (stack.getName().equals(aName)) {
                return stack;
            }
        }
        return null;
    }

    public NGObjectStack addStack(String aName) {
        NGObjectStack stack = getStack(aName);
        if (stack == null) {
            stack = new NGObjectStack(aName);
            FStacks.add(stack);
        }
        return stack;
    }

    public void removeStack(String aName) {
        NGObjectStack stack = getStack(aName);
        if (stack != null) {
            FStacks.remove(stack);
        }
    }

    public void pushStack(String aName, Object aObject) {
        pushStack(aName, "", aObject);
    }

    public void pushStack(String aName, String aObjectName, Object aObject) {
        NGObjectStack stack = getStack(aName);
        stack.push(aObjectName, aObject);
    }

    public Object popStack(String aName) {
        return popStack(aName, "");
    }

    public Object popStack(String aName, String aObjectName) {
        NGObjectStack stack = getStack(aName);
        if (aObjectName.length() == 0) {
            return stack.pop();
        }
        else {
            while (!stack.isEmpty()) {
                NGObjectStackItem item = stack.popItem();
                if (item.getName().equals(aObjectName)) {
                    return item.getObject();
                }
            }
        }
        return null;
    }

    public Boolean isStackEmpty(String aName) {
        NGObjectStack item = getStack(aName);
        return item.isEmpty();
    }

}
