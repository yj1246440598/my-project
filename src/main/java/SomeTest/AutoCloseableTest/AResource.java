package SomeTest.AutoCloseableTest;

public class AResource implements AutoCloseable{

    public void read(){
        System.out.println("do read");
    }
    @Override
    public void close() throws Exception {
        System.out.println("close");
    }

    public static void t1(){
        AResource aResource = new AResource();
        try{
            aResource.read();
        }finally {
            try {
                aResource.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void t2(){
        try(AResource aResource = new AResource()){
            aResource.read();
        }catch (Exception e){

        }
    }

    public static void main(String[] args) {
        t2();
    }
}
