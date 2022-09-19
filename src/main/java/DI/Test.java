package DI;

public class Test {

    private DiTest diTest;
//    private T2 t2;

    public Test(DiTest diTest) {
        this.diTest = diTest;
//        t2 = new T2();
    }

    public void show() {
        diTest.testPrint();
//        t2.t2print();
    }
}
