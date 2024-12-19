package SomeTest.ReferenceableTest;

import javax.naming.LinkRef;
import javax.naming.NamingException;
import javax.naming.RefAddr;
import javax.naming.Reference;
import javax.naming.Referenceable;
import javax.naming.StringRefAddr;

public class MyReference implements Referenceable {
    @Override
    public Reference getReference() throws NamingException {
        Reference reference = new Reference("SomeTest.ReferenceableTest.MyReference", "SomeTest.ReferenceableTest.MyReferenceImpl", null);
        reference.add(new StringRefAddr("1","111"));
        return reference;
    }


    public static void main(String[] args) {
        MyReference myReference = new MyReference();
        try {
            Reference reference = myReference.getReference();
            RefAddr refAddr = reference.get("1");
            System.out.println(refAddr);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
