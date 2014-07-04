package Uniwork.Base;

import java.util.ArrayList;

public class NGObjectRequestObject extends NGObject {

    protected String FName;
    protected ArrayList<NGObjectRequestMethod> FMethods;
    protected Object FObject;

    public NGObjectRequestObject(String aName, Object aObject) {
        super();
        FName = aName;
        FObject = aObject;
        FMethods = new ArrayList<NGObjectRequestMethod>();
    }

    public NGObjectRequestMethod addMethod(String aName, String aObjectMethod) {
        NGObjectRequestMethod method = new NGObjectRequestMethod(aName, aObjectMethod);
        addMethod(method);
        return method;
    }

    public void addMethod(NGObjectRequestMethod aMethod) {
        FMethods.add(aMethod);
    }

    public String getName() {
        return FName;
    }

    public Object getObject() {
        return FObject;
    }

    public NGObjectRequestMethod getMethod(String aName) {
        for (NGObjectRequestMethod method : FMethods) {
            if (method.getName().equals(aName)) {
                return method;
            }
        }
        return null;
    }

}